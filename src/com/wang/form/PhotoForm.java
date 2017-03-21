package com.wang.form;

public class PhotoForm {

	
	private long id;           
	private String file_name;     
	private long create_time;  
	private long create_user_id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	public long getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(long create_user_id) {
		this.create_user_id = create_user_id;
	}

}
