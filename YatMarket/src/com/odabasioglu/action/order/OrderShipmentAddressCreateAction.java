package com.odabasioglu.action.order;

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

/**
 * @version 1.0
 * @author
 */
public class OrderShipmentAddressCreateAction extends Action {
	private static final String actionRight = "OrderShipmentAddressCreateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbOrder order = new TbOrder();
				TbUsers user = (TbUsers) session.getAttribute("user");
				user.setId(user.getId());
				order.setUsers(user);
				Integer shipmentAddressId = Integer.valueOf(request
						.getParameter("addressId"));
				order.setShipmentAddress(shipmentAddressId);
				session.setAttribute("order", order);
				if (request.getParameter("paymentAddress") != null) {
					order.setPaymentAddress(shipmentAddressId);
					forward = mapping.findForward("orderPaymentTypeSelect");
				} else {
					forward = mapping.findForward("orderPaymentAddressSelect");
				}
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {
			Logger.getLogger(OrderShipmentAddressCreateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		return (forward);

	}
}
