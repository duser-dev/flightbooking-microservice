package com.cgi.microservices.services.leaguedata;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cgi.microservices.services.leaguedata.OpenLigaDb.Match;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class OpenLigaDbTest {

	private static OpenLigaDb openLigaDb;

	@BeforeClass
	public static void setUp() {
		openLigaDb = Feign.builder().decoder(new GsonDecoder()).encoder(new GsonEncoder()).target(OpenLigaDb.class,
				"http://www.openligadb.de");
	}

	@Test
	public void testOpenLigaDb() {

		List<Match> matchdayResults = openLigaDb.getMatchdayResults("bl1", 2015, 1);
		assertEquals(matchdayResults.size(), 9);

		assertEquals(matchdayResults.get(0).MatchID, 33236);
		assertEquals(matchdayResults.get(0).Team1.TeamName, "Bayern München");
		assertEquals(matchdayResults.get(0).Team2.TeamName, "Hamburger SV");
		assertEquals(matchdayResults.get(0).MatchResults.get(0).PointsTeam1, 1);
		assertEquals(matchdayResults.get(0).MatchResults.get(0).PointsTeam2, 0);
		assertEquals(matchdayResults.get(0).MatchResults.get(1).PointsTeam1, 5);
		assertEquals(matchdayResults.get(0).MatchResults.get(1).PointsTeam2, 0);

		assertEquals(matchdayResults.get(8).MatchID, 33240);
		assertEquals(matchdayResults.get(8).Team1.TeamName, "VfB Stuttgart");
		assertEquals(matchdayResults.get(8).Team2.TeamName, "1. FC Köln");
		assertEquals(matchdayResults.get(8).MatchResults.get(0).PointsTeam1, 0);
		assertEquals(matchdayResults.get(8).MatchResults.get(0).PointsTeam2, 0);
		assertEquals(matchdayResults.get(8).MatchResults.get(1).PointsTeam1, 1);
		assertEquals(matchdayResults.get(8).MatchResults.get(1).PointsTeam2, 3);
	}

}
