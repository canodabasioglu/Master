package com.odabasioglu.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbLogs;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.data.dao.TbCurrencyDAO;
import com.odabasioglu.data.dao.TbLogsDAO;
import com.odabasioglu.utility.ResourceUtility;

public class LogManager extends TbLogs {

	static Logger loggingManager = Logger.getLogger(LogManager.class.getName());
	private static final String LOG_FILE_SYNTAX ="| <> D E B U G < > |";

	public static void logOperations(String operationDesc) {
		// logOperations(null,operationDesc, null, null, null);
		System.out.println(LOG_FILE_SYNTAX + " : OPERATION : "+operationDesc);
	}

	public static List listLog() {
		List listLog = null;
		try {
			listLog = TbCurrencyDAO.getInstance().find(
					"from TbLogs order by Id desc");

			if (listLog == null) {
				listLog = new ArrayList();
			}
			loggingManager.debug("Log Manager Info : List Log ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("Log Manager Exception : List Log : " + e);

		}

		return listLog;
	}

	public static void logInfo(String logDescription) {
		logOperations(SystemConstants.LOGS.OBJECT_NAME_INFO,
				SystemConstants.LOGS.OPERATION_TYPE_INFO, null,
				SystemConstants.LOGS.TYPE_INFO,
				SystemConstants.LOGS.STATUS_ACTIVE, null, logDescription);
		System.out.println(LOG_FILE_SYNTAX + " : INFO : "+logDescription);
	}
	
	public static void logError(String errorDesc) {
	
		logOperations(SystemConstants.LOGS.OBJECT_NAME_ERROR,
				SystemConstants.LOGS.OPERATION_TYPE_ERROR, null,
				SystemConstants.LOGS.TYPE_ERROR,
				SystemConstants.LOGS.STATUS_ACTIVE, null, errorDesc);
		System.out.println(LOG_FILE_SYNTAX + " : ERROR : "+errorDesc);
		
	}


	public static void logNavigation(String pageName, Integer userId,
			String logIp) {
		logOperations(SystemConstants.LOGS.OBJECT_NAME_NAVIGATION,
				SystemConstants.LOGS.OPERATION_TYPE_NAVIGATION, userId,
				SystemConstants.LOGS.TYPE_DEBUG,
				SystemConstants.LOGS.STATUS_ACTIVE, logIp, pageName);
	}

	public static void logActivity(String actionRightRole, Integer userId,
			String logIp) {
		logOperations(SystemConstants.LOGS.OBJECT_NAME_ACTIVITY,
				SystemConstants.LOGS.OPERATION_TYPE_ACTIVITY, userId,
				SystemConstants.LOGS.TYPE_INFO,
				SystemConstants.LOGS.STATUS_ACTIVE, logIp, actionRightRole);
	}

	public static void logOperations(String objectName, String operationType,
			Integer userId, Integer logType, Integer logStatus, String logIp,
			String operationDesc) {
		try {
			String flag = ParametersManager.parameterValueByName("Logging");
			if(!flag.equals("database")){
				if(flag.equals("file")){
					System.out.println(LOG_FILE_SYNTAX + " : FILE DB DISABLED : "+operationDesc);
				}
				return;
			}
			
			ResourceUtility resource = new ResourceUtility("application");
			String logDatabase = resource.getValue("logDatabase").trim();

			TbLogs logs = new TbLogs();
			logs.setObjectName(objectName); // page name, right name etc
			logs.setOperationType(operationType); // activity , navigation,
													// error ,debug
			if (userId != null) {
				logs.setUserId(userId); // user id
			} else
				logs.setUserId(new Integer(0));

			logs.setModifiedDate(new Date()); // date
			logs.setLogType(logType); // fatal error debug info
			logs.setStatus(logStatus); // active || passive
			if (logIp != null) {
				logs.setLogIp(logIp); // user ip
			} else
				logs.setLogIp("0.0.0.0");

			if(operationDesc!=null){
			if(operationDesc.length()<240){
				logs.setObjectDesc(operationDesc); // error desc
			}else{
				logs.setObjectDesc(operationDesc.substring(240)); 	
			}
			}else{
				logs.setObjectDesc(" ");
			}
			
			TbLogsDAO.getInstance().save(logs);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
