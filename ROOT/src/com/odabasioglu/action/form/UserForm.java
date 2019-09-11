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
public class UserForm extends ActionForm {

	private static final long serialVersionUID = -3229533629029177167L;

	private Integer userId;

	private Integer birthDateYear;

	private Integer birthDateMonth;

	private Integer birthDateDay;

	private String birthPlace;

	private String email;

	private String fax;

	private String gsm;

	private String name;

	private String occupation;

	private String phone1;

	private String sentEvents;

	private String sex;

	private String surname;

	private String username;

	private String userpassword;

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("ISO-8859-9");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// Reset field values here.
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		try {

		} catch (Exception e) {
		}

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
	public String getBirthPlace() {
		return birthPlace;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @return
	 */
	public String getGsm() {
		return gsm;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @return
	 */
	public String getPhone1() {
		return phone1;
	}

	/**
	 * @return
	 */
	public String getSentEvents() {
		return sentEvents;
	}

	/**
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @return
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return
	 */
	public String getUserpassword() {
		return userpassword;
	}

	/**
	 * @param string
	 */
	public void setBirthPlace(String string) {
		birthPlace = string;
	}

	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string
	 */
	public void setFax(String string) {
		fax = string;
	}

	/**
	 * @param string
	 */
	public void setGsm(String string) {
		gsm = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param string
	 */
	public void setOccupation(String string) {
		occupation = string;
	}

	/**
	 * @param string
	 */
	public void setPhone1(String string) {
		phone1 = string;
	}

	/**
	 * @param string
	 */
	public void setSentEvents(String string) {
		sentEvents = string;
	}

	/**
	 * @param string
	 */
	public void setSex(String string) {
		sex = string;
	}

	/**
	 * @param string
	 */
	public void setSurname(String string) {
		surname = string;
	}

	/**
	 * @param string
	 */
	public void setUsername(String string) {
		username = string;
	}

	/**
	 * @param string
	 */
	public void setUserpassword(String string) {
		userpassword = string;
	}

	/**
	 * @return
	 */
	public Integer getBirthDateDay() {
		return birthDateDay;
	}

	/**
	 * @return
	 */
	public Integer getBirthDateMonth() {
		return birthDateMonth;
	}

	/**
	 * @return
	 */
	public Integer getBirthDateYear() {
		return birthDateYear;
	}

	/**
	 * @param integer
	 */
	public void setBirthDateDay(Integer integer) {
		birthDateDay = integer;
	}

	/**
	 * @param integer
	 */
	public void setBirthDateMonth(Integer integer) {
		birthDateMonth = integer;
	}

	/**
	 * @param integer
	 */
	public void setBirthDateYear(Integer integer) {
		birthDateYear = integer;
	}

	/**
	 * @return
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param integer
	 */
	public void setUserId(Integer integer) {
		userId = integer;
	}

}
