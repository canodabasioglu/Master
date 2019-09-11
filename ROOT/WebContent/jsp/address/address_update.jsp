<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.data.TbAddress"%>
<%TbAddress address = (TbAddress)session.getAttribute("address");%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@page import="java.util.List"%>
<%@page import="com.odabasioglu.manager.ListOfValueManager"%>
<%@page import="com.odabasioglu.data.TbLov"%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<SCRIPT language="JavaScript">
function onFormSubmit(){
		
		if(!isValid(SHORTNAME,form.shortName.value)){
			alert(MSG_SHORTNAME);
			form.shortName.select();
			return false;
		}
				
		if(!isValid(LINE,form.line1.value)){
			alert(MSG_LINE);
			form.line1.select();
			return false;
		}
		
				
		if(!isValid(LINE,form.line2.value)){
			alert(MSG_LINE);
			form.line2.select();
			return false;
		}
		
		if(!isValid(STATE,form.state.value)){
			alert(MSG_STATE);
			form.state.select();
			return false;
		}
		
		if(!isValid(CITY,form.city.value)){
			alert(MSG_CITY);
			form.city.select();
			return false;
		}
		
		if(!isValid(POSTALCODE,form.postalCode.value)){
			alert(MSG_POSTALCODE);
			form.postalCode.select();
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
												<TD colspan="6" class="topmenu"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/arrow.png"
													width="9" height="9">&nbsp;<bean:message key="Address.Header.message"/><BR>
												<BR>
												</TD>
											</TR>
											<TR>
												<TD colspan="6">Sistemimizde kayýtlý olan adrese ait detaylar aþaðýda listelenmiþtir. Adresinize ait bilgileri buradan güncelleyebilirsiniz.<BR>
												<BR>
												Adres Adý bölümü adreslerinizi birbirinden ayýrt edebilmeniz için
			isimlendirebileceðiniz bir alandýr. Bu bölüme yazdýðýnýz bilgiler teslimat sýrasýnda görüntülenmez.<BR><BR>
												</TD>
											</TR><TR>
												<TD colspan="6"><A class="butonlar"
													href="<%=request.getContextPath()%>/jsp/address/address_create.jsp"></A>
												<FORM name="form" method="post" action="<%=request.getContextPath()%>/userAddressUpdate.do">
												<TABLE border="0" width="100%">
													<TBODY>
													<TR>
															<TD class="leftTitle"><bean:message key="Address.type"/></TD>
															<TD><INPUT type="hidden" name="addressId"
																size="20" value="<%=address.getId()%>">
																<SELECT name="addressType">
																<%List addressTypeList = ListOfValueManager.addressTypeList(); %>
																
																<%for (int i = 0; i <addressTypeList.size(); i++) {%>
																<OPTION value="<%=((TbLov) addressTypeList.get(i)).getValue()%>"><%=((TbLov) addressTypeList.get(i)).getLabel()%></OPTION>
																<%}%>
																
															</SELECT>*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message key="Address.shortName"/></TD>
															<TD><INPUT name="shortName" type="text" class="textfield2"
																maxlength="50"
																value="<%=address.getShortName()%>"><INPUT
																type="hidden" name="addressId" size="20"
																value="<%=address.getId()%>"> *</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message key="Address.line1"/></TD>
															<TD><INPUT name=line1 type="text" class="textfield2"
																maxlength="100"
																value="<%=address.getLine1()%>">
															*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message key="Address.line2"/></TD>
															<TD><INPUT name="line2" type="text" class="textfield2"
																maxlength="100"
																value="<%=address.getLine2()%>">
															*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message key="Address.state"/></TD>
															<TD><INPUT name="state" type="text" class="textfield2"
																maxlength="30"
																value="<%=address.getState()%>">
															*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message key="Address.city"/></TD>
															<TD><SELECT name="city">
																<%List cityList = ListOfValueManager.cityList(); %>
																<OPTION value="<%=address.getCity()%>" selected><%=address.getCity()%></OPTION>
																<%for (int i = 0; i <cityList.size(); i++) {%>
																<OPTION value="<%=cityList.get(i)%>"><%=cityList.get(i)%></OPTION>
																<%}%>
																
															</SELECT>*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message key="Address.postalCode"/></TD>
															<TD><INPUT name="postalCode" type="text"
																class="textfield2" maxlength="5" onkeypress="return OnlyNumeric(event)"
																value="<%=address.getPostalCode()%>">
															*</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message key="Address.country"/></TD>
															<TD>
																<SELECT name="country" >
																<OPTION value="Türkiye" selected="selected">Türkiye</OPTION>									
																</SELECT>
																</TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message key="Address.taxNo"/></TD>
															<TD><INPUT name="taxNo" type="text" class="textfield2"
																maxlength="12" onblur="return CurrencyFormatted(this)"
																value="<%=address.getTaxNo()%>"></TD>
														</TR>
														<TR>
															<TD class="leftTitle"><bean:message key="Address.taxOffice"/></TD>
															<TD><INPUT name="taxOffice" type="text"
																class="textfield2" maxlength="40"
																value="<%=address.getTaxOffice()%>"></TD>
														</TR>
														<TR>
															<TD class="leftTitle"><BR>
															</TD>
															<TD></TD>
														</TR>
														<TR>
															<TD></TD>
															<TD><A class="butonlar" href="#" onclick="onFormSubmit()"><bean:message key="Menu.update.button"/></A></TD>
														</TR>
													</TBODY>
												</TABLE>
												</FORM></TD>
											</TR>
											<TR>
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
