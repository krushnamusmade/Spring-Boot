package com.krushna.SpringBeanCompmentConfiguration;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootBeanComponentConfiguration {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringBootBeanComponentConfiguration.class, args);
		MyApp component = context.getBean(MyApp.class);
		component.run();
		
		
	}

}
