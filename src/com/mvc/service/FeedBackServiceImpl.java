package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mvc.constroller.ResourceController;
import com.wang.access.LoginDao;
import com.wang.form.FeedBackForm;

@Service
public class FeedBackServiceImpl implements FeedBackService{
	LoginDao dao = null;
	
	@Override
	public List<FeedBackForm> findAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<FeedBackForm> feedback = LoginDao.SelectAllFeedBack();	
	
		log.info("selectAllFeedBackSuccess");
			return feedback;
		}
	
	

}
