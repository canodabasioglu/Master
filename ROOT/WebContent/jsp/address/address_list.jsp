<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.AddressManager"%>
<%@ page import="com.odabasioglu.data.TbAddress"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>

<%AddressManager addressManager = new AddressManager();
TbUsers user = (TbUsers)session.getAttribute("user");
List addressList = addressManager.listAddress(user.getId());
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY leftMargin=0 topMargin=0 rightmargin="0"	bottommargin="0">

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
												<TD colspan="6"><bean:message key="Address.listText1" /><BR>
												<BR><bean:message key="Address.listText2" />
												<BR>
												<BR><bean:message key="Address.listText3" />
												<BR>
												<BR>
												<%=com.odabasioglu.utility.MessageUtility.getMessage(request.getAttribute("message"))%>
												</TD>
											</TR>
											<TR>
												<TD class="topTitle" width="16%" colspan="6"><bean:message key="Address.Header.list" /> ( <A class="butonlar"
													href="<%=request.getContextPath()%>/siteManager.do?url=addressCreate"><bean:message key="Button.addAddress" /></A> )<BR>
												<BR>
											<TR>
												<TD class="topTitle"><bean:message key="Address.shortName"/></TD>
												<TD class="topTitle"><bean:message key="Address.state"/></TD>
												<TD class="topTitle"><bean:message key="Address.line1"/></TD>
												<TD class="topTitle"><bean:message key="Menu.update.button"/></TD>
												<TD class="topTitle"><bean:message key="Menu.delete.button"/></TD>
											</TR>
											
											<%if (addressList!=null && addressList.size()>0) {%>
											<%for (int z = 0; z < addressList.size(); z++){%>
										
											<TR>
												<TD class="topTitle" colspan="5"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/spacer6.gif"
													height="1"></TD>
											</TR>
											<TR>
												<TD><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/point.gif"
													width="9" height="9">&nbsp;<A href="<%=request.getContextPath()%>/userAddressDetails.do?addressId=<%=((TbAddress)addressList.get(z)).getId()%>"><%=((TbAddress)addressList.get(z)).getShortName()%>
												</A></TD>
												<TD><%=((TbAddress)addressList.get(z)).getState()%></TD>
												<TD><%=((TbAddress)addressList.get(z)).getLine1()%></TD>
												<TD align="center"><A
													href="<%=request.getContextPath()%>/userAddressDetails.do?addressId=<%=((TbAddress)addressList.get(z)).getId()%>"><IMG
													border="0"
													src="<%=request.getContextPath()%>/image/application/edit.gif"
													width="20" height="19"></A></TD>
												<TD><A
													href="<%=request.getContextPath()%>/userAddressDelete.do?addressId=<%=((TbAddress)addressList.get(z)).getId()%>" onclick="return confirmation()"><IMG
													border="0"
													src="<%=request.getContextPath()%>/image/application/sil.gif"
													width="19" height="19"></A></TD>
											</TR>

											<%} }else{ %>
											<TR>
												<TD colspan="5"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/spacer6.gif"
													height="1"></TD>
												<TD></TD>
											</TR>
											<TR>
												<TD class="topTitle" width="20%" colspan="5" align="center"><bean:message key="Error.address.empty" /></TD>
												<TD></TD>
											</TR>
											<%}%>
											<TR>
												<TD colspan="5"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/spacer6.gif"
													height="1"></TD>
												<TD></TD>
											</TR>
											<TR>
												<TD colspan="5" align="center"><BR>
												<BR>
												<A class="butonlar"
													href="<%=request.getContextPath()%>/jsp/address/address_create.jsp"></A><IMG
													border="0"
													src="<%=request.getContextPath()%>/image/application/house.gif"
													width="80" height="69"></TD>
												<TD></TD>
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
