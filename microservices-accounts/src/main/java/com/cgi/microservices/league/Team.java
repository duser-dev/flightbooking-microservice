package com.cgi.microservices.league;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Account DTO - used to interact with the {@link WebLeagueService}.
 * 
 * @author Paul Chapman
 */
@JsonRootName("Team")
public class Team {

	protected String id;
	protected String name;

	protected Team() {
		//do nothing
	}
	
	protected Team(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	
	protected void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return id + " " + name;
	}

}
