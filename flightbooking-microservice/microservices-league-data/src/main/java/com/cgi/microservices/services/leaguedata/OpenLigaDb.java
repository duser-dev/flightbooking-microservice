package com.cgi.microservices.services.leaguedata;

import java.util.List;

import com.cgi.microservices.services.leaguedata.dto.Match;
import com.cgi.microservices.services.leaguedata.dto.Team1;

import feign.Param;
import feign.RequestLine;

public interface OpenLigaDb {

	public static final String API_MATCHDATA_BASE_PATH = "/api/getmatchdata";

	public static final String API_LAST_CHANGED_DATA_BASE_PATH = "/api/getlastchangedate";
	
	public static final String API_AVAILABLE_TEAMS = "/api/getavailableteams/";


	@RequestLine("GET " + API_MATCHDATA_BASE_PATH + "/{league}/{season}/{matchday}")
	List<Match> getMatchdayResults(@Param("league") String league, @Param("season") int season,	@Param("matchday") int matchday);

	@RequestLine("GET " + API_MATCHDATA_BASE_PATH + "/{league}/{season}")
	List<Match> getSeasonResults(@Param("league") String league, @Param("season") int season);

	@RequestLine("GET " + API_LAST_CHANGED_DATA_BASE_PATH + "/{league}/{season}/{matchday}")
	String getLastChangedDate(@Param("league") String league, @Param("season") int season,
			@Param("matchday") int matchday);
	
	@RequestLine("GET " + API_AVAILABLE_TEAMS + "/{league}/{season}")
	List<Team1> getAvailableTeams(@Param("league") String league, @Param("season") int season);

}
