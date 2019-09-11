package com.odabasioglu.action.general;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.action.form.CurrencyForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbCurrency;
import com.odabasioglu.data.dao.TbCurrencyDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class CurrencyUpdateAction extends Action {
	private static final String actionRight = "CurrencyUpdateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbCurrency currency = new TbCurrency();
				TbCurrencyDAO currencyDAO = TbCurrencyDAO.getInstance();
				CurrencyForm currencyForm = (CurrencyForm) form;
				currency.setId(currencyForm.getCurrencyId());
				currency.setEuro(currencyForm.getEuro());
				currency.setUsd(currencyForm.getUsd());
				currency.setCurrencyDate(currencyForm.getCurrencyDate());
				currency.setStatus(currencyForm.getStatus());
				currency.setLogId(SystemConstants.DEFAULT_LOG);
				currencyDAO.update(currency);

				request.setAttribute("message", "Success.currency.update");
				forward = mapping.findForward("listCurrency");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {		
			Logger.getLogger(CurrencyUpdateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
