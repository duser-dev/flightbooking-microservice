package com.cgi.microservices.services.leaguedata;

import java.util.List;

public class LeagueData {

	/**
	 * A data structure containing all information about a league A list of
	 * teams, and a list of matchdays, which are lists of matches.
	 * 
	 * @author schuldd
	 *
	 */
	static class League {
		private String id;

		private List<Team> teams;
		private List<Matchday> matchdays;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public List<Team> getTeams() {
			return teams;
		}

		/**
		 * Returns the list of matches. <b>The list is a 0-based java data
		 * structure. This method should not be used directly, but only by the
		 * framework code to convert the data structure to the exchange format.
		 * For direct access of the matchdays, use {@link #getMatchday(int)}</b>
		 * 
		 */
		public List<Matchday> getMatchdays() {
			return matchdays;
		}

		/**
		 * Returns a certain matchday, which is a list of matches.
		 * 
		 * @param day
		 *            Number of matchday. This is 1-based, thus for a Bundesliga
		 *            matchday, values between 1 and 34 are valid.
		 */
		public Matchday getMatchday(int day) {
			return matchdays.get(day - 1);
		}

		public void setTeams(List<Team> teams) {
			this.teams = teams;
		}

		/**
		 * Sets the list of matches. <b>The list is a 0-based java data
		 * structure. This method should not be used directly, but only by the
		 * framework code to convert the data structure to the exchange format.
		 * For direct access of the matchdays, use
		 * {@link #setMatchday(int, Matchday)}</b>
		 * 
		 */
		public void setMatchdays(List<Matchday> matchdays) {
			this.matchdays = matchdays;
		}

		/**
		 * Sets a certain matchday, which is a list of matches.
		 * 
		 * @param day
		 *            Number of matchday. This is 1-based, thus for a Bundesliga
		 *            matchday, values between 1 and 34 are valid.
		 * @param matchday
		 *            Matchday to set
		 */
		public void setMatchday(int day, Matchday matchday) {
			this.matchdays.set(day - 1, matchday);

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
