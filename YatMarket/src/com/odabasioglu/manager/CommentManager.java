package com.odabasioglu.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.odabasioglu.data.dao.TbCommentDAO;
import com.odabasioglu.data.dao.TbNewsDAO;

public class CommentManager {

	private static Logger loggingManager =
		Logger.getLogger(CommentManager.class.getName());
	LogManager log = new LogManager();

	public List listProductComment(Integer productId) {
		List productCommentList = null;
		try {
			productCommentList =
				TbNewsDAO.getInstance().find("from TbComment comment where comment.Product.Id="+productId+" order by comment.Id desc");

			if (productCommentList == null) {
				productCommentList = new ArrayList();
			}
			loggingManager.debug(
				"Comment Manager Info : List Product Comment ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Comment Manager Exception : List Product Comment -: " + e);
		}

		return productCommentList;
	}

}
