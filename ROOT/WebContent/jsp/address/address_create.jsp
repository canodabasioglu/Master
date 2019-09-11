<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@page import="com.odabasioglu.manager.ListOfValueManager"%>
<%@page import="java.util.List"%>
<%@page import="com.odabasioglu.data.TbLov"%>

<%@page import="com.odabasioglu.manager.ParametersManager"%><html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<SCRIPT language="JavaScript">
	function onFormSubmit() {

		if (!isValid(SHORTNAME, form.shortName.value)) {
			alert(MSG_SHORTNAME);
			form.shortName.select();
			return false;
		}

		if (!isValid(LINE, form.line1.value)) {
			alert(MSG_LINE);
			form.line1.select();
			return false;
		}

		if (!isValid(LINE, form.line2.value)) {
			alert(MSG_LINE);
			form.line2.select();
			return false;
		}

		if (!isValid(STATE, form.state.value)) {
			alert(MSG_STATE);
			form.state.select();
			return false;
		}

		if (!isValid(CITY, form.city.value)) {
			alert(MSG_CITY);
			form.city.select();
			return false;
		}

		if (!isValid(POSTALCODE, form.postalCode.value)) {
			alert(MSG_POSTALCODE);
			form.postalCode.select();
			return false;
		}

		form.submit();
		return true;
	}
</SCRIPT>
<BODY leftMargin=0 topMargin=0 rightmargin="0" bottommargin="0">

<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD><jsp:include page="/jsp/user/layout/user_toppane.jsp"
				flush="true" /></TD>
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
									<FORM name="form" method="POST"
										action="<%=request.getContextPath()%>/userAddressCreate.do">
									<TABLE width="100%" border="0">
										<TBODY>
											<TR>
												<TD colspan="2"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/arrow.png"
													width="9" height="9">&nbsp;<bean:message
													key="Address.Header.message" /><BR>
												<BR>
												</TD>
											</TR>
											<TR>
												<TD colspan="2"><bean:message key="Address.createText1" /><BR>
												<BR>
												<bean:message key="Address.createText2" /> <BR>
												<BR>
												<bean:message key="Address.createText3" /></TD>
											</TR>
											<TR>
												<TD colspan="2">
												<TABLE border="0" width="100%">
													<TBODY>
														<TR>
															<TD class="leftTitle"><bean:message
																key="Address.type" /></TD>
															<TD><INPUT type="hidden" name="addressId" size="20">
															<SELECT name="addressType">
																<%
																	List addressTypeList = ListOfValueManager.addressTypeList();												
																%>
																<%
																	for (int i = 0; i < addressTypeList.size(); i++) {
																%>
																<OPTION
																	value="<%=((TbLov) addressTypeList.get(i)).getValue()%>"><%=((TbLov) addressTypeList.get(i)).getLabel()%></OPTION>
																<%
																	}
																%>

															</SELECT>*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message
																key="Address.shortName" /></TD>
															<TD><INPUT name="shortName" type="text"
																class="textfield2" maxlength="20">*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message
																key="Address.line1" /></TD>
															<TD><INPUT name="line1" type="text"
																class="textfield2" maxlength="100">*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message
																key="Address.line2" /></TD>
															<TD><INPUT name="line2" type="text"
																class="textfield2" maxlength="100">*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message
																key="Address.state" /></TD>
															<TD><INPUT name="state" type="text"
																class="textfield2" maxlength="50">*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message
																key="Address.city" /></TD>
															<TD><SELECT name="city">
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

															</SELECT>*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message
																key="Address.postalCode" /></TD>
															<TD><INPUT name="postalCode" type="text" onkeypress="return OnlyNumeric(event)"
																class="textfield2" maxlength="5">*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message
																key="Address.country" /></TD>
															<TD><SELECT name="country">
																<OPTION value="Türkiye" selected="selected">Türkiye</OPTION>
															</SELECT></TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message
																key="Address.taxNo" /></TD>
															<TD><INPUT name="taxNo" type="text" onkeypress="return OnlyNumeric(event)"
																class="textfield2" maxlength="12"></TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message
																key="Address.taxOffice" /></TD>
															<TD><INPUT name="taxOffice" type="text"
																class="textfield2" maxlength="50"></TD>
														</TR>
														<TR>
															<TD><A class="butonlar"
																href="javascript:history.back()"></A></TD>
															<TD><A class="butonlar" href="#"
																onclick="onFormSubmit()"><bean:message
																key="Address.save.button" /></A></TD>
														</TR>
													</TBODY>
												</TABLE>
												</TD>
											</TR>
											<TR>
												<TD colspan="2" align="right"></TD>
											</TR>
										</TBODY>
									</TABLE>
									</FORM>
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
			<TD align="center" width="993"><jsp:include
				page="/jsp/guest/layout/guest_bottompane.jsp" flush="true" /></TD>
		</TR>
	</TBODY>
</TABLE>

</BODY>
</html:html>
