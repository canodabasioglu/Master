package com.odabasioglu.action.product;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.odabasioglu.action.form.CategoryForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbCategory;
import com.odabasioglu.data.dao.TbCategoryDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.utility.ImageUtility;

/**
 * @version 1.0
 * @author
 */
public class ProductCategoryUpdateAction extends Action {
	private static final String actionRight = "ProductCategoryUpdateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		CategoryForm categoryForm = (CategoryForm) form;

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				String mainCategoryId = request.getParameter("mainCategoryId")
						.trim();

				Integer isMain;
				Integer mainCategory;

				// new category
				if (Integer.valueOf(mainCategoryId).equals(
						SystemConstants.SUB_CATEGORY)) {
					isMain = SystemConstants.MAIN_CATEGORY;
					mainCategory = SystemConstants.SUB_CATEGORY;
				}
				// category exist sub category
				else {
					isMain = SystemConstants.SUB_CATEGORY;
					mainCategory = Integer.valueOf(mainCategoryId);

				}

				TbCategory category = new TbCategory();
				category.setId(categoryForm.getCategoryId());
				category.setCategoryName(categoryForm.getCategoryName());
				category.setCategoryDescription(categoryForm
						.getCategoryDescription());
				category.setMainCategoryId(mainCategory);
				category.setModifiedDate(new Date(System.currentTimeMillis()));
				category.setStatus(categoryForm.getStatus());
				category.setIsMain(isMain);
				category.setMainCategoryId(mainCategory);
				category.setLogId(SystemConstants.IS_ACTIVE);
				category.setCategoryType(SystemConstants.IS_ACTIVE);

				TbCategoryDAO categoryDAO = TbCategoryDAO.getInstance();

				FormFile myFile = categoryForm.getTheFile();

				if (ImageUtility.checkFile(myFile)) {
					category.setThumbnail(myFile.getFileData());
					request.setAttribute("message", "Success.category.update");
				} else {
					request.setAttribute("message", "Error.product.picture");
				}
				categoryDAO.update(category);

				forward = mapping.findForward("listMaincategory");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}

		} catch (Exception e) {
			request.setAttribute("message", "Error.category.create");
			Logger.getLogger(ProductCategoryUpdateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
