package com.rainbow.module.smartclass.vo;

import java.util.Date;

import com.rainbow.module.smartclass.bean.UserInfoBean;

public class User {
	Integer id;
	String openId; // the openId from wechat
	UserInfoBean userInfo;
	
	String phone;
	Date createdDate;

}
