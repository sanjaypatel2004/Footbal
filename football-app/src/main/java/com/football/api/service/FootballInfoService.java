package com.football.api.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.football.api.connector.ApiConnector;

public class FootballInfoService {
	
	String apiKey = "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
	String baseURL = "https://apiv2.apifootball.com/";
	String questionMark = "?";
	String action = "action";
	String equalSign= "=";

	private static final Logger LOGGER = LoggerFactory.getLogger(FootballInfoService.class);
			
	public String getCountriesJSON() throws Exception{
		
		ApiConnector apiConnector = new ApiConnector();
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("action", "get_countries");

		String url = createURL(param);
		LOGGER.info("URL created is: "+ url);

		String responseJSON = apiConnector.sendGet(url);
		return responseJSON;
		
	}

	public String getLeaguesJSON(String country) throws Exception{
		
		LOGGER.info("started method getLeaguesJSON with country: "+ country);
		
		ApiConnector apiConnector = new ApiConnector();
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("action", "get_leagues");
		param.put("country_id", country);
		
		String url = createURL(param);
		LOGGER.info("URL created is: "+ url);
		String responseJSON = apiConnector.sendGet(url);
		return responseJSON;
		
	}

	private String createURL(HashMap<String, String> param) {
		
		StringBuffer url = new StringBuffer().append(this.baseURL).append(this.questionMark);
		
		StringBuffer paramlist = new StringBuffer();
		
		Set entrySet = param.entrySet();
		
		Iterator itr = entrySet.iterator();
		
		while (itr.hasNext()) {
			
			Map.Entry entry = (Map.Entry)itr.next();
			paramlist.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		
		url.append(paramlist).append("APIkey=").append(this.apiKey);
		return url.toString();
		
		
	}
}
