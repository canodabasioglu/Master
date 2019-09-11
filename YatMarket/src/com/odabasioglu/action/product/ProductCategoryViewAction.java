package com.odabasioglu.action.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.CategoryManager;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.utility.PagerUtility;

/**
 * @version 1.0
 * @author
 */
public class ProductCategoryViewAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		try {

			CategoryManager categoryManager = new CategoryManager();
			Integer subCategoryId = Integer.valueOf(request
					.getParameter("productCategoryId"));
			List categoryList = categoryManager.listSubCategory(subCategoryId);
			PagerUtility pager = new PagerUtility();

			if (categoryList != null) {
				pager.setTotalItems(categoryList.size());
				session.setAttribute("pager", pager);
				session.setAttribute("maincategory", categoryList);
				if (session.getAttribute("user") != (null)) {
					forward = mapping.findForward("userListMaincategory");
				} else {
					forward = mapping.findForward("listMaincategory");
				}
			} else {
				pager.setTotalItems(0);
				session.setAttribute("pager", pager);
				session.setAttribute("maincategory", categoryList);

				if (AuthorizationManager.sessionActive(session)) {
					forward = mapping.findForward("userListMaincategory");
				} else {
					forward = mapping.findForward("listMaincategory");
				}
			}

		} catch (Exception e) {
			Logger.getLogger(ProductCategoryViewAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");
		}

		return (forward);

	}
}
