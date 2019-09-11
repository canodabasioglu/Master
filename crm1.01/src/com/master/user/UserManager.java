package com.master.user;

import java.sql.*;
import javax.sql.DataSource;
import java.io.IOException;

import com.master.system.ConnectionMaster;

/**
 * @author Can.Odabasioglu
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class UserManager {

	public static User userControl(String username, String password) {
		User user = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("UserManager");

		String query = "SELECT * FROM USER";

		try {

			conn = ConnectionMaster.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				user = new User();
				user.setName(rs.getString("NAME"));
				user.setSurname(rs.getString("SURNAME"));
				System.out.println("deneme "+rs.getString("NAME"));

			}

		} catch (SQLException e) {
			System.err.println("Exception:" + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException sqle) {
				System.err.println("SQLException:" + sqle);
			}
		}

		return user;
	}
}