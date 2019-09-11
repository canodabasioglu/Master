<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@page import="com.odabasioglu.manager.ListOfValueManager"%>
<%@page import="java.util.List"%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<SCRIPT language="JavaScript">
	function onFormSubmit() {

		if (!isValid(NAME, form.name.value)) {
			alert(MSG_NAME);
			form.name.select();
			return false;
		}

		if (!isValid(SURNAME, form.surname.value)) {
			alert(MSG_SURNAME);
			form.surname.select();
			return false;
		}

		if (!isValid(TEL, form.phone1.value)) {
			alert(MSG_TEL);
			form.phone1.select();
			return false;
		}

		if (!isValid(USERNAME, form.username.value)) {
			alert(MSG_USERNAME);
			form.username.select();
			return false;
		}

		if (!isValid(EMAIL, form.email.value)) {
			alert(MSG_EMAIL);
			form.email.select();
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
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">

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
												<TD colspan="3" width="31%" align="center">

												<FORM name="form" method="post"
													action="<%=request.getContextPath()%>/userCreate.do">
												<TABLE width="100%" height="418">

													<TBODY>
														<TR>
															<TD class="page_title" colspan="2" ><bean:message
																key="User.Header.newUser" /><BR>
															<BR>
															<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/personal.gif"
																width="80" height="79"> <BR><%=com.odabasioglu.utility.MessageUtility
								.getMessage(request.getAttribute("message"))%>
															</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.name" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT
																name="name" type="text" class="textfield2"
																maxlength="60"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.surname" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT
																name="surname" type="text" class="textfield2"
																maxlength="60"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.phone1" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT onkeypress="return OnlyNumeric(event)"
																name="phone1" type="text" class="textfield2"
																maxlength="10"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.fax" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT onkeypress="return OnlyNumeric(event)"
																name="fax" type="text" class="textfield2" maxlength="10"></TD>

														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.gsm" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT onkeypress="return OnlyNumeric(event)"
																name="gsm" type="text" class="textfield2" maxlength="10"></TD>

														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.email" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT
																name="email" type="text" class="textfield2"
																maxlength="50"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.username" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT onkeypress="return OnlyAlphaNumeric(event)"
																name="username" type="text" class="textfield2"
																maxlength="50"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.password" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT
																name="userpassword" type="password" class="textfield2"
																maxlength="20"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.passwordAgain" /></TD>
															<TD width="223"><INPUT name="userpassword2"
																type="password" class="textfield2" maxlength="20">
															*</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.sex" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT
																type="radio" name="sex" value="E" checked><bean:message
																key="User.sex.man" /><INPUT type="radio" name="sex"
																value="K"><bean:message key="User.sex.women" /></TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.birthPlace" /></TD>
															<TD width="223"><SELECT name="birthPlace">
																<%
																	List cityList = ListOfValueManager.cityList();
																%>
																<%
																	for (int i = 0; i < cityList.size(); i++) {
																%>
																<OPTION value="<%=cityList.get(i)%>"><%=cityList.get(i)%></OPTION>
																<%
																	}
																%>

															</SELECT></TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.birthDate" /></TD>
															<TD width="223"><SELECT name="birthDateDay">
																<OPTION value="1" selected>1</OPTION>
																<%
																	for (int i = 2; i <= 31; i++) {
																%>
																<OPTION value="<%=i%>"><%=i%></OPTION>
																<%
																	}
																%>
															</SELECT> <SELECT name="birthDateMonth">
																<OPTION value="1" selected>1</OPTION>
																<%
																	for (int i = 2; i <= 12; i++) {
																%>
																<OPTION value="<%=i%>"><%=i%></OPTION>
																<%
																	}
																%>
															</SELECT> <SELECT name="birthDateYear">
																<OPTION value="1940" selected>1940</OPTION>
																<%
																	for (int i = 1941; i <= 1999; i++) {
																%>
																<OPTION value="<%=i%>"><%=i%></OPTION>
																<%
																	}
																%>
															</SELECT></TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.occupation" /></TD>
															<TD width="223"><SELECT name="occupation">
																<%
																	List occupationList = ListOfValueManager.occupationList();
																%>
																<%
																	for (int i = 0; i < occupationList.size(); i++) {
																%>
																<OPTION value="<%=occupationList.get(i)%>"><%=occupationList.get(i)%></OPTION>
																<%
																	}
																%>

															</SELECT></TD>
														</TR>
														<TR>
															<TD class="altbilgi" colspan="2" align="left"><bean:message
																key="User.events" /><INPUT type="checkbox"
																name="sentEvents" value="E" checked><bean:message
																key="System.required" /></TD>
														</TR>
														<TR>
															<TD colspan="2" align="center"><A class="butonlar"
																href="#" onclick="javascript:document.form.reset()"><bean:message
																key="Menu.clear.button" /></A> &nbsp;&nbsp;<A
																class="butonlar" href="#" onclick="onFormSubmit()"><bean:message
																key="Menu.create.button" /></A><BR>
															<BR>
															</TD>
														</TR>
														<TR>
															<TD class="altbilgi" align="left" colspan="2"
																valign="middle"></TD>
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
