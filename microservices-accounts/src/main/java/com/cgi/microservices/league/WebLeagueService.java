package com.cgi.microservices.league;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * Hide the access to the microservice inside this local service.
 * 
 * @author Paul Chapman
 */
@Service
public class WebLeagueService {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(WebLeagueService.class.getName());

	public WebLeagueService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

//	/**
//	 * Default Constructor
//	 */
//	public WebLeagueService() {
//		// we do just nothing....
//	}
	
	/**
	 * The RestTemplate works because it uses a custom request-factory that uses
	 * Ribbon to look-up the service to use. This method simply exists to show
	 * this.
	 */
	@PostConstruct
	public void demoOnly() {
		// Can't do this in the constructor because the RestTemplate injection
		// happens afterwards.
//		logger.warning("The RestTemplate request factory is " + restTemplate.getRequestFactory());
		logger.warning("ahhhhhhhh");
	}

	public List findByYear(String yearNumber) {
		logger.info("findByNumber() invoked: for " + yearNumber);
		logger.info("Invoking REST Service at : " + serviceUrl + "/teams/" + yearNumber);
		
		List league = restTemplate.getForObject(serviceUrl + "/teams/{number}", List.class, yearNumber);
		
		if(league == null) {
			logger.warning("repsonse is emtpy...");
			return null;
		}
		
		logger.info(league.toString());
		
		return league;
	}

}
