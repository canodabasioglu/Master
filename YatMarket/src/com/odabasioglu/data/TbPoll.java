package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbPoll;

/**
 * This is the object class that relates to the TB_POLL table.
 * Any customizations belong here.
 */
public class TbPoll extends BaseTbPoll {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbPoll () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbPoll (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbPoll (
		java.lang.Integer _id,
		com.odabasioglu.data.TbUsers _users,
		java.lang.String _title,
		java.lang.String _description) {

		super (
			_id,
			_users,
			_title,
			_description);
	}

/*[CONSTRUCTOR MARKER END]*/
}