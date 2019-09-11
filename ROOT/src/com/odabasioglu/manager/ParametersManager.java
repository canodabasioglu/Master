package com.odabasioglu.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbCurrency;
import com.odabasioglu.data.TbParameters;
import com.odabasioglu.data.dao.TbCurrencyDAO;
import com.odabasioglu.data.dao.TbParametersDAO;

public class ParametersManager {

	private static Logger loggingManager = Logger
			.getLogger(ParametersManager.class.getName());

	public static List parameterByName(String name) {
		return parameterList(name,null);
	}
	
	public static List parameters() {
		return parameterList("Can",null);
	}
	
	public static String parameterValueByName(String name) {
		List parameterList= parameterList(name,null);
		String value="";
		if(parameterList!=null && parameterList.size()>0){
			TbParameters param = (TbParameters) parameterList.get(0);
			value =param.getValue();
		}
		return value;
	}
	
	private static List parameterList(String name,String condition) {
		List parameterList = new ArrayList();
		String query = "";
		if(condition!=null){
			condition = "and parm.Condition='"+condition+"'";
		}else
			condition="";
		try {
			query = "from TbParameters parm where parm.Name='" + name
					+ "' "+condition+"  ";
			List valueList = TbParametersDAO.getInstance().find(query);

			for (int i = 0; i < valueList.size(); i++) {
				// value ile label farklý ise

				parameterList = valueList;

			}
			LogManager.logOperations("Query :" + query);

		} catch (Exception e) {
			loggingManager.error("Parameters Manager Exception : : " + e);

		}

		return parameterList;
	}
	
	public List parametersList() {
		List listParameters = null;
		try {
			listParameters =
				TbParametersDAO.getInstance().find(
					"from TbParameters order by Id desc");

			if (listParameters == null) {
				listParameters = new ArrayList();
			}
			loggingManager.debug("Parameters Manager Info : List Parameters ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Parameters Manager Exception : List Parameters : " + e);

		}

		return listParameters;
	}
	
	public static TbParameters getParameter(Integer parameterId) {
		TbParameters parameter = null;

		try {
			List listParameter =
				TbParametersDAO.getInstance().find(
					"from TbParameters parameter where parameter.Id = "+parameterId+"");

			if (listParameter.size() > 0) {
				parameter = ((TbParameters) listParameter.get(0));
			}

			loggingManager.debug("Parameter Manager Info : Get Parameter ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Currency Manager Exception : Get Parameter : " + e);

		}

		return parameter;
	}

}
