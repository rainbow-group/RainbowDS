package com.rainbow.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rainbow.core.data.jdbc.BaseRepository;

/**
 * @author Ray
 */
public class DataTester extends BaseRepository{
	final static Logger logger = LogManager.getLogger(DataTester.class);

	public static void main(String[] s) throws SQLException {
		String sql = "SELECT * FROM USER";

		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString(2));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(rs, stmt, conn);
		}


	}

}
