package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.wang.form.EventInsertForm;

public interface ResourceService {
	
	

	List<EventInsertForm> findAll() throws SQLException;
	EventInsertForm findById(String id) throws SQLException;
	EventInsertForm deleteEventById(String id) throws SQLException;
	EventInsertForm updateEventById(EventInsertForm eventInsertForm) throws SQLException;
	
}
