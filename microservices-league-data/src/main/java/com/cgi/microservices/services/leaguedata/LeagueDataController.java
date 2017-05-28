package com.cgi.microservices.services.leaguedata;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.microservices.services.leaguedata.dto.Match;
import com.cgi.microservices.services.leaguedata.dto.Team1;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LeagueDataController {

	protected Logger logger = Logger.getLogger(LeagueDataController.class.getName());
	private LeagueDataProvider dataProvider;

	@Autowired
	public LeagueDataController(LeagueDataProvider dataProvider) {
		this.dataProvider = dataProvider;

	}

	@HystrixCommand()
	@RequestMapping("/league/{season}")
	public List<List<Match>> getLeague(@PathVariable("season") int season,
			@RequestParam(value = "forceRefresh", defaultValue = "false") boolean forceRefresh) {

		return dataProvider.getLeague(season, forceRefresh);
	}

	@HystrixCommand()
	@RequestMapping("/teams/{season}")
	public List<Team1> getTeams(@PathVariable("season") int season) {

		return dataProvider.getTeams(season);
	}

	@HystrixCommand()
	@RequestMapping("/matchday/{season}")
	public List<List<Match>> getMatchdays(@PathVariable("season") int season,
			@RequestParam(value = "forceRefresh", defaultValue = "false") boolean forceRefresh) {

		return dataProvider.getMatchdays(season, forceRefresh);
	}

	@HystrixCommand()
	@RequestMapping("/matchday/{season}/{day}")
	public List<Match> getMatchday(@PathVariable("season") int season, @PathVariable("day") int day) {

		return dataProvider.getMatchday(season, day);
	}

}
