package com.odabasioglu.data.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the TB_POLL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TB_POLL"
 */
public abstract class BaseTbPoll  implements Serializable {

	public static String PROP_STATUS = "Status";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_USERS = "Users";
	public static String PROP_CHOOSE = "Choose";
	public static String PROP_TITLE = "Title";
	public static String PROP_MODIFIED_DATE = "ModifiedDate";
	public static String PROP_ID = "Id";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.lang.String _title;
	private java.lang.Integer _status;
	private java.util.Date _modifiedDate;
	private java.lang.String _description;
	private java.lang.String _choose;

	// many to one
	private com.odabasioglu.data.TbUsers _users;


	// constructors
	public BaseTbPoll () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTbPoll (java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTbPoll (
		java.lang.Integer _id,
		com.odabasioglu.data.TbUsers _users,
		java.lang.String _title,
		java.lang.String _description) {

		this.setId(_id);
		this.setUsers(_users);
		this.setTitle(_title);
		this.setDescription(_description);
		initialize();
	}

	protected void initialize () {}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="POLL_ID"
     */
	public java.lang.Integer getId () {
		return _id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _id the new ID
	 */
	public void setId (java.lang.Integer _id) {
		this._id = _id;
		this.hashCode = Integer.MIN_VALUE;
	}


	/**
	 * Return the value associated with the column: TITLE
	 */
	public java.lang.String getTitle () {
		return _title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param _title the TITLE value
	 */
	public void setTitle (java.lang.String _title) {
		this._title = _title;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.Integer getStatus () {
		return _status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param _status the STATUS value
	 */
	public void setStatus (java.lang.Integer _status) {
		this._status = _status;
	}


	/**
	 * Return the value associated with the column: MODIFIED_DATE
	 */
	public java.util.Date getModifiedDate () {
		return _modifiedDate;
	}

	/**
	 * Set the value related to the column: MODIFIED_DATE
	 * @param _modifiedDate the MODIFIED_DATE value
	 */
	public void setModifiedDate (java.util.Date _modifiedDate) {
		this._modifiedDate = _modifiedDate;
	}


	/**
	 * Return the value associated with the column: DESCRIPTION
	 */
	public java.lang.String getDescription () {
		return _description;
	}

	/**
	 * Set the value related to the column: DESCRIPTION
	 * @param _description the DESCRIPTION value
	 */
	public void setDescription (java.lang.String _description) {
		this._description = _description;
	}


	/**
	 * Return the value associated with the column: CHOOSE
	 */
	public java.lang.String getChoose () {
		return _choose;
	}

	/**
	 * Set the value related to the column: CHOOSE
	 * @param _choose the CHOOSE value
	 */
	public void setChoose (java.lang.String _choose) {
		this._choose = _choose;
	}


	/**
     * @hibernate.property
     *  column=USERS_ID
	 * not-null=true
	 */
	public com.odabasioglu.data.TbUsers getUsers () {
		return this._users;
	}

	/**
	 * Set the value related to the column: USERS_ID
	 * @param _users the USERS_ID value
	 */
	public void setUsers (com.odabasioglu.data.TbUsers _users) {
		this._users = _users;
	}


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.odabasioglu.data.base.BaseTbPoll)) return false;
		else {
			com.odabasioglu.data.base.BaseTbPoll mObj = (com.odabasioglu.data.base.BaseTbPoll) obj;
			if (null == this.getId() || null == mObj.getId()) return false;
			else return (this.getId().equals(mObj.getId()));
		}
	}


	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

}