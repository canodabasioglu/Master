<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>

<%@ page import="com.odabasioglu.manager.UsersManager"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>
<%@ page import="com.odabasioglu.utility.PagerUtility"%>
<%
UsersManager usersManager = new UsersManager();
List userList=usersManager.listUsers();
request.setAttribute( "userList", userList );
%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">

<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD align="left"><jsp:include page="/jsp/admin/layout/admin_toppane.jsp" flush="true" /></TD>
		</TR>
		<TR vAlign=top>
			<TD>
			<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
				<TBODY>
					<TR vAlign=top>
						<TD align="left" width="200"><jsp:include
							page="/jsp/admin/layout/admin_leftpane.jsp" flush="true" /></TD>
						<TD width="20">&nbsp;</TD>
						<TD valign="top" align="center" colspan="3">
						<TABLE width="100%" border="0" cellpadding="1">
							<TBODY>							
							<TR>
								<TD colspan="7"><%=com.odabasioglu.utility.MessageUtility.getMessage(request.getAttribute("message"))%></TD>
								<TD></TD>
								<TD></TD>
							</TR>		
								
							<display:table name="userList" pagesize="20" >
							<display:caption><bean:message key="Admin.user.title" /></display:caption>
							<display:column property="name" title="Adý" sortable="true" headerClass="sortable" />  		
							<display:column property="surname" title="Soyadý" sortable="true" headerClass="sortable" />  
							<display:column property="username" title="Kullanýcý Adý" sortable="true" headerClass="sortable" />  
							<display:column property="phone1" title="Telefon"  /> 
							<display:column property="gsm" title="Cep Telefonu"  /> 							 
							<display:column property="loginDate" title="Son Giriþ Zamaný" sortable="true" headerClass="sortable" format="{0,date,dd/MM/yyyy hh:mm}"/> 
							<display:column property="loginIp" title="Baðlantý IP"  />	,
							<display:column paramProperty="id" url="/jsp/admin/user_details.jsp?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/edit.gif"></display:column>     
							<display:column paramProperty="id" url="/userDelete.do?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/sil.gif"></display:column>
							
  							</display:table>
  							
  							<TR>
								<TD><A href="<%=request.getContextPath()%>/jsp/user/user_create.jsp" target="_BLANK"><BR>
								<bean:message key="Admin.user.adduser" /></A></TD>
								<TD></TD>
								<TD></TD>
								<TD></TD>
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
		
		<TR>
			<TD align="center"></TD>
		</TR>
	</TBODY>
</TABLE>

</BODY>
</html:html>
