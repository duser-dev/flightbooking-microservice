package com.cgi.microservices.services.leaguedata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang.StringUtils;

import com.cgi.microservices.services.leaguedata.LeagueData.League;
import com.cgi.microservices.services.leaguedata.LeagueData.Matchday;
import com.cgi.microservices.services.leaguedata.LeagueData.Team;
import com.cgi.microservices.services.leaguedata.OpenLigaDb.Match;

/**
 * A {@link LeagueDataProvider} implementation that retrieves data from the
 * OpenLigaDB (http://www.openligadb.de/) JSON API.
 * 
 * @author schuldd
 *
 */
public class OpenLigaDbLeagueDataProvider implements LeagueDataProvider {

	protected Logger logger = Logger.getLogger(OpenLigaDbLeagueDataProvider.class.getName());

	private OpenLigaDb openLigaDb;
	private League league;

	private Map<Integer, Date> matchdayTimestamps;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	public OpenLigaDbLeagueDataProvider(OpenLigaDb openLigaDb) {
		this.openLigaDb = openLigaDb;
		this.matchdayTimestamps = new HashMap<>();
	}

	private void convertLeague(int season) {
		this.league = new League();
		league.setId("bl1");

		List<List<Match>> seasonResults = IntStream.range(1, 35).mapToObj(day -> getUpdatedMatches(season, day))
				.collect(Collectors.toList());

		league.setMatchdays(seasonResults.stream().map(matches -> convertMatchListToMatchday(matches))
				.collect(Collectors.toList()));

		league.setTeams(new ArrayList<Team>());
		Matchday firstMatchday = league.getMatchday(1);

		firstMatchday.matches.forEach(match -> {
			league.getTeams().add(match.team1);
			league.getTeams().add(match.team2);
		});

	}

	private Matchday convertMatchListToMatchday(List<Match> matches) {
		return new Matchday(matches.stream().map(this::convertMatch).collect(Collectors.toList()));
	}

	private List<Match> getUpdatedMatches(int season, int day) {
		// 2 things to do here: Init the lastUpdate value for each matchday,
		// and convert the matchday to internal date format
		String lastChangedDate = openLigaDb.getLastChangedDate("bl1", season, day);

		if (StringUtils.isNotBlank(lastChangedDate)) {
			try {

				matchdayTimestamps.put(day - 1, dateFormat.parse(lastChangedDate));
			} catch (ParseException e) {
				logger.warning("Received unparseable or non-existent update timestamp for matchday " + day + ".");
			}
		}

		return openLigaDb.getMatchdayResults("bl1", season, day);
	}

	private LeagueData.Match convertMatch(OpenLigaDb.Match oldbMatch) {

		LeagueData.Match match = new LeagueData.Match();
		match.matchId = oldbMatch.MatchID;
		match.team1 = convertTeam(oldbMatch.Team1);
		match.team2 = convertTeam(oldbMatch.Team2);
		match.halftimeResult = new LeagueData.Result(oldbMatch.MatchResults.get(0).PointsTeam1,
				oldbMatch.MatchResults.get(0).PointsTeam2);
		match.endResult = new LeagueData.Result(oldbMatch.MatchResults.get(1).PointsTeam1,
				oldbMatch.MatchResults.get(1).PointsTeam2);
		match.matchDate = oldbMatch.MatchDateTime;
		return match;

	}

	private LeagueData.Team convertTeam(OpenLigaDb.Match.Team team1) {
		return new LeagueData.Team(team1.TeamId, team1.TeamName);
	}

	@Override
	public League getLeague(int season, boolean forceRefresh) {

		if (league == null || forceRefresh) {
			convertLeague(season);
		}

		return league;
	}

	public League getLeague(int season) {

		return getLeague(season, false);
	}

	@Override
	public Matchday getMatchday(int season, int day) {

		Matchday matchday = getLeague(season).getMatchday(day);

		String lastChangedDate = openLigaDb.getLastChangedDate("bl1", season, day);

		if (StringUtils.isNotBlank(lastChangedDate)) {
			try {
				Date lastUpdate = dateFormat.parse(lastChangedDate);
				Date lastCached = matchdayTimestamps.get(day - 1);

				// TODO use something better than java.util.Date
				if (lastUpdate.getTime() > lastCached.getTime()) {

					List<Match> matchdayResults = getUpdatedMatches(season, day);
					matchday = convertMatchListToMatchday(matchdayResults);
					league.setMatchday(day, matchday);

				}
			} catch (ParseException e) {
				logger.warning("Received unparseable or non-existent update timestamp for matchday " + day + ".");
			}
		}

		return matchday;
	}

	@Override
	public List<Team> getTeams(int season) {
		return getLeague(season).getTeams();
	}

	@Override
	public List<Matchday> getMatchdays(int season, boolean forceRefresh) {

		if (league == null || forceRefresh) {
			convertLeague(season);
		}

		// TODO check each matchday for update and refresh if necessary
		return getLeague(season).getMatchdays();
	}

}
