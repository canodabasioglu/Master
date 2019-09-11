package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbOrderline;

/**
 * This is the object class that relates to the TB_ORDERLINE table.
 * Any customizations belong here.
 */
public class TbOrderline extends BaseTbOrderline {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbOrderline () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbOrderline (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbOrderline (
		java.lang.Integer _id,
		com.odabasioglu.data.TbProduct _product,
		com.odabasioglu.data.TbUsers _users,
		java.lang.Integer _amount,
		float _price) {

		super (
			_id,
			_product,
			_users,
			_amount,
			_price);
	}

/*[CONSTRUCTOR MARKER END]*/
}