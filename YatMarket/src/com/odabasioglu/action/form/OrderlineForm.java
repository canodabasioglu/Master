package com.odabasioglu.action.form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author can odabasioglu
 */
public class OrderlineForm extends ActionForm {

	private static final long serialVersionUID = -2261440841422179580L;
	private Integer productId;
	private float price;
	private Integer amount;
	private Integer ORDERLINE_STATUS_INBASKET = new Integer(0);

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("ISO-8859-9");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		// if ((field == null) || (field.length() == 0)) {
		//   errors.add("field", new org.apache.struts.action.ActionError("error.field.required"));
		// }
		return errors;

	}

	/**
	 * @return
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @return
	 */
	public Integer getORDERLINE_STATUS_INBASKET() {
		return ORDERLINE_STATUS_INBASKET;
	}

	/**
	 * @return
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @return
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param integer
	 */
	public void setAmount(Integer integer) {
		amount = integer;
	}

	/**
	 * @param integer
	 */
	public void setORDERLINE_STATUS_INBASKET(Integer integer) {
		ORDERLINE_STATUS_INBASKET = integer;
	}

	/**
	 * @param f
	 */
	public void setPrice(float f) {
		price = f;
	}

	/**
	 * @param integer
	 */
	public void setProductId(Integer integer) {
		productId = integer;
	}

}
