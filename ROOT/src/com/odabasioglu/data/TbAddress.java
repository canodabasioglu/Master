package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbAddress;

/**
 * This is the object class that relates to the TB_ADDRESS table.
 * Any customizations belong here.
 */
public class TbAddress extends BaseTbAddress {

/**
	 * 
	 */
	private static final long serialVersionUID = -587194817657966626L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbAddress () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbAddress (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbAddress (
		java.lang.Integer _id,
		com.odabasioglu.data.TbUsers _users,
		java.lang.String _state,
		java.lang.String _line1,
		java.lang.String _country,
		java.lang.String _postalCode,
		java.lang.String _line2,
		java.lang.String _shortName,
		java.lang.String _city) {

		super (
			_id,
			_users,
			_state,
			_line1,
			_country,
			_postalCode,
			_line2,
			_shortName,
			_city);
	}

/*[CONSTRUCTOR MARKER END]*/
}