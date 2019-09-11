package com.odabasioglu.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbCurrency;
import com.odabasioglu.data.dao.TbCurrencyDAO;

public class CurrencyManager {

	private static Logger loggingManager =
		Logger.getLogger(CurrencyManager.class.getName());
	
	LogManager log = new LogManager();

	public static TbCurrency getTodaysCurrency() {
		TbCurrency currency = null;

		try {
			List listCurrency =
				TbCurrencyDAO.getInstance().find(
					"from TbCurrency order by Id desc");

			if (listCurrency.size() > 0) {
				currency = ((TbCurrency) listCurrency.get(0));
			} else {
				currency.setEuro(SystemConstants.UNDEFINED_CURRENCY_EURO);
				currency.setUsd(SystemConstants.UNDEFINED_CURRENCY_USD);
				currency.setStatus(SystemConstants.IS_DEACTIVE);
				currency.setId(SystemConstants.IS_ACTIVE);
			}

			loggingManager.debug("Currency Manager Info : Get Today Currency ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Currency Manager Exception : Get Today Currency : " + e);

		}

		return currency;
	}

	public List listCurrency() {
		List listCurrency = null;
		try {
			listCurrency =
				TbCurrencyDAO.getInstance().find(
					"from TbCurrency order by Id desc");

			if (listCurrency == null) {
				listCurrency = new ArrayList();
			}
			loggingManager.debug("Currency Manager Info : List Currency ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Currency Manager Exception : List Currency : " + e);

		}

		return listCurrency;
	}
	
	public static TbCurrency getCurrency(Integer currencyId) {
			TbCurrency currency = null;

			try {
				List listCurrency =
					TbCurrencyDAO.getInstance().find(
						"from TbCurrency currency where currency.Id = "+currencyId+"");

				if (listCurrency.size() > 0) {
					currency = ((TbCurrency) listCurrency.get(0));
				} else {
					currency.setEuro(SystemConstants.UNDEFINED_CURRENCY_EURO);
					currency.setUsd(SystemConstants.UNDEFINED_CURRENCY_USD);
					currency.setStatus(SystemConstants.IS_DEACTIVE);
					currency.setId(SystemConstants.IS_ACTIVE);
				}

				loggingManager.debug("Currency Manager Info : Get Currency ");
			} catch (Exception e) {
				LogManager.logError(e.getMessage());
				loggingManager.error(
					"Currency Manager Exception : Get Currency : " + e);

			}

			return currency;
		}

}
