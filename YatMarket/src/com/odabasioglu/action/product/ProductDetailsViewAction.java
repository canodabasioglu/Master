package com.odabasioglu.action.product;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbLastvisit;
import com.odabasioglu.data.TbProduct;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.data.dao.TbLastvisitDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.manager.ProductManager;

/**
 * @version 1.0
 * @author
 */
public class ProductDetailsViewAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		try {

			Integer productId = Integer.valueOf(request
					.getParameter("productId"));

			ProductManager productManager = new ProductManager();
			TbProduct product = productManager.getProduct(productId);

			request.setAttribute("product", product);

			if (AuthorizationManager.sessionActive(session)) {
				TbUsers user = (TbUsers) session.getAttribute("user");

				if (ProductManager.listLastvisit(user.getId(), productId)
						.size() < 1) {
					TbLastvisit lastvisit = new TbLastvisit();
					lastvisit.setProduct(product);
					lastvisit.setUsers(user);
					lastvisit.setModifiedDate(new Date());
					lastvisit.setStatus(SystemConstants.IS_ACTIVE);
					lastvisit.setLogId(SystemConstants.IS_ACTIVE);
					TbLastvisitDAO.getInstance().save(lastvisit);
				}

				forward = mapping.findForward("userProductDetails");
			} else {
				forward = mapping.findForward("productDetails");
			}

		} catch (Exception e) {
			Logger.getLogger(ProductDetailsViewAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
