package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbLastvisit;

/**
 * This is the object class that relates to the TB_LASTVISIT table.
 * Any customizations belong here.
 */
public class TbLastvisit extends BaseTbLastvisit {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbLastvisit () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbLastvisit (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbLastvisit (
		java.lang.Integer _id,
		com.odabasioglu.data.TbProduct _product,
		com.odabasioglu.data.TbUsers _users,
		java.util.Date _modifiedDate) {

		super (
			_id,
			_product,
			_users,
			_modifiedDate);
	}

/*[CONSTRUCTOR MARKER END]*/
}