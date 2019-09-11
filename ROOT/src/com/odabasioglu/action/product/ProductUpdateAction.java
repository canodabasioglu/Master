package com.odabasioglu.action.product;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.odabasioglu.action.form.ProductForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbCategory;
import com.odabasioglu.data.TbProduct;
import com.odabasioglu.data.dao.TbCategoryDAO;
import com.odabasioglu.data.dao.TbProductDAO;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.utility.ImageUtility;

/**
 * @version 1.0
 * @author
 */
public class ProductUpdateAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value

		ProductForm productForm = (ProductForm) form;

		try {
			if (1 == 1) {

				Integer productId = Integer.valueOf(request
						.getParameter("productId"));
				TbProductDAO productDAO = TbProductDAO.getInstance();
				TbProduct product = productDAO.load(productId);
				String productCode = "";

				product.setName(productForm.getName());
				product.setDescription(productForm.getDescription());
				product.setModifiedDate(new Date(System.currentTimeMillis()));
				// update product Code

				// 001015003494

				// get new subcategory
				Integer catId = productForm.getCategoryId();
				String newSubCategoryId = "000";
				if (catId.intValue() < 10) {
					newSubCategoryId = "00" + String.valueOf(catId);
				} else if (catId.intValue() > 10 && catId.intValue() < 100) {
					newSubCategoryId = "0" + String.valueOf(catId);
				} else {
					newSubCategoryId = String.valueOf(catId);
				}

				// append old product code
				String oldProductId = productForm.getProductCode().substring(6,
						12);

				// get main category id
				TbCategoryDAO categoryDAO = TbCategoryDAO.getInstance();
				List catList = categoryDAO.find("from TbCategory where Id ="
						+ catId + " ");
				TbCategory category = (TbCategory) catList.get(0);
				Integer mainCategoryId = category.getMainCategoryId();

				String newMainCategoryId = "000";
				if (mainCategoryId.intValue() < 10) {
					newMainCategoryId = "00" + String.valueOf(mainCategoryId);
				} else if (mainCategoryId.intValue() > 10
						&& catId.intValue() < 100) {
					newMainCategoryId = "0" + String.valueOf(mainCategoryId);
				} else {
					newMainCategoryId = String.valueOf(mainCategoryId);
				}

				productCode = newMainCategoryId + newSubCategoryId
						+ oldProductId;

				category = new TbCategory();
				category.setId(productForm.getCategoryId());
				product.setCategory(category);

				product.setProductCode(productCode);
				product.setPrice(productForm.getPrice());
				product.setCurrencyType(productForm.getCurrencyType());

				product.setProductStatus(productForm.getProductStatus());
				product.setStockStatus(productForm.getStockStatus());
				product.setStatus(SystemConstants.IS_ACTIVE);
				product.setLogId(SystemConstants.IS_ACTIVE);

				FormFile myFile = productForm.getTheFile();

				if (ImageUtility.checkFile(myFile)) {
					product.setThumbnail(myFile.getFileData());
					product.setThumbnailSmall(ImageUtility
							.createThumbnailSmall(myFile));

					request.setAttribute("message", "Success.product.update");
				} else {
					request.setAttribute("message", "Error.product.picture");
				}
				productDAO.update(product);

				forward = mapping.findForward("listProduct");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {			
			Logger.getLogger(ProductUpdateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
