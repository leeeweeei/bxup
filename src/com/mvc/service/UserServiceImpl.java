package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mvc.constroller.ResourceController;
import com.wang.access.LoginDao;
import com.wang.form.UserForm;

@Service
public class UserServiceImpl implements UserService{
	LoginDao dao = null;
	
	@Override
	public List<UserForm> findAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<UserForm> user = LoginDao.SelectAllUser();	
		log.info("selectAllUserSuccess");
			return user;
	}
		
	@Override
	public String insertUserInfo(UserForm userForm){						
		String sucflg = LoginDao.AddT_user(userForm);						
		return sucflg;		
	};
	
	@Override
	public List<UserForm> findnicknamebyid(long user_id) throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<UserForm> user = LoginDao.SelectNicknameByid(user_id);	
		log.info("selectNicknameByidSuccess");
			return user;
	}


}
