package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.wang.form.PhotoForm;
import com.wang.form.ShowForm;
import com.wang.form.ShowPhotoRelForm;

public interface ShowService {
	
	List<ShowForm> findAll() throws SQLException;
	String insertShow(ShowForm showForm);
	String insertPhoto(PhotoForm photoForm);
	String insertPhotoshowrel(ShowPhotoRelForm showPhotoRelForm);
	List<ShowPhotoRelForm> findrelbyid(long user_id) throws SQLException;
	List<PhotoForm> findphotonamebyid(long photo_id) throws SQLException;
	
}
