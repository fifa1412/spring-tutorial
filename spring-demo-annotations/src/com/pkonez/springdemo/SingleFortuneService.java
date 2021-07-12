package com.pkonez.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SingleFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "This is single fortune service";
	}

}
