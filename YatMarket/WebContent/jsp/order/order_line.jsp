<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.OrderManager"%>
<%@ page import="com.odabasioglu.data.TbOrder"%>
<%@ page import="com.odabasioglu.data.TbOrderline"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>
<%@ page import="com.odabasioglu.config.SystemConstants"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>

<%
	TbUsers user = (TbUsers) session.getAttribute("user");
	List orderLinelist = OrderManager.listOrderline(user.getId(), null);
%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
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
									<TD width="580" valign="top" align="center">
									<TABLE border="0" width="500">
										<TBODY>
											<TR>
												<TD colspan="6" class="topmenu">


												<TABLE border="0">
													<TBODY>
														<TR>
															<TD colspan="7" class="topmenu"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<bean:message
																key="Orderline.Header.message" /></TD>
														</TR>
														<TR>
															<TD colspan="7"><bean:message
																key="Orderline.details" /></TD>

														</TR>
														<TR>
															<TD class="topTitle"><bean:message key="Order.no" /></TD>
															<TD class="topTitle"><bean:message
																key="Product.code" /></TD>
															<TD class="topTitle"><bean:message
																key="Product.name" /></TD>
															<TD class="topTitle"><bean:message
																key="Product.amount" /></TD>
															<TD class="topTitle"><bean:message
																key="Product.price" /></TD>
															<TD class="topTitle"><bean:message
																key="Product.price.total" /></TD>
															<TD class="topTitle"><bean:message
																key="Menu.delete.button" /></TD>
														</TR>
														<TR>
															<TD class="topTitle" colspan="7"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1"></TD>
														</TR>
														<%
																float totalPrice = 0;
																if (orderLinelist != null && orderLinelist.size() > 0) {
														%>

														<%
														for (int z = 0; z < orderLinelist.size(); z++) {
														%>
														<TR>

															<TD><%=z + 1%></TD>
															<TD><%=((TbOrderline) orderLinelist.get(z))
										.getProduct().getProductCode()%></TD>
															<TD><A
																href="<%=request.getContextPath()%>/productDetailsView.do?productId=<%=((TbOrderline) orderLinelist.get(z)).getProduct().getId()%>"><%=((TbOrderline) orderLinelist.get(z))
										.getProduct().getName()%></A></TD>
															<TD><%=((TbOrderline) orderLinelist.get(z))
										.getAmount()%></TD>

															<TD align="right"><%=ConverterUtility
												.formatCurrency(((TbOrderline) orderLinelist
														.get(z)).getPrice())%></TD>
															<TD align="right"><%=ConverterUtility.calculateTotalPrice(
										((TbOrderline) orderLinelist.get(z))
												.getPrice(),
										((TbOrderline) orderLinelist.get(z))
												.getAmount())%></TD>
															<TD align="right"><A
																href="<%=request.getContextPath()%>/orderLineDelete.do?orderlineId=<%=((TbOrderline) orderLinelist.get(z)).getId()%>"
																onclick="return confirmation()"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/sil.gif"
																width="19" height="19"></A></TD>
														</TR>

														<TR>
															<TD colspan="7"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1">
															<%
																			totalPrice += (((TbOrderline) orderLinelist.get(z))
																			.getPrice())
																			* ((TbOrderline) orderLinelist.get(z))
																			.getAmount().intValue();
															%>
															</TD>
														</TR>
														<TR>
															<%
															}
															%>
															<TD></TD>
															<TD></TD>
															<TD></TD>
															<TD></TD>
															<TD></TD>
															<TD></TD>
															<TD></TD>
														</TR>
														<TR>
															<TD colspan="7"></TD>
														</TR>
														<TR>
															<TD></TD>
															<TD></TD>
															<TD></TD>
															<TD></TD>
															<TD align="right"><bean:message
																key="Orderline.lineTotal" /></TD>
															<TD align="right"><%=ConverterUtility.formatCurrency(totalPrice)%></TD>
															<TD align="right"></TD>
														</TR>
														<TR>
															<TD></TD>
															<TD></TD>
															<TD></TD>
															<TD></TD>
															<TD align="right"><bean:message
																key="Orderline.vatTotal" /></TD>
															<TD align="right"><%=ConverterUtility.formatCurrency(totalPrice
									* SystemConstants.VAT_RATIO)%></TD>
															<TD align="right"></TD>
														</TR>
														<TR>
															<TD></TD>
															<TD></TD>
															<TD></TD>
															<TD></TD>
															<TD align="right"><bean:message
																key="Orderline.overallTotal" /></TD>
															<TD align="right"><B><%=ConverterUtility.formatCurrency(totalPrice
									* SystemConstants.TOTAL_VAT)%></B></TD>
															<TD align="right"></TD>
														</TR>
														<TR>
															<TD colspan="7"></TD>
														</TR>
														<TR>
															<TD colspan="7" align="right"><A class="butonlar"
																href="<%=request.getContextPath()%>/siteManager.do?url=shipmentAddress">
															<bean:message key="Orderline.continue.button" /></A> <%
 } else {
 %>
															</TD>
														</TR>
														<TR>
															<TD class="topTitle" colspan="7" align="center"><bean:message
																key="Error.orderline.empty" /></TD>
														</TR>
														<TR>
															<TD colspan="7"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1"></TD>
														</TR>
														<%
														}
														%>
														<TR>
															<TD class="topTitle" align="center" colspan="7"><BR>
															<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/basket.gif"
																width="80" height="66"></TD>
														</TR>
													</TBODY>
												</TABLE>
											


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
