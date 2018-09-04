package com.rainbow.common.data;

import org.apache.ibatis.session.SqlSession;

import com.rainbow.common.beans.User;
import com.rainbow.core.data.mybatis.BaseDAO;

/**
 * @author Ray
 */
public class UserDAO extends BaseDAO{

	public UserDAO() {
		super();
	}

	public User findUserByIdentity(String loginName, String pwd) {

		User identity = new User(loginName, pwd);
		SqlSession session = sqlSessionFactory.openSession();
		User user = null;
		try {
			user = session.selectOne("User.selectByIdentity", identity);
		} finally {
			session.close();
		}

		return user;

	}
}
