package com.cgi.microservices.services.leaguedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class LeagueDataServer {

	public static void main(String[] args) {

		System.setProperty("spring.config.name", "leaguedata-server");

		SpringApplication.run(LeagueDataServer.class, args);

	}
}
