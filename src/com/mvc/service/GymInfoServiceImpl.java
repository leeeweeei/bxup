package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mvc.constroller.ResourceController;
import com.wang.access.LoginDao;			
import com.wang.form.GymInfoForm;
import com.wang.form.GymPhotoForm;


@Service
public class GymInfoServiceImpl implements GymInfoService{
	LoginDao dao = null;
	
	@Override
	public List<GymInfoForm> findAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<GymInfoForm> gym = LoginDao.SelectAllGym();	
		log.info("selectAllGymSuccess");
			return gym;
		}
	
	@Override
	public String insertGymInfo(GymInfoForm gymInfoForm){
		
		
		
		String sucflg = LoginDao.AddT_gym(gymInfoForm);
				
		
		return sucflg;
		
	}
	
	@Override
	public String insertGymPhoto(GymPhotoForm gymPhotoForm){
		
		
		
		String sucflg = LoginDao.AddT_gym_photo_rel(gymPhotoForm);
				
		
		return sucflg;
		
	};	

}