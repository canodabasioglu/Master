package com.odabasioglu.action.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.action.form.OrderlineForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbOrderline;
import com.odabasioglu.data.TbProduct;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.data.dao.TbOrderlineDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.manager.OrderManager;

/**
 * @version 1.0
 * @author
 */
public class OrderLineCreateAction extends Action {
	private static final String actionRight = "OrderLineCreateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		OrderlineForm orderlineForm = (OrderlineForm) form;

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				OrderManager orderManager = new OrderManager();
				TbOrderline orderLine = new TbOrderline();
				TbOrderlineDAO orderlineDAO = TbOrderlineDAO.getInstance();
				TbUsers user = (TbUsers) session.getAttribute("user");
				user.setId(user.getId());
				Integer amountNow = orderlineForm.getAmount();
				float price = orderlineForm.getPrice();
				Integer productId = orderlineForm.getProductId();

				TbProduct product = new TbProduct();
				product.setId(productId);

				TbOrderline orderlineBefore = orderManager.getOrderLine(user
						.getId(), productId);
				orderLine.setUsers(user);
				orderLine.setOrderId(SystemConstants.IS_DEACTIVE);
				orderLine.setProduct(product);
				orderLine.setPrice(price);
				orderLine.setLogId(SystemConstants.IS_ACTIVE);
				orderLine.setStatus(SystemConstants.IS_ACTIVE);
				int amountBefore = orderManager.getOrderlineProductAmount(user
						.getId(), productId);

				if (amountBefore < 1) {
					orderLine.setAmount(amountNow);
					TbOrderlineDAO.getInstance().save(orderLine);

				} else {
					orderLine = TbOrderlineDAO.getInstance().load(
							orderlineBefore.getId());
					orderLine.setAmount(new Integer(orderlineForm.getAmount()
							.intValue()
							+ orderLine.getAmount().intValue()));
					orderlineDAO.update(orderLine);
				}

				forward = mapping.findForward("orderLineCreate");
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
