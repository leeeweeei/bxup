package com.mvc.service;

import org.springframework.stereotype.Service;

import com.wang.access.LoginDao;
import com.wang.form.GymInfoForm;
import com.wang.form.GymPhotoForm;


@Service
public class GymInfoServiceImpl implements GymInfoService{
	
	public String insertGymInfo(GymInfoForm gymInfoForm){
		
		
		
		String sucflg = LoginDao.AddT_gym(gymInfoForm);
				
		
		return sucflg;
		
	}
	
	
	public String insertGymPhoto(GymPhotoForm gymPhotoForm){
		
		
		
		String sucflg = LoginDao.AddT_gym_photo_rel(gymPhotoForm);
				
		
		return sucflg;
		
	};	

}