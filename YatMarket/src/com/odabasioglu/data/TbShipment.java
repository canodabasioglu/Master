package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbShipment;

/**
 * This is the object class that relates to the TB_SHIPMENT table.
 * Any customizations belong here.
 */
public class TbShipment extends BaseTbShipment {

/**
	 * 
	 */
	private static final long serialVersionUID = 3069903277384055866L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbShipment () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbShipment (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbShipment (
		java.lang.Integer _id,
		java.lang.String _name,
		java.lang.String _description) {

		super (
			_id,
			_name,
			_description);
	}

/*[CONSTRUCTOR MARKER END]*/
}