package com.odabasioglu.data.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the TB_ORDER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TB_ORDER"
 */
public abstract class BaseTbOrder  implements Serializable {

	public static String PROP_PAYMENT_ADDRESS = "PaymentAddress";
	public static String PROP_STATUS = "Status";
	public static String PROP_PAYMENT_TYPE = "PaymentType";
	public static String PROP_SHIPMENT_ADDRESS = "ShipmentAddress";
	public static String PROP_SHIPMENT_TYPE = "ShipmentType";
	public static String PROP_ORDER_STATUS = "OrderStatus";
	public static String PROP_LOG_ID = "LogId";
	public static String PROP_USERS = "Users";
	public static String PROP_MODIFIED_DATE = "ModifiedDate";
	public static String PROP_ID = "Id";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.lang.Integer _shipmentAddress;
	private java.lang.Integer _logId;
	private java.lang.Integer _status;
	private java.util.Date _modifiedDate;
	private java.lang.Integer _paymentType;
	private java.lang.Integer _shipmentType;
	private java.lang.Integer _orderStatus;
	private java.lang.Integer _paymentAddress;

	// many to one
	private com.odabasioglu.data.TbUsers _users;


	// constructors
	public BaseTbOrder () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTbOrder (java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTbOrder (
		java.lang.Integer _id,
		com.odabasioglu.data.TbUsers _users,
		java.lang.Integer _shipmentAddress,
		java.lang.Integer _paymentType,
		java.lang.Integer _shipmentType,
		java.lang.Integer _paymentAddress) {

		this.setId(_id);
		this.setUsers(_users);
		this.setShipmentAddress(_shipmentAddress);
		this.setPaymentType(_paymentType);
		this.setShipmentType(_shipmentType);
		this.setPaymentAddress(_paymentAddress);
		initialize();
	}

	protected void initialize () {}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="ORDER_ID"
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
	 * Return the value associated with the column: SHIPMENT_ADDRESS
	 */
	public java.lang.Integer getShipmentAddress () {
		return _shipmentAddress;
	}

	/**
	 * Set the value related to the column: SHIPMENT_ADDRESS
	 * @param _shipmentAddress the SHIPMENT_ADDRESS value
	 */
	public void setShipmentAddress (java.lang.Integer _shipmentAddress) {
		this._shipmentAddress = _shipmentAddress;
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
	 * Return the value associated with the column: PAYMENT_TYPE
	 */
	public java.lang.Integer getPaymentType () {
		return _paymentType;
	}

	/**
	 * Set the value related to the column: PAYMENT_TYPE
	 * @param _paymentType the PAYMENT_TYPE value
	 */
	public void setPaymentType (java.lang.Integer _paymentType) {
		this._paymentType = _paymentType;
	}


	/**
	 * Return the value associated with the column: SHIPMENT_TYPE
	 */
	public java.lang.Integer getShipmentType () {
		return _shipmentType;
	}

	/**
	 * Set the value related to the column: SHIPMENT_TYPE
	 * @param _shipmentType the SHIPMENT_TYPE value
	 */
	public void setShipmentType (java.lang.Integer _shipmentType) {
		this._shipmentType = _shipmentType;
	}


	/**
	 * Return the value associated with the column: ORDER_STATUS
	 */
	public java.lang.Integer getOrderStatus () {
		return _orderStatus;
	}

	/**
	 * Set the value related to the column: ORDER_STATUS
	 * @param _orderStatus the ORDER_STATUS value
	 */
	public void setOrderStatus (java.lang.Integer _orderStatus) {
		this._orderStatus = _orderStatus;
	}


	/**
	 * Return the value associated with the column: PAYMENT_ADDRESS
	 */
	public java.lang.Integer getPaymentAddress () {
		return _paymentAddress;
	}

	/**
	 * Set the value related to the column: PAYMENT_ADDRESS
	 * @param _paymentAddress the PAYMENT_ADDRESS value
	 */
	public void setPaymentAddress (java.lang.Integer _paymentAddress) {
		this._paymentAddress = _paymentAddress;
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
		if (!(obj instanceof com.odabasioglu.data.base.BaseTbOrder)) return false;
		else {
			com.odabasioglu.data.base.BaseTbOrder mObj = (com.odabasioglu.data.base.BaseTbOrder) obj;
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