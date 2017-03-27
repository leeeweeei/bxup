package com.bxup.bxup.constroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bxup.bxup.controller.client.dto.ShowDto;


import com.bxup.bxup.model.Show;
import com.bxup.bxup.service.ShowService;

@Controller
@RequestMapping(value = "/show")
public class ShowController {

	static Logger log = Logger.getLogger(ShowController.class.getName());

	@Autowired
	private ShowService showService;


	@RequestMapping(method = RequestMethod.GET)
	public String showAllShow(Map<String, Object> mode) throws Exception {
		log.info("showAllShow called");
		List<ShowDto> showDto = showService.findAll();
		List<ShowDto> showDtos = new ArrayList<ShowDto>();
		ShowDto show = new ShowDto();
		Long showID = null;
		int imgcount= 1;
		for(int i=0;i<showDto.size();i++){
			if(!showDto.get(i).getId().equals(showID)){				
				if(i != 0){
					showDtos.add(show);
				}
				show = new ShowDto();
				show.setId(showDto.get(i).getId());
				show.setDescription(showDto.get(i).getDescription());
				show.setNickname(showDto.get(i).getNickname());
				//System.out.println(transferLongToDate("yyyy/MM/dd",showDto.get(i).getCreate_time()));
				show.setCreateTime(showDto.get(i).getCreateTime());
				show.setImg1(showDto.get(i).getImg());
				imgcount = 2;
				showID = showDto.get(i).getId();
			} else {
				if(imgcount == 2){
					show.setImg2(showDto.get(i).getImg());
				} else if(imgcount == 3){
					show.setImg3(showDto.get(i).getImg());
				} else if(imgcount == 4){
					show.setImg4(showDto.get(i).getImg());
				} 
				imgcount++;
			}
		}
		showDtos.add(show);
		mode.put("show", showDtos);
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
		return "show";
	}
	
	
	@RequestMapping(value = "/show_delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable long id,		
			Map<String, Object> model) throws Exception {
	
		   log.info("delete called");
		   showService.deleteShowById(id);
		 	 
		 return "redirect:/show";	
	}

}
