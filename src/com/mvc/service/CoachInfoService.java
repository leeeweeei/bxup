package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.wang.form.CoachInfoForm;
import com.wang.form.CoachPhotoForm;
import com.wang.form.GymInfoForm;

public interface CoachInfoService {
	
	String insertCoachInfo(CoachInfoForm coachInfoForm);
	String insertCoachPhoto(CoachPhotoForm coachPhotoForm);
	List<CoachInfoForm> findAll() throws SQLException;
}
