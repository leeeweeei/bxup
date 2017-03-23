package com.bxup.bxup.service;

import java.sql.SQLException;
import java.util.List;

import com.bxup.bxup.model.Subscribe;

public interface SubscribeService {
	
	List<Subscribe> findAllKnown() throws SQLException;
	String insertSubscribeInfo(Subscribe subscribeForm);
}
