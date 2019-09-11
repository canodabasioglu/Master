<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>

<%@ page import="com.odabasioglu.manager.NewsManager"%>
<%@ page import="com.odabasioglu.data.TbNews"%>

<%List newsList = NewsManager.listNews();
request.setAttribute( "newsList", newsList );
%>

<html:html>
<SCRIPT language="JavaScript">
function onFormSubmit(){
		
		if(!isValid(NEWS_TITLE,form.title.value)){
			alert(MSG_NEWS_TITLE);
			form.title.select();
			return false;
		}
		
		if(!isValid(NEWS_DESCRIPTION,form.newsdescription.value)){
			alert(MSG_NEWS_DESCRIPTION);
			form.newsdescription.select();
			return false;
		}
		
		form.submit();
		return true;
	}
</SCRIPT>
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
									<TD colspan="4"></TD>
								</TR>
								<TR>
									<TD colspan="4"><%=com.odabasioglu.utility.MessageUtility.getMessage(request.getAttribute("message"))%></TD>
								</TR>
								<TR>									
									<TD width="150"></TD>
									<TD width="450"></TD>
									<TD width="50"></TD>
									<TD width="100"><bean:message key="Admin.button.delete" /></TD>
								</TR>
								<TR>
									<TD valign="top"><INPUT type="text" size="25" name="title" maxlength="50"></TD>
									<TD><TEXTAREA rows="5" cols="50" name="newsdescription"></TEXTAREA></TD>
									<TD valign="top"><SELECT name="status">
										<OPTION value="1" selected>Aktif</OPTION>
										<OPTION value="0">Pasif</OPTION>
									</SELECT></TD>
									<TD valign="top"><A class="butonlar" href="#" onclick="onFormSubmit()"><bean:message
										key="Menu.create.button" /></A></TD>
									
								</TR>
							
								
								
											
							<display:table name="newsList" pagesize="20" >
							<display:caption><bean:message key="Admin.news.title" /></display:caption>
							<display:column property="title" title="Baþlýk" sortable="true" headerClass="sortable" />  		
							<display:column property="newsdescription" title="Açýklama" sortable="true" headerClass="sortable" />  
							<display:column property="status" title="Durum" sortable="true" headerClass="sortable" />  
						
  							<display:column paramProperty="id" url="/jsp/admin/news_details.jsp?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/edit.gif"></display:column>     
							<display:column paramProperty="id" url="/newsDelete.do?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/sil.gif"></display:column>
  							
  							</display:table>
								
								<TR>
									
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
</FORM>
</BODY>
</html:html>
