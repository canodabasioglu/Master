package com.odabasioglu.action.general;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.action.form.RoleForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbRole;
import com.odabasioglu.data.dao.TbRoleDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class RoleCreateAction extends Action {
	private static final String actionRight = "RoleCreateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		RoleForm roleForm = (RoleForm) form;

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbRole role = new TbRole();
				role.setDescription(roleForm.getDescription());
				role.setLogId(SystemConstants.IS_ACTIVE);
				role.setStatus(roleForm.getStatus());
				TbRoleDAO.getInstance().save(role);

				request.setAttribute("message", "Success.role.create");
				forward = mapping.findForward("listRole");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}

		} catch (Exception e) {
			Logger.getLogger(RoleCreateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
