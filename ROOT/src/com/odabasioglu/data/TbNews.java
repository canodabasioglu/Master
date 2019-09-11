package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbNews;

/**
 * This is the object class that relates to the TB_NEWS table.
 * Any customizations belong here.
 */
public class TbNews extends BaseTbNews {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbNews () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbNews (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbNews (
		java.lang.Integer _id,
		java.lang.String _title,
		java.lang.String _newsdescription) {

		super (
			_id,
			_title,
			_newsdescription);
	}

/*[CONSTRUCTOR MARKER END]*/
}