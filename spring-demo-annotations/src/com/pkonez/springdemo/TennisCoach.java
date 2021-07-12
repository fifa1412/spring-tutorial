package com.pkonez.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

//@Component("theSillyCoach")
@Component
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean {
	
	// 3. Field Injection (Java Reflection)
	@Autowired
	@Qualifier("fileRandomFortuneService")
	private FortuneService fortuneService;
	
	//1. Constructor Injection
	/*@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}*/
	
	/* 2. Setter Injection: define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	// define a setter method
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		fortuneService = theFortuneService;
	}*/
	
	/*
	@Autowired
 	2.1. Method Injection
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
		fortuneService = theFortuneService; 
	}*/
	
	
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
		
		// read fortune from file
		File file;
		try {
			// read fortune list from file
			file = ResourceUtils.getFile("classpath:fortune.txt");
			FileReader fr = new FileReader(file);   //reads the file  
			BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  
			System.out.println(br.readLine());
			fr.close();  
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	}
	
	

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println(">> TennisCoach: inside destroy()");
		
	}

}
