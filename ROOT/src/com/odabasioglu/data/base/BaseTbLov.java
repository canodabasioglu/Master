package com.odabasioglu.data.base;

import java.lang.Comparable;
import java.io.Serializable;


/**
 * This is an object that contains data related to the tb_lov table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tb_lov"
 */

public abstract class BaseTbLov  implements Comparable, Serializable {

	public static String REF = "TbLov";
	public static String PROP_NAME = "Name";
	public static String PROP_VALUE = "Value";
	public static String PROP_TYPE = "Type";
	public static String PROP_ORDER = "Order";
	public static String PROP_ID = "Id";
	public static String PROP_LANGUAGE = "Language";
	public static String PROP_LABEL = "Label";


	// constructors
	public BaseTbLov () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTbLov (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTbLov (
		java.lang.Integer id,
		java.lang.String name,
		java.lang.String label,
		java.lang.String type,
		java.lang.String value) {

		this.setId(id);
		this.setName(name);
		this.setLabel(label);
		this.setType(type);
		this.setValue(value);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String label;
	private java.lang.String type;
	private java.lang.String value;
	private java.lang.String language;
	private java.lang.Integer order;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="LOV_ID"
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
	 * Return the value associated with the column: LABEL
	 */
	public java.lang.String getLabel () {
		return label;
	}

	/**
	 * Set the value related to the column: LABEL
	 * @param label the LABEL value
	 */
	public void setLabel (java.lang.String label) {
		this.label = label;
	}



	/**
	 * Return the value associated with the column: TYPE
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE
	 * @param type the TYPE value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
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
	 * Return the value associated with the column: LANGUAGE
	 */
	public java.lang.String getLanguage () {
		return language;
	}

	/**
	 * Set the value related to the column: LANGUAGE
	 * @param language the LANGUAGE value
	 */
	public void setLanguage (java.lang.String language) {
		this.language = language;
	}



	/**
	 * Return the value associated with the column: ORDER
	 */
	public java.lang.Integer getOrder () {
		return order;
	}

	/**
	 * Set the value related to the column: ORDER
	 * @param order the ORDER value
	 */
	public void setOrder (java.lang.Integer order) {
		this.order = order;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.odabasioglu.data.TbLov)) return false;
		else {
			com.odabasioglu.data.TbLov tbLov = (com.odabasioglu.data.TbLov) obj;
			if (null == this.getId() || null == tbLov.getId()) return false;
			else return (this.getId().equals(tbLov.getId()));
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