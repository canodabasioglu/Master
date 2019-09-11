package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbCurrency;

/**
 * This is the object class that relates to the TB_CURRENCY table.
 * Any customizations belong here.
 */
public class TbCurrency extends BaseTbCurrency {

/**
	 * 
	 */
	private static final long serialVersionUID = 486176444604291972L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbCurrency () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbCurrency (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbCurrency (
		java.lang.Integer _id,
		float _euro,
		float _usd,
		java.util.Date _currencyDate) {

		super (
			_id,
			_euro,
			_usd,
			_currencyDate);
	}

/*[CONSTRUCTOR MARKER END]*/
}