package com.pkonez.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}
	
	@Override
	public String getRandomFortune() {
		String[] fortune_list = {
				"Today is your lucky day!", 
				"Today is your bad day!", 
				"Today is not your day!",
		};
		int rnd = new Random().nextInt(fortune_list.length);
	    return fortune_list[rnd];
	}

}
