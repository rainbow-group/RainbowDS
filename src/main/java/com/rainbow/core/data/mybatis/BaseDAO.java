package com.rainbow.core.data.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Ray
 * Rainbow
 */
public class BaseDAO {
	
	protected SqlSessionFactory sqlSessionFactory = null;

	protected BaseDAO() {
		this.sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
}
