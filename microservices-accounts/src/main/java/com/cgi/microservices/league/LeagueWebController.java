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
	public LeagueWebController(WebLeagueService leagueService) {
		logger.info("[LeagueWebController] - succesfully reached service...");
		this.leagueService = leagueService;
	}
	
	/** 
	 * Default constructor
	 * @param model
	 * @return
	 */
	public LeagueWebController() {
		logger.info("[LeagueWebController] - reached default constructor...");
		this.leagueService  = null;
	}
	
	@RequestMapping("league/{year}")
	public String summary(Model model, @PathVariable("leagueYear") String leagueYear) {
		logger.info("[LeagueWebController] - called Method summary(model) ...");
		League league = leagueService.findByYear(leagueYear); 
				
		logger.info("web-service byOwner() found: " + league);
//		model.addAttribute("search", name);
		if (league != null) {
			logger.info("...we have accounts...");
			model.addAttribute("leagues", league);
		}
			
		//return "accounts";
		return "summary";
	}
	
	
	
	/*@Autowired
	protected WebAccountsService accountsService;

	protected Logger logger = Logger.getLogger(WebAccountsController.class.getName());

	public WebAccountsController(WebAccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("accountNumber", "searchText");
	}

	@RequestMapping("/accounts")
	public String goHome() {
		return "index";
	}

	@RequestMapping("/accounts/{accountNumber}")
	public String byNumber(Model model,
			@PathVariable("accountNumber") String accountNumber) {

		logger.info("web-service byNumber() invoked: " + accountNumber);

		Account account = accountsService.findByNumber(accountNumber);
		logger.info("web-service byNumber() found: " + account);
		model.addAttribute("account", account);
		return "account";
	}

	@RequestMapping("/accounts/owner/{text}")
	public String ownerSearch(Model model, @PathVariable("text") String name) {
		logger.info("web-service byOwner() invoked: " + name);

		List<Account> accounts = accountsService.byOwnerContains(name);
		logger.info("web-service byOwner() found: " + accounts);
		model.addAttribute("search", name);
		if (accounts != null)
			model.addAttribute("accounts", accounts);
		return "accounts";
	}

	@RequestMapping(value = "/accounts/search", method = RequestMethod.GET)
	public String searchForm(Model model) {
		model.addAttribute("searchCriteria", new SearchCriteria());
		return "accountSearch";
	}

	@RequestMapping(value = "/accounts/dosearch")
	public String doSearch(Model model, SearchCriteria criteria,
			BindingResult result) {
		logger.info("web-service search() invoked: " + criteria);

		criteria.validate(result);

		if (result.hasErrors())
			return "accountSearch";

		String accountNumber = criteria.getAccountNumber();
		if (StringUtils.hasText(accountNumber)) {
			return byNumber(model, accountNumber);
		} else {
			String searchText = criteria.getSearchText();
			return ownerSearch(model, searchText);
		}
	}
	*/
}
