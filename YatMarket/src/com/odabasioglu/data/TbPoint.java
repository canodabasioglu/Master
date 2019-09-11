package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbPoint;

/**
 * This is the object class that relates to the TB_POINT table.
 * Any customizations belong here.
 */
public class TbPoint extends BaseTbPoint {

/**
	 * 
	 */
	private static final long serialVersionUID = -1470054863360069506L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbPoint () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbPoint (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbPoint (
		java.lang.Integer _id,
		com.odabasioglu.data.TbUsers _users,
		java.lang.Integer _pointType,
		java.lang.Integer _point) {

		super (
			_id,
			_users,
			_pointType,
			_point);
	}

/*[CONSTRUCTOR MARKER END]*/
}