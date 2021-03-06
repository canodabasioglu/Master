package com.master.system;

import java.io.IOException;
import javax.servlet.ServletException;

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

public class UserAction extends org.apache.struts.action.Action {

	/**
	* Constructor
	*/
	public UserAction() {

		super();

	}
	public ActionForward perform(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value
		
		System.out.println("deneme user class");

		try {

			// do something here

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
		forward = mapping.findForward("success");
		forward = mapping.findForward("failure");

		// Finish with
		return (forward);

	}
}
