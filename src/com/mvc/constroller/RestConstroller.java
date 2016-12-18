package com.mvc.constroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.mvc.service.CoachInsertServiceImpl;
import com.mvc.service.EventInsertService;
import com.mvc.service.GymInsertServiceImpl;
import com.wang.form.CoachForm;
import com.wang.form.EventInsertForm;
import com.wang.form.GymForm;
import com.wang.utility.CSVUtils;
import com.wang.utility.Constant;
import com.wang.utility.DataFormatCheck;

@Controller
public class RestConstroller {
	
	static Logger log = Logger.getLogger(RestConstroller.class.getName());

	@Autowired(required = false)
	private EventInsertService eventInsertService;
	
	@Autowired(required = false)
	private CoachInsertServiceImpl coachInsertService;

	@Autowired(required = false)
	private GymInsertServiceImpl gymInsertService;
	
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
	
	@RequestMapping(value = "/coachAdd", method = RequestMethod.POST)
	public String coachAdd(@RequestParam(value="coachCsv") MultipartFile fileUp,HttpServletRequest request,
			HttpServletResponse response,Model model) throws IllegalStateException, IOException {
		log.info("coachAdd called");		
		String filePath = "";

		if(fileUp==null || fileUp.isEmpty()){
			log.info("coachAdd ended");
			return Constant.VIRGULE + "coachUploadEnd";
	    }
		
		try {
			Properties properties = new Properties();
			properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
			String pictureposition = properties.getProperty("pictureposition");
			
			boolean localhost = request.getRequestURL().toString().contains("localhost");
			String rootPath=localhost?request.getServletContext().getRealPath("/"):pictureposition;
			
			String pathfalg = System.getProperty("file.separator");
			
			File dir = new File(rootPath+ pathfalg + "orderData" + pathfalg);
	        if(!dir.exists()){
	             dir.mkdir();
	        }
	        
	        filePath = rootPath+ pathfalg +"orderData"  + pathfalg + (new Random().nextInt(100000)+100000)+ fileUp.getOriginalFilename();
	        
	        File fileServer = new File(filePath);
	        fileUp.transferTo(fileServer);
	        
	        InputStreamReader inputReader = new InputStreamReader(new FileInputStream(filePath), Charset.forName("UTF-8")); 
	        
	        List<String[]> datalist = CSVUtils.readCsv(inputReader);	        
	        
	        Map<String,List<CoachForm>> coachList = DataFormatCheck.csvCoachDataCheck(datalist);
	        
	        if(Constant.FORWARD_FAILURE == coachInsertService.add(coachList.get("success"))){
	        	return Constant.VIRGULE + "failure";
	        }
	        
	        fileServer.delete();
	        
	        model.addAllAttributes(coachList);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        log.info("coachAdd abend");
	        return Constant.VIRGULE + "failure";
	    }

		log.info("coachAdd ended");
		return Constant.VIRGULE + "coachUploadEnd";
	}
	
	@RequestMapping(value = "/gymAdd", method = RequestMethod.POST)
	public String gymAdd(@RequestParam(value="gymCsv") MultipartFile fileUp,HttpServletRequest request,
			HttpServletResponse response,Model model) throws IllegalStateException, IOException {
		
		log.info("gymAdd called");
		String filePath = "";

		if(fileUp==null || fileUp.isEmpty()){
			log.info("gymAdd ended");
			return Constant.VIRGULE + "gymUploadEnd";
	    }
		
		try {
			Properties properties = new Properties();
			properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
			String pictureposition = properties.getProperty("pictureposition");
			
			boolean localhost = request.getRequestURL().toString().contains("localhost");
			String rootPath=localhost?request.getServletContext().getRealPath("/"):pictureposition;
			
			String pathfalg = System.getProperty("file.separator");
			
			File dir = new File(rootPath+ pathfalg + "orderData" + pathfalg);
	        if(!dir.exists()){
	             dir.mkdir();
	        }
	        
	        filePath = rootPath+ pathfalg +"orderData"  + pathfalg + (new Random().nextInt(100000)+100000)+ fileUp.getOriginalFilename();
	        File fileServer = new File(filePath);
	        fileUp.transferTo(fileServer);
	        
	        InputStreamReader inputReader = new InputStreamReader(new FileInputStream(filePath), Charset.forName("UTF-8")); 
	        
	        List<String[]> datalist = CSVUtils.readCsv(inputReader);
	        
	        Map<String,List<GymForm>> gymList = DataFormatCheck.csvGymDataCheck(datalist);
	        
	        if(Constant.FORWARD_FAILURE == gymInsertService.add(gymList.get("success"))){
	        	return Constant.VIRGULE + "failure";
	        }
	        
	        fileServer.delete();
	        
	        model.addAllAttributes(gymList);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        log.info("gymAdd abend");
	        return Constant.VIRGULE + "failure";
	    }

		log.info("gymAdd ended");
		return Constant.VIRGULE + "gymUploadEnd";
	}

}
