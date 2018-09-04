package com.rainbow.module.wechat.beans;

import java.util.Date;

/**
 * @author Ray
 * Rainbow
 */
public class Operation {

	private Integer id;
	private Integer userId;
	private Integer typeId;
	private Integer statusId;
	private Date optDate; 
	private String comments;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Date getOptDate() {
		return optDate;
	}
	public void setOptDate(Date optDate) {
		this.optDate = optDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
