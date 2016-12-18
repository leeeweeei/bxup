package com.wang.access;

import java.io.Reader;
import java.sql.SQLException;
import java.util.logging.Logger;

//import org.apache.log4j.Logger;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.mvc.constroller.RestConstroller;
import com.wang.form.CoachForm;
import com.wang.form.EventInsertForm;
import com.wang.form.GymForm;
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
			eventAdd.setEventDate(eventInsertForm.getEventDate());
			eventAdd.setEventTime(eventInsertForm.getEventTime());
			eventAdd.setCreateDate(eventInsertForm.getCreateDate());
			eventAdd.setCreateID(eventInsertForm.getCreateID());
			try {
				sqlMap.insert("insertEventInsertForm1", eventAdd);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				//log.error(e.getMessage());
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
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				//log.error(e.getMessage());
				sucflg=Constant.FORWARD_FAILURE;
				return sucflg;
			}
			    sucflg=Constant.FORWARD_SUCCESS;
			    return sucflg;
		}
		log.info("SqlAddT_event End.");
		return sucflg;
		
	}
	
	public static String AddT_coach(CoachForm coach) {
		log.info("SqlAddT_coach Start.");
		String sucflg = null;

		try {
			sqlMap.insert("insertCoachInsertForm1", coach);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			//log.error(e.getMessage());
			sucflg=Constant.FORWARD_FAILURE;
			return sucflg;
		}
		sucflg=Constant.FORWARD_SUCCESS;
			 
		log.info("SqlAddAddT_coach End.");
		return sucflg;
		
	}
	
	public static String AddT_gym(GymForm gym) {
		log.info("SqlAddT_gym Start.");
		String sucflg = null;

		try {
			sqlMap.insert("insertGymInsertForm1", gym);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			//log.error(e.getMessage());
			sucflg=Constant.FORWARD_FAILURE;
			return sucflg;
		}
		sucflg=Constant.FORWARD_SUCCESS;
			 
		log.info("SqlAddAddT_gym End.");
		return sucflg;
		
	}
}
