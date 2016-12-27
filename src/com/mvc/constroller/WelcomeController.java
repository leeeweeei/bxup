package com.mvc.constroller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
			
	static Logger log = Logger.getLogger(WelcomeController.class.getName());
	
/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Map<String, Object> model) {
		return "";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}*/
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomepage() {
		log.info("WelcomePage called");			

		return "redirect:/resources";
	}
	


}
