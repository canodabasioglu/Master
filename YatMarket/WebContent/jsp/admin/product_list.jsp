<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.manager.ProductManager"%>
<%@ page import="com.odabasioglu.manager.CategoryManager"%>
<%@ page import="com.odabasioglu.data.TbCategory"%>
<%@ page import="com.odabasioglu.config.SystemConstants"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>



<%ProductManager productManager = new ProductManager();
List productList = productManager.listProduct();
request.setAttribute( "productList", productList );
CategoryManager categoryManager = new CategoryManager();
List subCategoryList = categoryManager.listSubCategory(null);

%>

<html:html>
<SCRIPT language="JavaScript">
function onFormSubmit(){
		
		if(form.name.value==''){
			alert(MSG_PRODUCT_NAME);
			form.name.select();
			return false;
		}
		if(form.description.value==''){
			alert(MSG_PRODUCT_DESCRIPTION);
			form.description.select();
			return false;
		}

		if(!isValid(PRODUCT_PRICE,form.price.value)){
			alert(MSG_PRODUCT_PRICE);
			form.price.select();
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
	action="<%=request.getContextPath()%>/productCreate.do">
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
									<TD colspan="5"></TD>
								</TR>
								<TR>
									<TD colspan="5"><%=com.odabasioglu.utility.MessageUtility.getMessage(
	request.getAttribute("message"))%></TD>
								</TR>
								<TR>
									<TD width="150"><bean:message key="Admin.product.category" /></TD>
									<TD width="150"><bean:message key="Admin.product.name" /></TD>
									<TD width="100"><bean:message key="Admin.product.price" /></TD>
									<TD width="200"><bean:message key="Admin.product.stock" /></TD>
									<TD width="50"><bean:message key="Admin.product.type" /></TD>
								</TR>
								<TR>
									<TD><SELECT name="categoryId" size="0">
										<%for (int i = 0; i < subCategoryList.size(); i++) {%>
										<OPTION
											value="<%=((TbCategory) subCategoryList.get(i)).getId()%>"><%=ConverterUtility.getDisplaySize(
	((TbCategory) subCategoryList.get(i)).getCategoryName(),
	20)%></OPTION>
										<%}%>
									</SELECT></TD>
									<TD><INPUT type="text" size="20" name="name" maxlength="100"></TD>
									<TD><INPUT type="text" size="3" name="price" maxlength="6"><SELECT
										name="currencyType">
										<OPTION value="<%=SystemConstants.CURRENCY_YTL%>" selected><%=ConverterUtility.getCurrencyType(SystemConstants.CURRENCY_YTL)%></OPTION>
										<OPTION value="<%=SystemConstants.CURRENCY_DOLLAR%>"><%=ConverterUtility.getCurrencyType(SystemConstants.CURRENCY_DOLLAR)%></OPTION>
										<OPTION value="<%=SystemConstants.CURRENCY_EURO%>"><%=ConverterUtility.getCurrencyType(SystemConstants.CURRENCY_EURO)%></OPTION>
									</SELECT></TD>
									<TD><SELECT name="stockStatus">
										<OPTION value="<%=SystemConstants.PRODUCT_IN_STOCK%>" selected><%=ConverterUtility.getDisplaySize(
	ConverterUtility.getStockStatus(SystemConstants.PRODUCT_IN_STOCK),
	25)%></OPTION>
										<OPTION value="<%=SystemConstants.PRODUCT_NOT_IN_STOCK%>"><%=ConverterUtility.getDisplaySize(
	ConverterUtility.getStockStatus(SystemConstants.PRODUCT_NOT_IN_STOCK),
	25)%></OPTION>
									</SELECT></TD>
									<TD><SELECT name="productStatus">
										<OPTION value="<%=SystemConstants.PRODUCT_TYPE_IMPORT%>"
											selected><%=ConverterUtility.getProductType(SystemConstants.PRODUCT_TYPE_IMPORT)%></OPTION>
										<OPTION value="<%=SystemConstants.PRODUCT_TYPE_EXPORT%>"><%=ConverterUtility.getProductType(SystemConstants.PRODUCT_TYPE_EXPORT)%></OPTION>
									</SELECT></TD>
								</TR>
								
								<TR>
									<TD><bean:message key="Admin.product.description" /></TD>
									<TD colspan="3"><textarea name="description" cols="60" rows="3"></textarea></TD>
									<TD></TD>
								</TR>
								
								<TR>
									<TD>Resim : </TD>
									<TD colspan="4"><INPUT type="file" name="theFile" size="50" >
									</TD>								
								</TR>
								<TR>
									<TD colspan="5"><A class="butonlar" href="#" onclick="onFormSubmit()"><bean:message
										key="Menu.create.button" /></A></TD>								
								</TR>
								
								
								
							
						
								
								
							<display:table name="productList" pagesize="20" >

							<display:caption><bean:message key="Admin.product.title" /></display:caption>
  							<display:column property="name" title="Ürün Adý" sortable="true" headerClass="sortable" />  		
  							<display:column property="description" title="Ürün Açýklamasý" maxLength="20" sortable="true" headerClass="sortable" />  		
  							<display:column property="price" title="Fiyat" sortable="true" headerClass="sortable" />  
							<display:column property="category.categoryName" title="Kategori" sortable="true" headerClass="sortable" />  
							<display:column paramProperty="id" url="/jsp/admin/product_details.jsp?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/edit.gif"></display:column>     
							<display:column paramProperty="id" url="/productDelete.do?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/sil.gif"></display:column>
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
