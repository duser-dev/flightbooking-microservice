package com.cgi.microservices.league;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Account DTO - used to interact with the {@link WebLeagueService}.
 * 
 * @author Paul Chapman
 */
@JsonRootName("League")
public class League {

	protected ArrayList<Team> teams = null;

	/**
	 * Default constructor for JPA only.
	 */
	protected League() {
	}

	public ArrayList<Team> getAllTeams() {
		return teams;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void addTeam(String id, String nameMannschaft) {
		if(teams == null) {
			teams = new ArrayList<Team>();
		}
		teams.add(new Team(id, nameMannschaft));
	}

	
	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void addTeam(Team team) {
		if(teams == null) {
			teams = new ArrayList<Team>();
		}
		teams.add(team);
	}
	
	@Override
	public String toString() {
		return "many teams";
	}

}
