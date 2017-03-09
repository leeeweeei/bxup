package com.mvc.constroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.service.CoachInfoService;
import com.wang.form.CoachInfoForm;

@Controller
@RequestMapping(value = "/coach")
public class CoachController {

	static Logger log = Logger.getLogger(ResourceController.class.getName());
	
	@Autowired
	private CoachInfoService coachInfoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllResource(Map<String, Object> mode) throws Exception{
		log.info("showAllCoachInfo called");
		List<CoachInfoForm> coach = coachInfoService.findAll();	
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
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			java.util.Date date = new Date(coach.get(i).getCreate_time() * 1000);
				String cre_time = sdf.format(date); 

		}

				
		mode.put("coach", coach);
		return "coach";
	}
	
}
