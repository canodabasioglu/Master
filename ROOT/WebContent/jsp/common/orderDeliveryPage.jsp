<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY topmargin="0" leftmargin="0" bottommargin="0" rightmargin="0">

<TABLE border="0" width="100%">
	<TBODY>
		<TR>
			<TD class="page_title"><bean:message
				key="PageContent.orderDeliveryHeader" /><BR>
			<BR>
			</TD>
		</TR>
		<TR>
			<TD style="text-align: justify"><FONT
				face="Arial, Helvetica, sans-serif" size="2"><bean:message
				key="PageContent.orderDeliveryText1" />
			<LI></TD>
		</TR>
		<TR>
			<TD style="text-align: justify"><BR>
			<LI><FONT face="Arial, Helvetica, sans-serif" size="2"><bean:message
				key="PageContent.orderDeliveryText2" />
		</TR>
		<TR>
			<TD style="text-align: justify"><BR>
			<LI><FONT face="Arial, Helvetica, sans-serif" size="2"><bean:message
				key="PageContent.orderDeliveryText3" /></LI>
			</TD>
		</TR>
		<TR>
			<TD style="text-align: justify"><BR>
			<LI><FONT face="Arial, Helvetica, sans-serif" size="2"><bean:message
				key="PageContent.orderDeliveryText4" /></LI>
			</TD>
		</TR>
		<TR>
			<TD style="text-align: justify"><BR>
			<LI><FONT face="Arial, Helvetica, sans-serif" size="2"><bean:message
				key="PageContent.orderDeliveryText5" />
			</TD>
		</TR>
		<TR align="right">
			<TD style="text-align: justify" align="right"><B><BR>
			<BR>
			<bean:message key="PageContent.pageName" /></B></TD>
		</TR>
	</TBODY>
</TABLE>

</BODY>
</html:html>
