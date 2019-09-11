package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbParameters;



public class TbParameters extends BaseTbParameters {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbParameters () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbParameters (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbParameters (
		java.lang.Integer id,
		java.lang.String name,
		java.lang.String value) {

		super (
			id,
			name,
			value);
	}

/*[CONSTRUCTOR MARKER END]*/


}