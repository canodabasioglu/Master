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
import com.odabasioglu.action.form.ParameterForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbCurrency;
import com.odabasioglu.data.TbParameters;
import com.odabasioglu.data.dao.TbCurrencyDAO;
import com.odabasioglu.data.dao.TbParametersDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class ParameterUpdateAction extends Action {
	private static final String actionRight = "ParameterUpdateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbParameters parameter= new TbParameters();
				TbParametersDAO parameterDAO = TbParametersDAO.getInstance();
				ParameterForm parameterForm = (ParameterForm) form;
				parameter.setId(parameterForm.getId());
				parameter.setCondition(parameterForm.getCondition());
				parameter.setCustom(parameterForm.getCustom());
				parameter.setName(parameterForm.getName());
				parameter.setValue(parameterForm.getValue());
				parameterDAO.update(parameter);

				request.setAttribute("message", "Success.currency.update");
				forward = mapping.findForward("listParameter");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {	
			e.printStackTrace();
			Logger.getLogger(ParameterUpdateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
