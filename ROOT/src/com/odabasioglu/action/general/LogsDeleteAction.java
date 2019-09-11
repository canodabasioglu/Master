package com.odabasioglu.action.general;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.data.dao.TbLogsDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class LogsDeleteAction extends Action {
	private static final String actionRight = "LogsDeleteAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbLogsDAO logsDAO = TbLogsDAO.getInstance();
				Integer logsId = Integer.valueOf(request.getParameter("id")
						.trim());

				logsDAO.delete(logsId);
				request.setAttribute("message", "Success.logs.delete");
				forward = mapping.findForward("listLogs");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}

		} catch (Exception e) {
			Logger.getLogger(LogsDeleteAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("listCurrency");

		}

		// Finish with
		return (forward);

	}
}
