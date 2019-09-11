<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.FavouriteManager"%>
<%@ page import="com.odabasioglu.data.TbFavourite"%>
<%@ page import="com.odabasioglu.data.TbProduct"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>

<%
TbUsers user = (TbUsers)session.getAttribute("user");
List favouriteList = FavouriteManager.listFavourite(user.getId());
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
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
									<TD width="580" valign="top" align="center">
									<TABLE border="0" width="100%">
										<TBODY>
											<TR>
												<TD colspan="6" class="topmenu"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/arrow.png"
													width="9" height="9">&nbsp;<bean:message key="Favourite.Header.message"/></TD>
											</TR>
											<TR>
												<TD colspan="6"><bean:message key="Favourite.Header.description"/>
												</TD>
											</TR>
											<TR>
												<TD class="topTitle"><bean:message key="Product.code"/></TD>
												<TD class="topTitle"><bean:message key="Product.name"/></TD>
												<TD class="topTitle"><bean:message key="Product.date"/></TD>
												<TD class="topTitle"><bean:message key="Product.price"/></TD>
												<TD class="topTitle"><bean:message key="Product.details"/></TD>
												<TD class="topTitle"><bean:message key="Menu.delete.button"/></TD>
											</TR>
											<% if (favouriteList!=null && favouriteList.size()>0) {%>
											<% for(int z = 0;z<favouriteList.size();z++) {%>
											
											<TR>
												<TD colspan="6"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/spacer6.gif"
													height="1"></TD>
											</TR>
											<TR>
												<TD><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/point.gif"
													width="9" height="9">&nbsp;<%=((TbFavourite)favouriteList.get(z)).getProduct().getProductCode()%></TD>
												<TD><A href="<%=request.getContextPath()%>/productDetailsView.do?productId=<%=((TbFavourite)favouriteList.get(z)).getProduct().getId()%>"><%=((TbFavourite)favouriteList.get(z)).getProduct().getName()%></A></TD>
												<TD><%=ConverterUtility.getShortDate(((TbFavourite)favouriteList.get(z)).getModifiedDate())%></TD>
												<TD><%=ConverterUtility.formatCurrency(ConverterUtility.getPriceCalculated(((TbFavourite)favouriteList.get(z)).getProduct()))%></TD>
												<TD> <A
													href="<%=request.getContextPath()%>/productDetailsView.do?productId=<%=((TbFavourite)favouriteList.get(z)).getProduct().getId()%>"><IMG
													border="0"
													src="<%=request.getContextPath()%>/image/application/addbasket.gif"
													width="24" height="21"></A></TD>
												<TD><A
													href="<%=request.getContextPath()%>/userFavouriteDelete.do?favouriteId=<%=((TbFavourite)favouriteList.get(z)).getId()%>" onclick="return confirmation()"><IMG
													border="0"
													src="<%=request.getContextPath()%>/image/application/sil.gif"></A></TD>
											</TR>

											<%} }else{ %>
											<TR>
												<TD colspan="6"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/spacer6.gif"
													height="1"></TD>
											</TR>
											<TR>
												<TD class="topTitle" width="20%" colspan="6" align="center"><bean:message key="Error.favourite.empty" /></TD>
											</TR>
											<%}%>
											<TR>
												<TD colspan="6"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/spacer6.gif"
													height="1"></TD>
											</TR>
											<TR>
												<TD colspan="6" align="center"><BR>
												<IMG border="0"
													src="<%=request.getContextPath()%>/image/application/favourite.gif"
													width="80" height="69"></TD>
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
