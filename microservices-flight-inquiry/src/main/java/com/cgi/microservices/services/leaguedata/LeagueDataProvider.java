package com.cgi.microservices.services.leaguedata;

import com.cgi.microservices.services.leaguedata.LeagueData.League;

public interface LeagueDataProvider {

	League getLeague(int season);

}
