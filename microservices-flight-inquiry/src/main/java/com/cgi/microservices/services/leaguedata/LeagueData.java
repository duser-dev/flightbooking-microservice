package com.cgi.microservices.services.leaguedata;

import java.util.List;

public class LeagueData {

	static class League {
		public String id;
		public List<Team> teams;
		public List<Matchday> matchdays;

		public List<Team> getTeams() {
			return teams;
		}

		public List<Matchday> getMatchdays() {
			return matchdays;
		}

		public Matchday getMatchday(int day) {
			return matchdays.get(day);
		}

	}

	static class Team {
		public Team(int teamId, String teamName) {
			id = teamId;
			name = teamName;
		}

		public int id;
		public String name;
	}

	static class Matchday {
		public Matchday(List<Match> matches) {
			this.matches = matches;
		}

		public List<Match> matches;
	}

	static class Match {
		public int matchId;
		public Team team1;
		public Team team2;
		public String matchDate;
		public Result halftimeResult;
		public Result endResult;

	}

	static class Result {
		public Result(int pointsTeam1, int pointsTeam2) {
			goalsTeam1 = pointsTeam1;
			goalsTeam2 = pointsTeam2;
		}

		public int goalsTeam1;
		public int goalsTeam2;
	}
}
