package com.odabasioglu.action.form;

import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * 
 * @version 1.0
 * @author can odabasioglu
 */
public class CurrencyForm extends ActionForm {

	private static final long serialVersionUID = -7737970007548392078L;

	private Integer currencyId;

	private float usd;

	private float euro;

	private Integer status;

	private Date currencyDate;

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("ISO-8859-9");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		// if ((field == null) || (field.length() == 0)) {
		// errors.add("field", new
		// org.apache.struts.action.ActionError("error.field.required"));
		// }
		return errors;

	}

	/**
	 * @return
	 */
	public float getEuro() {
		return euro;
	}

	/**
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @return
	 */
	public float getUsd() {
		return usd;
	}

	/**
	 * @param f
	 */
	public void setEuro(float f) {
		euro = f;
	}

	/**
	 * @param integer
	 */
	public void setStatus(Integer integer) {
		status = integer;
	}

	/**
	 * @param f
	 */
	public void setUsd(float f) {
		usd = f;
	}

	/**
	 * @return
	 */
	public Integer getCurrencyId() {
		return currencyId;
	}

	/**
	 * @param integer
	 */
	public void setCurrencyId(Integer integer) {
		currencyId = integer;
	}

	/**
	 * @return
	 */
	public Date getCurrencyDate() {
		return currencyDate;
	}

	/**
	 * @param date
	 */
	public void setCurrencyDate(Date date) {
		currencyDate = date;
	}

}
