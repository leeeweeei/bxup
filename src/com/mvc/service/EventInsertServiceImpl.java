package com.mvc.service;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Service;

import com.mvc.constroller.RestConstroller;
import com.wang.access.LoginDao;
import com.wang.form.EventInsertForm;
import com.wang.utility.Constant;
import com.wang.utility.Imgtype;


@Service
public class EventInsertServiceImpl implements EventInsertService{
	EventInsertForm eventInsertForm = new EventInsertForm();
	
	
	public String add(EventInsertForm eventInsertForm,HashMap<String, String> filename){
		Logger log = Logger.getLogger(RestConstroller.class.getName());	
		LoginDao dao = null;
		int imgtype = 0;
		String img_type = eventInsertForm.getImg_Type();
		SimpleDateFormat formatter = new SimpleDateFormat(Constant.YYYYMMDD);
		Date date = new Date();
		eventInsertForm.setCreateDate(formatter.format(date));
		
		try {
			
			
			Properties properties = new Properties();
			properties.load(this.getClass().getClassLoader()
					.getResourceAsStream("Webinfo.properties"));
			
			// img_type= 1 or 2

			if (img_type.equals(Imgtype.STRING_EVENT.getStringValue())
					|| img_type.equals(Imgtype.STRING_BANNER.getStringValue())) {
				
				imgtype = Integer.parseInt(img_type);				
				String eventStartdate = eventInsertForm.getEventStartDate();		
				Date dbdate = formatter.parse(eventStartdate);
				eventStartdate = formatter.format(dbdate);
				eventInsertForm.setEventStartDate(formatter.format(dbdate));	
				String eventEnddate = eventInsertForm.getEventEndDate();	
				dbdate = formatter.parse(eventEnddate);
				eventEnddate = formatter.format(dbdate);
				eventInsertForm.setEventEndDate(formatter.format(dbdate));
				eventInsertForm.setiPhone4IMGName(filename.get(Constant.IPHONE4IMGNAME));
				eventInsertForm.setiPhone5IMGName(filename.get(Constant.IPHONE5IMGNAME));
				eventInsertForm.setiPhone6IMGName(filename.get(Constant.IPHONE6IMGNAME));
				eventInsertForm.setiPhone6PIMGName(filename.get(Constant.IPHONE6PIMGNAME));
						
			} else if (img_type.equals(Imgtype.STRING_ICON.getStringValue())) {
				
				imgtype = Integer.parseInt(img_type);
				
				String start_date = eventInsertForm.getStartDate();
				String end_date = eventInsertForm.getEndDate();
				Date startdate = formatter.parse(start_date);
				Date enddate = formatter.parse(end_date);
				eventInsertForm.setStartDate(formatter.format(startdate));
				eventInsertForm.setEndDate(formatter.format(enddate));				
				eventInsertForm.setEventDef(filename.get(Constant.EVENTDEFNAME));
				eventInsertForm.setFriendDef(filename.get(Constant.FRIENDDEFNAME));
				eventInsertForm.setpKDef(filename.get(Constant.PKDEFNAME));
				eventInsertForm.setMetalDef(filename.get(Constant.METALDEFNAME));
			}
			dao = new LoginDao();
			String sucflg = LoginDao.AddT_event(eventInsertForm, imgtype);
			
			if(sucflg.equals(Constant.FORWARD_SUCCESS)){
				log.info("PictureUploadSuccess");
				return Constant.FORWARD_SUCCESS;
			}else{
				log.info("PictureUploadFailure");
				return Constant.FORWARD_FAILURE;
			}
			
		} catch (IOException e) {		
			e.printStackTrace();
			return Constant.FORWARD_FAILURE;
		} catch (Exception e) {			
			e.printStackTrace();
			return Constant.FORWARD_FAILURE;
		}
	}	
	
}


