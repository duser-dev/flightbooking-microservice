package com.cgi.microservices.league;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgi.microservices.league.dto.League;
import com.cgi.microservices.league.dto.Team1;

/**
 * League Web Controller which is responsible for handling the Json Answers and
 * render a page.
 * 
 * @author beyerd
 *
 */
@Controller
@EnableFeignClients
public class LeagueWebController {

	@Autowired
	protected LeaguedataServiceClient leaguedataService;

	protected Logger logger = Logger.getLogger(LeagueWebController.class.getName());

	/**
	 * Default constructor
	 * 
	 * @param model
	 * @return
	 */
	public LeagueWebController() {
		logger.info("[LeagueWebController] - reached default constructor...");
	}

	@RequestMapping("/")
	public String home() {
		logger.info("[LeagueWebController] - called index ...");
		return "index";
	}
	
	@RequestMapping("/info")
	public String info() {
		logger.info("[LeagueWebController] - called index ...");
		return "info";
	}

	@RequestMapping("/teams/{season}")
	public String getTeamsByYear(Model model, @PathVariable("season") int season) {
		logger.info("[LeagueWebController] - called Method teamsByYear(model) ...");
		List<Team1> teamList = leaguedataService.getTeams(season);
		model.addAttribute("year", season);
		
		if (teamList != null) {
			logger.info("...teams found...");
			model.addAttribute("teams", teamList);
		}

		return "summary";
	}

	
	@RequestMapping("/league/{season}")
	public String getLeagueByYear(Model model, @PathVariable("season") int season) {

		logger.info("[LeagueWebController] - called Method leagueByYear(model) ...");
		League league = leaguedataService.getLeague(season);

		if (league != null) {
			logger.info("...league found...");
			model.addAttribute("league", league);
		}

		return "league";
	}

	/*
	 * NOT YET IMPLEMENTED
	@RequestMapping("/matchday/{season}")
	public String getMatchdays(Model model, @PathVariable("season") int season) {

		logger.info("[LeagueWebController] - called Method matchdays(model) ...");
		List<Matchday> matchdayList = leaguedataService.getMatchdays(season);

		if (matchdayList != null) {
			logger.info("...matchdays found...");
			model.addAttribute("matchdays", matchdayList);
		}

		return "league";
	}*/

	/*
	 * NOT YET IMPLEMENTED
	@RequestMapping("/matchday/{season}/{day}")
	public String getMatchday(Model model, @PathVariable("season") int season, @PathVariable("day") int day) {

		Matchday matchday = leaguedataService.getMatchday(season, day);

		logger.info("web-service byOwner() found: " + season);
		model.addAttribute("year", season);
		
		if (matchday != null) {
			logger.info("...matchday found...");
			model.addAttribute("matchday", matchday);
		}

		return "league";
	}*/

}
