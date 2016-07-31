package com.cgi.microservices.league.domain;

/**
 * Data model for a match
 * 
 * @author mark
 *
 */
public class Match {

	private int matchId;

	private Team team1;

	private Team team2;

	private String matchDate;

	private Result halftimeResult;

	private Result endResult;

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public Result getHalftimeResult() {
		return halftimeResult;
	}

	public void setHalftimeResult(Result halftimeResult) {
		this.halftimeResult = halftimeResult;
	}

	public Result getEndResult() {
		return endResult;
	}

	public void setEndResult(Result endResult) {
		this.endResult = endResult;
	}

}
