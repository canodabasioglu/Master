package com.odabasioglu.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.odabasioglu.data.TbLov;
import com.odabasioglu.data.dao.TbLovDAO;

public class ListOfValueManager {

	private static Logger loggingManager = Logger
			.getLogger(ListOfValueManager.class.getName());

	LogManager log = new LogManager();

	public static List cityList() {
		return lovList("City",true);
	}

	public static List paymentTypeList() {
		return lovList("PaymentType",false);
	}
	
	public static List occupationList() {
		return lovList("Occupation",true);
	}
	
	public static List addressTypeList() {
	   return lovList("AddressType",false);
	}
	
	private static List lovList(String name,boolean isLabelEqualToValue) {
		List lovList = new ArrayList();
		String query="";
		try {
			query="from TbLov lov where lov.Name='" + name
							+ "' order by lov.Label asc ";
			List valueList = TbLovDAO.getInstance().find(query);

			for (int i = 0; i < valueList.size(); i++) {
				//value ile label farklý ise 
				if(isLabelEqualToValue){
				lovList.add(((TbLov) valueList.get(i)).getLabel());
				}else{
				lovList=valueList;
				}
			}
			LogManager.logInfo("Query :" +query);
			
			loggingManager.debug("ListOfValue Manager Info :"+query);
		} catch (Exception e) {
			loggingManager
					.error("ListOfValue Manager Exception : " + e);

		}

		return lovList;
	}

	
	public static String lovLabel(String name,String key) {
		List lovList = new ArrayList();
		String query="";
		String label="";
		try {
			query="from TbLov lov where lov.Name='" + name
							+ "' and lov.Value ='" + key+ "' ";
			List valueList = TbLovDAO.getInstance().find(query);

			if(valueList!=null && valueList.size()>0){
				label = ((TbLov) valueList.get(0)).getLabel();
			}else
				label = key;
			
			LogManager.logInfo("Query :" +query);
			
			loggingManager.debug("ListOfValue Manager Info :"+query);
		} catch (Exception e) {
			loggingManager
			.error("ListOfValue Manager Exception : " + e);

		}

		return label;
	}
}


