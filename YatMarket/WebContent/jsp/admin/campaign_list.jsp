<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.manager.CategoryManager"%>
<%@ page import="com.odabasioglu.manager.ProductManager"%>
<%@ page import="com.odabasioglu.data.TbProduct"%>
<%
ProductManager productManager = new ProductManager();
CategoryManager categoryManager = new CategoryManager();
List categoryList = categoryManager.listSubCategory(null);
List productList =null;
if (productManager.listProduct()!=null){ 
	productList = productManager.listProduct();
}
request.setAttribute( "productList", productList );
%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY  leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">
<FORM name="form" method="post" action="<%=request.getContextPath()%>/productCreate.do">
<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD><jsp:include page="/jsp/admin/layout/admin_toppane.jsp" flush="true" /></TD>
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
											
											
							<display:table name="productList" pagesize="30" >
  							<display:caption><bean:message key="Admin.topsales.details" /></display:caption>
  							<display:column property="name" title="Ürün Adý"  sortable="true" headerClass="sortable" />
  							<display:column property="description" title="Açýklama"  sortable="true" headerClass="sortable" />
  							<display:column property="modifiedDate" title="Ýþlem Tarihi"  sortable="true" headerClass="sortable" format="{0,date,dd/MM/yyyy hh:mm:ss}" />
  							</display:table>

											
											
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
