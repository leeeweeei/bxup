package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.wang.form.FeedBackForm;

public interface FeedBackService {
	
	List<FeedBackForm> findAll() throws SQLException;

}
