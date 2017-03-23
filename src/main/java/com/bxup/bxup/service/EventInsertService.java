package com.bxup.bxup.service;

import com.bxup.bxup.model.Event;

public interface EventInsertService {

/*	String add(EventInsertForm eventInsertForm,
			HashMap<String, String> filename);*/
	
	String insertEvent(Event eventInsertForm);

}
