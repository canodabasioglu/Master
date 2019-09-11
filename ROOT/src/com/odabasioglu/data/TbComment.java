package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbComment;

/**
 * This is the object class that relates to the TB_COMMENT table.
 * Any customizations belong here.
 */
public class TbComment extends BaseTbComment {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbComment () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbComment (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbComment (
		java.lang.Integer _id,
		com.odabasioglu.data.TbProduct _product,
		com.odabasioglu.data.TbUsers _users,
		java.lang.String _comment,
		java.lang.Integer _point) {

		super (
			_id,
			_product,
			_users,
			_comment,
			_point);
	}

/*[CONSTRUCTOR MARKER END]*/
}