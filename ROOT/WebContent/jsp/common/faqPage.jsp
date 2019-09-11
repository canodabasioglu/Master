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
				key="Menu.faq" /><BR>
			<BR>
			</TD>
		</TR>
		<TR>
			<TD style="text-align: justify">
			<LI><FONT face="Arial, Helvetica, sans-serif" size="2"><B><bean:message
				key="PageContent.faq1" /></B></LI>
			</TD>
		</TR>
		<TR>
			<TD style="text-align: justify"><FONT
				face="Arial, Helvetica, sans-serif" size="2"><bean:message
				key="PageContent.faq1A" /></TD>
		</TR>
		<TR>
			<TD style="text-align: justify"></TD>
		</TR>
		<TR>
			<TD style="text-align: justify">
			<LI><FONT face="Arial, Helvetica, sans-serif" size="2"><B><bean:message
				key="PageContent.faq2" /></B></FONT></LI>
			</TD>
		</TR>
		<TR>
			<TD style="text-align: justify"><FONT
				face="Arial, Helvetica, sans-serif" size="2"><bean:message
				key="PageContent.faq2A" /></TD>
		</TR>
		<TR>
			<TD style="text-align: justify"></TD>
		</TR>
		<TR>
			<TD style="text-align: justify">
			<LI><FONT face="Arial, Helvetica, sans-serif" size="2"><B><bean:message
				key="PageContent.faq3" /></B></FONT></LI>
			</TD>
		</TR>
		<TR>
			<TD style="text-align: justify"><FONT
				face="Arial, Helvetica, sans-serif" size="2"><bean:message
				key="PageContent.faq3A" /></TD>
		</TR>
	<TR>
		<TD style="text-align: justify">
			<LI><FONT face="Arial, Helvetica, sans-serif" size="2"><B><bean:message
				key="PageContent.faq4" /></B></FONT></LI>
			</TD>
		</TR>
		<TR>
			<TD style="text-align: justify"><FONT
				face="Arial, Helvetica, sans-serif" size="2"><bean:message
				key="PageContent.faq4A" /></TD>
		</TR>
		<TR align="right">
			<TD style="text-align: justify" align="right"><B><BR>
			<BR>
			<bean:message
				key="PageContent.pageName" /></B></TD>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</html:html>
