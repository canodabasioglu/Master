/*
 * Created on 11.Mar.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.odabasioglu.manager;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.spi.ErrorCode;

import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbRight;
import com.odabasioglu.data.TbRole;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.data.dao.TbRightDAO;


/**
 * @author Can
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AuthorizationManager {
	
	public static boolean sessionHasActionRight(
		HttpSession session,
		String actionRight) {

		boolean sessionActive = false;

		TbRight right = null;
		TbUsers user = null;
		TbRole role = null;
				
		if (session.getAttribute("user") != (null)) {

			user = (TbUsers) session.getAttribute("user");
			role = user.getRole();

			List listRight =
				TbRightDAO.getInstance().find(
					"from TbRight rights where rights.Role.Id = "
						+ role.getId()
						+ " and rights.Description='"
						+ actionRight.trim()
						+ "' and rights.Status=1");

			if (listRight.size() < 1) {
				LogManager.logOperations("ROLE HAS NO RIGHT");
				return sessionActive;
			} else {
				LogManager.logOperations("ROLE HAS RIGHT");
				sessionActive = true;

			}
		
			if (!actionRight.startsWith("Logs")) {
				LogManager.logActivity("Action: "+actionRight + " Role:" +role.getId() , user.getId(), user.getLoginIp());
			}

		}

		return sessionActive;
	}

	public static boolean sessionActive(HttpSession session) {
		boolean sessionActive = false;

		TbUsers user = null;
		if (session.getAttribute("user") != (null)) {

			sessionActive = true;
		} else {
			session.invalidate();
					}
		return sessionActive;
	}

	


}
