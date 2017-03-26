package com.bxup.bxup.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bxup.bxup.access.LoginDao;
import com.bxup.bxup.constroller.ResourceController;
import com.bxup.bxup.model.FeedBack;
import com.bxup.bxup.model.User;
import com.bxup.bxup.service.FeedBackService;

@Service
public class FeedBackServiceImpl implements FeedBackService{
	LoginDao dao = null;
	
	@Override
	public List<FeedBack> findAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<FeedBack> feedback = LoginDao.SelectAllFeedBack();	
		
		for(int i=0;i<feedback.size();i++){

			;
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");  
			java.util.Date date = feedback.get(i).getCreate_time();
				String simple_createtime = sdf.format(date);
				feedback.get(i).setSimple_createtime(simple_createtime);	
		}				
	
		log.info("selectAllFeedBackSuccess");
			return feedback;
		}
	
	//20170311 Baojun add
	@Override
	public User findnikenameById(long user_id) {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();

		User nickname = LoginDao.SelectNicknameByid(user_id);	
		log.info("selectAllGymSuccess");
			return nickname;
		}


}
