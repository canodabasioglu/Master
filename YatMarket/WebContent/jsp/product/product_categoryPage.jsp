<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.data.TbCategory"%>
<%@ page import="com.odabasioglu.manager.CategoryManager"%>
<%@ page import="com.odabasioglu.manager.ProductManager"%>
<%@ page import="com.odabasioglu.utility.PagerUtility"%>
<%List categoryList = (List) session.getAttribute("maincategory");
PagerUtility pager = (PagerUtility) session.getAttribute("pager");

int displayPage =
	pager.setSelectedPageNumber(request.getParameter("selectedPageNumber"));
int endPageValue = (displayPage * pager.getItemsPerPage());
int itemsStart = pager.getItemsStart();
int itemsEnd = pager.getItemsEnd();
ProductManager  productManager = new ProductManager();
CategoryManager categoryManager = new CategoryManager();
Integer productCategoryId = Integer.valueOf(request.getParameter("productCategoryId"));
TbCategory category = categoryManager.getCategoryById(productCategoryId);


%>
<html:html>

<BODY topmargin="0">
<TABLE width="100%" align="center" border="0">
	<TBODY>
	<%if (categoryList != null && category!=null) {%>
		<TR>
			<TD width="92">
				
				<IMG border="0"
				<%if(category.getThumbnail()!=null){%>
					src="<%=request.getContextPath()%>/ImageServlet?type=category&id=<%=category.getId()%>"
				<% } else {%>
				
					src="<%=request.getContextPath()%>/image/application/no_picture.gif"
				<% } %>
				
				height="50">
				
				</TD>
			<TD class="product_menu" colspan="6"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/arrow.png" width="9"
				height="9"> <%=category.getCategoryName()%><BR>
			<BR>
			<I>(<%=category.getCategoryDescription()%>)</I></TD>
		</TR>
		
		
		<TR>
			<TD colspan="7"></TD>
		</TR>
		
		<TR>
			<TD width="92"></TD>
			<TD colspan="5" width="206"><bean:message key="Category.description" /></TD>
			<TD width="654"></TD>
		</TR>
		<TR>
			<TD colspan="7"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/spacer6.gif"></TD>
		</TR>

		<TR>
			<TD colspan="7"><%for (int z = itemsStart; z < itemsEnd; z++) {
				TbCategory categories = (TbCategory) categoryList.get(z);
				%></TD>
		</TR>
		<TR>
			<TD width="92"><center>
				<IMG border="0"
				<%if(categories.getThumbnail()!=null){%>
					src="<%=request.getContextPath()%>/ImageServlet?type=category&id=<%=categories.getId()%>"
				<% } else {%>
				
					src="<%=request.getContextPath()%>/image/application/no_picture.gif"
				<% } %>
				
				height="40">
				
				</center></TD>
			<TD colspan="5" width="206"><B></B><A
				href="<%=request.getContextPath()%>/productSubcategoryView.do?productSubcategoryId=<%=categories.getId()%> "><%=com.odabasioglu.utility.ConverterUtility.getDisplaySize(
						categories.getCategoryName(),15)%></A></TD>
			<TD width="654"><%=categories.getCategoryDescription()%> (<I><%=productManager
														.getProductCountByCategoryId(categories.getId())%> Adet Ürün</I>)</TD>
		</TR>
		<TR>
			<TD colspan="7"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/spacer6.gif"></TD>
		</TR>
		<TR>
			<TD colspan="7"><%}%></TD>
		</TR>
		<TR>
			<TD colspan="7"></TD>
		</TR>
		<TR>
			<TD align="right" colspan="7"><BR>
			</TD>
		</TR>
		<TR>
			<TD colspan="7" align="right"><bean:message key="System.page" />
			&raquo;| <%int i;
for (i = 0; i < pager.getTotalPages(); i++) {%><A class="pages"
				href="<%=request.getContextPath()%>/jsp/<%if (session.getAttribute("user") != (null)) {%>product<%} else {%>guest<%}%>/product_category.jsp?selectedPageNumber=<%=i + 1%>&productCategoryId=<%=productCategoryId%>"><%=i + 1%></A>&nbsp;&nbsp;|&nbsp;<%}%></TD>
		</TR>
		<%} else { %>
		<TR>
			<TD colspan="7" align="center"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/empty.gif"><BR>
			<BR>
			<BR>
			<bean:message key="Error.category.empty" /></TD>

		</TR>
		<%}%>
	</TBODY>
</TABLE>




</BODY>
</html:html>
