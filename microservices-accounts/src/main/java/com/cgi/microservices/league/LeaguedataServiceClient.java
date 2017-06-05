package com.cgi.microservices.league;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgi.microservices.league.dto.League;
import com.cgi.microservices.league.dto.Match;
import com.cgi.microservices.league.dto.Matchday;
import com.cgi.microservices.league.dto.Team1;

/**
 * Feign service client with enabled load balancing
 * 
 * @author mark
 *
 */
@FeignClient("http://leaguedata-service")
public interface LeaguedataServiceClient {

	@RequestMapping(value = "/teams/{season}", method = RequestMethod.GET)
	List<Team1> getTeams(@PathVariable("season") int year);
	
	@RequestMapping(value = "/matchday/{season}/{day}", method = RequestMethod.GET)
	Matchday getMatchday(@PathVariable("season") int season, @PathVariable("day") int day);

	@RequestMapping(value = "/matchday/{season}", method = RequestMethod.GET)
	List<Matchday> getMatchdays(@PathVariable("season") int season);

	@RequestMapping(value = "/league/{season}", method = RequestMethod.GET)
	List<Match> getLeague(@PathVariable("season") int season, boolean forceRefresh);
}
