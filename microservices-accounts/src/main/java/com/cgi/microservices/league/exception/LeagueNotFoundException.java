package com.cgi.microservices.league.exception;

/**
 * Allow the controller to return a 404 if an account is not found by simply
 * throwing this exception. The @ResponseStatus causes Spring MVC to return a
 * 404 instead of the usual 500.
 * 
 * @author Paul Chapman
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class LeagueNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LeagueNotFoundException(String accountNumber) {
		super("No such account: " + accountNumber);
	}
}
