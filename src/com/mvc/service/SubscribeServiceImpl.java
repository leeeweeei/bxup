package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mvc.constroller.ResourceController;
import com.wang.access.LoginDao;
import com.wang.form.SubscribeForm;

@Service
public class SubscribeServiceImpl implements SubscribeService{
	
LoginDao dao = null;

	@Override
	public List<SubscribeForm> findAllKnown() throws SQLException {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<SubscribeForm> subscribe = LoginDao.SelectAllsubscribe();	
		log.info("selectAllsubscribeSuccess");
	    return subscribe;
	}

	@Override
	public String insertSubscribeInfo(SubscribeForm subscribeForm){						
		String sucflg = LoginDao.insertSubscribeInfo(subscribeForm);						
		return sucflg;		
	};
	
}
