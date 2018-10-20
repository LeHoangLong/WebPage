
package com.kiti;

import com.kiti.backend.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.kiti.backend")
public class WebApplication {
	


	
	public static void main(String[] args) {
		initializeDatabase();
		SpringApplication.run(WebApplication.class, args);
	}
	
	private static void initializeDatabase() {
		
	}
}
