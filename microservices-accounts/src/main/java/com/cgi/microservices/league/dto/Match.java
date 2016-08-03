package com.cgi.microservices.league.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * A Team as dto
 * 
 * @author Daniel Beyer
 */
@JsonRootName("Match")
class Match {
	public int matchId;
	public Team team1;
	public Team team2;
	public String matchDate;
	public Result halftimeResult;
	public Result endResult;
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

