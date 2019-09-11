package com.odabasioglu.action.form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/**
 * Form bean for a Struts application.
 * 
 * @version 1.0
 * @author can odabasioglu
 */
public class ProductForm extends ActionForm {

	private static final long serialVersionUID = -820924436596425009L;

	private Integer categoryId;

	private String name;

	private String productCode;

	private String description;

	private float price;

	private Integer currencyType;

	private Integer stockStatus;

	private Integer productStatus;

	private Integer status;

	private FormFile theFile;

	/**
	 * @return Returns the theFile.
	 */
	public FormFile getTheFile() {
		return theFile;
	}

	/**
	 * @param theFile
	 *            The FormFile to set.
	 */
	public void setTheFile(FormFile theFile) {
		this.theFile = theFile;
	}

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
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
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
	public float getPrice() {
		return price;
	}

	/**
	 * @return
	 */
	public Integer getProductStatus() {
		return productStatus;
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
	public Integer getStockStatus() {
		return stockStatus;
	}

	/**
	 * @param integer
	 */
	public void setCategoryId(Integer integer) {
		categoryId = integer;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
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
	public void setProductStatus(Integer integer) {
		productStatus = integer;
	}

	/**
	 * @param integer
	 */
	public void setStatus(Integer integer) {
		status = integer;
	}

	/**
	 * @param integer
	 */
	public void setStockStatus(Integer integer) {
		stockStatus = integer;
	}

	/**
	 * @return
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param string
	 */
	public void setProductCode(String string) {
		productCode = string;
	}

	/**
	 * @return
	 */
	public Integer getCurrencyType() {
		return currencyType;
	}

	/**
	 * @param integer
	 */
	public void setCurrencyType(Integer integer) {
		currencyType = integer;
	}

}
