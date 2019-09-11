package com.odabasioglu.utility;

/**
 * Copyright C@N
 * www.odabasioglu.net
 * 
 * Calendar Util
 * 
 * @author can odabasioglu
 * @version 1.0.2
 * @since 2005
 *
 */

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.odabasioglu.manager.LogManager;

public class ResourceUtility {

	static Logger loggingManager =
		Logger.getLogger(ResourceUtility.class.getName());
	private Locale locale = Locale.ENGLISH;
	private String RESOURCE_PATH = "com.odabasioglu.resources.";
	private String filename = "";

	private ResourceBundle resourceBundle;

	public ResourceUtility(String _filename) {
		filename = _filename;

	}

	public String getValue(String value) {

		try {
			resourceBundle =
				PropertyResourceBundle.getBundle(
					RESOURCE_PATH + "" + filename,
					locale);
			loggingManager.debug(
				"Property Resource Bundle Initialized : "
					+ RESOURCE_PATH
					+ ""
					+ filename
					+ ".properties");

		} catch (Exception e) {
		
			loggingManager.error(
				"Property Resource Unknown Bundle Error : " + e);

		}

		try {
			return resourceBundle.getString(value);

		} catch (MissingResourceException e) {
			
			loggingManager.error(
				"Property Resource Unknown Value Error : " + e);
			return "Unknown Value " + value;
		}
	}

	public String getValue(String value, String file) {

		try {
			resourceBundle =
				PropertyResourceBundle.getBundle(
					RESOURCE_PATH + "" + file,
					locale);
			loggingManager.debug(
				"Property Resource Bundle Initialized : "
					+ RESOURCE_PATH
					+ ""
					+ file
					+ ".properties");

		} catch (Exception e) {
		
			loggingManager.error(
				"Property Resource Unknown Bundle Error : " + e);

		}

		try {
			return resourceBundle.getString(value);

		} catch (MissingResourceException exception) {
			loggingManager.error(
				"Property Resource Unknown Value Error : " + exception);
			return "Unknown Value " + value;
		}
	}

	public void setLocale(Locale locale) {
		try {
			resourceBundle =
				PropertyResourceBundle.getBundle(RESOURCE_PATH, locale);
		} catch (Exception ex) {
			resourceBundle =
				PropertyResourceBundle.getBundle(RESOURCE_PATH, Locale.ENGLISH);
		}
	}

}
