package com.cgi.microservices.league;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgi.microservices.league.dto.League;
import com.cgi.microservices.league.dto.Team;

@FeignClient("http://leaguedata-service")
public interface LeaguedataServiceClient {

	@RequestMapping(value = "/teams/{year}", method = RequestMethod.GET)
	List<Team> getTeams(@PathVariable("year") int year);
	
	@RequestMapping(value = "/league/{year}", method = RequestMethod.GET)
	League getLeague(@PathVariable("year") int leagueYear);

}
