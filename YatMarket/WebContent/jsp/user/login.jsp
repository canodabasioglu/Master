<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<html:html>
<SCRIPT language="JavaScript">
	function onFormSubmit() {

		if (!isValid(USERNAME, form.username.value)) {
			alert(MSG_USERNAME);
			form.username.select();
			return false;
		}
		if (!isValid(PASSWORD, form.userpassword.value)) {
			alert(MSG_PASSWORD);
			form.userpassword.select();
			return false;
		}

		form.submit();
		return true;
	}
	
</SCRIPT>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0" onkeypress="onEnter(event);">

<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD><jsp:include page="/jsp/guest/layout/guest_toppane.jsp"
				flush="true" /></TD>
		</TR>
		<TR vAlign=top>
			<TD>
			<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
				<TBODY>
					<TR vAlign=top>
						<TD align="left" width="200"><jsp:include
							page="/jsp/guest/layout/guest_leftpane.jsp" flush="true" /></TD>
						<TD width="20">&nbsp;</TD>
						<TD valign="top" align="center">
						<TABLE cellspacing="0" cellpadding="0" border="0" width="100%">
							<TBODY>
								<TR>
									<TD width="608" valign="top" align="center">

									<TABLE border="0" width="557">
										<TBODY>
											<TR>
												<TD colspan="3" width="31%">
												<FORM name="form" method="post"
													action="<%=request.getContextPath()%>/userLogin.do">
												<TABLE border="0" width="90%">
													<TBODY>
														<TR>
															<TD colspan="3" width="100%" class="page_title"><bean:message
																key="Login.Header" /><BR>
															</TD>
														</TR>
														<TR>
															<TD colspan="3" width="504"><bean:message
																key="Login.Header.message" /></TD>
														</TR>
														<TR>
															<TD width="504" colspan="3"><%=com.odabasioglu.utility.MessageUtility
								.getMessage(request.getAttribute("message"))%></TD>
														</TR>


														<TR>
															<TD width="504" colspan="3"></TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message
																key="Login.Header.username" /></TD>
															<TD><INPUT class="textField" type="text"
																name="username" size="20" onkeypress="return OnlyAlphaNumeric(event)" ></TD>
															<TD rowspan="4"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/lock.gif"></TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message
																key="Login.Header.password" /></TD>
															<TD valign="top"><INPUT class="textField"
																type="password" name="userpassword" size="10">
															&nbsp; <A class="butonlar" href="#"
																onclick="onFormSubmit()"><bean:message
																key="Login.loginbutton" /></A></TD>
														</TR>
														<TR>
															<TD></TD>
															<TD><A href="#"></A><A href="#"
																onclick="onFormSubmit()"></A></TD>
														</TR>
														<TR>
															<TD colspan="2"></TD>
														</TR>
														<TR>
															<TD class="tableExp" colspan="3"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/remind_password.gif"
																width="22" height="22">&nbsp;<bean:message
																key="PageContent.loginText1" /><A class="link"
																href="<%=request.getContextPath()%>/jsp/user/user_reminder.jsp">&nbsp;<bean:message
																key="PageContent.clickHere" /></A>&nbsp;<bean:message
																key="PageContent.loginText2" /></TD>
														</TR>
														<TR>
															<TD class="tableExp" colspan="3"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/membership.gif"
																width="22" height="22">&nbsp;<bean:message
																key="PageContent.loginText3" /> <A
																href="<%=request.getContextPath()%>/jsp/common/default_user.jsp"></A>&nbsp;<A
																href="<%=request.getContextPath()%>/jsp/user/user_create.jsp"><bean:message
																key="PageContent.clickHere" /></A>&nbsp;<bean:message
																key="PageContent.loginText4" /></TD>
														</TR>
													</TBODY>
												</TABLE>
												</FORM>
												</TD>
											</TR>
										</TBODY>
									</TABLE>

									</TD>
								</TR>
							</TBODY>
						</TABLE>
						</TD>
						<TD width="20"></TD>
						<TD valign="top" width="200"><jsp:include
							page="/jsp/guest/layout/guest_rightpane.jsp" flush="true" /></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		<TR>
			<TD align="center"><jsp:include
				page="/jsp/guest/layout/guest_bottompane.jsp" flush="true" /></TD>
		</TR>
	</TBODY>
</TABLE>

</BODY>
</html:html>
