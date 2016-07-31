package com.cgi.microservices.league.domain;

/**
 * Data model for a result
 * 
 * @author mark
 *
 */
public class Result {

	public Result() {
		super();
	}

	public Result(int pointsTeam1, int pointsTeam2) {
		goalsTeam1 = pointsTeam1;
		goalsTeam2 = pointsTeam2;
	}

	private int goalsTeam1;

	private int goalsTeam2;

	public int getGoalsTeam1() {
		return goalsTeam1;
	}

	public void setGoalsTeam1(int goalsTeam1) {
		this.goalsTeam1 = goalsTeam1;
	}

	public int getGoalsTeam2() {
		return goalsTeam2;
	}

	public void setGoalsTeam2(int goalsTeam2) {
		this.goalsTeam2 = goalsTeam2;
	}

}