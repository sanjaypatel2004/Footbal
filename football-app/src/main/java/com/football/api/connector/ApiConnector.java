package com.football.api.connector;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

public class ApiConnector {
	
		
	public String sendGet(String url) throws Exception {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
        String result = null;

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            
            
            if (entity != null) {
                // return it as a String
                result = EntityUtils.toString(entity);
                
            }
            httpClient.close();

        }
        return result;

    }
	
}
