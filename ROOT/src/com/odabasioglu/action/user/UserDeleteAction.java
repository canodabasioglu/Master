package com.odabasioglu.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.data.dao.TbUsersDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class UserDeleteAction extends Action {
	private static final String actionRight = "UserDeleteAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {

				TbUsersDAO usersDAO = TbUsersDAO.getInstance();
				Integer userId = Integer.valueOf(request.getParameter("id")
						.trim());
				usersDAO.delete(userId);
				request.setAttribute("message", "Success.user.delete");
				forward = mapping.findForward("deleteUserSuccess");
			} else {
				request.setAttribute("message", "Error.right.violation");
				forward = mapping.findForward("deleteUserSuccess");
			}
		} catch (Exception e) {
			request.setAttribute("message", "Error.user.delete");
			Logger.getLogger(UserDeleteAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		return (forward);

	}
}
