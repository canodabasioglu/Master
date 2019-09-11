package com.odabasioglu.action.form;

import java.io.UnsupportedEncodingException;

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
public class CommentForm extends ActionForm {

	private static final long serialVersionUID = 1121361690400551553L;

	private String comment;

	private Integer point;

	private Integer productId;

	private Integer userId;

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
	public String getComment() {
		return comment;
	}

	/**
	 * @return
	 */
	public Integer getPoint() {
		return point;
	}

	/**
	 * @return
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @return
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param string
	 */
	public void setComment(String string) {
		comment = string;
	}

	/**
	 * @param integer
	 */
	public void setPoint(Integer integer) {
		point = integer;
	}

	/**
	 * @param integer
	 */
	public void setProductId(Integer integer) {
		productId = integer;
	}

	/**
	 * @param integer
	 */
	public void setUserId(Integer integer) {
		userId = integer;
	}

}
