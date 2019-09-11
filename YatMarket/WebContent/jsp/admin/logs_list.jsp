<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.manager.LogManager"%>
<%@ page import="com.odabasioglu.manager.UsersManager"%>
<%@ page import="com.odabasioglu.data.TbLogs"%>

<%List logList = LogManager.listLog();
UsersManager userManager = new UsersManager();
request.setAttribute( "logList", logList );


%>

<html:html>

<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">
<FORM name="form" method="post"
	action="<%=request.getContextPath()%>/newsCreate.do" >
<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD><jsp:include page="/jsp/admin/layout/admin_toppane.jsp"
				flush="true" /></TD>
		</TR>
		<TR vAlign=top>
			<TD>
			<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
				<TBODY>
					<TR vAlign=top>
						<TD align="left" width="200"><jsp:include
							page="/jsp/admin/layout/admin_leftpane.jsp" flush="true" /></TD>
						<TD width="20">&nbsp;</TD>
						<TD valign="top" align="left" colspan="3">

						<TABLE width="750" border="0">
							<TBODY>
								<TR>
									<TD colspan="8"><%=com.odabasioglu.utility.MessageUtility.getMessage(request.getAttribute("message"))%></TD>
								</TR>
								
							<display:table name="logList" pagesize="20" >
							<display:caption><bean:message key="Admin.logs.title" /></display:caption>
							<display:column property="objectName" title="Ýþlem Tipi" sortable="true" headerClass="sortable" />  		
							<display:column property="modifiedDate" title="Ýþlem Tarihi" format="{0,date,dd/MM/yyyy hh:mm:ss}" sortable="true" headerClass="sortable" />  
							<display:column property="userId" title="Kullanýcý" sortable="true" headerClass="sortable" />  
							<display:column property="logIp" title="Baðlantý No" sortable="true" headerClass="sortable" />  
							<display:column property="operationType" title="Referans Adý" sortable="true" headerClass="sortable" />  
							<display:column property="logType" title="Durum" sortable="true" headerClass="sortable" />  
							<display:column property="objectDesc" title="Açýklama" sortable="true" headerClass="sortable" />
							<display:column paramProperty="id" url="/logsDelete.do?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/sil.gif"></display:column>
  							</display:table>
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
