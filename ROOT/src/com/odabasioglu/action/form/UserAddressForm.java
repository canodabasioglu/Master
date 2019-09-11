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
 * @author
 */
public class UserAddressForm extends ActionForm {

	private static final long serialVersionUID = -3105577417897754178L;

	private Integer addressId;

	private String shortName;

	private String line1;

	private String line2;

	private String state;

	private String city;

	private String country;

	private String postalCode;

	private String taxNo;

	private String taxOffice;

	private Integer addressType;

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
	public Integer getAddressType() {
		return addressType;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return
	 */
	public String getLine1() {
		return line1;
	}

	/**
	 * @return
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * @return
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @return
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return
	 */
	public String getTaxNo() {
		return taxNo;
	}

	/**
	 * @return
	 */
	public String getTaxOffice() {
		return taxOffice;
	}

	/**
	 * @param integer
	 */
	public void setAddressType(Integer integer) {
		addressType = integer;
	}

	/**
	 * @param string
	 */
	public void setCity(String string) {
		city = string;
	}

	/**
	 * @param string
	 */
	public void setCountry(String string) {
		country = string;
	}

	/**
	 * @param string
	 */
	public void setLine1(String string) {
		line1 = string;
	}

	/**
	 * @param string
	 */
	public void setLine2(String string) {
		line2 = string;
	}

	/**
	 * @param string
	 */
	public void setPostalCode(String string) {
		postalCode = string;
	}

	/**
	 * @param string
	 */
	public void setShortName(String string) {
		shortName = string;
	}

	/**
	 * @param string
	 */
	public void setState(String string) {
		state = string;
	}

	/**
	 * @param string
	 */
	public void setTaxNo(String string) {
		taxNo = string;
	}

	/**
	 * @param string
	 */
	public void setTaxOffice(String string) {
		taxOffice = string;
	}

	/**
	 * @return
	 */
	public Integer getAddressId() {
		return addressId;
	}

	/**
	 * @param integer
	 */
	public void setAddressId(Integer integer) {
		addressId = integer;
	}

}
