package com.odabasioglu.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.odabasioglu.data.dao.TbFavouriteDAO;

public class FavouriteManager {

	private static Logger loggingManager =
		Logger.getLogger(FavouriteManager.class.getName());
	
	LogManager log = new LogManager();

	public static List listFavourite(Integer userId) {
		List listFavourite = null;
		String whereClause = "";

		if (userId != null) {
			whereClause = " and favourite.Users.Id =" + userId + "";
		}
		try {
			listFavourite =
				TbFavouriteDAO.getInstance().find(
					"from TbFavourite favourite where favourite.Status=1 "
						+ whereClause
						+ " order by favourite.Id");

			if (listFavourite == null) {
				listFavourite = new ArrayList();
			}
			loggingManager.debug("Favourite Manager Info : List Favourite ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Favourite Manager Exception : List Favourite : " + e);

		}

		return listFavourite;
	}

	public static boolean checkFavourite(Integer productId, Integer userId) {
		boolean isAddedBefore = false;

		try {
			List listFavourite =
				TbFavouriteDAO.getInstance().find(
					"from TbFavourite favourite where favourite.Users.Id="+userId+" and favourite.Product.Id="+productId+"");
			if (listFavourite.size() > 0) {
				isAddedBefore = true;
			}

			loggingManager.debug("Favourite Manager Info : Check Favourite ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Favourite Manager Exception : Check Favourite : " + e);

		}

		return isAddedBefore;
	}

}
