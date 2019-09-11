<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.NewsManager"%>
<%@ page import="com.odabasioglu.data.TbNews"%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.utility.PagerUtility"%>
<%@ page import="com.odabasioglu.config.SystemConstants"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>

<%TbNews news = NewsManager.getNews(Integer.valueOf(request.getParameter("id")));%>

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
<FORM name="form" method="post"	action="<%=request.getContextPath()%>/newsUpdate.do" >
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
									<TD colspan="4"><bean:message key="Admin.news.details" /></TD>
								</TR>
								<TR>
									<TD colspan="4"><%=com.odabasioglu.utility.MessageUtility.getMessage(request.getAttribute("message"))%></TD>
								</TR>
								<TR>
									
									<TD width="150"><bean:message key="Admin.news.header" /></TD>
									<TD width="450"><bean:message key="Admin.news.description" /></TD>
									<TD width="50"><bean:message key="Admin.news.status" /></TD>
									<TD width="100"><bean:message key="Admin.button.delete" /></TD>
								</TR>
								<TR>
									<TD valign="top"><INPUT type="hidden" size="25" name="newsId" maxlength="50" value="<%=news.getId()%>"><INPUT type="text" size="25" name="title" maxlength="50" value="<%=news.getTitle()%>"></TD>
									<TD><TEXTAREA rows="8" cols="50" name="newsdescription"><%=news.getNewsdescription()%></TEXTAREA></TD>
									<TD valign="top"><SELECT name="status">
										<OPTION value="<%=news.getStatus()%>" selected><%=ConverterUtility.getStatus(news.getStatus())%></OPTION>
										<OPTION value="<%=SystemConstants.STATUS_PASSIVE%>"><%=ConverterUtility.getStatus(SystemConstants.STATUS_PASSIVE)%></OPTION>
										<OPTION value="<%=SystemConstants.STATUS_ACTIVE%>"><%=ConverterUtility.getStatus(SystemConstants.STATUS_ACTIVE)%></OPTION>
									</SELECT></TD>
									<TD valign="top"><A class="butonlar" href="#" onclick="onFormSubmit()"><bean:message
										key="Menu.create.button" /></A></TD>
									
								</TR>
						
								
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
