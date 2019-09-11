package com.odabasioglu.action.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbOrder;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.utility.MailUtility;

/**
 * @version 1.0
 * @author
 */
public class OrderCreateAction extends Action {
	private static final String actionRight = "OrderCreateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				Integer paymentType = Integer.valueOf(request
						.getParameter("paymentType"));
				TbOrder order = (TbOrder) session.getAttribute("order");
				order.setPaymentType(paymentType);
				order.setShipmentType(SystemConstants.SHIPMENT_BY_YURTICI);
				order.setLogId(SystemConstants.IS_ACTIVE);
				order.setStatus(SystemConstants.IS_ACTIVE);
				order.setOrderStatus(SystemConstants.ORDER_STATUS_NEW);

				forward = mapping.findForward("orderCreate");
				
			

			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}

		} catch (Exception e) {
			Logger.getLogger(OrderCreateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		return (forward);

	}
}
