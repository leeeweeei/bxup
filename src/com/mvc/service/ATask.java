package com.mvc.service;

import java.sql.SQLException;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;  
import org.springframework.stereotype.Component;  
import com.mvc.service.IATask;
import com.wang.access.EmailService;
import com.wang.form.FeedBackForm;  
@Component  
public class ATask implements IATask{
	//20170304 Baojun Add
	@Autowired(required = false)
	private FeedBackService feedBackService;
	
       @Scheduled(cron="0/10 * *  * * ?")   //每天12点自动执行    //             0/10 * *  * * ? 
       @Override      
       public void aTask(){         	   
/*            try {  
                TimeUnit.SECONDS.sleep(20);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  */
            try {
				List<FeedBackForm> feedback = feedBackService.findAll();
	            for(int i = 0;i < feedback.size(); i ++){
	                System.out.println(feedback.get(i)); 
	            	Date time= feedback.get(i).getCreate_time();        
			            if(time.compareTo(new Date()) == 0){
			            	//20170301 每天12点自动送信功能
			            	EmailService.sendmail();	            	
			            }
			            //EmailService.sendmail();
	            }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            
            
            
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
            System.out.println(sdf.format(new Date())+"*********A任务每10秒执行一次进入测试");      
       }      
} 
