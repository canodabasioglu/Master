package com.odabasioglu.action.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.data.dao.TbCategoryDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class ProductCategoryDeleteAction extends Action {
	private static final String actionRight = "ProductCategoryDeleteAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {

				TbCategoryDAO categoryDAO = TbCategoryDAO.getInstance();

				Integer categoryId = Integer.valueOf(request.getParameter("id")
						.trim());

				categoryDAO.delete(categoryId);
				request.setAttribute("message", "Success.category.delete");

				forward = mapping.findForward("listMaincategory");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {
			request.setAttribute("message", "Error.category.delete");
			Logger.getLogger(ProductCategoryDeleteAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("listMaincategory");

		}

		// Finish with
		return (forward);

	}
}
