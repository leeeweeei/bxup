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
@RequestMapping(value = "/known")
public class KnownController {
static Logger log = Logger.getLogger(ResourceController.class.getName());
	
	@Autowired
	private SubscribeService subscribeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllknownchoosehead(Map<String, Object> mode) throws Exception{
		log.info("showAllknown called");
		List<SubscribeForm> subscribe = subscribeService.findAllKnown();
		List<SubscribeForm> known = new ArrayList<SubscribeForm>();
		
/*		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader()
				.getResourceAsStream("Webinfo.properties"));*/
		
		for(int i=0;i<subscribe.size();i++){
			//String picture_url = properties.getProperty("picture_url");
			if(subscribe.get(i).getSubscribe_type() == 2){
				known.add(subscribe.get(i));
				mode.put("known", known);
			}
		}

		return "known";
	}
}


