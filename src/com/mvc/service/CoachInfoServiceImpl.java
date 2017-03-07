package com.mvc.service;

import org.springframework.stereotype.Service;

import com.wang.access.LoginDao;
import com.wang.form.CoachInfoForm;
import com.wang.form.CoachPhotoForm;

@Service
public class CoachInfoServiceImpl implements CoachInfoService{
	
	public String insertCoachInfo(CoachInfoForm coachInfoForm){
		
		
		
		String sucflg = LoginDao.AddT_coach(coachInfoForm);
				
		
		return sucflg;
		
	};
	
	public String insertCoachPhoto(CoachPhotoForm coachPhotoForm){
		
		
		
		String sucflg = LoginDao.AddT_coach_photo_rel(coachPhotoForm);
				
		
		return sucflg;
		
	};

}
