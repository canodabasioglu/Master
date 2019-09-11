package com.odabasioglu.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.action.form.UserForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.manager.UsersManager;

/**
 * @version 1.0
 * @author
 */
public class UserLoginAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		UserForm userForm = (UserForm) form;
		String username = userForm.getUsername();
		String password = userForm.getUserpassword();
		String loginIp = request.getRemoteAddr();

		try {
			UsersManager usersManager = new UsersManager();
			TbUsers user = usersManager.authenticateUser(username, password);
			
			if (user == null) {
				request.setAttribute("message", "Error.user.notexist");
				LogManager.logInfo("UserLogin Error Username: "+username + " password: " +password);
				forward = mapping.findForward("userError");
			} else if (user.getUserType().equals(
					SystemConstants.USERTYPE_NORMAL)) {
				session.setAttribute("user", user);
				usersManager.updateLogin(user, loginIp);
				forward = mapping.findForward("userLogin");
				LogManager.logInfo("UserLogin success : "+user.getUsername());
			} else if (user.getUserType().equals(
					SystemConstants.USERTYPE_ADMINISTRATOR)) {
				session.setAttribute("user", user);
				usersManager.updateLogin(user, loginIp);
				forward = mapping.findForward("adminLogin");
				LogManager.logInfo("AdminLogin success : "+user.getUsername());
			} else {
				forward = mapping.findForward("exception");
			}


		} catch (Exception e) {

			request.setAttribute("message", "Error.user.notexist");
			Logger.getLogger(UserLoginAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		return (forward);

	}
}
