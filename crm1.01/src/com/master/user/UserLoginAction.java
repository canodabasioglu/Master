package com.master.user;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @version 	1.0
 * @author
 */
public class UserLoginAction extends Action {

	/**
	* Constructor
	*/
	public UserLoginAction() {

		super();

	}
	public ActionForward perform(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {
			
			System.out.println("deneme UserLoginAction");

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String forward2 = "";
		HttpSession session = request.getSession(true);

		try {

			// do something here

			User loggedUser = UserManager.userControl(username, password);
			if (loggedUser != null) {
				session.setAttribute("User", loggedUser);
				forward2 = "success";

			} else
				forward2 = "error";

		} catch (Exception e) {

			// Report the error using the appropriate name and ID.
			errors.add("name", new ActionError("id"));

		}

		// If a message is required, save the specified key(s)
		// into the request for use by the <struts:errors> tag.

		if (!errors.empty()) {
			saveErrors(request, errors);
		}
		// Write logic determining how the user should be forwarded.
		//forward = mapping.findForward("userValidated");
		//forward = mapping.findForward("userIncorrect");

		// Finish with
		return(forward);

	}
}
