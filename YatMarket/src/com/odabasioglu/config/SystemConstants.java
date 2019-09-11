/*
 * Created on Jan 29, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.odabasioglu.config;

import java.util.Date;

import com.odabasioglu.utility.ResourceUtility;

/**
 * @author Can
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SystemConstants {

	private static ResourceUtility resourceApplication = new ResourceUtility(
			"application");

	private static ResourceUtility resourceBundle = new ResourceUtility(
			"formtext_tr");

	public static boolean MAIL_UTILITY_ENABLED_ADMIN = true;

	public static boolean MAIL_UTILITY_ENABLED = true;

	

	public static final long ONE_DAY = 24 * 60 * 60 * 100;

	public static final Integer DEFAULT_LOG = new Integer(1);

	public static final Integer IS_DEACTIVE = new Integer(0);

	public static final Integer IS_ACTIVE = new Integer(1);

	public static final String ERROR = "ERROR";

	public static final Integer MAIN_CATEGORY = new Integer(1);

	public static final Integer SUB_CATEGORY = new Integer(0);

	public static final Integer ORDER_NOT_CREATED = new Integer(0);

	// Currency Constants
	public static final float UNDEFINED_CURRENCY_USD = Float
			.parseFloat(resourceApplication.getValue("defaultUsd"));

	public static final float UNDEFINED_CURRENCY_EURO = Float
			.parseFloat(resourceApplication.getValue("defaultEuro"));

	public static final double VAT_RATIO = Double
			.parseDouble(resourceApplication.getValue("defaultVAT"));

	public static final double TOTAL_VAT = (Double
			.parseDouble(resourceApplication.getValue("defaultVAT"))) + 1;

	public static final double OTHER_PRICE = (Double
			.parseDouble(resourceApplication.getValue("defaultDiscount"))) + 1;

	// Point Constants
	public static final Integer MEMBERSHIP_POINT = Integer
			.valueOf(resourceApplication.getValue("pointsPerMember"));

	public static final double POINTS_PER_ORDER = Double
			.parseDouble(resourceApplication.getValue("pointsPerOrder"));

	public static final Integer MEMBER_POINT_TYPE = new Integer(0);

	public static final Integer ORDER_POINT_NOT_AVAILABLE = new Integer(0);

	public static final Integer ORDER_POINT_AVAILABLE = new Integer(1);

	public static final Integer USERTYPE_NORMAL = new Integer(1);

	public static final Integer USERTYPE_ADMINISTRATOR = new Integer(2);

	public static final Integer STATUS_PASSIVE = new Integer(0);

	public static final Integer STATUS_ACTIVE = new Integer(1);

	public static final Integer PRODUCT_TYPE_IMPORT = new Integer(1);

	public static final Integer PRODUCT_TYPE_EXPORT = new Integer(2);

	public static final Integer ORDER_STATUS_DELETED = new Integer(-1);

	public static final Integer ORDER_STATUS_OLD = new Integer(0);

	public static final Integer ORDER_STATUS_NEW = new Integer(1);

	public static final Integer FEEDBACK_IS_NEW = new Integer(1);

	public static final Integer FEEDBACK_IS_OLD = new Integer(0);

	public static final Integer SHIPMENT_BY_ARAS = new Integer(1);

	public static final Integer SHIPMENT_BY_YURTICI = new Integer(2);

	public static final Integer SHIPMENT_BY_UPS = new Integer(3);

	public static final Integer CURRENCY_YTL = new Integer(1);

	public static final Integer CURRENCY_DOLLAR = new Integer(2);

	public static final Integer CURRENCY_EURO = new Integer(3);

	public static final Integer PRODUCT_IN_STOCK = new Integer(1);

	public static final Integer PRODUCT_NOT_IN_STOCK = new Integer(0);

	public static final String USERNAME = resourceApplication
			.getValue("mail.smtp.username");

	public static final String PASSWORD = resourceApplication
			.getValue("mail.smtp.password");

	public static final String[] MAIL_TO = {
			resourceApplication.getValue("administratormail.send.to1"),
			resourceApplication.getValue("administratormail.send.to2"),
			resourceApplication.getValue("administratormail.send.to3") };
	
	public static final String MAIL_SMTP_HOST = resourceApplication.getValue("mail.smtp.host");
	
	public static final String MAIL_SMTP_PORT = resourceApplication.getValue("mail.smtp.port");
	
	public static class LOGS{
		
		public static final Integer TYPE_FATAL = new Integer(3);
		public static final Integer TYPE_ERROR = new Integer(2);
		public static final Integer TYPE_DEBUG = new Integer(1);
		public static final Integer TYPE_INFO = new Integer(0);
		
		public static final Integer STATUS_ACTIVE = new Integer(1);
		public static final Integer STATUS_PASSIVE = new Integer(0);
		
		public static final String OPERATION_TYPE_ACTIVITY = "OPERATION_TYPE_ACTIVITY";
		public static final String OPERATION_TYPE_NAVIGATION = "OPERATION_TYPE_NAVIGATION";
		public static final String OPERATION_TYPE_ERROR = "OPERATION_TYPE_ERROR";
		public static final String OPERATION_TYPE_INFO = "OPERATION_TYPE_INFO";
		
		public static final String OBJECT_NAME_ACTIVITY = "ACTIVITY LOG";
		public static final String OBJECT_NAME_NAVIGATION = "NAVIGATION LOG";
		public static final String OBJECT_NAME_ERROR = "ERROR";
		public static final String OBJECT_NAME_INFO = "INFO";
		
	
	}
	
	
	
	
}

