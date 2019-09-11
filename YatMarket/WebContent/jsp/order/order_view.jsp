<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.OrderManager"%>
<%@ page import="com.odabasioglu.data.TbOrder"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>

<%
TbUsers user = (TbUsers) session.getAttribute("user");
List orderList = OrderManager.listOrder(user.getId());
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
									<TD valign="top" align="center">
									<TABLE border="0">
										<TBODY>
											<TR>
												<TD colspan="6" class="topmenu">
												<TABLE border="0">
													<TBODY>
														<TR>
															<TD colspan="7" class="topmenu"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<bean:message key="Order.Header.message"/></TD>
														</TR>
														<TR>
															<TD colspan="7"><bean:message key="Order.explanation"/></TD>
														</TR>
														<TR>
															<TD class="topTitle"><bean:message key="Order.orderNo"/></TD>
															<TD class="topTitle"><bean:message key="Order.orderDate"/></TD>
															<TD class="topTitle"><bean:message key="Order.paymentType"/></TD>

															<TD class="topTitle" align="center"><bean:message key="Order.orderStatus"/></TD>
														</TR>
														<TR>
															<TD class="topTitle" colspan="4"><IMG
																border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1"></TD>
														</TR>
														<%if (orderList != null && orderList.size() > 0) {%>
														<%for (int z = 0; z < orderList.size(); z++) {%>
														<TR>
															<TD width="161"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/point.gif"
																width="9" height="9">&nbsp;<A
																href="<%=request.getContextPath()%>/orderDetails.do?orderId=<%=((TbOrder) orderList.get(z)).getId()%>"><%=((TbOrder) orderList.get(z)).getId()%></A></TD>
															<TD><%=ConverterUtility.getShortDateTime(((TbOrder) orderList.get(z)).getModifiedDate())%></TD>
															<TD><%=ConverterUtility.getPaymentType((((TbOrder) orderList.get(z)).getPaymentType())) %>
															</TD>
															<TD align="right"><%=ConverterUtility.getOrderStatus((((TbOrder) orderList.get(z)).getOrderStatus())) %>&nbsp;<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/checked.gif"></TD>
															<TD></TD>
															<TD></TD>
															<TD></TD>
														</TR>
														<TR>

															<TD colspan="4"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1"></TD>
														</TR>
														<%}
} else {%>

														<TR>
															<TD class="topTitle" width="20%" colspan="5"
																align="center"><bean:message key="Error.order.empty" /></TD>
															<TD></TD>
														</TR>
														<TR>

															<TD colspan="4"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1"></TD>
														</TR>
														<%}%>
														<TR>
															<TD colspan="4" align="center"><BR>
															<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/order.gif"
																width="80" height="95"></TD>
														</TR>
														<TR>
															<TD><A class="butonlar"
																href="javascript:history.back()"></A></TD>
															<TD></TD>
															<TD></TD>
															<TD></TD>
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
