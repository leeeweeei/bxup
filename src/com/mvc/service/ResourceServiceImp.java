package com.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.mvc.constroller.ResourceController;
import com.wang.access.LoginDao;
import com.wang.form.EventInsertForm;


@Service
public class ResourceServiceImp implements ResourceService {
	LoginDao dao = null;

	@Override
	public List<EventInsertForm> findAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<EventInsertForm> resource = LoginDao.SelectAllEvent();	
		//List<EventInsertForm> resource2 = LoginDao.SelectAllEvent();
		log.info("selectAllEventSuccess");
			return resource;
		}

	@Override
	public EventInsertForm findById(String id) throws SQLException {
       	Logger log = Logger.getLogger(ResourceController.class.getName());		
		dao = new LoginDao();
		EventInsertForm editevent = LoginDao.SelectEventById(id);	
		log.info("SelectEventByIdSuccess");
			return editevent;
	}
	
	
	@Override
	public EventInsertForm deleteEventById(String id) throws SQLException{
		Logger log = Logger.getLogger(ResourceController.class.getName());		
		dao = new LoginDao();
		 boolean deleteevent = dao.DeleteEventById(id);
		 log.info("DeleteEventByIdSuccess");
			return null;
	}

	@Override
	public EventInsertForm updateEventById(EventInsertForm eventInsertForm) throws SQLException{
		Logger log = Logger.getLogger(ResourceController.class.getName());		
		dao = new LoginDao();
		 boolean updateevent = dao.UpdateEventById(eventInsertForm);
		 log.info("UpdateEventById");
			return null;
	}
	
	
}
