package com.odabasioglu.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.action.form.UserAddressForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbAddress;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.data.dao.TbAddressDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class UserAddressUpdateAction extends Action {
	private static final String actionRight = "UserAddressUpdateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		UserAddressForm userAdressForm = (UserAddressForm) form;

		Integer addressId = userAdressForm.getAddressId();
		String shortName = userAdressForm.getShortName();
		String line1 = userAdressForm.getLine1();
		String line2 = userAdressForm.getLine2();
		String state = userAdressForm.getState();
		String city = userAdressForm.getCity();
		String country = userAdressForm.getCountry();
		String postalCode = userAdressForm.getPostalCode();
		String taxNo = userAdressForm.getTaxNo();
		String taxOffice = userAdressForm.getTaxOffice();
		Integer addressType = userAdressForm.getAddressType();

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbUsers user = (TbUsers) session.getAttribute("user");

				TbAddress address = new TbAddress();
				address.setUsers(user);
				address.setId(addressId);
				address.setShortName(shortName);
				address.setLine1(line1);
				address.setLine2(line2);
				address.setState(state);
				address.setCity(city);
				address.setCountry(country);
				address.setPostalCode(postalCode);
				address.setTaxNo(taxNo);
				address.setTaxOffice(taxOffice);
				address.setAddressType(addressType);
				address.setLogId(SystemConstants.IS_ACTIVE);
				address.setStatus(SystemConstants.IS_ACTIVE);
				TbAddressDAO addressDAO = TbAddressDAO.getInstance();
				addressDAO.update(address);
				forward = mapping.findForward("updateAddressSuccess");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {
			Logger.getLogger(UserAddressUpdateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		return (forward);

	}
}
