package com.pkonez.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// create the object
		//BaseballCoach theCoach = new BaseballCoach();
		//Coach theCoach = new BaseballCoach();
		Coach theCoach = new TrackCoach();
		
		
		// use the object
		System.out.println(theCoach.getDailyWorkout());
	}

}
