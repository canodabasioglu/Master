package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbLogs;

/**
 * This is the object class that relates to the TB_LOGS table.
 * Any customizations belong here.
 */
public class TbLogs extends BaseTbLogs {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbLogs () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbLogs (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbLogs (
		java.lang.Integer _id,
		java.lang.String _objectName,
		java.lang.String _objectDesc,
		java.util.Date _modifiedDate,
		java.lang.Integer _userId,
		java.lang.String _logIp,
		java.lang.String _operationType) {

		super (
			_id,
			_objectName,
			_objectDesc,
			_modifiedDate,
			_userId,
			_logIp,
			_operationType);
	}

/*[CONSTRUCTOR MARKER END]*/
}