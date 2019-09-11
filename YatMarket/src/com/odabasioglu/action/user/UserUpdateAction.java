package com.odabasioglu.action.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.odabasioglu.action.form.UserForm;
import com.odabasioglu.config.SystemConstants;
import com.odabasioglu.data.TbRole;
import com.odabasioglu.data.TbUsers;
import com.odabasioglu.data.dao.TbUsersDAO;
import com.odabasioglu.manager.AuthorizationManager;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.utility.ConverterUtility;

/**
 * @version 1.0
 * @author
 */
public class UserUpdateAction extends Action {
	private static final String actionRight = "UserUpdateAction";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value
		HttpSession session = request.getSession();
		UserForm userForm = (UserForm) form;
		Date now = new Date(System.currentTimeMillis());
		Integer userId = userForm.getUserId();
		String username = userForm.getUsername();
		String userpassword = userForm.getUserpassword();
		int birthDayYear = userForm.getBirthDateYear().intValue();
		int birthDayMonth = userForm.getBirthDateMonth().intValue();
		int birthDayDay = userForm.getBirthDateDay().intValue();

		String birthPlace = userForm.getBirthPlace();
		String email = userForm.getEmail();
		String fax = userForm.getFax();
		String gsm = userForm.getGsm();
		String name = userForm.getName();
		String occuppation = userForm.getOccupation();
		String phone1 = userForm.getPhone1();
		String sentEvents = userForm.getSentEvents();
		String sex = userForm.getSex();
		String surname = userForm.getSurname();
		String loginIp = request.getRemoteAddr();
		try {
			if (AuthorizationManager
					.sessionHasActionRight(session, actionRight)) {
				TbUsers user = new TbUsers();
				TbUsersDAO usersDAO = TbUsersDAO.getInstance();
				user.setId(userId);
				user.setBirthDate(ConverterUtility.getDate(birthDayYear,
						birthDayMonth, birthDayDay));
				user.setBirthPlace(birthPlace);
				user.setEmail(email);
				user.setFax(fax);
				user.setGsm(gsm);
				user.setLoginDate(now);
				user.setLoginIp(loginIp);
				user.setMemberDate(now);
				user.setName(name);
				user.setOccupation(occuppation);
				user.setPhone1(phone1);
				user.setSentEvents(sentEvents);
				user.setSex(sex);
				user.setStatus(SystemConstants.IS_ACTIVE);
				user.setSurname(surname);
				user.setUsername(username);
				user.setUserpassword(userpassword);
				user.setUserType(SystemConstants.USERTYPE_NORMAL);
				user.setLogId(SystemConstants.IS_ACTIVE);
				// Role 1 herzaman web kullan�c� olmal�
				TbRole role = new TbRole();
				role.setId(SystemConstants.USERTYPE_NORMAL);
				user.setRole(role);

				usersDAO.update(user);
				request.setAttribute("message", "Success.user.update");
				forward = mapping.findForward("updateSuccess");
			} else {
				request.setAttribute("message", "Error.session.expired");
				forward = mapping.findForward("sessionError");
			}
		} catch (Exception e) {
			Logger.getLogger(UserUpdateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		// Finish with
		return (forward);

	}
}
