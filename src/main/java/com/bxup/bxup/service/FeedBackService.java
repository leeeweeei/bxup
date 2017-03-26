package com.bxup.bxup.service;

import java.sql.SQLException;
import java.util.List;

import com.bxup.bxup.model.FeedBack;
import com.bxup.bxup.model.User;

public interface FeedBackService {
	
	List<FeedBack> findAll() throws SQLException;
	User findnikenameById(long user_id);
	
}
