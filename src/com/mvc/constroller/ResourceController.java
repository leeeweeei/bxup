package com.mvc.constroller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//import javax.validation.Valid;

//import org.joda.time.DateTime;
//import org.joda.time.format.DateTimeFormat;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.service.ResourceService;
import com.wang.form.EventInsertForm;

@Controller
@RequestMapping(value = "/resources")
public class ResourceController {
	
	static Logger log = Logger.getLogger(ResourceController.class.getName());

	@Autowired
	private ResourceService resourceService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllResource(Map<String, Object> mode) throws SQLException{
		log.info("showAllResource called");
		List<EventInsertForm> resources = resourceService.findAll();
		
 		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader()
					.getResourceAsStream("Webinfo.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String picturepositiontmp = properties.getProperty("picturepositiontmp");
	         File f = new File(picturepositiontmp);	         
	         if (!f.exists()) {
	        	 log.info("Folder not exists");	        	 
	        	 if (!f.mkdir()){
	        		 mode.put("message",  "create Folder " +  f.getPath() + " faile");
	        		 log.error("create Folder faile");
	        		 return "resources";
	        	 }
	         }
	         File fa[] = f.listFiles();
	         for (int i = 0; i < fa.length; i++) {
	             File fs = fa[i];
	             String filename = fs.getName();
	             String time = filename.substring(filename.indexOf(".")-17,filename.indexOf(".")-9);
//	             System.out.print(time); 
	             SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
//	             System.out.println(df.format(new Date()));
	             String timenow = df.format(new Date()).toString();
	            if(time.compareTo(timenow) < 0){
	            	fs.delete();	            	
	            }
	         }
				
		mode.put("resources", resources);
		return "resources";
	}
	
	
	@RequestMapping(value = "/event_edit/{id}", method = RequestMethod.GET)
	public String editEvent(Model model, @PathVariable String id) throws SQLException{
		        log.info("editEvent called");
				EventInsertForm edit_event = resourceService.findById(id);
/*				 Iterator iter = edit_event.iterator();
				  while(iter.hasNext()){
				   String str = (String) iter.next();
				   System.out.println(str);
				  }*/
			
				model.addAttribute("event_name", edit_event.getEvent_name());
				model.addAttribute("event_start_date", edit_event.getEvent_start_date());
				model.addAttribute("event_end_date", edit_event.getEvent_end_date());
				model.addAttribute("event_time", edit_event.getEvent_time());
				model.addAttribute("event_link", edit_event.getEvent_link());
				model.addAttribute("event_desc", edit_event.getEvent_desc());
				model.addAttribute("event_place", edit_event.getEvent_place());
				model.addAttribute("id", edit_event.getId());
				
				return "editevent";
			 }


	@RequestMapping(value = "/event_delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id,		
			Map<String, Object> model) throws Exception {
	
		   log.info("delete called");
		   resourceService.deleteEventById(id);
		 	 
		 return "redirect:/resources";	
	}
	
	@RequestMapping(value = "/event_update/{id}", method = RequestMethod.POST)
	public String updateevent(@PathVariable String id,HttpServletRequest request,
			HttpServletResponse response, EventInsertForm eventInsertForm) throws SQLException {
		 log.info("updateevent called");
		 resourceService.updateEventById(eventInsertForm);
	 
		 return "redirect:/resources";
	}
	
	
}
