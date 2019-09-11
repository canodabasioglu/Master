package com.odabasioglu.action.navigation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class SiteManagerAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value

		HttpSession session = request.getSession();
		Integer userId=null;
		String loginIp=null;
		try {

			String url = request.getParameter("url").trim();

			if (session.getAttribute("user") != (null)) {

				TbUsers user = (TbUsers) session.getAttribute("user");
				userId =user.getId();
				loginIp=user.getLoginIp();
				// Administrator Navigation Rule
				if (user.getUserType().equals(
						SystemConstants.USERTYPE_ADMINISTRATOR)) {

					if (url.equals("contact")) {
						forward = mapping.findForward("listContacts");
					} else if (url.equals("order")) {
						forward = mapping.findForward("listOrder");
					} else if (url.equals("log")) {
						forward = mapping.findForward("listLog");
					} else if (url.equals("right")) {
						forward = mapping.findForward("listRight");
					} else if (url.equals("role")) {
						forward = mapping.findForward("listRole");
					} else if (url.equals("category")) {
						forward = mapping.findForward("listCategory");
					} else if (url.equals("product")) {
						forward = mapping.findForward("listProduct");
					} else if (url.equals("campaign")) {
						forward = mapping.findForward("listCampaign");
					} else if (url.equals("currency")) {
						forward = mapping.findForward("listCurrency");
					} else if (url.equals("news")) {
						forward = mapping.findForward("listNews");
					} else if (url.equals("parameters")) {
						forward = mapping.findForward("listParameters");
					} else {
						forward = mapping.findForward("adminHomepage");
					}

					// Normal Member Navigation Rule
				} else {

					if (url.equals("homepage")) {
						forward = mapping.findForward("userHomepage");
					} else if (url.equals("aboutUs")) {
						forward = mapping.findForward("userAboutUs");
					} else if (url.equals("orderDelivery")) {
						forward = mapping.findForward("userOrderDelivery");
					} else if (url.equals("customerRelations")) {
						forward = mapping.findForward("userCustomerRelations");
					} else if (url.equals("siteMap")) {
						forward = mapping.findForward("userSiteMap");
					} else if (url.equals("payment")) {
						forward = mapping.findForward("userPayment");
					} else if (url.equals("faq")) {
						forward = mapping.findForward("userFaq");
					} else if (url.equals("contactUs")) {
						forward = mapping.findForward("userContactUs");
					} else if (url.equals("userUpdate")) {
						forward = mapping.findForward("userUpdate");
					} else if (url.equals("addressList")) {
						forward = mapping.findForward("addressList");
					} else if (url.equals("points")) {
						forward = mapping.findForward("points");
					} else if (url.equals("orders")) {
						forward = mapping.findForward("orders");
					} else if (url.equals("favourites")) {
						forward = mapping.findForward("favourites");
					} else if (url.equals("addressCreate")) {
						forward = mapping.findForward("addressCreate");
					} else if (url.equals("orderLines")) {
						forward = mapping.findForward("orderLines");
					} else if (url.equals("shipmentAddress")) {
						forward = mapping.findForward("shipmentAddress");
					} else if (url.equals("paymentAddress")) {
						forward = mapping.findForward("paymentAddress");

					} else {
						forward = mapping.findForward("userHomepage");
					}
				}

				// Guest Navigation Rule
			} else {

				if (url.equals("homepage")) {
					forward = mapping.findForward("homepage");
				} else if (url.equals("aboutUs")) {
					forward = mapping.findForward("aboutUs");
				} else if (url.equals("contactUs")) {
					forward = mapping.findForward("contactUs");
				} else if (url.equals("orderDelivery")) {
					forward = mapping.findForward("orderDelivery");
				} else if (url.equals("customerRelations")) {
					forward = mapping.findForward("customerRelations");
				} else if (url.equals("siteMap")) {
					forward = mapping.findForward("siteMap");
				} else if (url.equals("payment")) {
					forward = mapping.findForward("payment");
				} else if (url.equals("faq")) {
					forward = mapping.findForward("faq");
				} else if (url.equals("contactUs")) {
					forward = mapping.findForward("contactUs");

				} else {
					request.setAttribute("message", "Error.session.expired");
					forward = mapping.findForward("sessionError");
				}

			}
			//activity logging
			LogManager.logNavigation(url,userId,loginIp);
			
			// Finish with

		} catch (Exception e) {
			Logger.getLogger(SiteManagerAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");
		}

		return (forward);

	}
}
