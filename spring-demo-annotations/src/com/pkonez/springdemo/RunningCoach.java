package com.pkonez.springdemo;

import org.springframework.stereotype.Component;

@Component("marathonCoach")
public class RunningCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Go run 42.195km";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
