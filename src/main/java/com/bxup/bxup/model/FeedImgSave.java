package com.bxup.bxup.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FeedImgSave {

	private List<Integer> itmeID;

	private String setType;

	private List<MultipartFile> feedpicture;

	public List<Integer> getItmeID() {
		return itmeID;
	}

	public void setItmeID(List<Integer> itmeID) {
		this.itmeID = itmeID;
	}

	public String getSetType() {
		return setType;
	}

	public void setSetType(String setType) {
		this.setType = setType;
	}

	public List<MultipartFile> getFeedpicture() {
		return feedpicture;
	}

	public void setFeedpicture(List<MultipartFile> feedpicture) {
		this.feedpicture = feedpicture;
	}

}
