package com.odabasioglu.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class UserLogoutAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();

		ActionForward forward = new ActionForward(); // return value

		try {
			session.invalidate();
			forward = mapping.findForward("logout");
		} catch (Exception e) {
			Logger.getLogger(UserLogoutAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");
		}

		return (forward);

	}
}
