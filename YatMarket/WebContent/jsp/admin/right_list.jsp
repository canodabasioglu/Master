<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.UsersManager"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>
<%@ page import="com.odabasioglu.data.TbRight"%>
<%@ page import="com.odabasioglu.data.TbRole"%>

<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.utility.PagerUtility"%>
<%
UsersManager usersManager=new UsersManager();

List listRights = usersManager.listRights(null);
List listRoles=usersManager.listRoles(null);
request.setAttribute( "listRights", listRights );


%>

<html:html>
<SCRIPT language="JavaScript">
function onFormSubmit(){
		
		form.submit();
		return true;
	}
</SCRIPT>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">
<FORM name="form" method="post"
	action="<%=request.getContextPath()%>/rightCreate.do" >
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

						<TABLE width="550" border="0">
							<TBODY>
								
								<TR>
									<TD colspan="4"><%=com.odabasioglu.utility.MessageUtility.getMessage(request.getAttribute("message"))%></TD>
								</TR>
								<TR>
									<TD><bean:message key="Admin.right.role" /></TD>
									<TD><bean:message key="Admin.right.description" /></TD>
									<TD><bean:message key="Admin.right.status" /></TD>
									<TD><bean:message key="Admin.button.delete" /></TD>
								</TR>
								<TR>
									
									<TD><SELECT name="roleId">
										<%for (int k = 0; k < listRoles.size(); k++) {%>
										<OPTION
											value="<%=((TbRole) listRoles.get(k)).getId()%>"><%=com.odabasioglu.utility.ConverterUtility.getDisplaySize(
									((TbRole) listRoles.get(k)).getDescription(),35)%></OPTION>
										<%}%>
									</SELECT></TD>	
									<TD><INPUT type="text" size="25" name="description" maxlength="50"></TD>
									<TD><SELECT name="status">
										<OPTION value="1" selected>Aktif</OPTION>
										<OPTION value="0">Pasif</OPTION>
									</SELECT></TD>
									<TD valign="top"><A class="butonlar" href="#" onclick="onFormSubmit()"><bean:message
										key="Menu.create.button" /></A></TD>									
								</TR>
							
							<display:table name="listRights" pagesize="20" >
							<display:caption><bean:message key="Admin.right.title" /></display:caption>
							<display:column property="role.id" title="Rol" sortable="true" headerClass="sortable" />  
							<display:column property="description" title="A��klama" sortable="true" headerClass="sortable" />		
							<display:column property="status" title="Durum" sortable="true" headerClass="sortable" />  
							<display:column paramProperty="id" url="/rightDelete.do?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/sil.gif"></display:column>
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
