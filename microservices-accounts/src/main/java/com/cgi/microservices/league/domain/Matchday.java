package com.cgi.microservices.league.domain;

import java.util.List;

/**
 * Data model for a matchday
 * 
 * @author mark
 *
 */
public class Matchday {

	public Matchday() {
		super();
	}

	public Matchday(List<Match> matches) {
		this.matches = matches;
	}

	private List<Match> matches;

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
}
