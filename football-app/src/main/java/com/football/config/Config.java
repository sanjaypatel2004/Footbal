package com.football.config;

import java.util.Properties;
import java.io.*;

public class Config{
	
	private static Config config = null;
	private static Properties configFile = null;
	//Constructor for config initializing the file object to a fixed file
	private Config(){
	
		configFile = new Properties();
		try {
				
			String fileName = "C:\\Users\\sanpatel\\git\\Footbal\\football-app\\src\\main\\resources\\config\\config.properties";
			FileInputStream fis = new FileInputStream(fileName);
			configFile.load(fis);
			
		}catch(Exception eta){
	    
			eta.printStackTrace();
		}
	}

	//Making the class Singleton to avoid unnecessary instance creation
	public static Config getInstance() {
		
		if (config == null) {
			
			config = new Config();
		}
		
		return config;
		
	}
	//Method to fetch value corresponding to the key
	public String getProperty(String key){
		
		String value = configFile.getProperty(key);
		return value;
   }
	
}