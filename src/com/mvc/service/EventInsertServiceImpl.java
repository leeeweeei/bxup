package com.mvc.service;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public String insertEvent(EventInsertForm eventInsertForm){
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
				String eventStartdate = eventInsertForm.getEvent_start_date();		
				Date dbdate = formatter.parse(eventStartdate);
				eventStartdate = formatter.format(dbdate);
				eventInsertForm.setEventStartDate(formatter.format(dbdate));	
				String eventEnddate = eventInsertForm.getEvent_end_date();	
				dbdate = formatter.parse(eventEnddate);
				eventEnddate = formatter.format(dbdate);
				eventInsertForm.setEventEndDate(formatter.format(dbdate));
				eventInsertForm.setEventName(eventInsertForm.getEvent_name());
				eventInsertForm.setTab(eventInsertForm.getTab());
				eventInsertForm.setEventTime(eventInsertForm.getEvent_time());
				eventInsertForm.setEventLink(eventInsertForm.getEvent_link());
				eventInsertForm.setEventDesc(eventInsertForm.getEvent_desc());
				eventInsertForm.setEventPlace(eventInsertForm.getEvent_place());
				eventInsertForm.setiPhone4IMGName(eventInsertForm.getiPhone4IMGName());
				eventInsertForm.setiPhone5IMGName(eventInsertForm.getiPhone5IMGName());
				eventInsertForm.setiPhone6IMGName(eventInsertForm.getiPhone6IMGName());
				eventInsertForm.setiPhone6PIMGName(eventInsertForm.getiPhone6PIMGName());
				eventInsertForm.setDel_fg("0");
						
			} else if (img_type.equals(Imgtype.STRING_ICON.getStringValue())) {
				
				imgtype = Integer.parseInt(img_type);
				
				String start_date = eventInsertForm.getStartDate();
				String end_date = eventInsertForm.getEndDate();
				Date startdate = formatter.parse(start_date);
				Date enddate = formatter.parse(end_date);
				eventInsertForm.setStartDate(formatter.format(startdate));
				eventInsertForm.setEndDate(formatter.format(enddate));				
				eventInsertForm.setEventDef(eventInsertForm.getEventDef());
				eventInsertForm.setFriendDef(eventInsertForm.getFriendDef());
				eventInsertForm.setpKDef(eventInsertForm.getpKDef());
				eventInsertForm.setMetalDef(eventInsertForm.getMetalDef());
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
	



