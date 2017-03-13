//20170304  Baojun ADD
package com.wang.form;

import java.util.Date;

public class FeedBackForm {
	
	
	private int id;
	private int user_id ;
	private String comment;
	private Date create_time;
	private String simple_createtime;
	private String nikename;
	
	public String getNikename() {
		return nikename;
	}
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}
	public String getSimple_createtime() {
		return simple_createtime;
	}
	public void setSimple_createtime(String simple_createtime) {
		this.simple_createtime = simple_createtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
}
