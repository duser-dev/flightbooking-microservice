package com.cgi.microservices.services.leaguedata;

import java.util.List;


import com.cgi.microservices.services.leaguedata.dto.Match;
import com.cgi.microservices.services.leaguedata.dto.Team1;

/**
 * Implementations of this interface are used to provide the service with data
 * from an external data provider. The data retrieved from the external services
 * must be converted into the data structures defined in {@link LeagueData}.
 * 
 * @author schuldd
 *
 */
public interface LeagueDataProvider {

	/**
	 * Returns the {@link League} data structure that contains all information
	 * about the teams and the matchdays. This method should be queried at
	 * startup. This method returns cached results in case results have been
	 * successfully retrieved in the past. For updated results, set the
	 * forceRefresh parameter to true. For updates of particular matchdays, use
	 * {@link #getMatchday(int, int)}
	 * 
	 * @param season
	 *            Season that should be queried
	 * @param forceRefresh
	 *            True if results should be refreshed from external provider
	 * @return {@link League}
	 */
	List<List<Match>> getLeague(int season, boolean forceRefresh);

	/**
	 * Returns the matchday referenced by the season and day parameters. This
	 * method always checks the external data provider if updated data is
	 * available.
	 * 
	 * @param season
	 *            Season identifier
	 * @param day
	 *            Number of matchday
	 * @return {@link Matchday}
	 */
	List<Match> getMatchday(int season, int day);

	/**
	 * Returns a list of teams.
	 * 
	 * @param season
	 *            Season identifier
	 * @return List of {@link Team1}
	 */
	List<Team1> getTeams(int season);

	/**
	 * Returns the list of all matchdays in a given season.This method returns
	 * cached results in case results have been successfully retrieved in the
	 * past. For updated results, set the forceRefresh parameter to true. For
	 * updates of particular matchdays, use {@link #getMatchday(int, int)}
	 * 
	 * @param season
	 *            Season that should be queried
	 * @param forceRefresh
	 *            True if results should be refreshed from external provider
	 * @return List of {@link List<List<Match>>}
	 */
	List<List<Match>> getMatchdays(int season, boolean forceRefresh);

}
