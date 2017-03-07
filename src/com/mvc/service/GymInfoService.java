package com.mvc.service;

import com.wang.form.GymInfoForm;
import com.wang.form.GymPhotoForm;

public interface GymInfoService {
	
	String insertGymInfo(GymInfoForm gymInfoForm);
	String insertGymPhoto(GymPhotoForm gymPhotoForm);

}
