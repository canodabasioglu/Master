package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbDiscount;

/**
 * This is the object class that relates to the TB_DISCOUNT table.
 * Any customizations belong here.
 */
public class TbDiscount extends BaseTbDiscount {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbDiscount () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbDiscount (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbDiscount (
		java.lang.Integer _id,
		com.odabasioglu.data.TbProduct _product,
		java.util.Date _modifiedDate,
		java.lang.Integer _ratio,
		java.lang.Integer _discountType) {

		super (
			_id,
			_product,
			_modifiedDate,
			_ratio,
			_discountType);
	}

/*[CONSTRUCTOR MARKER END]*/
}