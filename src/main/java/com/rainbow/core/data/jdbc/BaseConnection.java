package com.rainbow.core.data.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Ray
 * 
 */
public class BaseConnection {
	
	private static ComboPooledDataSource ds=new ComboPooledDataSource();

//	protected Connection getConnection() {
//
//		Connection conn = null;
//
//		try {
//			Context initialContext = new InitialContext();
//			DataSource datasource = (DataSource) initialContext.lookup("jdbc:mysql://localhost:3306/sc");
//
//			if (datasource != null) {
//				conn = datasource.getConnection();
//			} else {
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return conn;
//	}
	
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
