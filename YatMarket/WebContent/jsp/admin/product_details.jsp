<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>

<%@ page import="com.odabasioglu.data.TbProduct"%>
<%@ page import="com.odabasioglu.data.TbCategory"%>
<%@ page import="com.odabasioglu.manager.CategoryManager"%>
<%@ page import="com.odabasioglu.manager.ProductManager"%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.config.SystemConstants"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>


<%
	ProductManager productManager = new ProductManager();
	TbProduct product = productManager.getProduct(Integer
			.valueOf(request.getParameter("id")));
	CategoryManager categoryManager = new CategoryManager();
	List categoryList = categoryManager.listSubCategory(null);
%>
<html:html>
<SCRIPT language="JavaScript">
	function onFormSubmit() {

		if (form.name.value == '') {
			alert(MSG_PRODUCT_NAME);
			form.name.select();
			return false;
		}

		if (form.description.value == '') {
			alert(MSG_PRODUCT_DESCRIPTION);
			form.description.select();
			return false;
		}

		form.submit();
		return true;
	}
</SCRIPT>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY leftMargin=0 topMargin=0 rightmargin="0" bottommargin="0">
<FORM name="form" method="post" enctype="multipart/form-data"
	action="<%=request.getContextPath()%>/productUpdate.do?productId=<%=product.getId()%>">
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
						<TD valign="top" align="center" colspan="3">
						<TABLE cellspacing="0" cellpadding="0" border="0" width="100%">
							<TBODY>
								<TR>
									<TD valign="top" align="center">

									<TABLE width="100%" border="0">
										<TBODY>
											<TR>
												<TD colspan="2"><bean:message
													key="Admin.product.details" /></TD>
											</TR>
<TR>
											<TD colspan="2"><IMG border="1" width="90"
													<%if (product.getThumbnail() != null) {%>
													src="<%=request.getContextPath()%>/ImageServlet?type=picture&id=<%=product.getId()%>"
													<%} else {%>
													src="<%=request.getContextPath()%>/image/application/no_picture.gif"
													<%}%>><BR>
												<BR>
											</TR>
											<TR>
												<TD>Kategori :</TD>
												<TD><SELECT name="categoryId" size="0">
													<%
														for (int i = 0; i < categoryList.size(); i++) {
													%>
													<OPTION
														value="<%=((TbCategory) categoryList.get(i)).getId()%>"><%=((TbCategory) categoryList.get(i))
									.getCategoryName()%></OPTION>
													<%
														}
													%>
													<OPTION value="<%=product.getCategory().getId()%>" selected><%=product.getCategory().getCategoryName()%></OPTION>

												</SELECT></TD>
											</TR>
											<TR>
												<TD>Ürün Adý :</TD>
												<TD><INPUT type="text" name="name" size="60"
													value="<%=product.getName()%>"></TD>
											</TR>
											<TR>
												<TD>Açýklama :</TD>
												<TD><TEXTAREA rows="10" cols="60" name="description"><%=product.getDescription()%></TEXTAREA></TD>
											</TR>
											<TR>
												<TD>Ürün Kodu :</TD>
												<TD><INPUT type="hidden" name="productCode" size="20"
													value="<%=product.getProductCode()%>" maxlength="8"><%=product.getProductCode()%></TD>
											</TR>
											<TR>
												<TD>Fiyatý :</TD>
												<TD><INPUT type="text" name="price" size="4"
													value="<%=product.getPrice()%>"></TD>
											</TR>
											<TR>
												<TD>Birim :</TD>
												<TD><SELECT name="currencyType">
													<OPTION value="<%=product.getCurrencyType()%>" selected><%=ConverterUtility.getCurrencyType(product
								.getCurrencyType())%></OPTION>
													<OPTION value="<%=SystemConstants.CURRENCY_DOLLAR%>"><%=ConverterUtility
										.getCurrencyType(SystemConstants.CURRENCY_DOLLAR)%></OPTION>
													<OPTION value="<%=SystemConstants.CURRENCY_EURO%>"><%=ConverterUtility
										.getCurrencyType(SystemConstants.CURRENCY_EURO)%></OPTION>
													<OPTION value="<%=SystemConstants.CURRENCY_YTL%>"><%=ConverterUtility
								.getCurrencyType(SystemConstants.CURRENCY_YTL)%></OPTION>
												</SELECT></TD>
											</TR>
											<TR>
												<TD>Stok Durumu :</TD>
												<TD><SELECT name="stockStatus">
													<OPTION value="<%=product.getStockStatus()%>" selected><%=ConverterUtility.getStockStatus(product
								.getProductStatus())%></OPTION>
													<OPTION value="<%=SystemConstants.PRODUCT_NOT_IN_STOCK%>"><%=ConverterUtility
										.getStockStatus(SystemConstants.PRODUCT_NOT_IN_STOCK)%></OPTION>
													<OPTION value="<%=SystemConstants.PRODUCT_IN_STOCK%>"><%=ConverterUtility
										.getStockStatus(SystemConstants.PRODUCT_IN_STOCK)%></OPTION>
												</SELECT></TD>
											</TR>
											<TR>
												<TD>Tip :</TD>
												<TD><SELECT name="productStatus">
													<OPTION value="<%=product.getProductStatus()%>" selected><%=ConverterUtility.getProductType(product
								.getProductStatus())%></OPTION>
													<OPTION value="<%=SystemConstants.PRODUCT_TYPE_EXPORT%>"><%=ConverterUtility
										.getProductType(SystemConstants.PRODUCT_TYPE_EXPORT)%></OPTION>
													<OPTION value="<%=SystemConstants.PRODUCT_TYPE_IMPORT%>"><%=ConverterUtility
										.getProductType(SystemConstants.PRODUCT_TYPE_IMPORT)%></OPTION>
												</SELECT></TD>
											</TR>
											<TR>
												<TD>Resim :</TD>
												<TD><INPUT type="file" name="theFile" size="30"></TD>

											</TR>
											<TR>
												<TD></TD>
												<TD><A class="butonlar" href="#"
													onclick="onFormSubmit()"><bean:message
													key="Menu.create.button" /></A></TD>
											</TR>
											<TR>
												<TD colspan="2"><br>
												<br>
												</TD>
											</TR>
											<TR>
												<TD colspan="2"><IMG border="1"
													<%if (product.getThumbnail() != null) {%>
													src="<%=request.getContextPath()%>/ImageServlet?type=picture&id=<%=product.getId()%>"
													<%} else {%>
													src="<%=request.getContextPath()%>/image/application/no_picture.gif"
													<%}%>><BR>
												<BR>
											</TR>
											
											<TR>
											<TR>
										</TBODY>
									</TABLE>
									</TD>
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
