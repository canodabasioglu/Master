package com.odabasioglu.utility;

import java.sql.Timestamp;
import java.util.ArrayList;

public class GenericObjectMapper {

	public String objectName; // Users table
	public String objectStatus; //disable active etc.
	public ArrayList objectType; // such as Integer,date,float etc
	public ArrayList objectFields; // table field name
	public ArrayList objectValues; // field value
	public Timestamp objectTime; //create date
	public int objectOwner; //user id
	
	
	public GenericObjectMapper() {
		super();

	}
	
	
	public ArrayList getObjectFields() {
		return objectFields;
	}
	public void setObjectFields(ArrayList objectFields) {
		this.objectFields = objectFields;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public int getObjectOwner() {
		return objectOwner;
	}
	public void setObjectOwner(int objectOwner) {
		this.objectOwner = objectOwner;
	}
	public String getObjectStatus() {
		return objectStatus;
	}
	public void setObjectStatus(String objectStatus) {
		this.objectStatus = objectStatus;
	}
	public Timestamp getObjectTime() {
		return objectTime;
	}
	public void setObjectTime(Timestamp objectTime) {
		this.objectTime = objectTime;
	}
	public ArrayList getObjectType() {
		return objectType;
	}
	public void setObjectType(ArrayList objectType) {
		this.objectType = objectType;
	}
	public ArrayList getObjectValues() {
		return objectValues;
	}
	public void setObjectValues(ArrayList objectValues) {
		this.objectValues = objectValues;
	}


}
