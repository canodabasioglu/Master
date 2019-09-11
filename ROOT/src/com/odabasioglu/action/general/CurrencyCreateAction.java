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
import com.odabasioglu.utility.ConverterUtility;

/**
 * @version 1.0
 * @author
 */
public class CurrencyCreateAction extends Action {
	private static final String actionRight = "CurrencyCreateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		CurrencyForm currencyForm = (CurrencyForm) form;

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbCurrency currency = new TbCurrency();
				currency.setCurrencyDate(ConverterUtility.getTodayDate());
				currency.setEuro(currencyForm.getEuro());
				currency.setUsd(currencyForm.getUsd());
				currency.setStatus(currencyForm.getStatus());
				currency.setLogId(SystemConstants.IS_ACTIVE);
				TbCurrencyDAO.getInstance().save(currency);

				request.setAttribute("message", "Success.currency.create");
				forward = mapping.findForward("listCurrency");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}

		} catch (Exception e) {			
			LogManager.logError(e.getMessage());

			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
