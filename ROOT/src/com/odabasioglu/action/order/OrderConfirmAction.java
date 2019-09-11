package com.odabasioglu.action.order;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.data.TbOrder;
import com.odabasioglu.data.TbPoint;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.data.dao.TbOrderDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.manager.OrderManager;
import com.odabasioglu.utility.MailUtility;

/**
 * @version 1.0
 * @author
 */
public class OrderConfirmAction extends Action {
	private static final String actionRight = "OrderConfirmAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbUsers user = (TbUsers) session.getAttribute("user");

				TbOrder order = (TbOrder) session.getAttribute("order");

				order.setModifiedDate(new Date(System.currentTimeMillis()));
				OrderManager orderManager = new OrderManager();

				Integer orderId = TbOrderDAO.getInstance().save(order);

				Integer points = Integer.valueOf(request
						.getParameter("orderPoints"));
				if (orderId.intValue() > 0) {

					orderManager
							.updateOrderlineByOrderId(orderId, user.getId());
					// Create Order Point
					TbPoint point = new TbPoint();
					point.setUsers((TbUsers) session.getAttribute("user"));
					point.setPoint(points);
					// pointManager.createOrderPoint(point);
					LogManager.logInfo("Order confirm success User: "+user.getId() + " order : " +orderId);
					MailUtility mailUtility = new MailUtility();
					ArrayList mailText = new ArrayList();
					mailText.add(order.getUsers().getEmail());				
					mailUtility.sendNewOrderMail(mailText);
					
					forward = mapping.findForward("orderConfirmed");
				} else {
					forward = mapping.findForward("orderNotConfirmed");
				}

			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}

		} catch (Exception e) {
			Logger.getLogger(OrderConfirmAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		return (forward);

	}
}
