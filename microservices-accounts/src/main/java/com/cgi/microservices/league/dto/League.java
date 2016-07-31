package com.cgi.microservices.league.dto;

import java.util.ArrayList;
import java.util.List;

import com.cgi.microservices.league.WebLeagueService;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Account DTO - used to interact with the {@link WebLeagueService}.
 * 
 * @author Paul Chapman
 */
@JsonRootName("League")
public class League {

	private List<Team> teams = null;
	private List<Matchday> matchdays = new ArrayList<>();

	/**
	 * Default constructor for JPA only.
	 */
	protected League() {
	}

	public List<Team> getAllTeams() {
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
		if (day > matchdays.size()) {
			return new Matchday(new ArrayList<>());
		}
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
	
	@Override
	public String toString() {
		return "many teams";
	}

}
