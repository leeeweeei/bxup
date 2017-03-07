package com.wang.access;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

//import org.apache.log4j.Logger;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.mvc.constroller.RestConstroller;
import com.wang.form.CoachForm;
import com.wang.form.CoachInfoForm;
import com.wang.form.CoachPhotoForm;
import com.wang.form.EventInsertForm;
import com.wang.form.FeedBackForm;
import com.wang.form.GymForm;
import com.wang.form.GymInfoForm;
import com.wang.form.GymPhotoForm;
import com.wang.utility.Constant;
import com.wang.utility.Imgtype;

public class LoginDao {
	static Logger log = Logger.getLogger(RestConstroller.class.getName());
	private static final SqlMapClient sqlMap;
	static {
		log.info("SqlMapClientBuilder Start.");
		
		try {
			String resource = "SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			log.info("SqlMapClientBuilder End.");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			throw new RuntimeException(
					"Error initializing MyAppSqlConfig class. Cause: " + e);
		}
	}

	public static String AddT_event(EventInsertForm eventInsertForm, int imgtype) {
		log.info("SqlAddT_event Start.");
		String sucflg = null;
		EventInsertForm eventAdd = new EventInsertForm();
		if (Imgtype.STRING_EVENT.getStringValue().equals(
				Integer.toString(imgtype))
				|| Imgtype.STRING_BANNER.getStringValue().equals(
						Integer.toString(imgtype))) {
			eventAdd.setEventName(eventInsertForm.getEventName());
			eventAdd.setEventDesc(eventInsertForm.getEventDesc());
			eventAdd.setEventPlace(eventInsertForm.getEventPlace());
			eventAdd.setImgtype(imgtype);
			eventAdd.setiPhone4IMGName(eventInsertForm.getiPhone4IMGName());
			eventAdd.setiPhone5IMGName(eventInsertForm.getiPhone5IMGName());
			eventAdd.setiPhone6IMGName(eventInsertForm.getiPhone6IMGName());
			eventAdd.setiPhone6PIMGName(eventInsertForm.getiPhone6PIMGName());
			eventAdd.setAndroidIMGName1(eventInsertForm.getAndroidIMGName1());
			eventAdd.setAndroidIMGName2(eventInsertForm.getAndroidIMGName2());
			eventAdd.setAndroidIMGName3(eventInsertForm.getAndroidIMGName3());
			eventAdd.setEventStartDate(eventInsertForm.getEventStartDate());
			eventAdd.setEventEndDate(eventInsertForm.getEventEndDate());
			eventAdd.setEventLink(eventInsertForm.getEventLink());
			eventAdd.setEventTime(eventInsertForm.getEventTime());
			eventAdd.setCreateDate(eventInsertForm.getCreateDate());
			eventAdd.setCreateID(eventInsertForm.getCreateID());
			eventAdd.setDel_fg(eventInsertForm.getDel_fg());
			try {
				sqlMap.insert("insertEventInsertForm1", eventAdd);
			} catch (SQLException e) {
				// TODO �����������ꂽ catch �u���b�N
				e.printStackTrace();
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				return sucflg;
			}
				 sucflg=Constant.FORWARD_SUCCESS;
				 return sucflg;
		} else if (Imgtype.STRING_ICON.getStringValue().equals(
				Integer.toString(imgtype))) {
			eventAdd.setEventDef(eventInsertForm.getEventDef());
			eventAdd.setFriendDef(eventInsertForm.getFriendDef());
			eventAdd.setpKDef(eventInsertForm.getpKDef());
			eventAdd.setMetalDef(eventInsertForm.getMetalDef());
			eventAdd.setStartDate(eventInsertForm.getStartDate());
			eventAdd.setEndDate(eventInsertForm.getEndDate());
			eventAdd.setCreateDate(eventInsertForm.getCreateDate());
			eventAdd.setCreateID(eventInsertForm.getCreateID());
			try {
				sqlMap.insert("insertEventInsertForm2", eventAdd);

			} catch (SQLException e) {
				// TODO �����������ꂽ catch �u���b�N
				e.printStackTrace();
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				return sucflg;
			}
			    sucflg=Constant.FORWARD_SUCCESS;
			    return sucflg;
		}
		log.info("SqlAddT_event End.");
		return sucflg;
		
	}
	
	public static String AddT_coach(CoachForm coach) throws SQLException {
		log.info("SqlAddT_coach Start.");
		String sucflg = null;

		try {
			sqlMap.insert("insertCoachInsertForm1", coach);
		} catch (SQLException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg=Constant.FORWARD_FAILURE;
			throw e;
		}
		sucflg=Constant.FORWARD_SUCCESS;
			 
		log.info("SqlAddAddT_coach End.");
		return sucflg;
		
	}
	
	public static String AddT_gym(GymForm gym) throws SQLException {
		log.info("SqlAddT_gym Start.");
		String sucflg = null;

		try {
			sqlMap.insert("insertGymInsertForm1", gym);
		} catch (SQLException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg=Constant.FORWARD_FAILURE;
			throw e;
		}
		sucflg=Constant.FORWARD_SUCCESS;
			 
		log.info("SqlAddAddT_gym End.");
		return sucflg;	
	}
		
	public static List<EventInsertForm> SelectAllEvent() throws SQLException {
		log.info("SqlSelectAllEvent Start.");
		List<EventInsertForm> eventInsertForm = null; 
		String sucflg = null;
		try { 
			eventInsertForm = sqlMap.queryForList("selectAllEvent"); 
		} catch (SQLException e) { 
			e.printStackTrace(); 
			log.error(e.getMessage());
			sucflg=Constant.FORWARD_FAILURE;
			throw e;
		} 
		sucflg=Constant.FORWARD_SUCCESS;
		
		log.info("SqlselectAllEvent End.");
		return eventInsertForm; 
		} 

	public static EventInsertForm SelectEventById(String id) throws SQLException {
		log.info("SqlSelectEventById Start.");
		EventInsertForm eventInsertForm = null; 
		String sucflg = null;
		try { 
			eventInsertForm = (EventInsertForm) sqlMap.queryForObject("selectEventById",id); 
		} catch (SQLException e) {
			e.printStackTrace(); 
			log.error(e.getMessage());
			sucflg=Constant.FORWARD_FAILURE;
			throw e;	
		} 
		sucflg=Constant.FORWARD_SUCCESS;	
		log.info("SqlselectEventById End.");
		return eventInsertForm; 
		}
	
	 public boolean DeleteEventById(String id) throws SQLException{
		 log.info("SqlDeleteEventById Start.");
		 boolean flag = false;
		 Object object = false; 
		 String sucflg = null;
		 EventInsertForm eventInsertForm = new EventInsertForm(); 
		 eventInsertForm.setId(id);
		 try { 
			 object = sqlMap.update("deleteEventById",eventInsertForm);
		 } catch (SQLException e) { 
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				throw e;		
		 } 
		 if (object != null) {
			 sucflg=Constant.FORWARD_SUCCESS;	
			 log.info("sqldeleteEventById End.");
			 flag = true; 
			 } 
			 return flag; 		 

	  }
	 public boolean UpdateEventById(EventInsertForm eventInsertForm) throws SQLException{
		 log.info("SqlUpdateEventById Start.");
		 boolean flag = false; 
		 Object object = false;
		 String sucflg = null;
		 try { 
			 object = sqlMap.update("updateEventById",eventInsertForm);
		 } catch (SQLException e) {
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				throw e;		
		 } 
		 if (object != null) {
			 sucflg=Constant.FORWARD_SUCCESS;	
			 log.info("sqlUpdateEventById End.");
			 flag = true; 		 
			 } 
			 return flag; 		 
	 }
	 
	 public boolean UpdateImg4(EventInsertForm eventInsertForm) throws SQLException{
		 log.info("SqlUpdateEventById Start.");
		 boolean flag = false; 
		 Object object = false;
		 String sucflg = null;
		 try { 
			 object = sqlMap.update("updateimg4",eventInsertForm);
		 } catch (SQLException e) {
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				throw e;		
		 } 
		 if (object != null) {
			 sucflg=Constant.FORWARD_SUCCESS;	
			 log.info("sqlUpdateEventById End.");
			 flag = true; 		 
			 } 
			 return flag; 		 
	 }	
	 
	 public boolean UpdateImg5(EventInsertForm eventInsertForm) throws SQLException{
		 log.info("SqlUpdateEventById Start.");
		 boolean flag = false; 
		 Object object = false;
		 String sucflg = null;
		 try { 
			 object = sqlMap.update("updateimg5",eventInsertForm);
		 } catch (SQLException e) {
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				throw e;		
		 } 
		 if (object != null) {
			 sucflg=Constant.FORWARD_SUCCESS;	
			 log.info("sqlUpdateEventById End.");
			 flag = true; 		 
			 } 
			 return flag; 		 
	 }	
	 
	 public boolean UpdateImg6(EventInsertForm eventInsertForm) throws SQLException{
		 log.info("SqlUpdateEventById Start.");
		 boolean flag = false; 
		 Object object = false;
		 String sucflg = null;
		 try { 
			 object = sqlMap.update("updateimg6",eventInsertForm);
		 } catch (SQLException e) {
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				throw e;		
		 } 
		 if (object != null) {
			 sucflg=Constant.FORWARD_SUCCESS;	
			 log.info("sqlUpdateEventById End.");
			 flag = true; 		 
			 } 
			 return flag; 		 
	 }	
	 
	 public boolean UpdateImg6p(EventInsertForm eventInsertForm) throws SQLException{
		 log.info("SqlUpdateEventById Start.");
		 boolean flag = false; 
		 Object object = false;
		 String sucflg = null;
		 try { 
			 object = sqlMap.update("updateimg6p",eventInsertForm);
		 } catch (SQLException e) {
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				throw e;		
		 } 
		 if (object != null) {
			 sucflg=Constant.FORWARD_SUCCESS;	
			 log.info("sqlUpdateEventById End.");
			 flag = true; 		 
			 } 
			 return flag; 		 
	 }	
	 //20170303 Baojun ADD
	 public static String AddT_coach(CoachInfoForm coachInfoForm) {
			log.info("SqlAddT_coach Start.");
			String sucflg = null;
			
				try {
					sqlMap.insert("insertCoachInfoForm", coachInfoForm);
				} catch (SQLException e) {

					e.printStackTrace();
					log.error(e.getMessage());
					sucflg=Constant.FORWARD_FAILURE;
					return sucflg;
				}
					 sucflg=Constant.FORWARD_SUCCESS;
					 return sucflg;	
		}
	 
	 //20170304 Baojun Add
	 public static String AddT_coach_photo_rel(CoachPhotoForm coachPhotoForm) {
			log.info("SqlAddT_coach_photo_rel Start.");
			String sucflg = null;
			
				try {
					sqlMap.insert("insertCoachPhotoForm", coachPhotoForm);
				} catch (SQLException e) {

					e.printStackTrace();
					log.error(e.getMessage());
					sucflg=Constant.FORWARD_FAILURE;
					return sucflg;
				}
					 sucflg=Constant.FORWARD_SUCCESS;
					 return sucflg;	
	  }
	 
	 //20170304 Baojun ADD
	 public static String AddT_gym(GymInfoForm gymInfoForm) {
			log.info("SqlAddT_gym Start.");
			String sucflg = null;
			
				try {
					sqlMap.insert("insertGymInfoForm", gymInfoForm);
				} catch (SQLException e) {

					e.printStackTrace();
					log.error(e.getMessage());
					sucflg=Constant.FORWARD_FAILURE;
					return sucflg;
				}
					 sucflg=Constant.FORWARD_SUCCESS;
					 return sucflg;	
		}
	 
	 //20170304 Baojun Add
	 public static String AddT_gym_photo_rel(GymPhotoForm gymPhotoForm) {
			log.info("SqlAddT_coach_photo_rel Start.");
			String sucflg = null;
			
				try {
					sqlMap.insert("insertGymPhotoForm", gymPhotoForm);
				} catch (SQLException e) {

					e.printStackTrace();
					log.error(e.getMessage());
					sucflg=Constant.FORWARD_FAILURE;
					return sucflg;
				}
					 sucflg=Constant.FORWARD_SUCCESS;
					 return sucflg;	
	  }
	 
	    //20170304 Baojun Add
		public static List<FeedBackForm> SelectAllFeedBack() throws SQLException {
			log.info("SqlSelectAllEvent Start.");
			List<FeedBackForm> feedBackForm = null; 
			String sucflg = null;
			try { 
				feedBackForm = sqlMap.queryForList("selectAllFeedBack"); 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				throw e;
			} 
			sucflg=Constant.FORWARD_SUCCESS;
			
			log.info("SqlselectAllEvent End.");
			return feedBackForm; 
			} 

	
}
