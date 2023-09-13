package com.java.learnjava.programs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//this is to get values defined in property file.
@ConfigurationProperties(prefix = "currency-service")
@Component
public class ConfigurationPropertry {
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	

}
