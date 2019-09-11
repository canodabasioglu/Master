<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.OrderManager"%>
<%@ page import="com.odabasioglu.data.TbPoint"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>
<%@ page import="com.odabasioglu.config.SystemConstants"%>
<%
	TbUsers user = (TbUsers) session.getAttribute("user");
	int points = OrderManager.getOrderPoints(user.getId(),
			SystemConstants.ORDER_POINT_AVAILABLE);
	int pointsSpent = OrderManager.getOrderPoints(user.getId(),
			SystemConstants.ORDER_POINT_NOT_AVAILABLE);
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
															<TD colspan="6" class="topmenu"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<bean:message
																key="Point.Header.message" /><BR>
															<BR>
															</TD>
														</TR>
														<TR>
															<TD colspan="6"><bean:message
																key="Point.Header.description" /></TD>
														</TR>

														<TR>
															<TD colspan="6"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1"></TD>
														</TR>
														<TR>
															<TD colspan="6" align="center"><bean:message
																key="Error.point.empty" /></TD>
														</TR>

														<TR>
															<TD colspan="6"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1"></TD>
														</TR>
														<TR>
															<TD class="leftTitle" width="80%" height="20"><IMG
																border="0"
																src="<%=request.getContextPath()%>/image/application/point.gif"
																width="9" height="9"><bean:message
																key="Point.system.amount" /></TD>
															<TD width="210" align="right"><%=SystemConstants.MEMBERSHIP_POINT%><bean:message
																key="Point.message" /></TD>
														</TR>
														<TR>
															<TD class="leftTitle" width="80%" height="20"><IMG
																border="0"
																src="<%=request.getContextPath()%>/image/application/point.gif"
																width="9" height="9"><bean:message
																key="Point.totalorder.amount" /></TD>
															<TD width="210" align="right"><%=points%><bean:message
																key="Point.message" /></TD>
														</TR>
														<TR>
															<TD class="leftTitle" width="80%" height="20"><IMG
																border="0"
																src="<%=request.getContextPath()%>/image/application/point.gif"
																width="9" height="9"><bean:message
																key="Point.total.amount" /></TD>
															<TD width="210" align="right"><%=points
						+ (SystemConstants.MEMBERSHIP_POINT).intValue()%><bean:message
																key="Point.message" /></TD>
														</TR>
														<TR>
															<TD class="leftTitle" width="80%" height="20"><IMG
																border="0"
																src="<%=request.getContextPath()%>/image/application/point.gif"
																width="9" height="9"><bean:message
																key="Point.spent.amount" /></TD>
															<TD width="210" align="right"><%=pointsSpent%><bean:message
																key="Point.message" /></TD>
														</TR>
														<TR>
															<TD class="leftTitle" width="80%" height="20"><FONT
																color="#800000"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/point.gif"
																width="9" height="9"><bean:message
																key="Point.exist.amount" /></FONT></TD>
															<TD width="210" align="right"><FONT color="#800000"><%=((SystemConstants.MEMBERSHIP_POINT).intValue())
						+ points - pointsSpent%> <bean:message key="Point.message" /></FONT></TD>
														</TR>
														<TR>
															<TD class="leftTitle" width="80%" colspan="2"><IMG
																border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1"><BR>
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
