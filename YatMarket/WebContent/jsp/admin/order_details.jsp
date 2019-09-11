<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.OrderManager"%>
<%@ page import="com.odabasioglu.manager.AddressManager"%>
<%@ page import="com.odabasioglu.data.TbOrder"%>
<%@ page import="com.odabasioglu.data.TbAddress"%>
<%@ page import="com.odabasioglu.data.TbOrderline"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>
<%@ page import="com.odabasioglu.config.SystemConstants"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>

<%OrderManager orderManager = new OrderManager();
TbOrder order=(TbOrder)session.getAttribute("order");
List orderLine = (List)session.getAttribute("orderline");

String paymentAddress = AddressManager.getAddressDisplay(order.getPaymentAddress());
String shipmentAddress = AddressManager.getAddressDisplay(order.getShipmentAddress());
%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />

<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">
<FORM name="form" method="post" action="">
<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD><jsp:include page="/jsp/admin/layout/admin_toppane.jsp" flush="true" /></TD>
		</TR>
		<TR vAlign=top>
			<TD>
			<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
				<TBODY>
					<TR vAlign=top>
						<TD align="left" width="200"><jsp:include
							page="/jsp/admin/layout/admin_leftpane.jsp" flush="true" /></TD>
						<TD width="20">&nbsp;</TD>
						<TD valign="top" align="center">
						<TABLE cellspacing="0" cellpadding="0" border="0" >
							<TBODY>
								<TR>
									<TD valign="top" align="center">
									<TABLE border="0">
										<TBODY>
											<TR>
												<TD colspan="6" class="topmenu">
												<TABLE border="0">
													<TBODY>
														<TR>
															<TD colspan="6" class="topmenu"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<bean:message
																key="Order.Header.confirm" /></TD>
														</TR>
														<TR>
															<TD class="topTitle" colspan="2">Sipariþ Tarihi : </TD>
															<TD class="topTitle" colspan="4"><%=com.odabasioglu.utility.ConverterUtility.getShortDateTime(order.getModifiedDate())%></TD>
														</TR>
														<TR>
															<TD class="topTitle" colspan="2">Ödeme Tipi :</TD>
															<TD class="topTitle" colspan="4"><%=com.odabasioglu.utility.ConverterUtility.getPaymentType(order.getPaymentType()) %></TD>
														</TR>
														<TR>
															<TD class="topTitle" colspan="2">Gönderim :</TD>
															<TD class="topTitle" colspan="4"><%=com.odabasioglu.utility.ConverterUtility.getShipmentType(order.getShipmentType())%></TD>
														</TR>
														<TR>
															<TD class="topTitle" colspan="2">Teslimat Adresi :</TD>
															<TD class="topTitle" colspan="4"><%=shipmentAddress %></TD>
														</TR>
														<TR>
															<TD class="topTitle" colspan="2">Fatura Adresi :</TD>
															<TD class="topTitle" colspan="4"><%=paymentAddress%></TD>
														</TR>
														<TR>
															<TD class="topTitle" colspan="6"><bean:message key="Order.details" /></TD>
														</TR>
														<TR>
															<TD class="topTitle"><bean:message key="Order.no" /></TD>
															<TD class="topTitle"><bean:message key="Product.code" /></TD>
															<TD class="topTitle"><bean:message key="Product.name" /></TD>
															<TD class="topTitle"><bean:message key="Product.amount" /></TD>
															<TD class="topTitle"><bean:message key="Product.price" /></TD>
															<TD class="topTitle"><bean:message key="Product.price.total" /></TD>
														</TR>
														<TR>
															<TD class="topTitle" colspan="6"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1"><%float totalPrice = 0; for (int z = 0; z < orderLine.size(); z++){%></TD>
														</TR>
														<TR>

															<TD><%=z + 1%></TD>
															<TD><%=((TbOrderline)orderLine.get(z)).getProduct().getProductCode()%></TD>
															<TD><A
																href="<%=request.getContextPath()%>/productDetailsView.do?productId=<%=((TbOrderline)orderLine.get(z)).getProduct().getId()%>"><%=((TbOrderline)orderLine.get(z)).getProduct().getName()%></A></TD>
															<TD><%=((TbOrderline)orderLine.get(z)).getAmount()%></TD>
															<TD><%=ConverterUtility.formatCurrency(((TbOrderline)orderLine.get(z)).getPrice())%></TD>

															<TD align="right"><%=ConverterUtility.calculateTotalPrice(((TbOrderline) orderLine.get(z)).getPrice(),((TbOrderline) orderLine.get(z)).getAmount())%></TD>
														</TR>

														<TR><TD colspan="6"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1"><%totalPrice += (((TbOrderline) orderLine.get(z)).getPrice())* ((TbOrderline) orderLine.get(z)).getAmount().intValue();%></TD>
														</TR>
														<TR>
															<TD colspan="6"><%}%></TD>
														</TR>
														<TR>
															<TD colspan="4"></TD>
															<TD><bean:message key="Orderline.lineTotal" /></TD>
															<TD align="right"><%=ConverterUtility.formatCurrency(totalPrice)%></TD>
														</TR>
														<TR>
															<TD colspan="4"></TD>
															<TD><bean:message key="Orderline.vatTotal" /></TD>
															<TD align="right"><%=ConverterUtility.formatCurrency(totalPrice*SystemConstants.VAT_RATIO)%></TD>
														</TR>
														<TR>
															<TD colspan="4"></TD>
															<TD><bean:message key="Orderline.overallTotal" /></TD>
															<TD align="right"><%=ConverterUtility.formatCurrency(totalPrice*SystemConstants.TOTAL_VAT)%></TD>
														</TR>
														<TR>
															<TD colspan="6"></TD>
														</TR>
														<TR>
															<TD colspan="6" align="right"></TD>
														</TR>
														
														<TR>
															<TD class="topTitle" align="center" colspan="6"></TD>
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
