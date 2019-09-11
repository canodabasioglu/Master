package com.odabasioglu.utility;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatabaseUtility {

	private static Logger loggingManager = Logger
			.getLogger(DatabaseUtility.class.getName());

	protected static String hqlQuery = "";

	protected static String sqlQuery = "";

	protected int returnedEntities = 0;

	// Read Database Properties
	static ResourceUtility resource = new ResourceUtility("application");

	private String databaseVendor = resource.getValue("databaseVendor");

	private String serverConnection = resource.getValue(databaseVendor
			+ "ServerConnection");

	private String driverName = resource.getValue(databaseVendor + "Driver");

	private String serverURL = resource.getValue(databaseVendor + "ServerURL");

	private String username = resource.getValue(databaseVendor + "Username");

	private String password = resource.getValue(databaseVendor + "Password");

	private String schema = resource.getValue(databaseVendor + "Schema");

	private String databasePath = resource.getValue("databasePath")
			+ (resource.getValue(databaseVendor + "Driver"));

	public Session session = HibernateUtility.currentSession();

	public Transaction tx = session.beginTransaction();

	public DatabaseUtility() {
		super();
		loggingManager.debug("Database Util Initialized");
		loggingManager.debug("Server Connection : " + serverConnection);
		loggingManager.debug("Driver Name : " + driverName);
		loggingManager.debug("Server URL : " + serverURL);
		loggingManager.debug("Username : " + username);
		loggingManager.debug("Password : " + password);
		loggingManager.debug("Schema : " + schema);
		loggingManager.debug("DatabasePath : " + databasePath);
		loggingManager.debug("Database New Connection");

	}

}