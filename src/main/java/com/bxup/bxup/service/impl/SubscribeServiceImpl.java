package com.bxup.bxup.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bxup.bxup.access.LoginDao;
import com.bxup.bxup.constroller.ResourceController;
import com.bxup.bxup.model.Subscribe;
import com.bxup.bxup.service.SubscribeService;

@Service
public class SubscribeServiceImpl implements SubscribeService{
	
LoginDao dao = null;

	@Override
	public List<Subscribe> findAllKnown() throws SQLException {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<Subscribe> subscribe = LoginDao.SelectAllsubscribe();	
		log.info("selectAllsubscribeSuccess");
	    return subscribe;
	}

	@Override
	public String insertSubscribeInfo(Subscribe subscribeForm){						
		String sucflg = LoginDao.insertSubscribeInfo(subscribeForm);						
		return sucflg;		
	};
	
}
