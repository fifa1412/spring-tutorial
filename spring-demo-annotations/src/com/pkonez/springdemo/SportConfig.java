package com.pkonez.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.pkonez.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public FortuneService singleFortuneService() {
		return new SingleFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	// return type should be Coach (Coach interface to find any dependencies that implement the Coach interface)
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService()); // call from line 14
	}
	
	@Bean
	public Coach footballCoach() {
		return new FootballCoach(singleFortuneService()); // call from line 14
	}

}
