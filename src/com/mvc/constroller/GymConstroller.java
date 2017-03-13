package com.mvc.constroller;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.service.GymInfoService;
import com.wang.form.GymInfoForm;
import com.wang.utility.Constant;



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
		
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader()
				.getResourceAsStream("Webinfo.properties"));

		for(int i=0;i<gym.size();i++){
			String picture_url = properties.getProperty("picture_url");
			if(gym.get(i).getApproved() == 1){
				gym.get(i).setApprovedfg("通过");
			}else{
				gym.get(i).setApprovedfg("未通过");
			}
		
			gym.get(i).setPictureurl(picture_url + "/" + gym.get(i).getAvatar());
		
		}
 				
		mode.put("gym", gym);
		return "gym";
	}

}
