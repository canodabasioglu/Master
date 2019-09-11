package com.odabasioglu.action.form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author can odabasioglu2
 */
public class CategoryForm extends ActionForm {

	private static final long serialVersionUID = 1934017823987662983L;
	
	private Integer categoryId;
	private Integer status;
	private String categoryDescription;
	private String categoryName;
	private Integer isMain;
	private FormFile theFile;

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
	public String getCategoryDescription() {
		return categoryDescription;
	}

	/**
	 * @return
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @return
	 */
	public Integer getIsMain() {
		return isMain;
	}


	/**
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param string
	 */
	public void setCategoryDescription(String string) {
		categoryDescription = string;
	}

	/**
	 * @param string
	 */
	public void setCategoryName(String string) {
		categoryName = string;
	}

	/**
	 * @param integer
	 */
	public void setIsMain(Integer integer) {
		isMain = integer;
	}


	/**
	 * @param integer
	 */
	public void setStatus(Integer integer) {
		status = integer;
	}

	/**
	 * @return
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param integer
	 */
	public void setCategoryId(Integer integer) {
		categoryId = integer;
	}

	public FormFile getTheFile() {
		return theFile;
	}

	public void setTheFile(FormFile theFile) {
		this.theFile = theFile;
	}

}
