package com.wang.utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.wang.form.CoachForm;
import com.wang.form.GymForm;

public class DataFormatCheck {
	
	public static Map<String,List<CoachForm>> csvCoachDataCheck(List<String[]> datalist) throws Exception{
		
		Map<String,List<CoachForm>> coachMap = new HashMap<String,List<CoachForm>>();
		String[] csvData;
		CoachForm coach;
		CoachForm coachErr;
		List<CoachForm> coachList = new ArrayList<CoachForm>();
		List<CoachForm> coachErrList = new ArrayList<CoachForm>();
		Date now = new Date(); 
		List<String> errList = new ArrayList<String>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String sysDate = dateFormat.format(now); 		
		String ceateData = sysDate.substring(0,4) + sysDate.substring(5,7) + sysDate.substring(8,10) + sysDate.substring(11,13) + sysDate.substring(14,16) + sysDate.substring(17,19);
				
		for(int i=0;i<datalist.size();i++){
			coach = new CoachForm();
			coachErr = new CoachForm();
			csvData = datalist.get(i);
			errList = new ArrayList<String>();
			String errorData = "";
			if(csvData.length != 6){
				errList.add("Data format is not correct");
				for(int j=0;j<csvData.length;j++){
					if(j + 1 == csvData.length){
						errorData = errorData + csvData[j];
					} else {
						errorData = errorData + csvData[j] + ",";
					}					
				}
				coachErr.setLineCount(i+1);
				coachErr.setErrorData(errorData);
				coachErr.setErrorMsg(errList);
				coachErrList.add(coachErr);
			} else {
				errList = dataCoachCheck(csvData);
				if(errList.size() > 0){
					for(int j=0;j<csvData.length;j++){
						if(j + 1 == csvData.length){
							errorData = errorData + csvData[j];
						} else {
							errorData = errorData + csvData[j] + ",";
						}					
					}
					coachErr.setLineCount(i+1);
					coachErr.setErrorData(errorData);
					coachErr.setErrorMsg(errList);
					coachErrList.add(coachErr);
				} else {
					coach.setLineCount(i);
					coach.setAvatar(csvData[0].isEmpty()?null:csvData[0]);
					coach.setGym_id(csvData[1].isEmpty()?null:csvData[1]);
					coach.setName(csvData[2]);
					coach.setContact(csvData[3].isEmpty()?null:csvData[3]);
					coach.setCreate_time(ceateData);
					coach.setApproved(csvData[4].isEmpty()?null:csvData[4]);
					coach.setDelete_status(csvData[5].isEmpty()?null:csvData[5]);
					coachList.add(coach);
				}	
			}					
		}
		
		coachMap.put("success", coachList);
		coachMap.put("falure", coachErrList);
		return coachMap;
	}
	
	public static Map<String,List<GymForm>> csvGymDataCheck(List<String[]> datalist) throws Exception{
		
		Map<String,List<GymForm>> gymMap = new HashMap<String,List<GymForm>>();
		String[] csvData;
		GymForm gym;
		GymForm gymErr;
		List<GymForm> gymList = new ArrayList<GymForm>();
		List<GymForm> gymErrList = new ArrayList<GymForm>();
		Date now = new Date(); 
		List<String> errList = new ArrayList<String>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String sysDate = dateFormat.format(now); 		
		String ceateData = sysDate.substring(0,4) + sysDate.substring(5,7) + sysDate.substring(8,10) + sysDate.substring(11,13) + sysDate.substring(14,16) + sysDate.substring(17,19);
				
		for(int i=0;i<datalist.size();i++){
			gym = new GymForm();
			gymErr = new GymForm();
			csvData = datalist.get(i);
			errList = new ArrayList<String>();
			String errorData = "";
			if(csvData.length != 6){
				errList.add("Data format is not correct");
				for(int j=0;j<csvData.length;j++){
					if(j + 1 == csvData.length){
						errorData = errorData + csvData[j];
					} else {
						errorData = errorData + csvData[j] + ",";
					}					
				}
				gymErr.setLineCount(i+1);
				gymErr.setErrorData(errorData);
				gymErr.setErrorMsg(errList);
				gymErrList.add(gymErr);
			} else {
				errList = dataGymCheck(csvData);
				if(errList.size() > 0){
					for(int j=0;j<csvData.length;j++){
						if(j + 1 == csvData.length){
							errorData = errorData + csvData[j];
						} else {
							errorData = errorData + csvData[j] + ",";
						}					
					}
					gymErr.setLineCount(i+1);
					gymErr.setErrorData(errorData);
					gymErr.setErrorMsg(errList);
					gymErrList.add(gymErr);
				} else {
					gym.setLineCount(i);
					gym.setAvatar(csvData[0].isEmpty()?null:csvData[0]);					
					gym.setName(csvData[1]);
					gym.setCreate_time(ceateData);
					gym.setContact(csvData[2].isEmpty()?null:csvData[2]);
					gym.setLocation(csvData[3].isEmpty()?null:csvData[3]);					
					gym.setApproved(csvData[4].isEmpty()?null:csvData[4]);
					gym.setDelete_status(csvData[5].isEmpty()?null:csvData[5]);
					gymList.add(gym);
				}	
			}					
		}
		
		gymMap.put("success", gymList);
		gymMap.put("falure", gymErrList);
		return gymMap;
	}

	private final static boolean match(String text, String reg) {
        return Pattern.compile(reg).matcher(text).matches();
    }
	
	private final static List<String> dataCoachCheck(String[] csvData) {
		List<String> errList = new ArrayList<String>();
		if(csvData.length != 6){
			errList.add("Data format is not correct");
		} else {			
			//avatar
			if (csvData[0].length() > 200){
				errList.add("avatar Field length is 0-200");
			}
			
			//gym_id
			if(!csvData[1].isEmpty()){
				if (csvData[1].length() > 15){
					errList.add("gym_id Field length is 0-15");
				}
				if (!match(csvData[1], "^\\d+$")){
					errList.add("gym_id Field write by the number of 0-15");
				}
			}			
							
			//name
			if (csvData[2].isEmpty() || csvData[2] == null){
				errList.add("Name is not");
			} else {
				if (csvData[2].length() > 255){
					errList.add("Name Field length is 0-255");
				}
			}			
			
			//contact
			if(!csvData[3].isEmpty()){
				if (csvData[3].length() > 20){
					errList.add("avatar Field length is 0-20");
				}
			}			
			
			//approved
			if(!csvData[4].isEmpty()){
				if (csvData[4].length() > 2){
					errList.add("approved Field length is 0-2 number");
				}
				if (!match(csvData[4], "^\\d+$")){
					errList.add("approved Field write by the number of 0-2");
				}	
			}					
			
			//delete_status
			if(!csvData[5].isEmpty()){
				if (csvData[5].length() > 2){
					errList.add("delete_status Field length is 0-2 number");
				}
				if (!match(csvData[5], "^\\d+$")){
					errList.add("delete_status Field write by the number of 0-2");
				}
			}
			
		}
		return errList;
	}
	
	private final static List<String> dataGymCheck(String[] csvData) {
		List<String> errList = new ArrayList<String>();
		if(csvData.length != 6){
			errList.add("Data format is not correct");
		} else {			
			//avatar
			if (csvData[0].length() > 200){
				errList.add("avatar Field length is 0-200");
			}
			
			//name
			if (csvData[1].isEmpty() || csvData[1] == null){
				errList.add("Name is not");
			} else {
				if (csvData[1].length() > 255){
					errList.add("Name Field length is 0-255");
				}
			}	
			
			//contact
			if(!csvData[2].isEmpty()){
				if (csvData[2].length() > 20){
					errList.add("avatar Field length is 0-20");
				}
			}
			
			//Location
			if(!csvData[3].isEmpty()){
				if (csvData[3].length() > 255){
					errList.add("Location Field length is 0-255");
				}
			}								
			
			//approved
			if(!csvData[4].isEmpty()){
				if (csvData[4].length() > 2){
					errList.add("approved Field length is 0-2 number");
				}
				if (!match(csvData[4], "^\\d+$")){
					errList.add("approved Field write by the number of 0-2");
				}	
			}					
			
			//delete_status
			if(!csvData[5].isEmpty()){
				if (csvData[5].length() > 2){
					errList.add("delete_status Field length is 0-2 number");
				}
				if (!match(csvData[5], "^\\d+$")){
					errList.add("delete_status Field write by the number of 0-2");
				}
			}
			
		}
		return errList;
	}

}
