package com.cgi.microservices.services.leaguedata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cgi.microservices.services.leaguedata.dto.Match;
import com.cgi.microservices.services.leaguedata.dto.MatchResult;
import com.cgi.microservices.services.leaguedata.dto.Team1;

import feign.Feign;
import feign.FeignException;
import feign.Logger;
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

	

	
	protected java.util.logging.Logger logger = java.util.logging.Logger.getLogger(OpenLigaDbLeagueDataProvider.class.getName());

	private OpenLigaDb openLigaDb;
	private int curSeason;

	private Map<Integer, Date> matchdayTimestamps;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	public OpenLigaDbLeagueDataProvider() {
		this.openLigaDb = Feign.builder()
							   .decoder(new GsonDecoder())
							   .encoder(new GsonEncoder())
							   .logLevel(Logger.Level.FULL)
							   .target(OpenLigaDb.class, "https://www.openligadb.de");
		this.matchdayTimestamps = new HashMap<>();
	}

	
	@Override
	public List<List<Match>> getLeague(int season, boolean forceRefresh) {
//		getSeasonResults(season, forceRefresh)
		return null;
	}

	@Override
	public List<Match> getMatchday(int season, int day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team1> getTeams(int season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<Match>> getMatchdays(int season, boolean forceRefresh) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public League getLeague(int season, boolean forceRefresh) {
//
//		if (league == null || season != curSeason || forceRefresh) {
//			curSeason = season;
//			convertLeague(season);
//
//		}
//
//		return league;
//	}
//
//	@Override
//	public List<Match> getMatchday(int season, int day) {
//
//		try {
//			List<Match> matchday = getLeague(season).getMatchday(day);
//
//			String lastChangedDate = openLigaDb.getLastChangedDate(leagueId, season, day);
//
//			if (StringUtils.isNotBlank(lastChangedDate)) {
//				try {
//					Date lastUpdate = dateFormat.parse(lastChangedDate);
//					Date lastCached = matchdayTimestamps.get(day - 1);
//
//					// TODO use something better than java.util.Date
//					if (lastUpdate.getTime() > lastCached.getTime()) {
//
//						List<Match> matchdayResults = getUpdatedMatches(season, day);
//						//matchday = convertMatchListToMatchday(matchdayResults);
//						league.setMatchday(day, matchday);
//
//					}
//				} catch (ParseException e) {
//					logger.warning("Received unparseable or non-existent update timestamp for matchday " + day + ".");
//				}
//			}
//			return matchday;
//		} catch (FeignException e) {
//			return new Matchday(new ArrayList<LeagueData.Match>());
//		}
//
//	}
//
//	@Override
//	public List<Team1> getTeams(int season) {
//		try {
//			return getLeague(season).getTeams();
//		} catch (FeignException e) {
//			return new ArrayList<>();
//		}
//	}
//
//	@Override
//	public List<Matchday> getMatchdays(int season, boolean forceRefresh) {
//		try {
//			// TODO check each matchday for update and refresh if necessary
//			return getLeague(season).getMatchdays();
//		} catch (FeignException e) {
//			return new ArrayList<>();
//		}
//	}
//
//	private void convertLeague(int season) {
//
//		logger.info("Refreshing data from OpenLigaDB");
//		this.league = new League();
//		league.setId(leagueId);
//
//		List<List<Match>> seasonResults = IntStream.range(1, numMatchdays + 1)
//				.mapToObj(day -> getUpdatedMatches(season, day)).collect(Collectors.toList());
//
//		league.setMatchdays(seasonResults.stream().map(matches -> convertMatchListToMatchday(matches))
//				.collect(Collectors.toList()));
//
//		league.setTeams(new ArrayList<Team>());
//		Matchday firstMatchday = league.getMatchday(1);
//
//		firstMatchday.matches.forEach(match -> {
//			league.getTeams().add(match.team1);
//			league.getTeams().add(match.team2);
//		});
//
//	}
//
////	private Matchday convertMatchListToMatchday(List<Match> matches) {
////		return new Matchday(matches.stream().map(this::convertMatch).collect(Collectors.toList()));
////	}
//
//	private List<Match> getUpdatedMatches(int season, int day) {
//		// 2 things to do here: Init the lastUpdate value for each matchday,
//		// and convert the matchday to internal date format
//		String lastChangedDate = openLigaDb.getLastChangedDate(leagueId, season, day);
//
//		if (StringUtils.isNotBlank(lastChangedDate)) {
//			try {
//
//				matchdayTimestamps.put(day - 1, dateFormat.parse(lastChangedDate));
//			} catch (ParseException e) {
//				logger.warning("Received unparseable or non-existent update timestamp for matchday " + day + ".");
//			}
//		}
//
//		return openLigaDb.getMatchdayResults(leagueId, season, day);
//	}
//
////	private LeagueData.Match convertMatch(Match oldbMatch) {
////
////		LeagueData.Match match = new LeagueData.Match();
////		match.matchId = oldbMatch.getMatchID();
////		match.team1 = convertTeam1(oldbMatch.getTeam1());
////		match.team2 = convertTeam2(oldbMatch.getTeam2());
////
////		for (MatchResult result : oldbMatch.getMatchResults()) {
////			LeagueData.Result newResult = new LeagueData.Result(result.getPointsTeam1(), result.getPointsTeam2());
////			switch (result.getResultName()) {
////			case "Endergebnis":
////				match.endResult = newResult;
////				break;
////			case "Halbzeitergebnis":
////				match.halftimeResult = newResult;
////				break;
////			}
////
////		}
////
////		match.matchDate = oldbMatch.getMatchDateTime();
////		return match;
////
////	}
//
//	private LeagueData.Team convertTeam1(com.cgi.microservices.services.leaguedata.dto.Team1 team1) {
//		return new LeagueData.Team(team1.getShortName(), team1.getTeamIconUrl(), team1.getTeamId(), team1.getTeamName());
//	}
//
//	private LeagueData.Team convertTeam2(com.cgi.microservices.services.leaguedata.dto.Team2 team1) {
//		return new LeagueData.Team(team1.getShortName(), team1.getTeamIconUrl(), team1.getTeamId(), team1.getTeamName());
//	}
//	
//	private League getLeague(int season) {
//
//		return getLeague(season, false);
//	}

}
