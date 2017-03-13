package com.wang.access;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author Baojun
 * @date 2017年3月1日 下午14:05:07
 *
 */
public class EmailService {

    /**
     * 使用Transport 静态方法 发送邮件
     * 连接163服务，给多个QQ邮箱发邮件
     * @param args
     * @throws Exception
     */
    public void sendmail() throws Exception {
    	
		final Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader()
				.getResourceAsStream("mail.properties"));
		String host = properties.getProperty("mail.smtp.host");
		String port = properties.getProperty("mail.smtp.port");
		String auth = properties.getProperty("mail.smtp.auth");
		String username = properties.getProperty("mail.sender.username");
		
        // 属性对象
        // 开启debug调试  ，打印信息
        properties.setProperty("mail.debug", "true"); 
        // 发送服务器需要身份验证  
        properties.setProperty("mail.smtp.auth", auth);
        // 发送服务器端口，可以不设置，默认是25
        properties.setProperty("mail.smtp.port", port);
        // 发送邮件协议名称 
        properties.setProperty("mail.transport.protocol", "smtp");
        // 设置邮件服务器主机名 
        
        properties.setProperty("mail.host", host);
        // 环境信息
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 在session中设置账户信息，Transport发送邮件时会使用  
            	String username = properties.getProperty("mail.sender.username");
            	String password = properties.getProperty("mail.sender.password");
                return new PasswordAuthentication( username, password);
            }
        });        
        // 创建邮件对象  
        Message message = new MimeMessage(session);
        //设置主题
        message.setSubject("中文主题");
        // 发件人  
        message.setFrom(new InternetAddress(username));
        // 多个收件人  
        message.setRecipients(RecipientType.TO, InternetAddress.parse(username));
        // 抄送人  
        //message.setRecipient(RecipientType.CC, new InternetAddress("aaaaaa@163.com"));  
        // 暗送人  
        //message.setRecipient(RecipientType.BCC, new InternetAddress("bbbbbbb@163.com"));  
        // HTML内容  
        message.setContent("<span style='color:red'>邮件发送成功</span>","text/html;charset=utf-8");
        
        // 连接邮件服务器、发送邮件、关闭连接，全做了  
        Transport.send(message);
        
    }
}
