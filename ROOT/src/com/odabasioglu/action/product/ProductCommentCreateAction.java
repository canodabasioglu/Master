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

import com.odabasioglu.action.form.CommentForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbComment;
import com.odabasioglu.data.TbProduct;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.data.dao.TbCommentDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class ProductCommentCreateAction extends Action {
	private static final String actionRight = "ProductCommentCreateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		CommentForm commentForm = (CommentForm) form;

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbUsers user = (TbUsers) session.getAttribute("user");
				TbComment comment = new TbComment();
				TbProduct product = new TbProduct();
				product.setId(commentForm.getProductId());
				comment.setComment(commentForm.getComment());
				comment.setModifiedDate(new Date());
				comment.setPoint(commentForm.getPoint());
				comment.setProduct(product);
				comment.setUsers(user);
				comment.setStatus(SystemConstants.IS_ACTIVE);
				comment.setLogId(SystemConstants.IS_ACTIVE);
				TbCommentDAO.getInstance().save(comment);
				request.setAttribute("message", "Success.comment.create");

				forward = mapping.findForward("commentCreate");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {
			request.setAttribute("message", "Error.comment.create");
			Logger.getLogger(ProductCommentCreateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("commentCreate");

		}

		// Finish with
		return (forward);

	}
}
