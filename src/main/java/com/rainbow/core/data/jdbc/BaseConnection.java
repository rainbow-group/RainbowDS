package com.rainbow.core.data.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Ray
 * 
 */
public class BaseConnection {
	
	private static ComboPooledDataSource ds=new ComboPooledDataSource();

	public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }

	protected static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
