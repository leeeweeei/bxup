package com.mvc.service;

import com.wang.form.CoachInfoForm;
import com.wang.form.CoachPhotoForm;

public interface CoachInfoService {
	
	String insertCoachInfo(CoachInfoForm coachInfoForm);
	String insertCoachPhoto(CoachPhotoForm coachPhotoForm);

}
