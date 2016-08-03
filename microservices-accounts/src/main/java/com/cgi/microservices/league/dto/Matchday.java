package com.cgi.microservices.league.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Soccer team data model
 * 
 * @author Mark Beissert
 */
@JsonRootName("Matchday")
public class Matchday {
	
	public Matchday() {
		
	}
	
	public Matchday(List<Match> matches) {
		this.matches = matches;
	}

	public List<Match> matches;

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	
}