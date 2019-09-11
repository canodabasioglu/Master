package com.odabasioglu.action.user;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.manager.UsersManager;
import com.odabasioglu.utility.ConverterUtility;
import com.odabasioglu.utility.MailUtility;

/**
 * @version 1.0
 * @author
 */
public class UserCreateAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward(); // return value

		UserForm userForm = (UserForm) form;
		Date now = new Date(System.currentTimeMillis());
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

		try {

			TbUsers user = new TbUsers();
			user.setBirthDate(ConverterUtility.getDate(birthDayYear,
					birthDayMonth, birthDayDay));
			user.setBirthPlace(birthPlace);
			user.setEmail(email);
			user.setFax(fax);
			user.setGsm(gsm);
			user.setLoginDate(now);
			user.setMemberDate(now);
			user.setName(name);
			user.setOccupation(occuppation);
			user.setPhone1(phone1);
			TbRole role = new TbRole();
			role.setId(new Integer(1));
			user.setRole(role);
			user.setSentEvents(sentEvents);
			user.setSex(sex);
			user.setStatus(SystemConstants.IS_ACTIVE);
			user.setSurname(surname);
			user.setUsername(username);
			user.setUserpassword(userpassword);
			user.setUserType(SystemConstants.USERTYPE_NORMAL);
			user.setLogId(SystemConstants.IS_ACTIVE);
			user.setLoginIp(request.getRemoteAddr());

			UsersManager usersManager = new UsersManager();
			boolean userExists = usersManager.userExists(username, email);
			if (userExists) {
				request.setAttribute("message", "Error.user.exists");
				forward = mapping.findForward("userExists");
			} else {
				TbUsersDAO.getInstance().save(user);
				request.setAttribute("message", "Success.user.create");
				MailUtility mailUtility = new MailUtility();
				ArrayList mailText = new ArrayList();
				mailText.add(user.getEmail());
				mailText.add(user.getUsername());
				mailText.add(user.getUserpassword());
				mailText.add(user.getName());
				mailText.add(user.getSurname());				
				mailText.add(user.getPhone1());
				mailText.add(user.getFax());
				mailText.add(user.getGsm());
				mailText.add(user.getMemberDate());
				mailText.add(user.getLoginIp());
				mailText.add(user.getBirthPlace());
				mailText.add(user.getBirthDate());
				
				
				mailUtility.sendNewUserMail(mailText);
				forward = mapping.findForward("createSuccess");
			}

		} catch (Exception e) {
			Logger.getLogger(UserCreateAction.class).error(
					"Exception in Action : " + e);
			LogManager.logError(e.getMessage());
			forward = mapping.findForward("exception");

		}

		return (forward);

	}
}
