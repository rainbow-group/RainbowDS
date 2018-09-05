package com.rainbow.module.smartclass.bean;

import java.util.Date;

import com.rainbow.core.annotation.Column;

/**
 * @author Ray Rainbow
 */
public class UserBean {

	@Column(name = "ID")
	Integer id;

	@Column(name = "PHONE")
	String phone;

	@Column(name = "CREATED_DATE")
	Date createdDate;

	@Column(name = "OPEN_ID")
	String openId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

}
