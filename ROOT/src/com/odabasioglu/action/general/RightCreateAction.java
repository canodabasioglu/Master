package com.odabasioglu.action.general;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.action.form.RightForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbRight;
import com.odabasioglu.data.TbRole;
import com.odabasioglu.data.dao.TbRightDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class RightCreateAction extends Action {
	private static final String actionRight = "RightCreateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		RightForm rightForm = (RightForm) form;

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbRight right = new TbRight();
				TbRole role = new TbRole();
				role.setId(rightForm.getRoleId());
				right.setDescription(rightForm.getDescription());
				right.setRole(role);
				right.setStatus(rightForm.getStatus());
				right.setLogId(SystemConstants.IS_ACTIVE);
				TbRightDAO.getInstance().save(right);

				request.setAttribute("message", "Success.right.create");
				forward = mapping.findForward("listRight");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}

		} catch (Exception e) {
			Logger.getLogger(RightCreateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
