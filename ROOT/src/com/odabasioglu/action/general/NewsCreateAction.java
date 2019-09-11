package com.odabasioglu.action.general;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.action.form.NewsForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbNews;
import com.odabasioglu.data.dao.TbNewsDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;

/**
 * @version 1.0
 * @author
 */
public class NewsCreateAction extends Action {
	private static final String actionRight = "NewsCreateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		NewsForm newsForm = (NewsForm) form;

		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbNews news = new TbNews();
				news.setTitle(newsForm.getTitle());
				news.setNewsdescription(newsForm.getNewsdescription());
				news.setStatus(newsForm.getStatus());
				news.setLogId(SystemConstants.IS_ACTIVE);
				TbNewsDAO.getInstance().save(news);

				request.setAttribute("message", "Success.news.create");
				forward = mapping.findForward("listNews");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {
			request.setAttribute("message", "Error.news.create");
			Logger.getLogger(NewsCreateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
