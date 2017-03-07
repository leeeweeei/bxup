//20170304 Baojun Add
package com.wang.form;

public class CoachPhotoForm {
	
	private int coach_id;
	private int type;	
	private String photo;
	private int delete_status;

	
	public int getCoach_id() {
		return coach_id;
	}
	public void setCoach_id(int coach_id) {
		this.coach_id = coach_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getDelete_status() {
		return delete_status;
	}
	public void setDelete_status(int delete_status) {
		this.delete_status = delete_status;
	}
}
