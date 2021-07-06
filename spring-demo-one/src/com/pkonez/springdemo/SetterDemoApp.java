package com.pkonez.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		CricketCoach theCoach2 = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		// call our new methods to get the literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		System.out.println("Your Random Fortune: " + theCoach.getDailyRandomFortune());
		
		
		boolean isEqual = (theCoach == theCoach2);
		System.out.println("Check is Equals: " + isEqual);
		System.out.println(theCoach);
		System.out.println(theCoach2);
		
		
		// close the context
		context.close();

	}

}
