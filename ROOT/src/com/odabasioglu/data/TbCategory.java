package com.odabasioglu.data;

import com.odabasioglu.data.base.BaseTbCategory;

/**
 * This is the object class that relates to the TB_CATEGORY table.
 * Any customizations belong here.
 */
public class TbCategory extends BaseTbCategory {

/**
	 * 
	 */
	private static final long serialVersionUID = -306070562550590068L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public TbCategory () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TbCategory (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public TbCategory (
		java.lang.Integer _id,
		java.util.Date _modifiedDate,
		java.lang.Integer _isMain,
		java.lang.Integer _mainCategoryId,
		java.lang.String _categoryDescription,
		java.lang.String _categoryName,
		java.lang.String _picture) {

		super (
			_id,
			_modifiedDate,
			_isMain,
			_mainCategoryId,
			_categoryDescription,
			_categoryName,
			_picture);
	}

/*[CONSTRUCTOR MARKER END]*/
}