package com.cgi.microservices.services.leaguedata;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	private LeagueDataProvider datasource;

	public LeagueDataController() {
		this.datasource = new OpenLigaDbLeagueDataAdapter(Feign.builder().decoder(new GsonDecoder())
				.encoder(new GsonEncoder()).target(OpenLigaDb.class, "http://www.openligadb.de"));
	}

	@RequestMapping("/league/{season}")
	public League getLeague(@PathVariable("season") int season) {

		return datasource.getLeague(season);
	}

	@RequestMapping("/teams/{season}")
	public List<Team> getTeams(@PathVariable("season") int season) {

		return datasource.getLeague(season).getTeams();
	}

	@RequestMapping("/matchday/{season}")
	public List<Matchday> getMatchdays(@PathVariable("season") int season) {

		return datasource.getLeague(season).getMatchdays();
	}

	@RequestMapping("/matchday/{season}/{day}")
	public Matchday getMatchday(@PathVariable("season") int season, @PathVariable("day") int day) {

		return datasource.getLeague(season).getMatchday(day);
	}

}
