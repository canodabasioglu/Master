package com.odabasioglu.utility;

import java.util.List;
import java.util.Locale;

import com.odabasioglu.manager.LogManager;

import org.apache.log4j.Logger;

/**
 * 
 * www.odabasioglu.net
 */

public class DatabaseManager extends DatabaseUtility {

	private static Logger loggingManager =
		Logger.getLogger(DatabaseManager.class.getName());
	LogManager log = new LogManager();

	public List select(
		String objectName,
		String objectType,
		String whereClause,
		String whereValue)
		throws Exception {
		List result = null;

		//if no whereclause or where value defined
		if (whereClause.equals("")
			|| whereClause == null
			|| whereValue.equals("")
			|| whereValue == null) {
			hqlQuery = "from " + objectName;

		}
		//if whereclause and where value defined
		else {
			//Select objectType String
			if (objectType.toUpperCase(Locale.ENGLISH).equals("STRING")) {

				hqlQuery =
					"from "
						+ objectName
						+ " where "
						+ whereClause
						+ " =  '"
						+ whereValue
						+ "' ";

				//Select objectType Integer
			} else if (
				objectType.toUpperCase(Locale.ENGLISH).equals("INTEGER")) {

				hqlQuery =
					"from "
						+ objectName
						+ " where "
						+ whereClause
						+ " =  "
						+ whereValue
						+ " ";

				//if no objectType defined
			} else if (objectType.toUpperCase(Locale.ENGLISH).equals("")) {

			}

		}

		result = session.createQuery(hqlQuery).list();
		tx.commit();

		loggingManager.warn(
			"Total " + result.size() + " Entities Successfully selected ");

		return result;
	}

	public int delete(
		String objectName,
		String objectType,
		String whereClause,
		String whereValue)
		throws Exception {

		if (objectType.toUpperCase(Locale.ENGLISH).equals("STRING")) {

			hqlQuery =
				"delete "
					+ objectName
					+ " where "
					+ whereClause
					+ " = '"
					+ whereValue
					+ "'";
		} else if (objectType.toUpperCase(Locale.ENGLISH).equals("INTEGER")) {

			hqlQuery =
				"delete "
					+ objectName
					+ " where "
					+ whereClause
					+ " = "
					+ whereValue
					+ " ";
		} else if (
			objectType.toUpperCase(Locale.ENGLISH).equals("")
				|| objectType == null) {

		} else {

		}

		returnedEntities = session.createQuery(hqlQuery).executeUpdate();
		tx.commit();

		loggingManager.warn("Hibernate Delete Success ");
		loggingManager.warn(
			"Total " + returnedEntities + " Entities Successfully deleted ");

		return returnedEntities;

	}

	public int update(
		String objectName,
		String setField,
		String setValue,
		String whereField,
		String whereValue)
		throws Exception {

		if (whereField.equals("") || whereField == null) {

			hqlQuery =
				"update " + objectName + " set " + setField + " = :setValue ";

			returnedEntities =
				session
					.createQuery(hqlQuery)
					.setString("setValue", setValue)
					.executeUpdate();

		} else {

			hqlQuery =
				"update "
					+ objectName
					+ " set "
					+ setField
					+ " = :setValue where "
					+ whereField
					+ " = :whereValue";
			returnedEntities =
				session
					.createQuery(hqlQuery)
					.setString("setValue", setValue)
					.setString("whereValue", whereValue)
					.executeUpdate();
		}

		tx.commit();

	

		loggingManager.warn("Hibernate Update Success ");
		loggingManager.warn(
			"Total " + returnedEntities + " Entities Successfully updated ");

		return returnedEntities;

	}

}
