package com.odabasioglu.action.product;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.utility.ImageUtility;

/**
 * @version 1.0
 * @author
 */
public class ProductCreateAction extends Action {
	private static final String actionRight = "ProductCreateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		ProductForm productForm = (ProductForm) form;

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {

				TbProduct product = new TbProduct();
				product.setName(productForm.getName());
				product.setDescription(productForm.getDescription());
				product.setModifiedDate(new Date(System.currentTimeMillis()));

				product.setPrice(productForm.getPrice());
				product.setCurrencyType(productForm.getCurrencyType());
				TbCategory category = new TbCategory();

				TbCategoryDAO categoryDAO = TbCategoryDAO.getInstance();
				List catList = categoryDAO.find("from TbCategory where Id ="
						+ productForm.getCategoryId() + " ");
				category = (TbCategory) catList.get(0);

				TbProductDAO productDAO = TbProductDAO.getInstance();
				List productList = productDAO
						.find("from TbProduct order by Id desc");
				Integer lastId = ((TbProduct) productList.get(0)).getId();
				int lastValue = lastId.intValue();

				lastValue = lastValue + 1;

				String mainCategoryId = String.valueOf(category
						.getMainCategoryId()); // 1-999 deger gelecek
				String categoryId = String.valueOf(productForm.getCategoryId()); // >

				if (mainCategoryId.length() == 1) {
					mainCategoryId = "00" + mainCategoryId;
				} else if (mainCategoryId.length() == 2) {
					mainCategoryId = "0" + mainCategoryId;
				}

				if (categoryId.length() == 1) {
					categoryId = "00" + categoryId;
				} else if (categoryId.length() == 2) {
					categoryId = "0" + categoryId;
				}

				String lastStringValue = String.valueOf(lastValue);

				if (lastStringValue.length() == 1) {
					lastStringValue = "00000" + lastStringValue;
				} else if (lastStringValue.length() == 2) {
					lastStringValue = "0000" + lastStringValue;
				} else if (lastStringValue.length() == 3) {
					lastStringValue = "000" + lastStringValue;
				} else if (lastStringValue.length() == 4) {
					lastStringValue = "00" + lastStringValue;
				} else if (lastStringValue.length() == 5) {
					lastStringValue = "0" + lastStringValue;
				}

				String productCodeDefined = mainCategoryId + categoryId
						+ lastStringValue;

				product.setCategory(category);
				product.setProductCode(productCodeDefined);
				product.setProductStatus(productForm.getProductStatus());
				product.setStockStatus(productForm.getStockStatus());
				product.setStatus(SystemConstants.IS_ACTIVE);
				product.setLogId(SystemConstants.IS_ACTIVE);

				FormFile myFile = productForm.getTheFile();

				if (ImageUtility.checkFile(myFile)) {
					product.setThumbnail(myFile.getFileData());
					product.setThumbnailSmall(ImageUtility
							.createThumbnailSmall(myFile));

					request.setAttribute("message", "Success.product.create");
				} else {
					request.setAttribute("message", "Error.product.picture");
				}

				TbProductDAO.getInstance().save(product);

				forward = mapping.findForward("listProduct");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {
			request.setAttribute("productStatus", "Error.product.create");
			Logger.getLogger(ProductCreateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
