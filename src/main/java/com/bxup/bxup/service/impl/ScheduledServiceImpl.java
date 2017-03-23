package com.bxup.bxup.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bxup.bxup.access.EmailService;
import com.bxup.bxup.model.FeedBack;
import com.bxup.bxup.service.FeedBackService;
import com.bxup.bxup.service.ScheduledService;  
@Component  
public class ScheduledServiceImpl implements ScheduledService{
	//20170304 Baojun Add
	@Autowired(required = false)
	private FeedBackService feedBackService;
	
       @Scheduled(cron="0 0 12 * * ?")   //每天12点自动执行   cron="0 0 12 * * ?"
       @Override                         //每隔10秒自动执行   cron="0/10 * * * * ?"
       public void AutoSendmail(){ 
    	   EmailService emailService = new EmailService();
            try {           	
				List<FeedBack> feedback = feedBackService.findAll();
	            for(int i = 0;i < feedback.size(); i ++){
	                System.out.println(feedback.get(i)); 
	            	Date time= feedback.get(i).getCreate_time();        
			            if(time.compareTo(new Date()) == 0){
			            	//20170301 每天12点自动送信功能
			            	emailService.sendmail();	            	
			            }
	            }
			} catch (Exception e) {		
				// TODO Auto-generated catch block
				e.printStackTrace();
			}           
       }      
} 
