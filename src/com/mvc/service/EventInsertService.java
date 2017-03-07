package com.mvc.service;

import com.wang.form.EventInsertForm;

public interface EventInsertService {

/*	String add(EventInsertForm eventInsertForm,
			HashMap<String, String> filename);*/
	
	String insertEvent(EventInsertForm eventInsertForm);

}
