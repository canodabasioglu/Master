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
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.manager.ProductManager;
import com.odabasioglu.utility.PagerUtility;

/**
 * @version 1.0
 * @author
 */
public class ProductSubCategoryViewAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		try {

			Integer productSubcategoryId = Integer.valueOf(request
					.getParameter("productSubcategoryId"));

			ProductManager productManager = new ProductManager();
			List subcategory = productManager
					.listCategoryProduct(productSubcategoryId);
			PagerUtility pager = new PagerUtility();
			if (subcategory != null) {
				pager.setTotalItems(subcategory.size());
				session.setAttribute("pager", pager);
				session.setAttribute("subcategory", subcategory);

				if (session.getAttribute("user") != (null)) {
					forward = mapping.findForward("userListSubcategory");
				} else {
					forward = mapping.findForward("listSubcategory");
				}

			} else {
				pager.setTotalItems(0);
				session.setAttribute("pager", pager);
				session.setAttribute("subcategory", subcategory);
				if (AuthorizationManager.sessionActive(session)) {
					forward = mapping.findForward("userListSubcategory");
				} else {
					forward = mapping.findForward("listSubcategory");
				}

			}

		} catch (Exception e) {
			Logger.getLogger(ProductSubCategoryViewAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
