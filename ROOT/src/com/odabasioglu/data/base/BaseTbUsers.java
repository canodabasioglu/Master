package com.odabasioglu.data.base;

import java.io.Serializable;

/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the TB_USERS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TB_USERS"
 */
public abstract class BaseTbUsers implements Serializable {

	public static String PROP_STATUS = "Status";
	public static String PROP_LOGIN_DATE = "LoginDate";
	public static String PROP_USER_TYPE = "UserType";
	public static String PROP_USERPASSWORD = "Userpassword";
	public static String PROP_SEX = "Sex";
	public static String PROP_SURNAME = "Surname";
	public static String PROP_WEBSITE = "Website";
	public static String PROP_BIRTH_PLACE = "BirthPlace";
	public static String PROP_USER_PROGRAMS = "UserPrograms";
	public static String PROP_LOGIN_IP = "LoginIp";
	public static String PROP_SENT_EVENTS = "SentEvents";
	public static String PROP_PHONE1 = "Phone1";
	public static String PROP_BIRTH_DATE = "BirthDate";
	public static String PROP_EMAIL = "Email";
	public static String PROP_LOG_ID = "LogId";
	public static String PROP_FAX = "Fax";
	public static String PROP_OCCUPATION = "Occupation";
	public static String PROP_PHONE2 = "Phone2";
	public static String PROP_NAME = "Name";
	public static String PROP_MEMBER_DATE = "MemberDate";
	public static String PROP_GSM = "Gsm";
	public static String PROP_ID = "Id";
	public static String PROP_USERNAME = "Username";
	public static String PROP_ROLE = "Role";

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.lang.String _surname;
	private java.lang.String _username;
	private java.lang.Integer _userType;
	private java.util.Date _memberDate;
	private java.lang.String _occupation;
	private java.lang.String _website;
	private java.lang.String _fax;
	private java.lang.String _loginIp;
	private java.lang.String _sentEvents;
	private java.lang.String _email;
	private java.lang.String _phone2;
	private java.util.Date _loginDate;
	private java.lang.String _sex;
	private java.lang.Integer _logId;
	private java.lang.String _gsm;
	private java.lang.String _birthPlace;
	private java.lang.Integer _status;
	private java.lang.String _phone1;
	private java.lang.String _name;
	private java.util.Date _birthDate;
	private java.lang.String _userpassword;
	private java.lang.Integer _userPrograms;

	// collections
	private java.util.Set _tbOrderSet;
	private java.util.Set _tbLastvisitSet;
	private java.util.Set _tbFormSet;
	private java.util.Set _tbOrderlineSet;
	private java.util.Set _tbFavouriteSet;
	private java.util.Set _tbPointSet;
	private java.util.Set _tbAddressSet;
	private java.util.Set _tbCommentSet;
	private java.util.Set _tbPollSet;

	// many to one
	private com.odabasioglu.data.TbRole _role;

	// constructors
	public BaseTbUsers() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTbUsers(java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTbUsers(
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

		this.setId(_id);
		this.setSurname(_surname);
		this.setUsername(_username);
		this.setUserType(_userType);
		this.setEmail(_email);
		this.setLoginDate(_loginDate);
		this.setSex(_sex);
		this.setPhone1(_phone1);
		this.setName(_name);
		this.setRole(_role);
		this.setUserpassword(_userpassword);
		initialize();
	}

	protected void initialize() {
	}

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  generator-class="identity"
	 *  column="USERS_ID"
	 */
	public java.lang.Integer getId() {
		return _id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _id the new ID
	 */
	public void setId(java.lang.Integer _id) {
		this._id = _id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: SURNAME
	 */
	public java.lang.String getSurname() {
		return _surname;
	}

	/**
	 * Set the value related to the column: SURNAME
	 * @param _surname the SURNAME value
	 */
	public void setSurname(java.lang.String _surname) {
		this._surname = _surname;
	}

	/**
	 * Return the value associated with the column: USERNAME
	 */
	public java.lang.String getUsername() {
		return _username;
	}

	/**
	 * Set the value related to the column: USERNAME
	 * @param _username the USERNAME value
	 */
	public void setUsername(java.lang.String _username) {
		this._username = _username;
	}

	/**
	 * Return the value associated with the column: USER_TYPE
	 */
	public java.lang.Integer getUserType() {
		return _userType;
	}

	/**
	 * Set the value related to the column: USER_TYPE
	 * @param _userType the USER_TYPE value
	 */
	public void setUserType(java.lang.Integer _userType) {
		this._userType = _userType;
	}

	/**
	 * Return the value associated with the column: MEMBER_DATE
	 */
	public java.util.Date getMemberDate() {
		return _memberDate;
	}

	/**
	 * Set the value related to the column: MEMBER_DATE
	 * @param _memberDate the MEMBER_DATE value
	 */
	public void setMemberDate(java.util.Date _memberDate) {
		this._memberDate = _memberDate;
	}

	/**
	 * Return the value associated with the column: OCCUPATION
	 */
	public java.lang.String getOccupation() {
		return _occupation;
	}

	/**
	 * Set the value related to the column: OCCUPATION
	 * @param _occupation the OCCUPATION value
	 */
	public void setOccupation(java.lang.String _occupation) {
		this._occupation = _occupation;
	}

	/**
	 * Return the value associated with the column: WEBSITE
	 */
	public java.lang.String getWebsite() {
		return _website;
	}

	/**
	 * Set the value related to the column: WEBSITE
	 * @param _website the WEBSITE value
	 */
	public void setWebsite(java.lang.String _website) {
		this._website = _website;
	}

	/**
	 * Return the value associated with the column: FAX
	 */
	public java.lang.String getFax() {
		return _fax;
	}

	/**
	 * Set the value related to the column: FAX
	 * @param _fax the FAX value
	 */
	public void setFax(java.lang.String _fax) {
		this._fax = _fax;
	}

	/**
	 * Return the value associated with the column: LOGIN_IP
	 */
	public java.lang.String getLoginIp() {
		return _loginIp;
	}

	/**
	 * Set the value related to the column: LOGIN_IP
	 * @param _loginIp the LOGIN_IP value
	 */
	public void setLoginIp(java.lang.String _loginIp) {
		this._loginIp = _loginIp;
	}

	/**
	 * Return the value associated with the column: SENT_EVENTS
	 */
	public java.lang.String getSentEvents() {
		return _sentEvents;
	}

	/**
	 * Set the value related to the column: SENT_EVENTS
	 * @param _sentEvents the SENT_EVENTS value
	 */
	public void setSentEvents(java.lang.String _sentEvents) {
		this._sentEvents = _sentEvents;
	}

	/**
	 * Return the value associated with the column: EMAIL
	 */
	public java.lang.String getEmail() {
		return _email;
	}

	/**
	 * Set the value related to the column: EMAIL
	 * @param _email the EMAIL value
	 */
	public void setEmail(java.lang.String _email) {
		this._email = _email;
	}

	/**
	 * Return the value associated with the column: PHONE2
	 */
	public java.lang.String getPhone2() {
		return _phone2;
	}

	/**
	 * Set the value related to the column: PHONE2
	 * @param _phone2 the PHONE2 value
	 */
	public void setPhone2(java.lang.String _phone2) {
		this._phone2 = _phone2;
	}

	/**
	 * Return the value associated with the column: LOGIN_DATE
	 */
	public java.util.Date getLoginDate() {
		return _loginDate;
	}

	/**
	 * Set the value related to the column: LOGIN_DATE
	 * @param _loginDate the LOGIN_DATE value
	 */
	public void setLoginDate(java.util.Date _loginDate) {
		this._loginDate = _loginDate;
	}

	/**
	 * Return the value associated with the column: SEX
	 */
	public java.lang.String getSex() {
		return _sex;
	}

	/**
	 * Set the value related to the column: SEX
	 * @param _sex the SEX value
	 */
	public void setSex(java.lang.String _sex) {
		this._sex = _sex;
	}

	/**
	 * Return the value associated with the column: LOG_ID
	 */
	public java.lang.Integer getLogId() {
		return _logId;
	}

	/**
	 * Set the value related to the column: LOG_ID
	 * @param _logId the LOG_ID value
	 */
	public void setLogId(java.lang.Integer _logId) {
		this._logId = _logId;
	}

	/**
	 * Return the value associated with the column: GSM
	 */
	public java.lang.String getGsm() {
		return _gsm;
	}

	/**
	 * Set the value related to the column: GSM
	 * @param _gsm the GSM value
	 */
	public void setGsm(java.lang.String _gsm) {
		this._gsm = _gsm;
	}

	/**
	 * Return the value associated with the column: BIRTH_PLACE
	 */
	public java.lang.String getBirthPlace() {
		return _birthPlace;
	}

	/**
	 * Set the value related to the column: BIRTH_PLACE
	 * @param _birthPlace the BIRTH_PLACE value
	 */
	public void setBirthPlace(java.lang.String _birthPlace) {
		this._birthPlace = _birthPlace;
	}

	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.Integer getStatus() {
		return _status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param _status the STATUS value
	 */
	public void setStatus(java.lang.Integer _status) {
		this._status = _status;
	}

	/**
	 * Return the value associated with the column: PHONE1
	 */
	public java.lang.String getPhone1() {
		return _phone1;
	}

	/**
	 * Set the value related to the column: PHONE1
	 * @param _phone1 the PHONE1 value
	 */
	public void setPhone1(java.lang.String _phone1) {
		this._phone1 = _phone1;
	}

	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName() {
		return _name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param _name the NAME value
	 */
	public void setName(java.lang.String _name) {
		this._name = _name;
	}

	/**
	 * Return the value associated with the column: BIRTH_DATE
	 */
	public java.util.Date getBirthDate() {
		return _birthDate;
	}

	/**
	 * Set the value related to the column: BIRTH_DATE
	 * @param _birthDate the BIRTH_DATE value
	 */
	public void setBirthDate(java.util.Date _birthDate) {
		this._birthDate = _birthDate;
	}

	/**
	 * Return the value associated with the column: USERPASSWORD
	 */
	public java.lang.String getUserpassword() {
		return _userpassword;
	}

	/**
	 * Set the value related to the column: USERPASSWORD
	 * @param _userpassword the USERPASSWORD value
	 */
	public void setUserpassword(java.lang.String _userpassword) {
		this._userpassword = _userpassword;
	}

	/**
	 * Return the value associated with the column: USER_PROGRAMS
	 */
	public java.lang.Integer getUserPrograms() {
		return _userPrograms;
	}

	/**
	 * Set the value related to the column: USER_PROGRAMS
	 * @param _userPrograms the USER_PROGRAMS value
	 */
	public void setUserPrograms(java.lang.Integer _userPrograms) {
		this._userPrograms = _userPrograms;
	}

	/**
	 * Return the value associated with the column: TbOrderSet
	 */
	public java.util.Set getTbOrderSet() {
		return this._tbOrderSet;
	}

	/**
	 * Set the value related to the column: TbOrderSet
	 * @param _tbOrderSet the TbOrderSet value
	 */
	public void setTbOrderSet(java.util.Set _tbOrderSet) {
		this._tbOrderSet = _tbOrderSet;
	}

	public void addToTbOrderSet(Object obj) {
		if (null == this._tbOrderSet)
			this._tbOrderSet = new java.util.HashSet();
		this._tbOrderSet.add(obj);
	}

	/**
	 * Return the value associated with the column: TbLastvisitSet
	 */
	public java.util.Set getTbLastvisitSet() {
		return this._tbLastvisitSet;
	}

	/**
	 * Set the value related to the column: TbLastvisitSet
	 * @param _tbLastvisitSet the TbLastvisitSet value
	 */
	public void setTbLastvisitSet(java.util.Set _tbLastvisitSet) {
		this._tbLastvisitSet = _tbLastvisitSet;
	}

	public void addToTbLastvisitSet(Object obj) {
		if (null == this._tbLastvisitSet)
			this._tbLastvisitSet = new java.util.HashSet();
		this._tbLastvisitSet.add(obj);
	}

	/**
	 * Return the value associated with the column: TbFormSet
	 */
	public java.util.Set getTbFormSet() {
		return this._tbFormSet;
	}

	/**
	 * Set the value related to the column: TbFormSet
	 * @param _tbFormSet the TbFormSet value
	 */
	public void setTbFormSet(java.util.Set _tbFormSet) {
		this._tbFormSet = _tbFormSet;
	}

	public void addToTbFormSet(Object obj) {
		if (null == this._tbFormSet)
			this._tbFormSet = new java.util.HashSet();
		this._tbFormSet.add(obj);
	}

	/**
	 * Return the value associated with the column: TbOrderlineSet
	 */
	public java.util.Set getTbOrderlineSet() {
		return this._tbOrderlineSet;
	}

	/**
	 * Set the value related to the column: TbOrderlineSet
	 * @param _tbOrderlineSet the TbOrderlineSet value
	 */
	public void setTbOrderlineSet(java.util.Set _tbOrderlineSet) {
		this._tbOrderlineSet = _tbOrderlineSet;
	}

	public void addToTbOrderlineSet(Object obj) {
		if (null == this._tbOrderlineSet)
			this._tbOrderlineSet = new java.util.HashSet();
		this._tbOrderlineSet.add(obj);
	}

	/**
	 * Return the value associated with the column: TbFavouriteSet
	 */
	public java.util.Set getTbFavouriteSet() {
		return this._tbFavouriteSet;
	}

	/**
	 * Set the value related to the column: TbFavouriteSet
	 * @param _tbFavouriteSet the TbFavouriteSet value
	 */
	public void setTbFavouriteSet(java.util.Set _tbFavouriteSet) {
		this._tbFavouriteSet = _tbFavouriteSet;
	}

	public void addToTbFavouriteSet(Object obj) {
		if (null == this._tbFavouriteSet)
			this._tbFavouriteSet = new java.util.HashSet();
		this._tbFavouriteSet.add(obj);
	}

	/**
	 * Return the value associated with the column: TbPointSet
	 */
	public java.util.Set getTbPointSet() {
		return this._tbPointSet;
	}

	/**
	 * Set the value related to the column: TbPointSet
	 * @param _tbPointSet the TbPointSet value
	 */
	public void setTbPointSet(java.util.Set _tbPointSet) {
		this._tbPointSet = _tbPointSet;
	}

	public void addToTbPointSet(Object obj) {
		if (null == this._tbPointSet)
			this._tbPointSet = new java.util.HashSet();
		this._tbPointSet.add(obj);
	}

	/**
	 * Return the value associated with the column: TbAddressSet
	 */
	public java.util.Set getTbAddressSet() {
		return this._tbAddressSet;
	}

	/**
	 * Set the value related to the column: TbAddressSet
	 * @param _tbAddressSet the TbAddressSet value
	 */
	public void setTbAddressSet(java.util.Set _tbAddressSet) {
		this._tbAddressSet = _tbAddressSet;
	}

	public void addToTbAddressSet(Object obj) {
		if (null == this._tbAddressSet)
			this._tbAddressSet = new java.util.HashSet();
		this._tbAddressSet.add(obj);
	}
	/**
		 * @hibernate.property
		 *  column=ROLE_ID
		 * not-null=true
		 */
	public com.odabasioglu.data.TbRole getRole() {
		return this._role;
	}

	/**
	 * Set the value related to the column: ROLE_ID
	 * @param _role the ROLE_ID value
	 */
	public void setRole(com.odabasioglu.data.TbRole _role) {
		this._role = _role;
	}

	/**
	 * Return the value associated with the column: TbCommentSet
	 */
	public java.util.Set getTbCommentSet() {
		return this._tbCommentSet;
	}

	/**
	 * Set the value related to the column: TbCommentSet
	 * @param _tbCommentSet the TbCommentSet value
	 */
	public void setTbCommentSet(java.util.Set _tbCommentSet) {
		this._tbCommentSet = _tbCommentSet;
	}

	public void addToTbCommentSet(Object obj) {
		if (null == this._tbCommentSet)
			this._tbCommentSet = new java.util.HashSet();
		this._tbCommentSet.add(obj);
	}

	/**
	 * Return the value associated with the column: TbPollSet
	 */
	public java.util.Set getTbPollSet() {
		return this._tbPollSet;
	}

	/**
	 * Set the value related to the column: TbPollSet
	 * @param _tbPollSet the TbPollSet value
	 */
	public void setTbPollSet(java.util.Set _tbPollSet) {
		this._tbPollSet = _tbPollSet;
	}

	public void addToTbPollSet(Object obj) {
		if (null == this._tbPollSet)
			this._tbPollSet = new java.util.HashSet();
		this._tbPollSet.add(obj);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof com.odabasioglu.data.base.BaseTbUsers))
			return false;
		else {
			com.odabasioglu.data.base.BaseTbUsers mObj =
				(com.odabasioglu.data.base.BaseTbUsers) obj;
			if (null == this.getId() || null == mObj.getId())
				return false;
			else
				return (this.getId().equals(mObj.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr =
					this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}