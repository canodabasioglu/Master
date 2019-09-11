<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.UsersManager"%>
<%@ page import="com.odabasioglu.data.TbForm"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>
<%@ page import="com.odabasioglu.config.SystemConstants"%>
<%
TbUsers user = (TbUsers)session.getAttribute("user");
List formList = UsersManager.listForm(user.getId());
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
												<TD colspan="5" class="topmenu"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/arrow.png"
													width="9" height="9">&nbsp;MÜÞTERÝ HÝZMETLERÝ SORULAR</TD>
											</TR>
											<TR>
												<TD colspan="5"><BR>
												Bize daha önceden iletmiþ olduðunuz soru, istek ve önerileri buradan takip edebilirsiniz.<BR>
												<BR>
												</TD>
											</TR>
											<TR>
												<TD class="topTitle">Sýra</TD>
												<TD class="topTitle">Baþlýk</TD>
												<TD class="topTitle">Açýklama</TD>
												<TD class="topTitle">Tarih</TD>
												<TD class="topTitle">Durum</TD>
											</TR>
											<% if (formList!=null && formList.size()>0) {%>
											<% for(int z = 0;z<formList.size();z++) {%>
											
											<TR>
												<TD colspan="5"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/spacer6.gif"
													height="1"></TD>
											</TR>
											<TR>
												<TD><%=z+1%></TD>
												<TD><%=((TbForm)formList.get(z)).getTopic()%></TD>
												<TD><%=((TbForm)formList.get(z)).getDescription()%></TD>
												<TD><%=com.odabasioglu.utility.ConverterUtility.getShortDate(((TbForm)formList.get(z)).getModifiedDate())%></TD>
												<TD><%=com.odabasioglu.utility.ConverterUtility.getFeedBackStatus(((TbForm)formList.get(z)).getFormStatus())%><A
													href="<%=request.getContextPath()%>/userFavouriteDelete.do?favouriteId=<%=((TbForm)formList.get(z)).getId()%>"></A></TD>
											</TR>

											<%} }else{ %>
											<TR>
												<TD colspan="5"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/spacer6.gif"
													height="1"></TD>
											</TR>
											<TR>
												<TD class="topTitle" width="20%" colspan="5" align="center"><B><FONT
													color="#ff0000">Sistemde bekleyen bir soru / cevap
												bulunmamaktadýr.</FONT></B></TD>
											</TR>
											<%}%>
											<TR>
												<TD colspan="5"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/spacer6.gif"
													height="1"></TD>
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
