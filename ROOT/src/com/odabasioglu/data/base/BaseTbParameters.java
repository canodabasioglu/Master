package com.odabasioglu.data.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the tb_parameters table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tb_parameters"
 */

public abstract class BaseTbParameters  implements Comparable, Serializable {

	public static String REF = "TbParameters";
	public static String PROP_CONDITION = "Condition";
	public static String PROP_NAME = "Name";
	public static String PROP_VALUE = "Value";
	public static String PROP_ID = "Id";
	public static String PROP_CUSTOM = "Custom";


	// constructors
	public BaseTbParameters () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTbParameters (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTbParameters (
		java.lang.Integer id,
		java.lang.String name,
		java.lang.String value) {

		this.setId(id);
		this.setName(name);
		this.setValue(value);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String value;
	private java.lang.String condition;
	private java.lang.String custom;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="PARAMETER_ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: VALUE
	 */
	public java.lang.String getValue () {
		return value;
	}

	/**
	 * Set the value related to the column: VALUE
	 * @param value the VALUE value
	 */
	public void setValue (java.lang.String value) {
		this.value = value;
	}



	/**
	 * Return the value associated with the column: CONDITIONS
	 */
	public java.lang.String getCondition () {
		return condition;
	}

	/**
	 * Set the value related to the column: CONDITIONS
	 * @param condition the CONDITIONS value
	 */
	public void setCondition (java.lang.String condition) {
		this.condition = condition;
	}



	/**
	 * Return the value associated with the column: CUSTOM
	 */
	public java.lang.String getCustom () {
		return custom;
	}

	/**
	 * Set the value related to the column: CUSTOM
	 * @param custom the CUSTOM value
	 */
	public void setCustom (java.lang.String custom) {
		this.custom = custom;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.odabasioglu.data.TbParameters)) return false;
		else {
			com.odabasioglu.data.TbParameters tbParameters = (com.odabasioglu.data.TbParameters) obj;
			if (null == this.getId() || null == tbParameters.getId()) return false;
			else return (this.getId().equals(tbParameters.getId()));
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

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	public String toString () {
		return super.toString();
	}


}