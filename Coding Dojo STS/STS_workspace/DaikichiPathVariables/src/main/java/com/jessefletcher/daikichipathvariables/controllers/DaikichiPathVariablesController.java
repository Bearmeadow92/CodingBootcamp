package com.jessefletcher.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiPathVariablesController {
	 @RequestMapping("/daikichi")
	    public String daikichi() {
	   	return "Welcome!";
	   }
	    
	 @RequestMapping("/daikichi/today")
	    public String daikichiToday() {
	   	return "Today you will find luck in all your endeavors!";
	   }

	 @RequestMapping("/daikichi/tomorrow")
 		public String daikichiTomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	   }
	 
		@RequestMapping("/daikichi/travel/{city}")
		public String daikichitravel(@PathVariable ("city") String city){
		return String.format("Congratulations! You will soon travel to %s!", city);
		}
	 
		@RequestMapping("/daikichi/lotto/{num}")
		public String daikichiLottoNum(@PathVariable ("num") String num) {
			int intNum = Integer.parseInt(num);
			if(intNum % 2 != 0) {
				return "You have enjoyed the fruits of your labor not now is a great time to spend time with family and friends.";
			}
			else {
				return "You will take a grand journey in the near future, but be weary of tempting offers.";
			}
		}
	 
}
