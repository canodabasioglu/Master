package com.odabasioglu.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.odabasioglu.data.TbOrder;
import com.odabasioglu.data.TbOrderline;
import com.odabasioglu.data.TbPoint;
import com.odabasioglu.data.dao.TbOrderDAO;
import com.odabasioglu.data.dao.TbOrderlineDAO;
import com.odabasioglu.data.dao.TbPointDAO;

public class OrderManager {

	private static Logger loggingManager =
		Logger.getLogger(OrderManager.class.getName());
	LogManager log = new LogManager();

	public static List listOrder(Integer userId) {
		List listOrder = null;
		String whereClause = "";

		if (userId != null) {
			whereClause = " and order.Users.Id =" + userId + "";
		}
		try {
			listOrder =
				TbOrderDAO.getInstance().find(
					"from TbOrder order where order.Status=1 "
						+ whereClause
						+ " order by order.Id desc");

			if (listOrder == null) {
				listOrder = new ArrayList();
			}
			loggingManager.debug("Order Manager Info : List Order ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("Order Manager Exception : List Order : " + e);

		}

		return listOrder;
	}

	public static List listOrderline(Integer userId, Integer orderId) {
		List listOrderline = null;
		String whereClause = "";

		if (userId != null) {
			whereClause = " and orderline.Users.Id =" + userId + "";
		}
		if (orderId != null) {
			whereClause = " and orderline.OrderId =" + orderId + "";
		} else {
			whereClause = " and orderline.OrderId = 0 ";
		}

		try {
			listOrderline =
				TbOrderlineDAO.getInstance().find(
					"from TbOrderline orderline where Status=1"
						+ whereClause
						+ " order by orderline.Id desc");

			if (listOrderline == null) {
				listOrderline = new ArrayList();
			}
			loggingManager.debug("Order Manager Info : List Orderline ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Order Manager Exception : List Orderline : " + e);

		}

		return listOrderline;
	}

	public int getOrderlineProductAmount(Integer userId, Integer productId) {
		int orderlineProductAmount = 0;

		try {
			List listOrderlineProductAmount =
				TbOrderlineDAO.getInstance().find(
					"from TbOrderline orderline where orderline.OrderId=0 and orderline.Product.Id="
						+ productId
						+ " and orderline.Users.Id ="
						+ userId
						+ " order by orderline.Id desc");
			if (listOrderlineProductAmount.size() > 0) {
				orderlineProductAmount = listOrderlineProductAmount.size();
			}
			loggingManager.debug(
				"Order Manager Info : Get Orderline Product Amount ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Order Manager Exception : Get Orderline Product Amount : "
					+ e);

		}

		return orderlineProductAmount;
	}

	/**
	 * @param integer
	 * @param productId
	 * @return
	 */
	public TbOrderline getOrderLine(Integer userId, Integer productId) {

		TbOrderline orderline = null;

		try {
			List listOrderline =
				TbOrderlineDAO.getInstance().find(
					"from TbOrderline orderline where orderline.Product.Id="
						+ productId
						+ "and orderline.Users.Id ="
						+ userId
						+ " order by orderline.Id desc");

			if (listOrderline.size() > 0) {
				orderline = ((TbOrderline) listOrderline.get(0));
			}
			loggingManager.debug("Order Manager Info : List Orderline ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Order Manager Exception : List Orderline : " + e);

		}

		return orderline;

	}

	public void updateOrderlineByOrderId(Integer orderId, Integer userId) {

		try {

			List listOrderline = listOrderline(userId, null);
			TbOrderline orderline = null;
			TbOrderlineDAO orderlineDAO = TbOrderlineDAO.getInstance();
			for (int i = 0; i < listOrderline.size(); i++) {
				orderline = (TbOrderline) listOrderline.get(i);
				orderline.setOrderId(orderId);
				orderline.setStatus(new Integer(1));
				orderlineDAO.update(orderline);

			}

			loggingManager.debug("Order Manager Info : List Orderline ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Order Manager Exception : List Orderline : " + e);

		}

	}

	/**
	 * @param orderId
	 * @return
	 */
	public TbOrder getOrder(Integer orderId) {
		TbOrder order = null;

		try {
			List listOrder =
				TbOrderlineDAO.getInstance().find(
					"from TbOrder order where order.Id=" + orderId + "");

			if (listOrder.size() > 0) {
				order = ((TbOrder) listOrder.get(0));
			}
			loggingManager.debug("Order Manager Info : List Order ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("Order Manager Exception : List Order : " + e);

		}
		return order;
	}

	public static int getOrderPoints(Integer userId, Integer pointStatus) {
		int orderPoint = 0;
		
		//Point status 1 available, 0 spent not available
		try {
			List listOrderPoint =
				TbPointDAO.getInstance().find(
					"from TbPoint point where point.Users.Id="
						+ userId
						+ " and point.PointStatus="
						+ pointStatus
						+ "");
			TbPoint point = null;
			if (listOrderPoint.size() > 0) {

				for (int i = 0; i < listOrderPoint.size(); i++) {
					orderPoint
						+= ((TbPoint) listOrderPoint.get(i)).getPoint().intValue();
				}

			}
			loggingManager.debug("Order Manager Info : Get Order Points ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Order Manager Exception : Get Order Points : " + e);

		}
		return orderPoint;
	}

}
