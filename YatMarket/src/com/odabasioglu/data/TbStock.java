package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbStock;

/**
 * This is the object class that relates to the TB_STOCK table.
 * Any customizations belong here.
 */
public class TbStock extends BaseTbStock {

/**
	 * 
	 */
	private static final long serialVersionUID = 6586874106758767577L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbStock () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbStock (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbStock (
		java.lang.Integer _id,
		java.lang.Integer _amount,
		java.util.Date _modifiedDate,
		java.lang.String _info,
		java.lang.Integer _stockStatus) {

		super (
			_id,
			_amount,
			_modifiedDate,
			_info,
			_stockStatus);
	}

/*[CONSTRUCTOR MARKER END]*/
}