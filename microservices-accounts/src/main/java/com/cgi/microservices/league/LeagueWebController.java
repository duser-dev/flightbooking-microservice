package com.cgi.microservices.league;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/league/{leagueYear}")
	public String leagueByYear(Model model, @PathVariable("leagueYear") String leagueYear) {
		logger.info("[LeagueWebController] - called Method leagueByYear(model) ...");
		// League league = leagueService.findByYear(leagueYear);

		// logger.info("web-service byOwner() found: " + league);
		// model.addAttribute("search", name);
		// if (league != null) {
		// logger.info("...we have accounts...");
		// model.addAttribute("leagues", league);
		// }

		// return "accounts";
		return "summary";
	}

	@RequestMapping("/teams/{leagueYear}")
	public String teamsByYear(Model model, @PathVariable("leagueYear") String leagueYear) {
		logger.info("[LeagueWebController] - called Method teamsByYear(model) ...");
		List<Team> teamList = leaguedataService.getTeams(Integer.valueOf(leagueYear));

		logger.info("[LeagueWebController] - web-service byOwner() found: " + teamList);

		if (teamList != null) {
			logger.info("...we have accounts...");
			model.addAttribute("teams", teamList);
		}

		return "summary";
	}

}
