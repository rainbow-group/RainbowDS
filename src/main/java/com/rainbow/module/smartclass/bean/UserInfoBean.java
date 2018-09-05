package com.rainbow.module.smartclass.bean;

import com.rainbow.core.annotation.Column;

/**
 * @author Ray 
 * same bean as the userInfo from Wechat interface.
 */

public class UserInfoBean {

	@Column(name = "OPEN_ID")
	String openId;

	@Column(name = "avatarUrl")
	String avatarUrl;

	@Column(name = "city")
	String city;

	@Column(name = "country")
	String country;

	@Column(name = "gender")
	Integer gender;

	@Column(name = "language")
	String language;

	@Column(name = "nickName")
	String nickName;

	@Column(name = "province")
	String province;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}
