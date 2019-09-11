package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbCampaign;

/**
 * This is the object class that relates to the TB_CAMPAIGN table.
 * Any customizations belong here.
 */
public class TbCampaign extends BaseTbCampaign {

/**
	 * 
	 */
	private static final long serialVersionUID = -2317716659972292909L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbCampaign () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbCampaign (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbCampaign (
		java.lang.Integer _id,
		com.odabasioglu.data.TbProduct _product,
		java.util.Date _toDate,
		java.util.Date _fromDate,
		java.lang.Integer _ratio,
		java.lang.Integer _discountType) {

		super (
			_id,
			_product,
			_toDate,
			_fromDate,
			_ratio,
			_discountType);
	}

/*[CONSTRUCTOR MARKER END]*/
}