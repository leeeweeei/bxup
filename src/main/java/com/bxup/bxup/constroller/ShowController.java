package com.bxup.bxup.constroller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bxup.bxup.controller.client.dto.ShowDto;
import com.bxup.bxup.model.Show;
import com.bxup.bxup.service.ShowService;
import com.bxup.bxup.service.UserService;

@Controller
@RequestMapping(value = "/show")
public class ShowController {
	
	
	static Logger log = Logger.getLogger(ShowController.class.getName());
	
	@Autowired
	private ShowService showService;	
	
	@Autowired
	private UserService userService;
	

	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllShow(Map<String, Object> mode) throws Exception{
		log.info("showAllShow called");
		List<ShowDto> showDto = showService.findAll();
/*		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader()
				.getResourceAsStream("Webinfo.properties"));*/
//		List<String> nicknameList  = new ArrayList<String>();
/*		for(int i=0;i<show.size();i++){
			
			long user_id = show.get(i).getUser_id();
			long id = show.get(i).getId();
			List<User> user = userService.findnicknamebyid(user_id);
			show.get(i).setNickname(user.get(0).getNickname());					
			List<ShowPhotoRel> showphotorel = showService.findrelbyid(id);
			show.get(i).setPhotos(new ArrayList<String>());
			for(int n=0;n<4;n++){
				if(n >= showphotorel.size()){
					show.get(i).getPhotos().add("");
				} else {
					long photo_id = showphotorel.get(n).getPhoto_id();
					List<Photo> photo = showService.findphotonamebyid(photo_id);
					show.get(i).getPhotos().add(photo.get(0).getFile_name());
				}
				
			}			
			String picture_url = properties.getProperty("picture_url");
			gym.get(i).setPictureurl(picture_url + "/" + show.get(i).getAvatar());	
		}*/
			

 			
		mode.put("show", showDto);
		return "show";
	}

}

