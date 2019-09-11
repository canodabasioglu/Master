package com.odabasioglu.action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.action.form.UserForm;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.manager.UsersManager;
import com.odabasioglu.utility.MailUtility;
import com.odabasioglu.utility.ResourceUtility;

/**
 * @version 1.0
 * @author
 */
public class UserPasswordRemindAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value

		UserForm userPasswordRemindForm = (UserForm) form;
		String email = userPasswordRemindForm.getEmail();
		ResourceUtility resource = new ResourceUtility("formtext_tr");
		try {

			boolean status = UsersManager.emailExists(email);
			if (status == true) {
				MailUtility mailUtility = new MailUtility();
				TbUsers user = UsersManager.getUser(email);
				String sendTo[] = new String[] {email};
				ArrayList mailText = new ArrayList();
				mailText.add(user.getName());
				mailText.add(user.getSurname());
				mailText.add(user.getUsername());				
				mailText.add(user.getUserpassword());
			
				mailUtility.sendPasswordMail(sendTo,mailText);
			
				request.setAttribute("message", "Success.email.send");
				forward = mapping.findForward("remindPassword");
			} else {
				request.setAttribute("message", "Error.email.notexist");
				forward = mapping.findForward("noSuchEmail");
			}
		} catch (Exception e) {			
			Logger.getLogger(UserPasswordRemindAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("remindPassword");
		}
		return (forward);

	}
}
