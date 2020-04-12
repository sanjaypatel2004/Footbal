package com.football.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.football.api.service.FootballInfoService;

@RestController
@RequestMapping("/api/v1")
public class LeagueController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(LeagueController.class);
	
	@GetMapping("/countries")
	public ResponseEntity<String> getCountries() throws Exception{
		
		FootballInfoService foolballService = new FootballInfoService();
		
		LOGGER.info("request recieved for fetching countries");
		return new ResponseEntity<String>(foolballService.getCountriesJSON(), HttpStatus.OK);
	}

	@GetMapping("/leagues")
	public ResponseEntity<String> getLeagues(@RequestParam(value="country") String country) throws Exception{
		
		FootballInfoService foolballService = new FootballInfoService();
		
		LOGGER.info("request recieved for fetching Leagues for the country id: " + country);
		
		return new ResponseEntity<String>(foolballService.getLeaguesJSON(country), HttpStatus.OK);
	}

}
