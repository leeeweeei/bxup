package com.wang.form;

import java.util.List;

public class CoachForm {
	
	private int lineCount;
	private String avatar;
	private String gym_id;
	private String name;
	private String contact;
	private String create_time;
	private String approved;
	private String delete_status;
	private List<String> errorMsg;
	private String errorData;
	
	public int getLineCount() {
		return lineCount;
	}
	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getGym_id() {
		return gym_id;
	}
	public void setGym_id(String gym_id) {
		this.gym_id = gym_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	public String getDelete_status() {
		return delete_status;
	}
	public void setDelete_status(String delete_status) {
		this.delete_status = delete_status;
	}
	public List<String> getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(List<String> errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorData() {
		return errorData;
	}
	public void setErrorData(String errorData) {
		this.errorData = errorData;
	}
	
}
