package com.odabasioglu.action.general;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.action.form.CustomerFeedbackForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbForm;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.data.dao.TbFormDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.utility.MailUtility;

/**
 * @version 1.0
 * @author
 */
public class CustomerFeedbackCreateAction extends Action {
	private static final String actionRight = "CustomerFeedbackCreateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		CustomerFeedbackForm feedbackForm = (CustomerFeedbackForm) form;

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbForm feedback = new TbForm();
				TbUsers user = (TbUsers) session.getAttribute("user");
				user.setId(user.getId());
				feedback.setFormStatus(SystemConstants.FEEDBACK_IS_NEW);
				feedback.setUsers(user);
				feedback.setDescription(feedbackForm.getExplanation());
				feedback.setTopic(feedbackForm.getTopic());
				feedback.setModifiedDate(new Date());
				feedback.setStatus(SystemConstants.IS_ACTIVE);
				feedback.setLogId(SystemConstants.IS_ACTIVE);
				TbFormDAO.getInstance().save(feedback);

				forward = mapping.findForward("feedbackCreate");
				
				MailUtility mailUtility = new MailUtility();
				ArrayList mailText = new ArrayList();
				mailText.add(feedback.getTopic());	
				mailText.add(feedback.getDescription());				
				mailUtility.sendFeedbackFormMail(mailText);

			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {
			Logger.getLogger(CustomerFeedbackCreateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
