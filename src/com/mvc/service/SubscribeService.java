package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.wang.form.SubscribeForm;

public interface SubscribeService {
	
	List<SubscribeForm> findAllKnown() throws SQLException;
	String insertSubscribeInfo(SubscribeForm subscribeForm);
}
