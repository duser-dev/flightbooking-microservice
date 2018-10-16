package com.cgi.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableTurbine
public class MonitorApplication {

	@RequestMapping("/")
	public String home() {
		return "forward:/hystrix";
	}

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "monitorApplication-server");

		SpringApplication.run(MonitorApplication.class, args);
	}
}
