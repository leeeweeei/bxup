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
import com.wang.form.SubscribeForm;
import com.wang.form.PhotoForm;
import com.wang.form.ShowForm;
import com.wang.form.ShowPhotoRelForm;
import com.wang.form.UserForm;
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
			eventAdd.setTab(eventInsertForm.getTab());
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
		
		//20170308 Baojun Add
		public static List<GymInfoForm> SelectAllGym() throws SQLException {
			log.info("SqlSelectAllEvent Start.");
			List<GymInfoForm> gym = null; 
			String sucflg = null;
			try { 
				gym = sqlMap.queryForList("selectAllGym"); 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				throw e;
			} 
			sucflg=Constant.FORWARD_SUCCESS;
			
			log.info("SqlselectAllGym End.");
			return gym; 
			} 
		
		//20170308 Baojun Add
		public static List<CoachInfoForm> SelectAllCoach() throws SQLException {
			log.info("SqlSelectAllEvent Start.");
			List<CoachInfoForm> coach = null; 
			String sucflg = null;
			try { 
				coach = sqlMap.queryForList("selectAllCoach"); 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				throw e;
			} 
			sucflg=Constant.FORWARD_SUCCESS;
			
			log.info("SqlselectAllCoach End.");
			return coach; 
			} 
		
		//20170311 Baojun Add
		public static Object SelectAllGymnameById(int gymid){
			log.info("SqlSelectAllEvent Start.");
			String sucflg = null;
			Object gym = null; 
			try { 
				gym = sqlMap.queryForObject("selectAllGymnameById",gymid); 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
		
			} 
			sucflg=Constant.FORWARD_SUCCESS;
			
			log.info("SqlselectAllGym End.");
			return gym; 
			} 
		
		//20170311 Baojun Add
		public static Object SelectnikemnameById(int userid){
			log.info("SelectnikemnameById Start.");
			String sucflg = null;
			Object nickname = null; 
			try { 
				nickname = sqlMap.queryForObject("selectnikenameById",userid); 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
		
			} 
			sucflg=Constant.FORWARD_SUCCESS;
			
			log.info("SelectnikemnameById End.");
			return nickname; 
			}
		
		
		//20170314 Baojun Add
		public static List<UserForm> SelectAllUser() throws SQLException {
			log.info("SqlSelectAllUser Start.");
			List<UserForm> user = null; 	
			String sucflg = null;
			try { 
				user = sqlMap.queryForList("selectAllUser"); 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				throw e;
			} 
			sucflg=Constant.FORWARD_SUCCESS;
			
			log.info("SqlselectAllUser End.");
			return user; 
			} 
		
		 //20170314 Baojun ADD
		 public static String AddT_user(UserForm userForm) {
				log.info("SqlAddT_user Start.");
				String sucflg = null;
				
					try {
						sqlMap.insert("insertUserForm", userForm);
					} catch (SQLException e) {

						e.printStackTrace();
						log.error(e.getMessage());
						sucflg=Constant.FORWARD_FAILURE;
						return sucflg;
					}
						 sucflg=Constant.FORWARD_SUCCESS;
						 return sucflg;	
			}
		 
		 
			//20170315 Baojun Add
			public static List<ShowForm> SelectAllShow() throws SQLException {
				log.info("SqlSelectAllShow Start.");
				List<ShowForm> show = null; 	
				String sucflg = null;
				try { 
					show = sqlMap.queryForList("selectAllShow"); 
				} catch (SQLException e) { 
					e.printStackTrace(); 
					log.error(e.getMessage());
					sucflg=Constant.FORWARD_FAILURE;
					throw e;
				} 
				sucflg=Constant.FORWARD_SUCCESS;
				
				log.info("SqlselectAllShow End.");
				return show; 
				} 
			
			 //20170315 Baojun ADD
			 public static String AddT_show(ShowForm showForm) {
					log.info("SqlAddT_show Start.");
					String sucflg = null;
					
						try {
							sqlMap.insert("insertShowForm", showForm);
						} catch (SQLException e) {

							e.printStackTrace();
							log.error(e.getMessage());
							sucflg=Constant.FORWARD_FAILURE;
							return sucflg;
						}
							 sucflg=Constant.FORWARD_SUCCESS;
							 return sucflg;	
				}
			 
			 //20170315 Baojun ADD
			 public static String AddT_photo(PhotoForm photoForm) {
					log.info("SqlAddT_show Start.");
					String sucflg = null;
					
						try {
							sqlMap.insert("insertPhotoForm", photoForm);
						} catch (SQLException e) {

							e.printStackTrace();
							log.error(e.getMessage());
							sucflg=Constant.FORWARD_FAILURE;
							return sucflg;
						}
							 sucflg=Constant.FORWARD_SUCCESS;
							 return sucflg;	
				}
			 
			 //20170315 Baojun ADD
			 public static String AddT_showphotorel(ShowPhotoRelForm showPhotoRelForm) {
					log.info("SqlAddT_show Start.");
					String sucflg = null;			
						try {
							sqlMap.insert("insertshowPhotorelForm", showPhotoRelForm);
						} catch (SQLException e) {
							e.printStackTrace();
							log.error(e.getMessage());
							sucflg=Constant.FORWARD_FAILURE;
							return sucflg;
						}
							 sucflg=Constant.FORWARD_SUCCESS;
							 return sucflg;	
				}
			
			 
				//20170316 Baojun Add
				public static List<PhotoForm> FindT_photoid(long user_id) {
					log.info("FindT_photobyid Start.");
					String sucflg = null;
					List<PhotoForm> photo = null; 
					try { 
						photo = sqlMap.queryForList("selectphotobyid",user_id); 
					} catch (SQLException e) { 
						e.printStackTrace(); 
						log.error(e.getMessage());
						sucflg=Constant.FORWARD_FAILURE;
				
					} 
					sucflg=Constant.FORWARD_SUCCESS;
					
					log.info("FindT_photobyid End.");
					return photo; 
				}
			 
				//20170316 Baojun Add
				public static List<ShowForm> FindT_showid(long user_id) {
					log.info("FindT_photobyid Start.");
					String sucflg = null;
					List<ShowForm> show = null; 
					try { 
						show = sqlMap.queryForList("selectshowbyid",user_id); 
					} catch (SQLException e) { 
						e.printStackTrace(); 
						log.error(e.getMessage());
						sucflg=Constant.FORWARD_FAILURE;
				
					} 
					sucflg=Constant.FORWARD_SUCCESS;
					
					log.info("FindT_photobyid End.");
					return show; 
				}
				
				
				//20170318 Baojun Add
				public static List<UserForm> SelectNicknameByid(long user_id) {
					log.info("FindT_photobyid Start.");
					String sucflg = null;
					List<UserForm> user = null; 
					try { 
						user = sqlMap.queryForList("selectnickbyid",user_id); 
					} catch (SQLException e) { 
						e.printStackTrace(); 
						log.error(e.getMessage());
						sucflg=Constant.FORWARD_FAILURE;
				
					} 
					sucflg=Constant.FORWARD_SUCCESS;
					
					log.info("selectnickbyid End.");
					return user; 
				}
				
				
				//20170318 Baojun Add
				public static List<ShowPhotoRelForm> FindT_showphotorel(long id) {
					log.info("FindShowPhotoRel Start.");
					String sucflg = null;
					List<ShowPhotoRelForm> rel = null; 
					try { 
						rel = sqlMap.queryForList("selectrelbyid",id); 
					} catch (SQLException e) { 
						e.printStackTrace(); 
						log.error(e.getMessage());
						sucflg=Constant.FORWARD_FAILURE;
				
					} 
					sucflg=Constant.FORWARD_SUCCESS;
					
					log.info("selectShowPhotoRel End.");
					return rel; 
				}
				
				public static List<PhotoForm> FindT_photonamebyid(long photo_id) {
					log.info("Findphotonamebyid Start.");
					String sucflg = null;
					List<PhotoForm> photo = null; 
					try { 
						photo = sqlMap.queryForList("selectphotonamebyid",photo_id); 
					} catch (SQLException e) { 
						e.printStackTrace(); 
						log.error(e.getMessage());
						sucflg=Constant.FORWARD_FAILURE;
				
					} 
					sucflg=Constant.FORWARD_SUCCESS;
					
					log.info("selectphotonamebyid End.");
					return photo; 
				}
				
				public static List<SubscribeForm> SelectAllsubscribe() {
					log.info("Findsubscribe Start.");
					String sucflg = null;
					List<SubscribeForm> subscribe = null; 
					try { 
						subscribe = sqlMap.queryForList("SelectAllsubscribe"); 
					} catch (SQLException e) { 
						e.printStackTrace(); 
						log.error(e.getMessage());
						sucflg=Constant.FORWARD_FAILURE;
				
					} 
					sucflg=Constant.FORWARD_SUCCESS;
					
					log.info("selectsubscribe End.");
					return subscribe; 
				}
				
				public static String insertSubscribeInfo(SubscribeForm subscribeForm) {
					log.info("insertSubscribeInfo Start.");
					String sucflg = null;		
					try { 
						 sqlMap.insert("insertSubscribeInfo",subscribeForm); 
					} catch (SQLException e) { 
						e.printStackTrace(); 
						log.error(e.getMessage());
						sucflg=Constant.FORWARD_FAILURE;
				
					} 
					sucflg=Constant.FORWARD_SUCCESS;
					
					log.info("insertSubscribeInfo End.");
					return sucflg; 
				}
				
				
}
