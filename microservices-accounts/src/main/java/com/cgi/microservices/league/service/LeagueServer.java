package com.cgi.microservices.league.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.cgi.microservices.league.LeagueWebController;


/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link AccountsWebApplication}. This is a deliberate separation of concerns
 * and allows the application to run:
 * <ul>
 * <li>Standalone - by executing {@link AccountsWebApplication#main(String[])}</li>
 * <li>As a microservice - by executing {@link AccountsServer#main(String[])}</li>
 * </ul>
 * 
 * @author Paul Chapman
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(LeagueWebController.class)
public class LeagueServer {

	// -Autowired
	//protected AccountRepository accountRepository;

	protected static Logger LOGGER = Logger.getLogger(LeagueServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or
		// accounts-server.yml
		LOGGER.info("Running a microservice...");
		System.setProperty("spring.config.name", "league-server");
		LOGGER.info("Setted the properties...");
		SpringApplication.run(LeagueServer.class, args);
	}
}
