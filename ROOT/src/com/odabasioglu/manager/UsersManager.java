package com.odabasioglu.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.odabasioglu.data.TbRole;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.data.dao.TbRightDAO;
import com.odabasioglu.data.dao.TbRoleDAO;
import com.odabasioglu.data.dao.TbUsersDAO;

public class UsersManager {

	private static Logger loggingManager =
		Logger.getLogger(UsersManager.class.getName());
	LogManager log = new LogManager();

	public TbUsers authenticateUser(String username, String password) {
		TbUsers user = null;
		try {
			List listUser =
				TbUsersDAO.getInstance().find(
					"from TbUsers user where user.Username='"
						+ username
						+ "' and user.Userpassword='"
						+ password
						+ "'");

			if (listUser.size() > 0) {
				user = (TbUsers) listUser.get(0);
			} else {
				user = null;
			}
	
			loggingManager.debug("User Manager Info : Authenticate User ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"User Manager Exception : Authenticate User : " + e);

		}
		return user;

	}

	public boolean userExists(String username, String email) {
		boolean status = false;

		try {
			List listUser =
				TbUsersDAO.getInstance().find(
					"from TbUsers user where user.Username='"
						+ username
						+ "' or user.Email='"
						+ email
						+ "'");

			if (listUser != null) {
				if (listUser.size() > 0) {
					status = true;
				} else {
					status = false;
				}
			} else {
				status = false;
			}
			loggingManager.debug("User Manager Info : Check User ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("User Manager Exception : Check User : " + e);

		}
		return status;
	}

	public List listUsers() {
		List userList = null;
		try {
			userList =
				TbUsersDAO.getInstance().find(
					"from TbUsers user order by user.UserType");

			if (userList == null) {
				userList = new ArrayList();
			}
			loggingManager.debug("User Manager Info : List Users ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("User Manager Exception : List Users : " + e);

		}
		return userList;
	}

	public TbUsers getUser(Integer userId) {
		TbUsers user = null;
		try {
			List listUser =
				TbUsersDAO.getInstance().find(
					"from TbUsers user where user.Id=" + userId + "");
			if (listUser.size() > 0) {
				user = (TbUsers) listUser.get(0);
			} else {
				user = null;
			}

			loggingManager.debug("User Manager Info : Get User ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("User Manager Exception : Get User : " + e);

		}

		return user;
	}
	
	public static TbUsers getUser(String email) {
		TbUsers user = null;
		try {
			List listUser =
				TbUsersDAO.getInstance().find(
					"from TbUsers user where user.Email='" + email + "'");
			if (listUser.size() > 0) {
				user = (TbUsers) listUser.get(0);
			} else {
				user = null;
			}

			loggingManager.debug("User Manager Info : Get User ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("User Manager Exception : Get User : " + e);

		}

		return user;
	}
	public static List listForm(Integer userId) {
		List userList = null;
		try {
			userList =
				TbUsersDAO.getInstance().find(
					"from TbForm form where form.Users.Id="
						+ userId
						+ " order by form.Id");

			if (userList == null) {
				userList = new ArrayList();
			}
			loggingManager.debug("User Manager Info : List Users ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("User Manager Exception : List Users : " + e);

		}
		return userList;
	}

	/**
	 * @param email
	 * @return
	 */
	public static boolean emailExists(String email) {

		boolean emailExists = false;

		try {
			List userList =
				TbUsersDAO.getInstance().find(
					"from TbUsers user where user.Email='"
						+ email
						+ "' order by user.Id");

			if (userList.size() > 0) {
				emailExists = true;
			}
			loggingManager.debug("User Manager Info : Email exists ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("User Manager Exception : Email exists: " + e);

		}
		return emailExists;
	}
	public List listRights(Integer userId) {
		List listRights = null;
		String whereClause = "";

		if (userId != null) {
			whereClause = " and right.Role.UserId =" + userId + "";
		}

		try {
			listRights =
				TbRightDAO.getInstance().find(
					"from TbRight rights where 1=1 "
						+ whereClause
						+ " order by rights.Role.Id desc");

			if (listRights.size() < 1) {
				listRights = new ArrayList();
			}
			loggingManager.debug("User Manager Info : List Rights ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("User Manager Exception : List Rights : " + e);

		}
		return listRights;
	}
	public List listRoles(Integer userId) {
		List listRoles = null;
		String whereClause = "";

		if (userId != null) {
			whereClause = " and roles.UserId =" + userId + "";
		}

		try {
			listRoles =
				TbRoleDAO.getInstance().find(
					"from TbRole roles where 1=1 "
						+ whereClause
						+ " order by roles.Id desc");

			if (listRoles.size() < 1) {
				listRoles = new ArrayList();
			}
			loggingManager.debug("User Manager Info : List Roles ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("User Manager Exception : List Roles : " + e);

		}
		return listRoles;
	}

	public TbRole getRole(Integer roleId) {
		TbRole role = null;
		try {
			List listRole =
				TbUsersDAO.getInstance().find(
					"from TbRole role where role.Id=" + roleId + "");
			if (listRole.size() > 0) {
				role = (TbRole) listRole.get(0);
			} else {
				role = null;
			}

			loggingManager.debug("User Manager Info : Get Role ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("User Manager Exception : Get Role : " + e);

		}

		return role;
	}

	/**
	 * @param user
	 */
	public void updateLogin(TbUsers loggedUser, String loginIp) {

		try {
			TbUsersDAO userDAO = TbUsersDAO.getInstance();
			TbUsers user = userDAO.load(loggedUser.getId());
			user.setLoginDate(new Date());
			//dont update for local Ips
			if(!(loginIp.equals("127.0.0.1") || loginIp.startsWith("192.168")  || loginIp.equals("85.105.7.15") || loginIp.equals("85.105.37.142"))  ){
			user.setLoginIp(loginIp);	
			userDAO.update(user);
			}
			

			loggingManager.debug("User Manager Info : Update User Login : ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(					
				"User Manager Exception : Update User Login : " + e);

		}

	}

}
