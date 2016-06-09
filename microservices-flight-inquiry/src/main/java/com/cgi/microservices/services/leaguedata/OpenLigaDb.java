package com.cgi.microservices.services.leaguedata;

import java.util.Date;
import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface OpenLigaDb {

	public static final String API_MATCHDATA_BASE_PATH = "/api/getmatchdata";

	public static final String API_LAST_CHANGED_DATA_BASE_PATH = "/api/getlastchangedate";

	static class Match {
		int MatchID;
		String MatchDateTime;

		Team Team1;
		Team Team2;

		List<Result> MatchResults;

		static class Team {
			int TeamId;
			String TeamName;
		}

		static class Result {
			int PointsTeam1;
			int PointsTeam2;
			int ResultOrderID;
		}

	}

	@RequestLine("GET " + API_MATCHDATA_BASE_PATH + "/{league}/{season}/{matchday}")
	List<Match> getMatchdayResults(@Param("league") String league, @Param("season") int season,
			@Param("matchday") int matchday);

	@RequestLine("GET " + API_MATCHDATA_BASE_PATH + "/{league}/{season}")
	List<List<Match>> getSeasonResults(@Param("league") String league, @Param("season") int season);

	@RequestLine("GET " + API_LAST_CHANGED_DATA_BASE_PATH + "/{league}/{season}/{matchday}")
	Date getLastChangedDate(@Param("league") String league, @Param("season") int season,
			@Param("matchday") int matchday);

}
