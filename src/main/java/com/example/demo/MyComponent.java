package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MyComponent {
	
	@Value("${app.name}")
	private String appName;
	
	public String getAppName() {
		return appName;
	}
	

}
