package com.rainbow.common.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ray
 * 
 */
public class User {

	private Long id;
	private String loginName;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private String token;

	private List<String> accessAbleModules = new ArrayList<String>();

	public User() {

	}

	public User(String loginName, String pwd) {
		this.setLoginName(loginName);
		this.setPwd(pwd);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getAccessAbleModules() {
		return accessAbleModules;
	}

	public void setAccessAbleModules(List<String> accessAbleModules) {
		this.accessAbleModules = accessAbleModules;
	}

}
