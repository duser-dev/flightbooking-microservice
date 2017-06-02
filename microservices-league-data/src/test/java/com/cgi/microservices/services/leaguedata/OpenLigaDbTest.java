package com.cgi.microservices.services.leaguedata;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cgi.microservices.services.leaguedata.dto.Match;
import com.cgi.microservices.services.leaguedata.dto.Team1;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;

public class OpenLigaDbTest {

	private static OpenLigaDb openLigaDb;

	@BeforeClass
	public static void setUp() {
		openLigaDb = Feign.builder()
				          .decoder(new GsonDecoder())
				          .encoder(new GsonEncoder())
				          .logger(new Slf4jLogger(OpenLigaDbTest.class))
				          .logLevel(Logger.Level.FULL)
				          .target(OpenLigaDb.class,	"https://www.openligadb.de"); //getmatchdata //getavailableteams
		
		
	}

	@Test
	public void testOpenLigaDb() {
		
		
		List<Match> matchdayResults = openLigaDb.getMatchdayResults("bl1", 2015, 1);
		
		assertNotNull(matchdayResults);
		assertNotEquals(matchdayResults.size(), 0);
		
		List<Team1> teams = openLigaDb.getAvailableTeams("bl1", 2015);
		
		assertNotNull(teams);
		assertNotEquals(teams.size(), 0);
		
		List<Match> allMatches15 = openLigaDb.getSeasonResults("bl1", 2015);
		
		assertNotNull(allMatches15);
		assertNotEquals(allMatches15.size(), 0);
		
		List<Match> allMatches16 = openLigaDb.getSeasonResults("bl1", 2016);
		
		assertNotNull(allMatches16);
		assertNotEquals(allMatches16.size(), 0);
		
		
//		assertEquals(matchdayResults.size(), 9);
//
//		assertEquals(matchdayResults.get(0).getMatchID(), new Integer(33236));
//		assertEquals(matchdayResults.get(0).getTeam1().getTeamName(), "Bayern München");
//		assertEquals(matchdayResults.get(0).getTeam2().getTeamName(), "Hamburger SV");
//		assertEquals(matchdayResults.get(0).getMatchResults().get(0).getPointsTeam1(), new Integer(1));
//		assertEquals(matchdayResults.get(0).getMatchResults().get(0).getPointsTeam2(), new Integer(0));
//		assertEquals(matchdayResults.get(0).getMatchResults().get(1).getPointsTeam1(), new Integer(5));
//		assertEquals(matchdayResults.get(0).getMatchResults().get(1).getPointsTeam2(), new Integer(0));
//
//		assertEquals(matchdayResults.get(8).getMatchID(), new Integer(33240));
//		assertEquals(matchdayResults.get(8).getTeam1().getTeamName(), "VfB Stuttgart");
//		assertEquals(matchdayResults.get(8).getTeam2().getTeamName(), "1. FC Köln");
//		assertEquals(matchdayResults.get(8).getMatchResults().get(0).getPointsTeam1(), new Integer(0));
//		assertEquals(matchdayResults.get(8).getMatchResults().get(0).getPointsTeam2(), new Integer(0));
//		assertEquals(matchdayResults.get(8).getMatchResults().get(1).getPointsTeam1(), new Integer(1));
//		assertEquals(matchdayResults.get(8).getMatchResults().get(1).getPointsTeam2(), new Integer(3));
	}

}



