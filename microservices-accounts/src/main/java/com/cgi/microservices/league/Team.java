package com.cgi.microservices.league;

/**
 * Soccer team data model
 * 
 * @author Mark Beissert
 */
public class Team {

	protected String id;

	protected String name;

	protected Team() {
		super();
	}

	protected Team(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

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
