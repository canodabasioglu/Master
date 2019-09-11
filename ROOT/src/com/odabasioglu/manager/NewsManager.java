package com.odabasioglu.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.odabasioglu.data.TbNews;
import com.odabasioglu.data.dao.TbCurrencyDAO;
import com.odabasioglu.data.dao.TbNewsDAO;

public class NewsManager {

	static Logger loggingManager =
		Logger.getLogger(NewsManager.class.getName());
	LogManager log = new LogManager();

	public static List listNews() {
		List listNews = null;
		try {
			listNews =
				TbNewsDAO.getInstance().find(
					"from TbNews order by Id desc");

			if (listNews == null) {
				listNews = new ArrayList();
			}
			loggingManager.debug("News Manager Info : List News ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"News Manager Exception : List News : " + e);

		}

		return listNews;
	}

	public static TbNews getNews(Integer newsId) {
		TbNews news = null;
		try {
			List listNews =
				TbNewsDAO.getInstance().find(
					"from TbNews where Id="+newsId+"");

			if (listNews.size()>0) {
				news = (TbNews)listNews.get(0);
			}
			loggingManager.debug("News Manager Info : Get News ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"News Manager Exception : Get News : " + e);

		}

		return news;
	}

}
