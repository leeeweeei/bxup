package com.bxup.bxup.service;

import java.sql.SQLException;
import java.util.List;

import com.bxup.bxup.model.FeedBack;

public interface FeedBackService {
	
	List<FeedBack> findAll() throws SQLException;
	Object findnikenameById(int userid);
	
}
