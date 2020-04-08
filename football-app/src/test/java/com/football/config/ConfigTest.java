package com.football.config;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigTest {

	
	@Test
	public void test() {
		Config configFile = Config.getInstance();
		assertEquals("Tested", configFile.getProperty("football.api.url"),"apiv2.apifootball.com");
	}

}
