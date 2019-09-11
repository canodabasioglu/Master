package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbForm;

/**
 * This is the object class that relates to the TB_FORM table.
 * Any customizations belong here.
 */
public class TbForm extends BaseTbForm {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbForm () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbForm (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbForm (
		java.lang.Integer _id,
		com.odabasioglu.data.TbUsers _users,
		java.util.Date _modifiedDate,
		java.lang.String _description,
		java.lang.Integer _formStatus,
		java.lang.String _topic) {

		super (
			_id,
			_users,
			_modifiedDate,
			_description,
			_formStatus,
			_topic);
	}

/*[CONSTRUCTOR MARKER END]*/
}