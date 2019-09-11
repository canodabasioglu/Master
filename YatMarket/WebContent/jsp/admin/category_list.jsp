<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.manager.CategoryManager"%>
<%@ page import="com.odabasioglu.data.TbCategory"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>
<%CategoryManager categoryManager = new CategoryManager();
List categoryList = categoryManager.listCategory();
List mainCategoryList = categoryManager.listMainCategory();
request.setAttribute( "categoryList", categoryList );
%>


<%@page import="com.odabasioglu.config.SystemConstants"%><html:html>
<SCRIPT language="JavaScript">
function onFormSubmit(){
		
		if(!isValid(CATEGORY_NAME,form.categoryName.value)){
			alert(MSG_CATEGORY_NAME);
			form.categoryName.select();
			return false;
		}
		
		if(!isValid(CATEGORY_DESCRIPTION,form.categoryDescription.value)){
			alert(MSG_CATEGORY_DESCRIPTION);
			form.categoryDescription.select();
			return false;
		}
		
		form.submit();
		return true;
	}
</SCRIPT>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">
<FORM name="form" method="post" enctype="multipart/form-data"
	action="<%=request.getContextPath()%>/productCategoryCreate.do">
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
									<TD colspan="6"></TD>
								</TR>
								<TR>
									<TD colspan="6"><%=com.odabasioglu.utility.MessageUtility.getMessage(request.getAttribute("message"))%></TD>
								</TR>
								<TR>
									<TD width="60"><bean:message key="Admin.category.type" /></TD>
									<TD width="100"><bean:message key="Admin.category.name" /></TD>
									<TD width="100"><bean:message key="Admin.category.description" /></TD>
									<TD width="60"><bean:message key="Admin.category.picture" /></TD>
									<TD width="60"><bean:message key="Admin.category.status" /></TD>
									<TD width="100"></TD>
								</TR>
								<TR>
									<TD><SELECT name="mainCategoryId">
										<OPTION value="0" selected>Ana Kategori</OPTION>
										<%for (int i = 0; i < mainCategoryList.size(); i++) {%>
										<OPTION
											value="<%=((TbCategory) mainCategoryList.get(i)).getId()%>"><%=ConverterUtility.getDisplaySize(
									((TbCategory) mainCategoryList.get(i)).getCategoryName(),14)%></OPTION>
										<%}%>
									</SELECT></TD>
									<TD><INPUT type="text" size="17" name="categoryName"
										maxlength="100"></TD>
									<TD><INPUT type="text" size="26" name="categoryDescription"
										maxlength="200"></TD>
									<TD><INPUT type="file" name="theFile" size="10"></TD>
									<TD><SELECT name="status">
										<OPTION value="<%=SystemConstants.STATUS_PASSIVE%>"><%=ConverterUtility
											.getStatus(SystemConstants.STATUS_PASSIVE)%></OPTION>
										<OPTION value="<%=SystemConstants.STATUS_ACTIVE%>"><%=ConverterUtility
											.getStatus(SystemConstants.STATUS_ACTIVE)%></OPTION>
									</SELECT></TD>
									<TD><A class="butonlar" href="#" onclick="onFormSubmit()"><bean:message
										key="Menu.create.button" /></A></TD>
								</TR>
							
			
							
							<display:table name="categoryList" pagesize="30" >
  							<display:caption><bean:message key="Admin.category.title" /></display:caption>
  							<display:column property="categoryName" title="Kategori Adý"  sortable="true" headerClass="sortable" />
  							<display:column property="categoryDescription" title="Açýklama" sortable="true" headerClass="sortable" />
  							<display:column property="isMain" title="Ana Kategori" sortable="true" headerClass="sortable" />  
  							<display:column property="modifiedDate" title="Eklenme Tarihi"  sortable="true" format="{0,date,dd/MM/yyyy}" headerClass="sortable" /> 		
  							<display:column paramProperty="id" url="/jsp/admin/category_details.jsp?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/edit.gif"></display:column>     
							<display:column paramProperty="id" url="/productCategoryDelete.do?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/sil.gif"></display:column>
  							
  							
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
