package com.pacewisdom.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoForPacewisdomApplication {

	private static final Logger LOGGER =  LoggerFactory.getLogger(DemoForPacewisdomApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoForPacewisdomApplication.class, args);
		LOGGER.info("Main Application Started");
	}

}
