package com.odabasioglu.action.user;

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
import com.odabasioglu.data.TbFavourite;
import com.odabasioglu.data.TbProduct;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.data.dao.TbFavouriteDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.FavouriteManager;
import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class UserFavouriteCreateAction extends Action {
	private static final String actionRight = "UserFavouriteCreateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				Integer productId = Integer.valueOf(request
						.getParameter("productId"));
				Date now = new Date(System.currentTimeMillis());
				TbUsers user = (TbUsers) session.getAttribute("user");

				TbFavourite favourite = new TbFavourite();
				favourite.setModifiedDate(now);
				TbProduct product = new TbProduct();
				product.setId(productId);
				favourite.setProduct(product);
				user.setId(user.getId());
				favourite.setUsers(user);
				favourite.setStatus(SystemConstants.IS_ACTIVE);
				favourite.setLogId(SystemConstants.IS_ACTIVE);
				if (!FavouriteManager.checkFavourite(productId, user.getId())) {
					TbFavouriteDAO.getInstance().save(favourite);
				}
				forward = mapping.findForward("favouriteCreate");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {
			Logger.getLogger(UserFavouriteCreateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		return (forward);

	}
}
