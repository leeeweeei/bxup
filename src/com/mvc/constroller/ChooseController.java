package com.mvc.constroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.service.SubscribeService;
import com.wang.form.SubscribeForm;

@Controller
@RequestMapping(value = "/choose")
public class ChooseController {
static Logger log = Logger.getLogger(ResourceController.class.getName());
	
	@Autowired
	private SubscribeService subscribeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllknownchoosehead(Map<String, Object> mode) throws Exception{
		log.info("showAllknown called");
		List<SubscribeForm> subscribe = subscribeService.findAllKnown();
		List<SubscribeForm> choose = new ArrayList<SubscribeForm>();				
		for(int i=0;i<subscribe.size();i++){
			if(subscribe.get(i).getSubscribe_type() == 3){
				choose.add(subscribe.get(i));
				mode.put("choose", choose);
			}
		}
		return "choose";
	}
}


