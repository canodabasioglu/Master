package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbTopsales;

/**
 * This is the object class that relates to the TB_TOPSALES table.
 * Any customizations belong here.
 */
public class TbTopsales extends BaseTbTopsales {

/**
	 * 
	 */
	private static final long serialVersionUID = -3259697002528288817L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbTopsales () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbTopsales (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbTopsales (
		java.lang.Integer _id,
		com.odabasioglu.data.TbProduct _product,
		java.lang.Integer _percentage) {

		super (
			_id,
			_product,
			_percentage);
	}

/*[CONSTRUCTOR MARKER END]*/
}