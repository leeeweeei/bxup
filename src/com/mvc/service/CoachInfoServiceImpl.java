package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mvc.constroller.ResourceController;
import com.wang.access.LoginDao;
import com.wang.form.CoachInfoForm;
import com.wang.form.CoachPhotoForm;

@Service
public class CoachInfoServiceImpl implements CoachInfoService{
	LoginDao dao = null;
	
	@Override
	public List<CoachInfoForm> findAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<CoachInfoForm> coach = LoginDao.SelectAllCoach();	
		log.info("selectAllGymSuccess");
			return coach;
	}
	
	
	@Override
	public String insertCoachInfo(CoachInfoForm coachInfoForm){						
		String sucflg = LoginDao.AddT_coach(coachInfoForm);						
		return sucflg;		
	};
	
	@Override
	public String insertCoachPhoto(CoachPhotoForm coachPhotoForm){				
		String sucflg = LoginDao.AddT_coach_photo_rel(coachPhotoForm);						
		return sucflg;		
	};

}
