package com.odabasioglu.data.base;

import java.io.File;
import java.io.Serializable;

import com.odabasioglu.config.SystemConstants;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the TB_PRODUCT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TB_PRODUCT"
 */
public abstract class BaseTbProduct  implements Serializable {

	public static String PROP_STATUS = "Status";
	public static String PROP_CURRENCY_TYPE = "CurrencyType";
	public static String PROP_PRODUCT_STATUS = "ProductStatus";
	public static String PROP_PRICE = "Price";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_LOG_ID = "LogId";
	public static String PROP_STOCK_STATUS = "StockStatus";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_NAME = "Name";
	public static String PROP_MODIFIED_DATE = "ModifiedDate";
	public static String PROP_ID = "Id";
	public static String PROP_PRODUCT_CODE = "ProductCode";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.lang.String _productCode;
	private java.lang.Integer _productStatus;
	private java.lang.Integer _logId;
	private java.util.Date _modifiedDate;
	private java.lang.Integer _status;
	private float _price;
	private java.lang.String _name;
	private java.lang.String _description;
	private java.lang.Integer _currencyType;
	private java.lang.Integer _stockStatus;
	private byte[] _thumbnail;
	private byte[] _thumbnailSmall;
	

	// many to one
	private com.odabasioglu.data.TbCategory _category;

	// collections
	private java.util.Set _tbTopsalesSet;
	private java.util.Set _tbOrderlineSet;
	private java.util.Set _tbCampaignSet;
	private java.util.Set _tbDiscountSet;
	private java.util.Set _tbLastvisitSet;
	private java.util.Set _tbFavouriteSet;
	private java.util.Set _tbCommentSet;


	// constructors
	public BaseTbProduct () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTbProduct (java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTbProduct (
		java.lang.Integer _id,
		com.odabasioglu.data.TbCategory _category,
		java.lang.String _productCode,
		float _price,
		java.lang.String _name,
		java.lang.String _description,
		java.lang.Integer _currencyType,
		java.lang.Integer _stockStatus) {

		this.setId(_id);
		this.setCategory(_category);
		this.setProductCode(_productCode);
		this.setPrice(_price);
		this.setName(_name);
		this.setDescription(_description);
		this.setCurrencyType(_currencyType);
		this.setStockStatus(_stockStatus);
		initialize();
	}

	protected void initialize () {}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="PRODUCT_ID"
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
	 * Return the value associated with the column: PRODUCT_CODE
	 */
	public java.lang.String getProductCode () {
		return _productCode;
	}

	/**
	 * Set the value related to the column: PRODUCT_CODE
	 * @param _productCode the PRODUCT_CODE value
	 */
	public void setProductCode (java.lang.String _productCode) {
		this._productCode = _productCode;
	}


	/**
	 * Return the value associated with the column: PRODUCT_STATUS
	 */
	public java.lang.Integer getProductStatus () {
		return _productStatus;
	}

	
	public void setThumbnail (byte[] _thumbnail) {
		this._thumbnail = _thumbnail;
	}

	public byte[] getThumbnail () {
		return _thumbnail;
	}
	public void setThumbnailSmall (byte[] _thumbnailSmall) {
		this._thumbnailSmall = _thumbnailSmall;
	}

	public byte[] getThumbnailSmall () {
		return _thumbnailSmall;
	}
	
	/**
	 * Set the value related to the column: PRODUCT_STATUS
	 * @param _productStatus the PRODUCT_STATUS value
	 */
	public void setProductStatus (java.lang.Integer _productStatus) {
		this._productStatus = _productStatus;
	}


	/**
	 * Return the value associated with the column: LOG_ID
	 */
	public java.lang.Integer getLogId () {
		return _logId;
	}

	/**
	 * Set the value related to the column: LOG_ID
	 * @param _logId the LOG_ID value
	 */
	public void setLogId (java.lang.Integer _logId) {
		this._logId = _logId;
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
	 * Return the value associated with the column: PRICE
	 */
	public float getPrice () {
		return _price;
	}

	/**
	 * Set the value related to the column: PRICE
	 * @param _price the PRICE value
	 */
	public void setPrice (float _price) {
		this._price = _price;
	}


	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return _name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param _name the NAME value
	 */
	public void setName (java.lang.String _name) {
		this._name = _name;
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
	 * Return the value associated with the column: CURRENCY_TYPE
	 */
	public java.lang.Integer getCurrencyType () {
		return _currencyType;
	}

	/**
	 * Set the value related to the column: CURRENCY_TYPE
	 * @param _currencyType the CURRENCY_TYPE value
	 */
	public void setCurrencyType (java.lang.Integer _currencyType) {
		this._currencyType = _currencyType;
	}


	/**
	 * Return the value associated with the column: STOCK_STATUS
	 */
	public java.lang.Integer getStockStatus () {
		return _stockStatus;
	}

	/**
	 * Set the value related to the column: STOCK_STATUS
	 * @param _stockStatus the STOCK_STATUS value
	 */
	public void setStockStatus (java.lang.Integer _stockStatus) {
		this._stockStatus = _stockStatus;
	}


	/**
     * @hibernate.property
     *  column=CATEGORY_ID
	 * not-null=true
	 */
	public com.odabasioglu.data.TbCategory getCategory () {
		return this._category;
	}

	/**
	 * Set the value related to the column: CATEGORY_ID
	 * @param _category the CATEGORY_ID value
	 */
	public void setCategory (com.odabasioglu.data.TbCategory _category) {
		this._category = _category;
	}


	/**
	 * Return the value associated with the column: TbTopsalesSet
	 */
	public java.util.Set getTbTopsalesSet () {
		return this._tbTopsalesSet;
	}

	/**
	 * Set the value related to the column: TbTopsalesSet
	 * @param _tbTopsalesSet the TbTopsalesSet value
	 */
	public void setTbTopsalesSet (java.util.Set _tbTopsalesSet) {
		this._tbTopsalesSet = _tbTopsalesSet;
	}
	
	public void addToTbTopsalesSet (Object obj) {
		if (null == this._tbTopsalesSet) this._tbTopsalesSet = new java.util.HashSet();
		this._tbTopsalesSet.add(obj);
	}



	/**
	 * Return the value associated with the column: TbOrderlineSet
	 */
	public java.util.Set getTbOrderlineSet () {
		return this._tbOrderlineSet;
	}

	/**
	 * Set the value related to the column: TbOrderlineSet
	 * @param _tbOrderlineSet the TbOrderlineSet value
	 */
	public void setTbOrderlineSet (java.util.Set _tbOrderlineSet) {
		this._tbOrderlineSet = _tbOrderlineSet;
	}
	
	public void addToTbOrderlineSet (Object obj) {
		if (null == this._tbOrderlineSet) this._tbOrderlineSet = new java.util.HashSet();
		this._tbOrderlineSet.add(obj);
	}



	/**
	 * Return the value associated with the column: TbCampaignSet
	 */
	public java.util.Set getTbCampaignSet () {
		return this._tbCampaignSet;
	}

	/**
	 * Set the value related to the column: TbCampaignSet
	 * @param _tbCampaignSet the TbCampaignSet value
	 */
	public void setTbCampaignSet (java.util.Set _tbCampaignSet) {
		this._tbCampaignSet = _tbCampaignSet;
	}
	
	public void addToTbCampaignSet (Object obj) {
		if (null == this._tbCampaignSet) this._tbCampaignSet = new java.util.HashSet();
		this._tbCampaignSet.add(obj);
	}



	/**
	 * Return the value associated with the column: TbDiscountSet
	 */
	public java.util.Set getTbDiscountSet () {
		return this._tbDiscountSet;
	}

	/**
	 * Set the value related to the column: TbDiscountSet
	 * @param _tbDiscountSet the TbDiscountSet value
	 */
	public void setTbDiscountSet (java.util.Set _tbDiscountSet) {
		this._tbDiscountSet = _tbDiscountSet;
	}
	
	public void addToTbDiscountSet (Object obj) {
		if (null == this._tbDiscountSet) this._tbDiscountSet = new java.util.HashSet();
		this._tbDiscountSet.add(obj);
	}



	/**
	 * Return the value associated with the column: TbLastvisitSet
	 */
	public java.util.Set getTbLastvisitSet () {
		return this._tbLastvisitSet;
	}

	/**
	 * Set the value related to the column: TbLastvisitSet
	 * @param _tbLastvisitSet the TbLastvisitSet value
	 */
	public void setTbLastvisitSet (java.util.Set _tbLastvisitSet) {
		this._tbLastvisitSet = _tbLastvisitSet;
	}
	
	public void addToTbLastvisitSet (Object obj) {
		if (null == this._tbLastvisitSet) this._tbLastvisitSet = new java.util.HashSet();
		this._tbLastvisitSet.add(obj);
	}



	/**
	 * Return the value associated with the column: TbFavouriteSet
	 */
	public java.util.Set getTbFavouriteSet () {
		return this._tbFavouriteSet;
	}

	/**
	 * Set the value related to the column: TbFavouriteSet
	 * @param _tbFavouriteSet the TbFavouriteSet value
	 */
	public void setTbFavouriteSet (java.util.Set _tbFavouriteSet) {
		this._tbFavouriteSet = _tbFavouriteSet;
	}
	
	public void addToTbFavouriteSet (Object obj) {
		if (null == this._tbFavouriteSet) this._tbFavouriteSet = new java.util.HashSet();
		this._tbFavouriteSet.add(obj);
	}



	/**
	 * Return the value associated with the column: TbCommentSet
	 */
	public java.util.Set getTbCommentSet () {
		return this._tbCommentSet;
	}

	/**
	 * Set the value related to the column: TbCommentSet
	 * @param _tbCommentSet the TbCommentSet value
	 */
	public void setTbCommentSet (java.util.Set _tbCommentSet) {
		this._tbCommentSet = _tbCommentSet;
	}
	
	public void addToTbCommentSet (Object obj) {
		if (null == this._tbCommentSet) this._tbCommentSet = new java.util.HashSet();
		this._tbCommentSet.add(obj);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.odabasioglu.data.base.BaseTbProduct)) return false;
		else {
			com.odabasioglu.data.base.BaseTbProduct mObj = (com.odabasioglu.data.base.BaseTbProduct) obj;
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