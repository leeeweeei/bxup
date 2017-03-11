package com.mvc.constroller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
			
	static Logger log = Logger.getLogger(WelcomeController.class.getName());	
	
	@RequestMapping(value = "/welcome1", method = RequestMethod.GET)
	public String eventresources() {
		log.info("WelcomePage called");			

		return "redirect:/resources";
	}
	
	@RequestMapping(value = "/welcome2", method = RequestMethod.GET)
	public String coachresources() {
		log.info("WelcomePage called");			

		return "redirect:/coach";
	}
	
	@RequestMapping(value = "/welcome3", method = RequestMethod.GET)
	public String mgyresources() {
		log.info("WelcomePage called");			

		return "redirect:/gym";
	}
	
	@RequestMapping(value = "/welcome4", method = RequestMethod.GET)
	public String feedback() {
		log.info("WelcomePage called");			

		return "redirect:/feedback";
	}
	


}
