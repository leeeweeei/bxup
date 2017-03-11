package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.wang.form.GymInfoForm;
import com.wang.form.GymPhotoForm;

public interface GymInfoService {
	
	String insertGymInfo(GymInfoForm gymInfoForm);
	String insertGymPhoto(GymPhotoForm gymPhotoForm);
	List<GymInfoForm> findAll() throws SQLException;
	Object findgymById(int gymid);

}
