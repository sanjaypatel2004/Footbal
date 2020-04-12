package com.football.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.football.api.controller"})
public class FootballWebApplication {
	
	public static void main (String args[]) {
		
		SpringApplication.run(FootballWebApplication.class, args);
	}

}
