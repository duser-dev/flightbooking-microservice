package com.cgi.microservices.services.leaguedata;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.microservices.services.leaguedata.LeagueData.League;
import com.cgi.microservices.services.leaguedata.LeagueData.Matchday;
import com.cgi.microservices.services.leaguedata.LeagueData.Team;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

@RestController
public class LeagueDataController {

	protected Logger logger = Logger.getLogger(LeagueDataController.class.getName());
	private LeagueDataProvider dataProvider;

	public LeagueDataController() {
		this.dataProvider = new OpenLigaDbLeagueDataProvider(Feign.builder().decoder(new GsonDecoder())
				.encoder(new GsonEncoder()).target(OpenLigaDb.class, "http://www.openligadb.de"));
	}

	@RequestMapping("/league/{season}")
	public League getLeague(@PathVariable("season") int season,
			@RequestParam(value = "forceRefresh", defaultValue = "false") boolean forceRefresh) {

		return dataProvider.getLeague(season, forceRefresh);
	}

	@RequestMapping("/teams/{season}")
	public List<Team> getTeams(@PathVariable("season") int season) {

		return dataProvider.getTeams(season);
	}

	@RequestMapping("/matchday/{season}")
	public List<Matchday> getMatchdays(@PathVariable("season") int season,
			@RequestParam(value = "forceRefresh", defaultValue = "false") boolean forceRefresh) {

		return dataProvider.getMatchdays(season, forceRefresh);
	}

	@RequestMapping("/matchday/{season}/{day}")
	public Matchday getMatchday(@PathVariable("season") int season, @PathVariable("day") int day) {

		return dataProvider.getMatchday(season, day);
	}

}
