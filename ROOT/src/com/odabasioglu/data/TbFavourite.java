package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbFavourite;

/**
 * This is the object class that relates to the TB_FAVOURITE table.
 * Any customizations belong here.
 */
public class TbFavourite extends BaseTbFavourite {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbFavourite () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbFavourite (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbFavourite (
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