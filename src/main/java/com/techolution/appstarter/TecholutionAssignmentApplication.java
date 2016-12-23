package com.techolution.appstarter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.techolution.rest","com.techolution.util"})
public class TecholutionAssignmentApplication {
	private static Logger log= LoggerFactory.getLogger(TecholutionAssignmentApplication.class);
	public static void main(String[] args) {
		log.info("Application is starting Up.");
			SpringApplication.run(TecholutionAssignmentApplication.class, args);
			log.info("Application Started Successfully.");
	}
}
