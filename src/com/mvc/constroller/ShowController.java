package com.mvc.constroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.service.ShowService;
import com.mvc.service.UserService;
import com.wang.form.PhotoForm;
import com.wang.form.ShowForm;
import com.wang.form.ShowPhotoRelForm;
import com.wang.form.UserForm;

@Controller
@RequestMapping(value = "/show")
public class ShowController {
	
	
	static Logger log = Logger.getLogger(ResourceController.class.getName());
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private UserService userService;
	

	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllShow(Map<String, Object> mode) throws Exception{
		log.info("showAllShow called");
		List<ShowForm> show = showService.findAll();
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader()
				.getResourceAsStream("Webinfo.properties"));
		List<String> nicknameList  = new ArrayList<String>();
		for(int i=0;i<show.size();i++){
			
			long user_id = show.get(i).getUser_id();
			long id = show.get(i).getId();
			List<UserForm> user = userService.findnicknamebyid(user_id);
			nicknameList.add(user.get(i).getNickname());					
			List<ShowPhotoRelForm> showphotorel = showService.findrelbyid(id);
			for(int n=0;n<showphotorel.size();n++){
				long photo_id = showphotorel.get(n).getPhoto_id();
				List<PhotoForm> photo = showService.findphotonamebyid(photo_id);
				photo.get(n).getFile_name();
				
			}
			
			String picture_url = properties.getProperty("picture_url");
			//gym.get(i).setPictureurl(picture_url + "/" + show.get(i).getAvatar());	
		}
			

 			
		mode.put("show", show);
		return "show";
	}

}

