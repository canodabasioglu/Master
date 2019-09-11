<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.CategoryManager"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>

<%@ page import="com.odabasioglu.data.TbCategory"%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.utility.PagerUtility"%>
<%
	CategoryManager categoryManager = new CategoryManager();
	TbCategory category = categoryManager.getCategoryById(Integer
			.valueOf(request.getParameter("id")));
	List mainCategoryList = categoryManager.listMainCategory();
%>


<%@page import="com.odabasioglu.config.SystemConstants"%><html:html>
<SCRIPT language="JavaScript">
function onFormSubmit(){

		form.submit();
		return true;
	}
</SCRIPT>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">
<FORM name="form" method="post" enctype="multipart/form-data"
	action="<%=request.getContextPath()%>/productCategoryUpdate.do">
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
									<TD colspan="2"><bean:message key="Admin.category.details" /></TD>
								</TR>
								<TR>

									<TD colspan="2"><%=com.odabasioglu.utility.MessageUtility
								.getMessage(request.getAttribute("message"))%></TD>
								</TR>
							
								<TR>
									<TD width="100"><bean:message key="Admin.category.type" /></TD>
									<TD width="650"><INPUT type="hidden" name="categoryId"
										value="<%=category.getId()%>"><SELECT
										name="mainCategoryId">
										<OPTION value="0" selected>Ana Kategori</OPTION>
										<%
										for (int i = 0; i < mainCategoryList.size(); i++) {
										%>
										<OPTION
											value="<%=((TbCategory) mainCategoryList.get(i)).getId()%>"><%=ConverterUtility
									.getDisplaySize(
											((TbCategory) mainCategoryList
													.get(i)).getCategoryName(),
											10)%></OPTION>
										<%
										}
										%>
									</SELECT></TD>
								</TR>
								<TR>
									<TD><bean:message key="Admin.category.name" /></TD>
									<TD><INPUT type="text" name="categoryName" size="17"
										value="<%=category.getCategoryName()%>" maxlength="100"></TD>
								</TR>
								<TR>
									<TD><bean:message key="Admin.category.description" /></TD>
									<TD><INPUT type="text" name="categoryDescription"
										size="46" value="<%=category.getCategoryDescription()%>"
										maxlength="200"></TD>
								</TR>
								<TR>
									<TD><bean:message key="Admin.category.picture" /></TD>
									<TD><INPUT type="file" name="theFile" size="40"></TD>
								</TR>
								<TR>
									<TD><bean:message key="Admin.category.status" /></TD>
									<TD><SELECT name="status">
										<OPTION value="<%=category.getStatus()%>" selected><%=ConverterUtility
								.getStatus(category.getStatus())%></OPTION>
										<OPTION
											value="<%=com.odabasioglu.config.SystemConstants.STATUS_PASSIVE%>"><%=ConverterUtility
											.getStatus(SystemConstants.STATUS_PASSIVE)%></OPTION>
										<OPTION
											value="<%=com.odabasioglu.config.SystemConstants.STATUS_ACTIVE%>"><%=ConverterUtility
											.getStatus(SystemConstants.STATUS_ACTIVE)%></OPTION>
									</SELECT></TD>
								</TR>
								
								<TR>
									<TD colspan="2"><A class="butonlar" href="#" onclick="onFormSubmit()"><bean:message
										key="Menu.create.button" /></A></TD>
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
