package com.odabasioglu.data.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the TB_FAVOURITE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TB_FAVOURITE"
 */
public abstract class BaseTbFavourite  implements Serializable {

	public static String PROP_STATUS = "Status";
	public static String PROP_PRODUCT = "Product";
	public static String PROP_LOG_ID = "LogId";
	public static String PROP_USERS = "Users";
	public static String PROP_MODIFIED_DATE = "ModifiedDate";
	public static String PROP_ID = "Id";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.lang.Integer _logId;
	private java.lang.Integer _status;
	private java.util.Date _modifiedDate;

	// many to one
	private com.odabasioglu.data.TbProduct _product;
	private com.odabasioglu.data.TbUsers _users;


	// constructors
	public BaseTbFavourite () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTbFavourite (java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTbFavourite (
		java.lang.Integer _id,
		com.odabasioglu.data.TbProduct _product,
		com.odabasioglu.data.TbUsers _users,
		java.util.Date _modifiedDate) {

		this.setId(_id);
		this.setProduct(_product);
		this.setUsers(_users);
		this.setModifiedDate(_modifiedDate);
		initialize();
	}

	protected void initialize () {}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="FAVOURITE_ID"
     */
	public java.lang.Integer getId () {
		return _id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _id the new ID
	 */
	public void setId (java.lang.Integer _id) {
		this._id = _id;
		this.hashCode = Integer.MIN_VALUE;
	}


	/**
	 * Return the value associated with the column: LOG_ID
	 */
	public java.lang.Integer getLogId () {
		return _logId;
	}

	/**
	 * Set the value related to the column: LOG_ID
	 * @param _logId the LOG_ID value
	 */
	public void setLogId (java.lang.Integer _logId) {
		this._logId = _logId;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.Integer getStatus () {
		return _status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param _status the STATUS value
	 */
	public void setStatus (java.lang.Integer _status) {
		this._status = _status;
	}


	/**
	 * Return the value associated with the column: MODIFIED_DATE
	 */
	public java.util.Date getModifiedDate () {
		return _modifiedDate;
	}

	/**
	 * Set the value related to the column: MODIFIED_DATE
	 * @param _modifiedDate the MODIFIED_DATE value
	 */
	public void setModifiedDate (java.util.Date _modifiedDate) {
		this._modifiedDate = _modifiedDate;
	}


	/**
     * @hibernate.property
     *  column=PRODUCT_ID
	 * not-null=true
	 */
	public com.odabasioglu.data.TbProduct getProduct () {
		return this._product;
	}

	/**
	 * Set the value related to the column: PRODUCT_ID
	 * @param _product the PRODUCT_ID value
	 */
	public void setProduct (com.odabasioglu.data.TbProduct _product) {
		this._product = _product;
	}


	/**
     * @hibernate.property
     *  column=USERS_ID
	 * not-null=true
	 */
	public com.odabasioglu.data.TbUsers getUsers () {
		return this._users;
	}

	/**
	 * Set the value related to the column: USERS_ID
	 * @param _users the USERS_ID value
	 */
	public void setUsers (com.odabasioglu.data.TbUsers _users) {
		this._users = _users;
	}


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.odabasioglu.data.base.BaseTbFavourite)) return false;
		else {
			com.odabasioglu.data.base.BaseTbFavourite mObj = (com.odabasioglu.data.base.BaseTbFavourite) obj;
			if (null == this.getId() || null == mObj.getId()) return false;
			else return (this.getId().equals(mObj.getId()));
		}
	}


	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

}