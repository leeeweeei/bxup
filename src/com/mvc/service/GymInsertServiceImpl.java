package com.mvc.service;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.mvc.constroller.RestConstroller;
import com.wang.access.LoginDao;
import com.wang.form.GymForm;
import com.wang.utility.Constant;


@Service
public class GymInsertServiceImpl implements GymInsertService{	
	
	public String add(List<GymForm> gymList){
		Logger log = Logger.getLogger(RestConstroller.class.getName());	
		LoginDao dao = null;
		String sucflg = null;
		try {
			
			Properties properties = new Properties();
			properties.load(this.getClass().getClassLoader()
					.getResourceAsStream("Webinfo.properties"));
			
			dao = new LoginDao();
			for(GymForm gym:gymList){
				sucflg = LoginDao.AddT_gym(gym);
			}			
			
			if(sucflg.equals(Constant.FORWARD_SUCCESS)){
				log.info("GymInsertSuccess");
				return Constant.FORWARD_SUCCESS;
			}else{
				log.info("GymInsertFailure");
				return Constant.FORWARD_FAILURE;
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
			return Constant.FORWARD_FAILURE;
		}
	}	
	
}


