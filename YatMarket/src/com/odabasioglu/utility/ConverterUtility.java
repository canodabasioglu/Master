/*
 * Created on Feb 17, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.odabasioglu.utility;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbCurrency;
import com.odabasioglu.data.TbProduct;
import com.odabasioglu.manager.CurrencyManager;
import com.odabasioglu.manager.ListOfValueManager;

/**
 * @author Can
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ConverterUtility {
	private static ResourceUtility applicationResource = new ResourceUtility(
			"application");

	private static final String language = applicationResource
			.getValue("Country");

	private static final String country = applicationResource
			.getValue("Language");

	private static final Locale locale = new Locale(language, country);

	private static final TbCurrency currency = CurrencyManager
			.getTodaysCurrency();

	/**
	 * @return
	 */
	public static Date getDate(int year, int month, int day) {
		Date date = new Date();
		date.setYear(year - 1900);
		date.setMonth(month - 1);
		date.setDate(day);

		return date;
	}

	public static Date getTodayDate() {
		Date today = new Date();
		today.setHours(0);
		today.setMinutes(0);
		today.setSeconds(0);

		return today;
	}

	public static String getDisplaySize(String value, int size) {
		if (value.length() > size) {
			return value.substring(0, size) + "...";
		} else {
			return value;
		}
	}

	public static String getCurrentDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(applicationResource
				.getValue("CurrentDate"));
		Date currentTime = new Date();
		return dateFormat.format(currentTime);
	}

	public static String getShortDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(applicationResource
				.getValue("Date"));

		return dateFormat.format(date);
	}

	public static String getShortDateTime(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(applicationResource
				.getValue("Datetime"));

		return dateFormat.format(date);
	}

	public static int getOrderPoints(float price) {

		return (int) (price * SystemConstants.POINTS_PER_ORDER);
	}

	public static double getPriceCalculated(TbProduct product) {

		double calculatedPrice = 0;

		if (product.getCurrencyType().equals(SystemConstants.CURRENCY_YTL)) {
			calculatedPrice = product.getPrice();
		} else if (product.getCurrencyType().equals(
				SystemConstants.CURRENCY_DOLLAR)) {
			calculatedPrice = product.getPrice() * currency.getUsd();
		} else if (product.getCurrencyType().equals(
				SystemConstants.CURRENCY_EURO)) {
			calculatedPrice = product.getPrice() * currency.getEuro();
		}

		return calculatedPrice;

	}

	public static String formatCurrency(double calculatedPrice) {

		return DecimalFormat.getCurrencyInstance(locale).format(
				Double.parseDouble(String.valueOf(calculatedPrice)));

	}

	public static String formatCurrencyVAT(double calculatedPrice) {

		return DecimalFormat.getCurrencyInstance(locale).format(
				Double.parseDouble(String.valueOf(calculatedPrice
						* SystemConstants.TOTAL_VAT)));
	}

	public static String formatCurrencyOther(double calculatedPrice) {

		return DecimalFormat.getCurrencyInstance(locale).format(
				Double.parseDouble(String.valueOf(calculatedPrice
						* SystemConstants.OTHER_PRICE)));
	}

	public static String calculateTotalPrice(float price, Integer amount) {
		String language = applicationResource.getValue("Country");
		String country = applicationResource.getValue("Language");
		Locale locale = new Locale(language, country);
		double total = price * (amount.intValue());
		return DecimalFormat.getCurrencyInstance(locale).format(
				Double.parseDouble(String.valueOf(total)));
	}


	private static String getListOfValue(String key,Integer value) {
		String label = "";
		if (value != null) {
			label =  ListOfValueManager.lovLabel(key, value.toString());
			if(label.equals(value.toString())){
				label="| "+label+" |";
			}
		}else
			label = "! "+value +" !";

		return label;
		
	}
	
	public static String getPaymentType(Integer value) {
		return getListOfValue("PaymentType",value);		
	}
	public static String getShipmentType(Integer value) {
		return getListOfValue("ShipmentType",value);		
	}
	public static String getFeedBackStatus(Integer value) {
		return getListOfValue("FeedBackStatus",value);		
	}
	public static String getOrderStatus(Integer value) {
		return getListOfValue("OrderStatus",value);		
	}
	public static String getStockStatus(Integer value) {
		return getListOfValue("StockStatus",value);		
	}
	public static String getProductType(Integer value) {
		return getListOfValue("ProductType",value);		
	}
	public static String getCurrencyType(Integer value) {
		return getListOfValue("CurrencyType",value);		
	}
	public static String getStatus(Integer value) {
		return getListOfValue("Status",value);		
	}
	public static String getUserType(Integer value) {
		return getListOfValue("UserType",value);		
	}
	




}
