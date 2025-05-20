package com.springcore.main;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {  //Central Configuration Class 

	static {
		System.out.println("App Config File Detected and Loaded...");
	}
}
