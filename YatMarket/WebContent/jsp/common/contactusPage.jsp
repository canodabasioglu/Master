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
				key="Menu.contactUs" /><BR>
			<BR>
			</TD>
		</TR>
		<TR>
			<TD style="text-align: justify">
			<LI><FONT face="Arial, Helvetica, sans-serif" size="2"><bean:message
				key="PageContent.contactUsText1" />&nbsp;<A
				href="mailto:bilgi@yatmarketi.com?subject=Destek Hatti"><bean:message
				key="PageContent.email" /></A>&nbsp;<bean:message
				key="PageContent.contactUsText2" /><A
				href="<%=request.getContextPath()%>/siteManager.do?url=customerRelations"><bean:message
				key="Menu.customerRelations" /></A>&nbsp;<bean:message
				key="PageContent.contactUsText3" /></FONT></LI>
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
