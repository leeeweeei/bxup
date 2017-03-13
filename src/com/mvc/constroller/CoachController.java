package com.mvc.constroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.service.CoachInfoService;
import com.mvc.service.GymInfoService;
import com.wang.form.CoachInfoForm;
import com.wang.form.CoachPhotoForm;
import com.wang.form.GymInfoForm;
import com.wang.utility.Constant;


@Controller
@RequestMapping(value = "/coach")
public class CoachController {

	static Logger log = Logger.getLogger(ResourceController.class.getName());
	
	@Autowired
	private CoachInfoService coachInfoService;
	@Autowired
	private GymInfoService gymInfoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllResource(Map<String, Object> mode) throws Exception{
		log.info("showAllCoachInfo called");
		
		List<CoachInfoForm> coach = coachInfoService.findAll();	
		
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
				GymInfoForm gymInfoForm = (GymInfoForm) gymInfoService.findgymById(gymid);
				coach.get(i).setGym_name(gymInfoForm.getName());
			}
			
			String picture_url = properties.getProperty("picture_url");
			
			coach.get(i).setPictureurl(picture_url + "/" + coach.get(i).getAvatar());
			
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			java.util.Date date = new Date(coach.get(i).getCreate_time() * 1000);
				String cre_time = sdf.format(date); 				
		}

		
		mode.put("coach", coach);
		return "coach";
	}				
		
}
