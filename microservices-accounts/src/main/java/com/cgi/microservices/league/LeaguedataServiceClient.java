package com.cgi.microservices.league;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgi.microservices.league.dto.League;
import com.cgi.microservices.league.dto.Team;

import com.cgi.microservices.league.domain.League;
import com.cgi.microservices.league.domain.Matchday;
import com.cgi.microservices.league.domain.Team;

/**
 * Feign service client with enabled load balancing
 * 
 * @author mark
 *
 */
@FeignClient("http://leaguedata-service")
public interface LeaguedataServiceClient {

	@RequestMapping(value = "/teams/{year}", method = RequestMethod.GET)
	List<Team> getTeams(@PathVariable("year") int year);
	
	@RequestMapping(value = "/league/{year}", method = RequestMethod.GET)
	League getLeague(@PathVariable("year") int leagueYear);

	@RequestMapping(value = "/matchday/{season}/{day}", method = RequestMethod.GET)
	Matchday getMatchday(@PathVariable("season") int season, @PathVariable("day") int day);

	@RequestMapping(value = "/matchday/{season}", method = RequestMethod.GET)
	List<Matchday> getMatchdays(@PathVariable("season") int season);

	@RequestMapping(value = "/league/{season}", method = RequestMethod.GET)
	League getLeague(@PathVariable("season") int season);
}
