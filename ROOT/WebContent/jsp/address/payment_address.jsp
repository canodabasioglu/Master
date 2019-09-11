<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.AddressManager"%>
<%@ page import="com.odabasioglu.data.TbAddress"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>

<%AddressManager addressManager = new AddressManager();
TbUsers user = (TbUsers) session.getAttribute("user");
List addressList = addressManager.listAddress(user.getId());
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<SCRIPT language="JavaScript">


function onFormSubmit(){
		if(!isRadioChecked(paymentForm.addressId,MSG_PAYMENT_ADDRESS)){			
			}
			else{
		paymentForm.action="<%=request.getContextPath()%>/orderPaymentAddressCreate.do";
		paymentForm.submit();
		} }

</SCRIPT>
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">

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
									<FORM name="paymentForm" method="post"
										onsubmit="return onFormSubmit(this)">
									<TABLE border="0" width="100%">
										<TBODY>
											<TR>
												<TD colspan="3" class="topmenu"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/arrow.png"
													width="9" height="9">&nbsp;<bean:message
													key="Address.Header.payment" /><BR>
												<BR>
												</TD>
											</TR>
											<TR>
												<TD colspan="3"><bean:message key="Address.Header.select" /></TD>
											</TR>
											<TR>
												<TD class="topTitle" colspan="3"><bean:message key="Address.select.address" />( <A class="butonlar"
													href="<%=request.getContextPath()%>/siteManager.do?url=addressCreate"><bean:message key="Menu.addressCreate.button"/></A> )<BR>
												<BR>
												</TD>
											</TR>
											<TR>
												<TD class="topTitle" colspan="3"></TD>
											</TR>
											<TR>
												<TD class="topTitle" colspan="3"></TD>
											</TR>
											<%if (addressList != null && addressList.size() > 0) {
													for (int z = 0; z < addressList.size(); z++) {%>

											<TR>
												<TD class="topTitle" colspan="3"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/spacer6.gif"
													height="1"></TD>
											</TR>
											<TR>
												<TD width="31"><INPUT type="radio" name="addressId"
													value="<%=((TbAddress) addressList.get(z)).getId()%>">&nbsp;</TD>
												<TD colspan="2" width="475"><A
													href="<%=request.getContextPath()%>/userAddressDetails.do?addressId=<%=((TbAddress) addressList.get(z)).getId()%>"><%=((TbAddress) addressList.get(z)).getShortName()%></A></TD>
											</TR>
											<TR>
												<TD width="31"></TD>
												<TD width="475" colspan="2"><%=((TbAddress) addressList.get(z)).getLine1()%>&nbsp;<%=((TbAddress) addressList.get(z)).getLine2()%></TD>
											</TR>
											<TR>
												<TD width="31"></TD>
												<TD colspan="2" width="475"><%=((TbAddress) addressList.get(z)).getState()%>&nbsp;<%=((TbAddress) addressList.get(z)).getCity()%>&nbsp;<%=((TbAddress) addressList.get(z)).getPostalCode()%>&nbsp;<%=((TbAddress) addressList.get(z)).getCountry()%></TD>
											</TR>
											<TR>
												<TD width="31"></TD>
												<TD width="475" colspan="2"><%=((TbAddress) addressList.get(z)).getTaxOffice()%>&nbsp;<%=((TbAddress) addressList.get(z)).getTaxNo()%></TD>
											</TR>
											<TR>
												<TD colspan="3" align="right"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/spacer6.gif"
													height="1"><%}%> <A class="butonlar" href="#"
													onclick="onFormSubmit()"><bean:message key="Menu.continue.button" /></A> <%} else {%></TD>
											</TR>
											<TR>
												<TD class="topTitle" colspan="3" align="center"><bean:message key="Error.address.empty" /></TD>
											</TR>
											<%}%>
											<TR>
												<TD colspan="3"></TD>
											</TR>
											<TR>
												<TD colspan="3" align="center"><A class="butonlar"
													href="<%=request.getContextPath()%>/jsp/address/address_create.jsp"></A><IMG
													border="0"
													src="<%=request.getContextPath()%>/image/application/payaddress.gif"
													width="80" height="60"></TD>
											</TR>
											<TR>
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
			<TD align="center"><jsp:include
				page="/jsp/guest/layout/guest_bottompane.jsp" flush="true" /></TD>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</html:html>
