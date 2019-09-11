package com.master.system;

import javax.sql.DataSource;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Can.Odabasioglu
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ConnectionMaster {

	private static DataSource dataSource;

	private static String url;

	public static Connection getConnection() {
		Connection myconn = null;


				
		if (dataSource == null) {
			try {
				javax.naming.Context ctx = new javax.naming.InitialContext();
				dataSource = (DataSource) ctx.lookup("jdbc/crm"); 
				
	
				
			} catch (Exception e) {
				System.err.println("Exception: " + e);
			}
		}
		try {
			myconn = dataSource.getConnection();
		} catch (SQLException e) {
			System.err.println("SQLException: " + e);
		}
		return myconn;
	}
}
