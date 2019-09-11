package com.odabasioglu.action.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.data.TbOrder;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.manager.OrderManager;

/**
 * @version 1.0
 * @author
 */
public class OrderDetailsAction extends Action {
	private static final String actionRight = "OrderDetailsAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				String adminPage = request.getParameter("page");
				Integer orderId = Integer.valueOf(request
						.getParameter("orderId"));
				TbUsers user = (TbUsers) session.getAttribute("user");
				OrderManager orderManager = new OrderManager();
				TbOrder order = orderManager.getOrder(orderId);
				List orderline = OrderManager.listOrderline(user.getId(),
						orderId);
				session.setAttribute("order", order);
				session.setAttribute("orderline", orderline);

				if(adminPage!=null && adminPage.equals("admin")){
				forward = mapping.findForward("orderDetailsAdmin");
				}else{
					forward = mapping.findForward("orderDetails");
				}
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {
			Logger.getLogger(OrderDetailsAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		return (forward);

	}
}
