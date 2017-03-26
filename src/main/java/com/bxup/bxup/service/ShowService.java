package com.bxup.bxup.service;

import java.sql.SQLException;
import java.util.List;

import com.bxup.bxup.controller.client.dto.ShowDto;
import com.bxup.bxup.model.Photo;
import com.bxup.bxup.model.Show;
import com.bxup.bxup.model.ShowPhotoRel;

public interface ShowService {
	
	List<ShowDto> findAll() throws SQLException;
	String insertShow(Show showForm);
	String insertPhoto(Photo photoForm);
	String insertPhotoshowrel(ShowPhotoRel showPhotoRelForm);
	List<ShowPhotoRel> findrelbyid(long user_id) throws SQLException;
	List<Photo> findphotonamebyid(long photo_id) throws SQLException;
	
}
