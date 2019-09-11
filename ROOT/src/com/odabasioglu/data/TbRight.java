package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbRight;

/**
 * This is the object class that relates to the TB_RIGHT table.
 * Any customizations belong here.
 */
public class TbRight extends BaseTbRight {

/**
	 * 
	 */
	private static final long serialVersionUID = 1482148745773382061L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbRight () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbRight (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbRight (
		java.lang.Integer _id,
		com.odabasioglu.data.TbRole _role,
		java.lang.String _description) {

		super (
			_id,
			_role,
			_description);
	}

/*[CONSTRUCTOR MARKER END]*/
}