package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbProduct;

/**
 * This is the object class that relates to the TB_PRODUCT table.
 * Any customizations belong here.
 */
public class TbProduct extends BaseTbProduct {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbProduct () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbProduct (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbProduct (
		java.lang.Integer _id,
		com.odabasioglu.data.TbCategory _category,
		java.lang.String _productCode,
		float _price,
		java.lang.String _name,
		java.lang.String _description,
		java.lang.Integer _currencyType,
		java.lang.Integer _stockStatus) {

		super (
			_id,
			_category,
			_productCode,
			_price,
			_name,
			_description,
			_currencyType,
			_stockStatus);
	}
/*[CONSTRUCTOR MARKER END]*/
}