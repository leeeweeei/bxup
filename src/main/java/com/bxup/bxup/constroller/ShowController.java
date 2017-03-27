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
