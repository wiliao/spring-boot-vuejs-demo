package com.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	 
	// Enable CORS globally
	// Webpack & Vue have something much smarter for us to help us with Single-Origin Policy(SOP)!
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//	  return new WebMvcConfigurer() {
//	    @Override
//	    public void addCorsMappings(CorsRegistry registry) {
//	      registry.addMapping("/api/*").allowedOrigins("http://localhost:8080");
//	    }
//	  };
//	}
	
}
