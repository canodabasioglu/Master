<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.UsersManager"%>
<%@ page import="com.odabasioglu.manager.AddressManager"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>
<%@ page import="com.odabasioglu.data.TbRole"%>
<%@ page import="com.odabasioglu.data.TbAddress"%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.config.SystemConstants"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>

<%UsersManager usersManager = new UsersManager();
List userRoles = usersManager.listRoles(null);
Integer userId = Integer.valueOf(request.getParameter("id"));
TbUsers user = usersManager.getUser(userId);
TbRole role = usersManager.getRole(user.getRole().getId());
AddressManager addressManager = new AddressManager();
List addressList = addressManager.listAddress(userId);
%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">
<FORM name="form" method="post"
	action="<%=request.getContextPath()%>/roleUpdate.do">
<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD align="left"><jsp:include
				page="/jsp/admin/layout/admin_toppane.jsp" flush="true" /></TD>
		</TR>
		<TR vAlign=top>
			<TD>
			<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
				<TBODY>
					<TR vAlign=top>
						<TD align="left" width="200"><jsp:include
							page="/jsp/admin/layout/admin_leftpane.jsp" flush="true" /></TD>
						<TD width="20">&nbsp;</TD>
						<TD valign="top" align="center" colspan="3">
						<TABLE width="100%" border="0" cellpadding="1">
							<TBODY>
								<TR>
									<TD colspan="2"><bean:message
																key="Admin.user.details" /></TD>
								</TR>
								<TR>
									<TD width="133"><bean:message key="Admin.user.personal" /></TD>
									<TD width="592"></TD>
								</TR>
								<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.name" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT name="userId" type="hidden" value="<%=user.getId()%>"><INPUT name="name"
																type="text" class="textfield2" maxlength="60" value="<%=user.getName()%>"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.surname" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT
																name="surname" type="text" class="textfield2"
																maxlength="60" value="<%=user.getSurname()%>"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.phone1" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT name="phone1"
																type="text" class="textfield2" maxlength="10" value="<%=user.getPhone1()%>"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.fax" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT name="fax"
																type="text" class="textfield2" maxlength="10" value="<%=user.getFax()%>"></TD>

														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.gsm" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT name="gsm"
																type="text" class="textfield2" maxlength="10" value="<%=user.getGsm()%>"></TD>

														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.email" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT name="email"
																type="text" class="textfield2" maxlength="50" value="<%=user.getEmail()%>"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.username" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT
																name="username" type="text" class="textfield2"
																maxlength="50" value="<%=user.getUsername()%>"> *</TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.password" /></TD>
															<TD class="solBaslikDar" width="223"><INPUT
																name="userpassword" type="text" class="textfield2"
																maxlength="20" value="<%=user.getUserpassword()%>"> *</TD>
														</TR>
											 			<TR>
															<TD class="solBaslikDar"><bean:message key="User.sex" /></TD>
															<TD class="solBaslikDar"><%String selected = user.getSex().toUpperCase();%>
															<INPUT type="radio"	name="sex" value="E" <%if (selected.trim().equals("E")) { %> checked <%}%>><bean:message key="User.sex.man" /> 
															<INPUT type="radio"	name="sex" value="K" <%if (selected.trim().equals("K")) { %> checked <%}%>><bean:message key="User.sex.women" /></TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.birthPlace" /></TD>
															<TD width="223"><INPUT name="birthPlace" type="text"
																class="textfield2" maxlength="40" value="<%=user.getBirthPlace()%>"></TD>
														</TR>
														<TR>
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.birthDate" /></TD>
															<TD width="223">
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
															<TD class="solBaslikDar" width="169"><bean:message
																key="User.occupation" /></TD>
															<TD width="223"><INPUT name="occupation" type="text"
																class="textfield2" maxlength="60" value="<%=user.getOccupation()%>"></TD>
														</TR>
														<TR>
															<TD class="altbilgi" colspan="2" align="left"><bean:message key="User.events" />
															<INPUT type="checkbox" name="sentEvents" value="E" <%if (user.getSentEvents()!=null) {%> checked <%}%>>
															<bean:message key="System.required" />
															</TD>
														</TR>
								<TR>
									<TD width="133"></TD>
									<TD width="592"></TD>
								</TR>
								<TR>
									<TD width="133">Kullanýcý Tipi :</TD>
									<TD width="592"><SELECT name="userTypeId">
										<OPTION selected="selected" value="<%=user.getUserType()%>"><%=ConverterUtility.getUserType(user.getUserType())%></OPTION>
										<OPTION value="<%=SystemConstants.USERTYPE_NORMAL%>"><%=ConverterUtility.getUserType(SystemConstants.USERTYPE_NORMAL)%></OPTION>
										<OPTION value="<%=SystemConstants.USERTYPE_ADMINISTRATOR%>"><%=ConverterUtility.getUserType(SystemConstants.USERTYPE_ADMINISTRATOR)%></OPTION>

									</SELECT></TD>
								</TR>
								<TR>
									<TD width="133">Kullanýcý Rolü :</TD>
									<TD width="592"><SELECT name="userRoleId">
										<OPTION selected="selected" value="<%=role.getId()%>"><%=role.getDescription()%></OPTION>
										<%for (int i = 0; i < userRoles.size(); i++) {%>
										<OPTION value="<%=((TbRole) userRoles.get(i)).getId()%>"><%=((TbRole) userRoles.get(i)).getDescription()%></OPTION>
										<%}%>
									</SELECT></TD>
								</TR>
								<TR>
									<TD width="133"></TD>
									<TD width="592"><A class="butonlar" href="#"
										onclick="form.submit();"><bean:message
										key="Menu.create.button" /></A></TD>
								</TR>
								<TR>
									<TD width="133">ADRES BÝLGÝLERÝ</TD>
									<TD width="592"></TD>
								</TR>
								<%if (addressList != null && addressList.size() > 0) {%>
								<%for (int z = 0; z < addressList.size(); z++) {%>
								<TR>
									<TD width="133">Adres (<%=z + 1%>):</TD>
									<TD width="592"><%=((TbAddress) addressList.get(z)).getLine1()%>
									<%=((TbAddress) addressList.get(z)).getLine2()%> <%=((TbAddress) addressList.get(z)).getState()%>
									<%=((TbAddress) addressList.get(z)).getCity()%> <%=((TbAddress) addressList.get(z)).getCountry()%>
									<%=((TbAddress) addressList.get(z)).getPostalCode()%> <%=((TbAddress) addressList.get(z)).getTaxOffice()%>
									<%=((TbAddress) addressList.get(z)).getTaxNo()%></TD>
								</TR>
								<%}
}%>
							</TBODY>
						</TABLE>

						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		<TR>
			<TD align="center"></TD>
		</TR>
	</TBODY>
</TABLE>
</FORM>
</BODY>
</html:html>
