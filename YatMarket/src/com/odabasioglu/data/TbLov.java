package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbLov;



public class TbLov extends BaseTbLov {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbLov () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbLov (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbLov (
		java.lang.Integer id,
		java.lang.String name,
		java.lang.String label,
		java.lang.String type,
		java.lang.String value) {

		super (
			id,
			name,
			label,
			type,
			value);
	}

/*[CONSTRUCTOR MARKER END]*/


}