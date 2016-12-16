package com.mvc.constroller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.mvc.service.EventInsertService;
import com.wang.form.EventInsertForm;
import com.wang.utility.Constant;

@Controller
public class RestConstroller {
	
	static Logger log = Logger.getLogger(RestConstroller.class.getName());

	@Autowired(required = false)
	private EventInsertService eventInsertService;

	@RequestMapping(value = "/eventAdd", method = RequestMethod.GET)
	public String eventAdd() {
		log.info("WelcomePage called");

		return "eventAdd";
	}

	@RequestMapping(value = "/maineventAdd", method = RequestMethod.POST)
	public String springUpload(HttpServletRequest request,
			HttpServletResponse response, EventInsertForm eventInsertForm
			) throws IllegalStateException, IOException {
		log.info("maineventAdd called");
		String mainflg = new String();

		String iphoneimgtime = new SimpleDateFormat(
		"yyyyMMddHHmmssSSS").format(new Date());
		
		
		HashMap<String, String> filename = new HashMap<String, String>();
		List<String> decfileList  = new ArrayList<String>();
		
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader()
				.getResourceAsStream("Webinfo.properties"));
		String pictureposition = properties.getProperty("pictureposition");
		
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;				
			Iterator<?> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				StringBuilder filenamesave = new StringBuilder();
				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());
				String picturename = file.getOriginalFilename();
				int position = picturename.indexOf(Constant.POINT);	
				if (file != null && file.getOriginalFilename() != Constant.BLANK) {
					filenamesave.append(file.getName());
					filenamesave.append(Constant.UNDERLINE);
					filenamesave.append(picturename.substring(0,
							position));		
					filenamesave.append(iphoneimgtime);
					filenamesave.append(picturename.substring(position));
					//
					filename.put(file.getName(), filenamesave.toString());
					String path = pictureposition + filenamesave.toString();
					file.transferTo(new File(path));
					decfileList.add(filenamesave.toString());
					
			
				}
			}
			String sucflg = eventInsertService.add(eventInsertForm,filename);
			log.info("InsertForm called");
			if(sucflg.equals(Constant.FORWARD_FAILURE)){
				for(int i=0 ; i < decfileList.size(); i++){
					File file =new File(pictureposition+decfileList.get(i));		
					file.delete();
				}
				mainflg = Constant.FORWARD_FAILURE;
			}else{
				log.info("InsertForm ended");
				 mainflg = Constant.FORWARD_SUCCESS;
				}
			}else{
				 mainflg = Constant.FORWARD_FAILURE;
			}
		return Constant.VIRGULE + mainflg;

	}

}
