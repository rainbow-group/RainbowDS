package com.rainbow.test;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rainbow.core.data.jdbc.BaseRepository;
import com.rainbow.module.smartclass.bean.UserBean;
import com.rainbow.module.smartclass.repository.UserRepository;

/**
 * @author Ray
 */
public class DataTester extends BaseRepository{
	final static Logger logger = LogManager.getLogger(DataTester.class);

	public static void main(String[] s) throws SQLException {
		UserBean user;
		
		UserRepository ur = new UserRepository();
		
		user = ur.findById(1);
		
		System.out.println(user.getOpenId());
		
		UserRepository ur1 = new UserRepository();
		user = ur1.findById(1);
		
		System.out.println(user.getCreatedDate());


	}

}
