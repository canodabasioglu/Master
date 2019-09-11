package com.odabasioglu.action.general;

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
public class SearchProductAction extends Action {
	private static final String actionRight = "SearchProductAction";
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		String keyword = request.getParameter("keyword");

		try {
			if (AuthorizationManager.sessionHasActionRight(session, actionRight)) {
				ProductManager productManager = new ProductManager();
				List productList = productManager.searchProduct(keyword);
				PagerUtility pager = new PagerUtility();
				session.setAttribute("keyword", keyword);

				if (productList != null) {
					pager.setTotalItems(productList.size());
					pager.setItemsPerPage(10);
					session.setAttribute("pager", pager);
					session.setAttribute("searchList", productList);

					if (session.getAttribute("user") != (null)) {
						forward = mapping.findForward("userSearchList");
					} else {
						forward = mapping.findForward("searchList");
					}

				} else {
					pager.setTotalItems(0);
					session.setAttribute("pager", pager);
					session.setAttribute("searchList", productList);
					if (session.getAttribute("user") != (null)) {
						forward = mapping.findForward("userSearchList");
					} else {
						forward = mapping.findForward("searchList");
					}
				}

			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {
			Logger.getLogger(SearchProductAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
