<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>
<%@ page import="java.util.*"%>
<%TbUsers user =(TbUsers) session.getAttribute("user");%>
<%@page import="com.odabasioglu.manager.ListOfValueManager"%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<SCRIPT language="JavaScript">
function onFormSubmit(){
		
			if(!isValid(NAME,form.name.value)){
			alert(MSG_NAME);
			form.name.select();
			return false;
		}
		
			if(!isValid(SURNAME,form.surname.value)){
			alert(MSG_SURNAME);
			form.surname.select();
			return false;
		}
		
			if(!isValid(TEL,form.phone1.value)){
			alert(MSG_TEL);
			form.phone1.select();
			return false;
		}
		
		if(!isValid(USERNAME,form.username.value)){
			alert(MSG_USERNAME);
			form.username.select();
			return false;
		}
		
		
				
		if(!isValid(EMAIL,form.email.value)){
			alert(MSG_EMAIL);
			form.email.select();
			return false;
		}
		
		if(!isValid(PASSWORD,form.userpassword.value)){
			alert(MSG_PASSWORD);
			form.userpassword.select();
			return false;
		}
		
		
		form.submit();
		return true;
	}
</SCRIPT>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">

<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD><jsp:include page="/jsp/user/layout/user_toppane.jsp" flush="true" /></TD>
		</TR>
		<TR vAlign=top>
			<TD>
			<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
				<TBODY>
					<TR vAlign=top>
						<TD align="left" width="200"><jsp:include
							page="/jsp/user/layout/user_leftpane.jsp" flush="true" /></TD>
						<TD width="20">&nbsp;</TD>
						<TD valign="top" align="center">
						<TABLE cellspacing="0" cellpadding="0" border="0" width="100%">
							<TBODY>
								<TR>
									<TD valign="top" align="center">
									
									<TABLE border="0" width="100%">
										<TBODY>
											<TR>
												<TD colspan="3" align="center">

<FORM name="form" method="post"	 action="<%=request.getContextPath()%>/userUpdate.do">
												<TABLE width="100%">

													<TBODY>
														<TR>
															<TD class="page_title" colspan="2" 
																valign="middle"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/personal.gif"
																width="80" height="79"><BR>
															<BR>
															<bean:message key="User.Header.newUser" /><INPUT name="userId" type="hidden" value="<%=user.getId()%>">
															</TD>
														</TR>
														
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.name" /></TD>
															<TD class="solBaslikDar"><INPUT name="name"
																type="text" class="textfield2" maxlength="60" value="<%=user.getName()%>"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.surname" /></TD>
															<TD class="solBaslikDar" ><INPUT
																name="surname" type="text" class="textfield2" value="<%=user.getSurname()%>"
																maxlength="60"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.phone1" /></TD>
															<TD class="solBaslikDar" ><INPUT onkeypress="return OnlyNumeric(event)"
																name="phone1" type="text" class="textfield2" value="<%=user.getPhone1()%>"
																maxlength="10"> *</TD> 
														</TR>
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.fax" /></TD>
															<TD class="solBaslikDar" ><INPUT name="fax" onkeypress="return OnlyNumeric(event)"
																type="text" class="textfield2" maxlength="10" value="<%=user.getFax()%>"></TD>

														</TR>
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.gsm" /></TD>
															<TD class="solBaslikDar"><INPUT name="gsm" onkeypress="return OnlyNumeric(event)"
																type="text" class="textfield2" maxlength="10" value="<%=user.getGsm()%>"></TD>

														</TR>
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.email" /></TD>
															<TD class="solBaslikDar"><INPUT name="email"
																type="text" class="textfield2" maxlength="50" value="<%=user.getEmail()%>"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.username" /></TD>
															<TD class="solBaslikDar"><%=user.getUsername()%><INPUT name="username" 
																type="hidden" class="textfield2" maxlength="50" value="<%=user.getUsername()%>"></TD>
														</TR>
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.password" /></TD>
															<TD class="solBaslikDar"><INPUT
																name="userpassword" type="password" class="textfield2" value="<%=user.getUserpassword()%>"
																maxlength="20"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.passwordAgain" /></TD>
															<TD><INPUT name="userpassword2" type="password" value="<%=user.getUserpassword()%>"
																class="textfield2" maxlength="20"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.sex" /></TD>
															<TD class="solBaslikDar"><%String selected = user.getSex().toUpperCase();%>
															<INPUT type="radio"	name="sex" value="E" <%if (selected.trim().equals("E")) { %> checked <%}%>><bean:message key="User.sex.man" /> 
															<INPUT type="radio"	name="sex" value="K" <%if (selected.trim().equals("K")) { %> checked <%}%>><bean:message key="User.sex.women" /></TD>
														</TR>
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.birthPlace" /></TD>
															<TD>
																
																<SELECT name="birthPlace">
																<%List cityList = ListOfValueManager.cityList(); %>
																<OPTION value="<%=user.getBirthPlace()%>" selected><%=user.getBirthPlace()%></OPTION>
																<%for (int i = 0; i <cityList.size(); i++) {%>
																<OPTION value="<%=cityList.get(i)%>"><%=cityList.get(i)%></OPTION>
																<%}%>
																
															</SELECT>
																
																</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.birthDate" /></TD>
															<TD>
															<%Date birthDate = user.getBirthDate();%>
															<SELECT name="birthDateDay">
																<OPTION value="1" selected><%=birthDate.getDate()%></OPTION>
																<%for (int i = 1; i <= 31; i++) {%>
																<OPTION value="<%=i%>"><%=i%></OPTION>
																<%}%>
															</SELECT> <SELECT name="birthDateMonth">
																<OPTION value="<%=birthDate.getMonth()+1%>" selected><%=birthDate.getMonth()+1%></OPTION>
																<%for (int i = 1; i <= 12; i++) {%>
																<OPTION value="<%=i%>"><%=i%></OPTION>
																<%}%>
															</SELECT> <SELECT name="birthDateYear">
																<OPTION value="<%=birthDate.getYear()+1900%>" selected><%=birthDate.getYear()+1900%></OPTION>
																<%for (int i = 1941; i <= 1999; i++) {%>
																<OPTION value="<%=i%>"><%=i%></OPTION>
																<%}%>
															</SELECT></TD>
														</TR>
														<TR>
															<TD class="solBaslikDar"><bean:message key="User.occupation" /></TD>
															<TD><SELECT name="occupation">
																<%List occupationList = ListOfValueManager.occupationList(); %>
																<OPTION value="<%=user.getOccupation()%>" selected><%=user.getOccupation()%></OPTION>
																<%for (int i = 0; i <occupationList.size(); i++) {%>
																<OPTION value="<%=occupationList.get(i)%>"><%=occupationList.get(i)%></OPTION>
																<%}%>
																
															</SELECT></TD>
														</TR>
														<TR>
															<TD class="altbilgi" colspan="2" align="left"><bean:message key="User.events" />
															<INPUT type="checkbox" name="sentEvents" value="E" <%if (user.getSentEvents()!=null) {%> checked <%}%>>
															<bean:message key="System.required" />
															</TD>
														</TR>
														<TR>
															<TD colspan="2" align="center"><A class="butonlar" href="#"
																onclick="onFormSubmit()"><bean:message key="Menu.update.button" /></A><BR>
															<BR>
															</TD>
														</TR>
														<TR>
															<TD class="altbilgi" align="left" colspan="2"
																valign="middle"></TD>
														</TR>
													</TBODY>
												</TABLE>
													</FORM></TD>
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
							page="/jsp/user/layout/user_rightpane.jsp" flush="true" /></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		
		<TR>
			<TD align="center"><jsp:include page="/jsp/guest/layout/guest_bottompane.jsp"
				flush="true" /></TD>
		</TR>
	</TBODY>
</TABLE>

</BODY>
</html:html>
