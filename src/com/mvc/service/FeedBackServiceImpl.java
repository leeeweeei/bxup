package com.mvc.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
	public Object findnikenameById(int userid) {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();

		Object nickname = LoginDao.SelectnikemnameById(userid);	
		log.info("selectAllGymSuccess");
			return nickname;
		}


}
