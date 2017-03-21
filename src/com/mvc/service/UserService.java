package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.wang.form.UserForm;

public interface UserService {

	List<UserForm> findAll() throws SQLException;
	String insertUserInfo(UserForm userForm);
	List<UserForm> findnicknamebyid(long user_id) throws SQLException;
	
	
}
