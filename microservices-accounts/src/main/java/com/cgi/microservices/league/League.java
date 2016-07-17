package com.cgi.microservices.league;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Account DTO - used to interact with the {@link WebLeagueService}.
 * 
 * @author Paul Chapman
 */
@JsonRootName("League")
public class League {

	protected Teams[] teams;

	/**
	 * Default constructor for JPA only.
	 */
	protected League() {
	}

	public Teams[] getTeams() {
		return teams;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void setTeams(Teams[] teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "many teams";
	}

}
