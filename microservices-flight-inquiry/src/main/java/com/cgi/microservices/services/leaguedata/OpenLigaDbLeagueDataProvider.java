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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cgi.microservices.services.leaguedata.LeagueData.League;
import com.cgi.microservices.services.leaguedata.LeagueData.Matchday;
import com.cgi.microservices.services.leaguedata.LeagueData.Team;
import com.cgi.microservices.services.leaguedata.OpenLigaDb.Match;
import com.cgi.microservices.services.leaguedata.OpenLigaDb.Match.Result;

import feign.Feign;
import feign.FeignException;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * A {@link LeagueDataProvider} implementation that retrieves data from the
 * OpenLigaDB (http://www.openligadb.de/) JSON API.
 * 
 * @author schuldd
 *
 */
@Component
public class OpenLigaDbLeagueDataProvider implements LeagueDataProvider {

	@Value("${spring.application.league}")
	private String leagueId;

	@Value("${spring.application.numMatchdays}")
	private int numMatchdays;

	protected Logger logger = Logger.getLogger(OpenLigaDbLeagueDataProvider.class.getName());

	private OpenLigaDb openLigaDb;
	private League league;
	private int curSeason;

	private Map<Integer, Date> matchdayTimestamps;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	public OpenLigaDbLeagueDataProvider() {
		this.openLigaDb = Feign.builder().decoder(new GsonDecoder()).encoder(new GsonEncoder()).target(OpenLigaDb.class,
				"http://www.openligadb.de");
		this.matchdayTimestamps = new HashMap<>();
	}

	@Override
	public League getLeague(int season, boolean forceRefresh) {

		if (league == null || season != curSeason || forceRefresh) {
			curSeason = season;
			convertLeague(season);

		}

		return league;
	}

	@Override
	public Matchday getMatchday(int season, int day) {

		try {
			Matchday matchday = getLeague(season).getMatchday(day);

			String lastChangedDate = openLigaDb.getLastChangedDate(leagueId, season, day);

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
		} catch (FeignException e) {
			return new Matchday(new ArrayList<LeagueData.Match>());
		}

	}

	@Override
	public List<Team> getTeams(int season) {
		try {
			return getLeague(season).getTeams();
		} catch (FeignException e) {
			return new ArrayList<>();
		}
	}

	@Override
	public List<Matchday> getMatchdays(int season, boolean forceRefresh) {
		try {
			// TODO check each matchday for update and refresh if necessary
			return getLeague(season).getMatchdays();
		} catch (FeignException e) {
			return new ArrayList<>();
		}
	}

	private void convertLeague(int season) {

		logger.info("Refreshing data from OpenLigaDB");
		this.league = new League();
		league.setId(leagueId);

		List<List<Match>> seasonResults = IntStream.range(1, numMatchdays + 1)
				.mapToObj(day -> getUpdatedMatches(season, day)).collect(Collectors.toList());

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
		String lastChangedDate = openLigaDb.getLastChangedDate(leagueId, season, day);

		if (StringUtils.isNotBlank(lastChangedDate)) {
			try {

				matchdayTimestamps.put(day - 1, dateFormat.parse(lastChangedDate));
			} catch (ParseException e) {
				logger.warning("Received unparseable or non-existent update timestamp for matchday " + day + ".");
			}
		}

		return openLigaDb.getMatchdayResults(leagueId, season, day);
	}

	private LeagueData.Match convertMatch(OpenLigaDb.Match oldbMatch) {

		LeagueData.Match match = new LeagueData.Match();
		match.matchId = oldbMatch.MatchID;
		match.team1 = convertTeam(oldbMatch.Team1);
		match.team2 = convertTeam(oldbMatch.Team2);

		for (Result result : oldbMatch.MatchResults) {
			LeagueData.Result newResult = new LeagueData.Result(result.PointsTeam1, result.PointsTeam2);
			switch (result.ResultName) {
			case "Endergebnis":
				match.endResult = newResult;
				break;
			case "Halbzeitergebnis":
				match.halftimeResult = newResult;
				break;
			}

		}

		match.matchDate = oldbMatch.MatchDateTime;
		return match;

	}

	private LeagueData.Team convertTeam(OpenLigaDb.Match.Team team1) {
		return new LeagueData.Team(team1.TeamId, team1.TeamName);
	}

	private League getLeague(int season) {

		return getLeague(season, false);
	}

}
