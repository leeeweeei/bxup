package com.mvc.constroller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.service.GymInfoService;
import com.wang.form.GymInfoForm;

@Controller
@RequestMapping(value = "/gym")
public class GymConstroller {
	
	static Logger log = Logger.getLogger(ResourceController.class.getName());
	
	@Autowired
	private GymInfoService gymInfoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllResource(Map<String, Object> mode) throws Exception{
		log.info("showAllCoachInfo called");
		List<GymInfoForm> gym = gymInfoService.findAll();	
		
		for(int i=0;i<gym.size();i++){

			if(gym.get(i).getApproved() == 1){
				gym.get(i).setApprovedfg("通过");
			}else{
				gym.get(i).setApprovedfg("未通过");
			}
			
		}
 
				
		mode.put("gym", gym);
		return "gym";
	}

}
