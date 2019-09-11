package com.odabasioglu.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.odabasioglu.data.TbCurrency;
import com.odabasioglu.data.TbProduct;
import com.odabasioglu.data.dao.TbProductDAO;
import com.odabasioglu.utility.MailUtility;

public class ProductManager {

	private static Logger loggingManager = Logger
			.getLogger(ProductManager.class.getName());

	private static TbProductDAO productDAO;

	LogManager log = new LogManager();

	public TbProduct getProduct(Integer productId) {
		TbProduct product = null;

		try {
			List productList = TbProductDAO.getInstance().find(
					"from TbProduct where Id=" + productId + "");
			if (productList != null) {
				product = (TbProduct) productList.get(0);
			}

			loggingManager.debug("Product Manager Info : Get Product ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("Product Manager Exception : Get Product : "
					+ e);
		}

		return product;
	}

	public List listProduct() {
		List listProduct = null;
		try {
			listProduct = TbProductDAO.getInstance().find(
					"from TbProduct order by Id desc");

			if (listProduct == null) {
				listProduct = new ArrayList();
			}
			loggingManager.debug("Product Manager Info : List Product ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("Product Manager Exception : List Product : "
					+ e);

		}

		return listProduct;
	}

	public List searchProduct(String keyword) {

		List listProduct = null;
		try {
			listProduct = TbProductDAO.getInstance().find(
					"from TbProduct where Name Like '%" + keyword
							+ "%' or Description Like '%" + keyword + "%'");

			if (listProduct == null) {
				listProduct = new ArrayList();
			}
			loggingManager.debug("Product Manager Info : Search Product ");
		} catch (Exception e) {
			loggingManager
					.error("Product Manager Exception : Search Product : " + e);

		}

		return listProduct;

	}

	public static List listTopSales() {

		List listTopSales = null;
		try {
			listTopSales = TbProductDAO.getInstance().find(
					"from TbTopsales order by Percentage desc");

			if (listTopSales == null) {
				listTopSales = new ArrayList();
			}
			loggingManager.debug("Product Manager Info : Top Sales List ");
		} catch (Exception e) {
			loggingManager
					.error("Product Manager Exception : Top Sales List : " + e);

		}

		return listTopSales;

	}

	public static List listLastvisit(Integer userId, Integer productId) {

		List listLastvisit = null;
		String whereClause = "";

		if (userId != null) {
			whereClause = " and lastvisit.Users.Id =" + userId + "";
		}
		if (productId != null) {
			whereClause = " and lastvisit.Product.Id =" + productId + "";
		}

		try {
			listLastvisit = TbProductDAO.getInstance().find(
					"from TbLastvisit lastvisit where lastvisit.Status=1 "
							+ whereClause + " order by lastvisit.Id desc");

			if (listLastvisit.size() < 1) {
				listLastvisit = new ArrayList();
			}
			loggingManager.debug("Product Manager Info : Last Visit List ");
		} catch (Exception e) {
			loggingManager
					.error("Product Manager Exception : Last Visit List : " + e);

		}

		return listLastvisit;

	}

	public List listCategoryProduct(Integer subcategoryId) {

		List listCategoryProduct = null;
		try {
			listCategoryProduct = TbProductDAO.getInstance().find(
					"from TbProduct product where product.Category.Id= "
							+ subcategoryId + "");

			if (listCategoryProduct.size() < 0) {
				listCategoryProduct = new ArrayList();
			}
			loggingManager
					.debug("Product Manager Info : List Category Product ");
		} catch (Exception e) {
			loggingManager
					.error("Product Manager Exception :  List Category Product : "
							+ e);

		}

		return listCategoryProduct;

	}

	public int getProductCountByCategoryId(Integer categoryId) {
		int count = 0;

		List listCategoryProduct = null;
		try {
			listCategoryProduct = TbProductDAO.getInstance().find(
					"from TbProduct product where product.Category.Id= "
							+ categoryId + "");

			if (listCategoryProduct.size() > 0) {
				count = listCategoryProduct.size();
			}
			loggingManager
					.debug("Product Manager Info : Count Category Product ");
		} catch (Exception e) {
			loggingManager
					.error("Product Manager Exception :  Count Category Product : "
							+ e);

		}

		return count;

	}
	
	public static boolean checkDBConnection() {
		boolean isDBAlive=false;
		long oneDay = 1000*60*60*24;
		try {
			List currencyList = TbProductDAO.getInstance().find(
					"from TbCurrency order by Id desc");
			TbCurrency currency;
			if (currencyList != null) {
				currency = (TbCurrency) currencyList.get(0);
				Date dbDate = currency.getCurrencyDate();
				Date today = new Date();
				LogManager.logInfo("Son döviz kuru tarihi :"+dbDate.getTime());
				long now = today.getTime();
				int numberOfDays = Integer.parseInt(ParametersManager.parameterValueByName("MaxNumberOfDays"));
				long lastCurrencyTime= dbDate.getTime()+(numberOfDays*oneDay);
				if(lastCurrencyTime<now){
					LogManager.logOperations("Kur eski kalmis");
					MailUtility mail = new MailUtility();
					mail.sendCurrencyWarning(dbDate);
				}else{
					LogManager.logOperations("Kur guncel");
				}
				
			}

			
			isDBAlive=true;
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("Product Manager Exception : Get Product : "
					+ e);
			MailUtility mailUtility = new MailUtility();
			try {
				mailUtility.sendFatalError(""+e.getMessage());
			} catch (Exception e1) {
					e1.printStackTrace();
			}
		}

		return isDBAlive;
	}

}
