package com.cgi.microservices.services.leaguedata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.cgi.microservices.services.leaguedata.LeagueData.League;
import com.cgi.microservices.services.leaguedata.LeagueData.Matchday;
import com.cgi.microservices.services.leaguedata.LeagueData.Team;
import com.cgi.microservices.services.leaguedata.OpenLigaDb.Match;

public class OpenLigaDbLeagueDataAdapter implements LeagueDataProvider {

	private OpenLigaDb openLigaDb;
	private League league;

	public OpenLigaDbLeagueDataAdapter(OpenLigaDb openLigaDb) {
		this.openLigaDb = openLigaDb;
	}

	private void convertLeague(int season) {
		this.league = new League();
		league.id = "bl1";

		List<List<Match>> seasonResults = IntStream.range(1, 18)
				.mapToObj(day -> openLigaDb.getMatchdayResults("bl1", season, day)).collect(Collectors.toList());

		league.matchdays = seasonResults.stream().map((List<Match> matches) -> {
			List<LeagueData.Match> matchList = matches.stream().map(this::convertMatch).collect(Collectors.toList());
			return new Matchday(matchList);
		}).collect(Collectors.toList());

		league.teams = new ArrayList<Team>();
		Matchday firstMatchday = league.matchdays.get(0);

		firstMatchday.matches.forEach(match -> {
			league.teams.add(match.team1);
			league.teams.add(match.team2);
		});

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
	public League getLeague(int season) {

		// if (league == null) {
		convertLeague(season);
		// }

		return league;
	}

}
