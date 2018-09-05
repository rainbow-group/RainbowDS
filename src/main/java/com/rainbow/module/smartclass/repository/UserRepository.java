package com.rainbow.module.smartclass.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rainbow.core.data.jdbc.BaseRepository;
import com.rainbow.module.smartclass.bean.UserBean;

/**
 * @author Ray
 *
 *         Oct 15, 2015
 */
public class UserRepository extends BaseRepository {

	public UserBean findById(Integer id) {
		UserBean user = null;
		String sql = "SELECT * FROM USER WHERE ID = " + id;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				user = new UserBean();
				fillData(user, rs);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			close(rs, stmt, conn);
		}

		return user;
	}

	public UserBean findByOpenId(String openId) {
		UserBean user = null;
		String sql = "SELECT * FROM USER WHERE ID = " + openId;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				user = new UserBean();
				fillData(user, rs);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			close(rs, stmt, conn);
		}

		return user;
	}

	public UserBean save(UserBean user) {
		String sql = "";

		if (this.findByOpenId(user.getOpenId()) == null) {
			sql = "insert into user (openid, phone) values ('" + user.getOpenId() + "', '" + user.getPhone() + "'  )";
		} else {

		}


		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				user = new UserBean();
				fillData(user, rs);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			close(rs, stmt, conn);
		}

		return user;
	}

}
