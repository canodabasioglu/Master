package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbOrder;

/**
 * This is the object class that relates to the TB_ORDER table.
 * Any customizations belong here.
 */
public class TbOrder extends BaseTbOrder {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbOrder () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbOrder (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbOrder (
		java.lang.Integer _id,
		com.odabasioglu.data.TbUsers _users,
		java.lang.Integer _shipmentAddress,
		java.lang.Integer _paymentType,
		java.lang.Integer _shipmentType,
		java.lang.Integer _paymentAddress) {

		super (
			_id,
			_users,
			_shipmentAddress,
			_paymentType,
			_shipmentType,
			_paymentAddress);
	}

/*[CONSTRUCTOR MARKER END]*/
}