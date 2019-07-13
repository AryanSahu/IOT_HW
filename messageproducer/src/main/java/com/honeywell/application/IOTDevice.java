package com.honeywell.application;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class IOTDevice {
	
	RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
	
	private HttpClient httpClient()
    {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
 
        credentialsProvider.setCredentials(AuthScope.ANY,
                        new UsernamePasswordCredentials("turbine1", "password"));
 
        HttpClient client = HttpClientBuilder
                                .create()
                                .setDefaultCredentialsProvider(credentialsProvider)
                                .build();
        return client;
    }
	
	
	private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory()
    {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                          = new HttpComponentsClientHttpRequestFactory();
         
        clientHttpRequestFactory.setHttpClient(httpClient());
              
        return clientHttpRequestFactory;
    }
	
	
	public static void main(String[] args) {
		
		
		
		
		
		while(true)
			
		{
			
			 new IOTDevice().restTemplate.getForEntity("http://localhost:9090/pumpTimeSeriesData?deviceId=123&data=666", String.class);
			
		}
	}
     

}
