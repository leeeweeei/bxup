package com.bxup.bxup.constroller;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bxup.bxup.model.Coach;
import com.bxup.bxup.model.Gym;
import com.bxup.bxup.service.CoachService;
import com.bxup.bxup.service.GymService;


@Controller
@RequestMapping(value = "/coach")
public class CoachController {

	static Logger log = Logger.getLogger(CoachController.class.getName());
	
	@Autowired
	private CoachService coachInfoService;
	@Autowired
	private GymService gymInfoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllResource(Map<String, Object> mode) throws Exception{
		log.info("showAllCoachInfo called");
		
		List<Coach> coach = coachInfoService.findAll();	
		
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader()
				.getResourceAsStream("Webinfo.properties"));
		
		for(int i=0;i<coach.size();i++){
			if(coach.get(i).getGendar() == 1){
				coach.get(i).setSex("男");
			}else{
				coach.get(i).setSex("女");
			}
			if(coach.get(i).getApproved() == 1){
				coach.get(i).setApprovedfg("通过");
			}else{
				coach.get(i).setApprovedfg("未通过");
			}
			
			int gymid = coach.get(i).getGym_id();
			if(gymid != 0){
				Gym gymInfoForm = (Gym) gymInfoService.findgymById(gymid);
				coach.get(i).setGym_name(gymInfoForm.getName());
			}
			
			String picture_url = properties.getProperty("picture_url");
			
			coach.get(i).setPictureurl(picture_url + "/" + coach.get(i).getAvatar());
			
					
		}

		
		mode.put("coach", coach);
		return "coach";
	}				
		
}
