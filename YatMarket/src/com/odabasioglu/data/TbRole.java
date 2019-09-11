package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbRole;

/**
 * This is the object class that relates to the TB_ROLE table.
 * Any customizations belong here.
 */
public class TbRole extends BaseTbRole {

/**
	 * 
	 */
	private static final long serialVersionUID = 7280056740282151040L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbRole () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbRole (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbRole (
		java.lang.Integer _id,
		java.lang.String _description) {

		super (
			_id,
		    _description);
	}

/*[CONSTRUCTOR MARKER END]*/
}