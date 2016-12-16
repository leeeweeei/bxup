package com.mvc.service;

import java.util.HashMap;

import com.wang.form.EventInsertForm;

public interface EventInsertService {

	String add(EventInsertForm eventInsertForm,
			HashMap<String, String> filename);

}
