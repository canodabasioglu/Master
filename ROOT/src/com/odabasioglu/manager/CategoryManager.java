package com.odabasioglu.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.odabasioglu.data.TbCategory;
import com.odabasioglu.data.dao.TbCategoryDAO;

public class CategoryManager {

	private static Logger loggingManager =
		Logger.getLogger(CategoryManager.class.getName());
	private static TbCategoryDAO categoryDAO;
	LogManager log = new LogManager();

	public List listCategory() {
		List listCategory = null;
		try {
			listCategory =
				TbCategoryDAO.getInstance().find(
	 				"from TbCategory order by IsMain");

			if (listCategory == null) {
				listCategory = new ArrayList();
			}
			loggingManager.debug("Category Manager Info : List Category ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Category Manager Exception : List Category : " + e);

		}

		return listCategory;
	}

	public List listMainCategory() {
		List listCategory = null;
		
		try {
			listCategory =
				TbCategoryDAO.getInstance().find(
					"from TbCategory category where category.IsMain=1 order by category.Id");

			if (listCategory == null) {
				listCategory = new ArrayList();
			}
			loggingManager.debug("Category Manager Info : List Category ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Category Manager Exception : List Category : " + e);

		}

		return listCategory;
	}

	public List listSubCategory(Integer mainCategoryId) {
		List listSubCategory = null;
		String whereClause="";
		
		if (mainCategoryId!=null){
			whereClause = " and category.MainCategoryId ="+mainCategoryId+"";
		}
		try {
			listSubCategory =
				TbCategoryDAO.getInstance().find(
					"from TbCategory category where category.IsMain=0 "+whereClause+" order by category.CategoryName asc");

			if (listSubCategory.size() <1) {
				listSubCategory = new ArrayList();
			}
			loggingManager.debug("Category Manager Info : List Category ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Category Manager Exception : List Category : " + e);

		}

		return listSubCategory;
	}

	public String getCategoryName(Integer categoryId) {
		String categoryName = "Ana Kategori";
		try {
			List categoryList =
				TbCategoryDAO.getInstance().find(
					"from TbCategory category where category.Id=" + categoryId + " order by category.CategoryName");
			if (categoryList != null && categoryList.size()>0) {
				categoryName =
					((TbCategory) categoryList.get(0)).getCategoryName();
			}

			loggingManager.debug("Category Manager Info : Get Category Name ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Category Manager Exception : Get Category Name : " + e);
		}
		return categoryName;
	}
	
	public TbCategory getCategory(Integer categoryId) {
		TbCategory category=null;
		try {
			List categoryList =
				TbCategoryDAO.getInstance().find(
					"from TbCategory where MainCategoryId=" + categoryId + "");
			if (categoryList.size()>0) {
				category=((TbCategory) categoryList.get(0));
			}

			loggingManager.debug("Category Manager Info : Get Category ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Category Manager Exception : Get Category : " + e);
		}
		return category;
	}

	
	public TbCategory getCategoryById(Integer categoryId) {
		TbCategory category=null;
		try {
			List categoryList =
				TbCategoryDAO.getInstance().find(
					"from TbCategory category where category.Id=" + categoryId + "");
			if (categoryList.size()>0) {
				category=((TbCategory) categoryList.get(0));
			}

			loggingManager.debug("Category Manager Info : Get Category ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Category Manager Exception : Get Category : " + e);
		}
		return category;
	}

}