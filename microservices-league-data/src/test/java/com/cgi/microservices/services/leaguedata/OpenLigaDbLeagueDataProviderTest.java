package com.cgi.microservices.services.leaguedata;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cgi.microservices.services.leaguedata.LeagueData.Team;

public class OpenLigaDbLeagueDataProviderTest {

	private static OpenLigaDbLeagueDataProvider dataProvider;
	
	@BeforeClass
	public static void setUp() {
		dataProvider = new OpenLigaDbLeagueDataProvider();
	}
	
	@Test
	public void test() {
//		List<Team> teams = dataProvider.getTeams(2016);
		
	}

}
