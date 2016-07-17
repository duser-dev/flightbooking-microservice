package com.cgi.microservices.league;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * League Web Controller
 * He is resposible for handling the Json Answers and render
 * a page.
 * @author beyerd
 *
 */
@Controller
public class LeagueWebController {
	
	@Autowired
	protected WebLeagueService leagueService;
	protected Logger logger = Logger.getLogger(LeagueWebController.class.getName());
	
	/**
	 * Constructor...
	 * @param accountsService
	 */
//	public LeagueWebController(WebLeagueService leagueService) {
//		logger.info("[LeagueWebController] - succesfully reached service...");
//		this.leagueService = leagueService;
//	}
	
	/** 
	 * Default constructor
	 * @param model
	 * @return
	 */
	public LeagueWebController() {
		logger.info("[LeagueWebController] - reached default constructor...");
		this.leagueService  = null;
	}
	
	@RequestMapping("/")
	public String home() {
		logger.info("[LeagueWebController] - called index ...");
		return "index";
	}
	
	@RequestMapping("/league/{leagueYear}")
	public String leagueByYear(Model model, @PathVariable("leagueYear") String leagueYear) {
		logger.info("[LeagueWebController] - called Method leagueByYear(model) ...");
//		League league = leagueService.findByYear(leagueYear); 
				
//		logger.info("web-service byOwner() found: " + league);
//		model.addAttribute("search", name);
//		if (league != null) {
//			logger.info("...we have accounts...");
//			model.addAttribute("leagues", league);
//		}
			
		//return "accounts";
		return "summary";
	}
	
	@RequestMapping("/teams/{leagueYear}")
	public String teamsByYear(Model model, @PathVariable("leagueYear") String leagueYear) {
		logger.info("[LeagueWebController] - called Method teamsByYear(model) ...");
		logger.warning("[LeagueWebController] - we have it....");
		return "summary";
	}
	
	
}
