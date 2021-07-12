package com.pkonez.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class FileRandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		List<String> fortuneList = new ArrayList<String>();
		String returnFortune = "";
		File file;
		try {
			// read fortune list from file
			file = ResourceUtils.getFile("classpath:fortune_list.txt");
			FileReader fr = new FileReader(file);   //reads the file  
			BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  
			String line;  
			while((line = br.readLine()) != null)  
			{  
				fortuneList.add(line);
			}  
			fr.close();  
			
			// random fortune from array
			Random myRandom = new Random();
			int index = myRandom.nextInt(fortuneList.size());
			returnFortune = fortuneList.get(index).toString();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return returnFortune;

	}

}
