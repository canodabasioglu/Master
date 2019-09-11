package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbUsers;

/**
 * This is the object class that relates to the TB_USERS table.
 * Any customizations belong here.
 */
public class TbUsers extends BaseTbUsers {

/**
	 * 
	 */
	private static final long serialVersionUID = -798454827803809874L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbUsers () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbUsers (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbUsers (
		java.lang.Integer _id,
		java.lang.String _surname,
		java.lang.String _username,
		java.lang.Integer _userType,
		java.lang.String _email,
		java.util.Date _loginDate,
		java.lang.String _sex,
		java.lang.String _phone1,
		java.lang.String _name,
		com.odabasioglu.data.TbRole _role,
		java.lang.String _userpassword) {

		super (
			_id,
			_surname,
			_username,
			_userType,
			_email,
			_loginDate,
			_sex,
			_phone1,
			_name,
			_role,
			_userpassword);
	}

/*[CONSTRUCTOR MARKER END]*/
}