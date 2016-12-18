package com.mvc.service;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.mvc.constroller.RestConstroller;
import com.wang.access.LoginDao;
import com.wang.form.CoachForm;
import com.wang.utility.Constant;


@Service
public class CoachInsertServiceImpl implements CoachInsertService{	
	
	public String add(List<CoachForm> coachList){
		Logger log = Logger.getLogger(RestConstroller.class.getName());	
		
		log.info("CoachInsertServiceImpl add");
		
		LoginDao dao = null;
		String sucflg = Constant.FORWARD_SUCCESS;
		try {
			
			Properties properties = new Properties();
			properties.load(this.getClass().getClassLoader()
					.getResourceAsStream("Webinfo.properties"));
			
			dao = new LoginDao();
			for(CoachForm coach:coachList){
				sucflg = LoginDao.AddT_coach(coach);
			}			
			
			if(sucflg.equals(Constant.FORWARD_SUCCESS)){
				log.info("CoachInsertServiceImpl Success");
				return Constant.FORWARD_SUCCESS;
			}else{
				log.info("CoachInsertServiceImpl Failure");
				return Constant.FORWARD_FAILURE;
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
			return Constant.FORWARD_FAILURE;
		}
	}	
	
}


