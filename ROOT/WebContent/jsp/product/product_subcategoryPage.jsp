<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.data.TbProduct"%>
<%@ page import="com.odabasioglu.data.TbCategory"%>
<%@ page import="com.odabasioglu.manager.CategoryManager"%>

<%@ page import="com.odabasioglu.utility.PagerUtility"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>

<%

List productList =(List)session.getAttribute("subcategory");
PagerUtility pager = (PagerUtility) session.getAttribute("pager");
pager.setItemsPerPage(15);
int displayPage = pager.setSelectedPageNumber(request.getParameter("selectedPageNumber"));
int endPageValue = (displayPage * pager.getItemsPerPage());
int itemsStart = pager.getItemsStart();
int itemsEnd = pager.getItemsEnd();

CategoryManager categoryManager = new CategoryManager();
Integer productCategoryId = Integer.valueOf(request.getParameter("productSubcategoryId"));
TbCategory category = categoryManager.getCategoryById(productCategoryId);

%>
<html:html>

<BODY topmargin="0">

	
<TABLE width="100%" align="center" border="0">
	<TBODY>
		<%if (category != null) {%>
		<TR>
			<TD align="center">
			
			<IMG border="0"
				<%if(category.getThumbnail()!=null){%>
					src="<%=request.getContextPath()%>/ImageServlet?type=category&id=<%=category.getId()%>"
				<% } else {%>
				
					src="<%=request.getContextPath()%>/image/application/no_picture.gif"
				<% } %>
				
				height="40">
				
			</TD>
			<TD class="product_menu" colspan="5"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/arrow.png" width="9"
				height="9"> <%=category.getCategoryName()%><BR>
			<BR>
			<I>(<%=category.getCategoryDescription()%>)</I></TD>
		</TR>
	
		
		<TR>
			<TD></TD>
			
			<TD><bean:message key="Product.name"/></TD>
			<TD><bean:message key="Product.price"/></TD>
			<TD><bean:message key="Product.stock"/></TD>
			<TD><bean:message key="Product.details"/></TD>
		</TR>
		<TR>
			<TD colspan="7"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/spacer6.gif"></TD>
		</TR>
		<TR>
			<TD colspan="6"><%for (int z = itemsStart; z < itemsEnd; z++) {
			
				TbProduct product = ((TbProduct)productList.get(z));
			%></TD>
		</TR>
		<TR>
			<TD align="center"><A
				href="<%=request.getContextPath()%>/productDetailsView.do?productId=<%=product.getId()%>">
				
				
				
				<IMG border="0"
				<%if(product.getThumbnail()!=null){%>
					src="<%=request.getContextPath()%>/ImageServlet?type=thumbnail&id=<%=product.getId()%>"
				<% } else {%>
				
					src="<%=request.getContextPath()%>/image/application/no_picture.gif"
				<% } %>
				
				height="30">
				
				
				</A></TD>
			
			<TD><A href="<%=request.getContextPath()%>/productDetailsView.do?productId=<%=product.getId()%>" ><%=ConverterUtility.getDisplaySize(product.getName(),25)%></A></TD>
			
			<TD><%=ConverterUtility.formatCurrency(ConverterUtility.getPriceCalculated(product))%></TD>
			<TD><IMG border="0" src="<%=request.getContextPath()%>/image/application/product_status<%=product.getStockStatus().intValue()%>.gif" alt="<%=ConverterUtility.getStockStatus( product.getStockStatus())%>"></TD>
			<TD><A href="<%=request.getContextPath()%>/productDetailsView.do?productId=<%=product.getId()%>"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/addbasket.gif" width="24"
				height="21"></A></TD>
		</TR>
		<TR>
			<TD colspan="6"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/spacer6.gif"></TD>
		</TR>
		<TR>
			<TD colspan="6"><%}%></TD>
		</TR>
		<TR>
			<TD colspan="6"></TD>
		</TR>
		<TR>
			<TD align="right" colspan="6"><BR>
			</TD>
		</TR>
		<TR>
			<TD colspan="7" align="right"><bean:message key="System.page"/> &raquo;| <%int i; for (i = 0; i < pager.getTotalPages(); i++) {%><A
				class="pages"
				href="<%=request.getContextPath()%>/jsp/<%if (session.getAttribute("user") != (null)){%>product<%}else{%>guest<%}%>/product_subcategory.jsp?selectedPageNumber=<%=i + 1%>&productSubcategoryId=<%=category.getId()%>"><%=i + 1%></A>&nbsp;&nbsp;|&nbsp;<%}%></TD>
		</TR>
		<%} else {%>
		<TR>
			<TD colspan="7" align="center"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/empty.gif"><BR>
			<BR>
			<BR>
			<bean:message key="Error.subcategory.empty" /></TD>

		</TR>
		<%}%>
		
	</TBODY>
</TABLE>
</BODY>
</html:html>
