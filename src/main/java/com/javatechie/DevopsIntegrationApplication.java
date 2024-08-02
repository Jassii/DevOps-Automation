package com.javatechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@RestController
public class DevopsIntegrationApplication {

	Logger logger=LoggerFactory.getLogger(DevopsIntegrationApplication.class);
	@GetMapping
	public String message(){
		logger.info("info message");
		logger.debug("This is a debug message");
		return "Hi Welcome to DevOps Automation";
	}

	public static void main(String[] args) {
		SpringApplication.run(DevopsIntegrationApplication.class, args);
	}

}
