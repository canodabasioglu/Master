<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.data.TbProduct"%>
<%@ page import="com.odabasioglu.utility.PagerUtility"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>
<%
List searchList =(List)session.getAttribute("searchList");
PagerUtility pager = (PagerUtility) session.getAttribute("pager");

int displayPage = pager.setSelectedPageNumber(request.getParameter("selectedPageNumber"));
int endPageValue = (displayPage * pager.getItemsPerPage());
int itemsStart = pager.getItemsStart();
int itemsEnd = pager.getItemsEnd();
%>
<html:html>

<BODY topmargin="0">
<TABLE width="100%" align="center" border="0">
	<TBODY>
		<TR>
			<TD><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/questionmark.jpg"
				 height="50"></TD>
			<TD class="product_menu" colspan="8"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/arrow.png" width="9"
				height="9"> Aranan &quot;<B><Font color=red><I><%=session.getAttribute("keyword")%></I></Font></B> &quot; için bulunan ürünler aþaðýda listelenmiþtir.   </TD>
		</TR>
		<TR>
			<TD><% if(searchList!=null) { %></TD>
			<TD colspan="8">Toplam <B><Font color=red><%=searchList.size()%></Font></B> ürün bulundu</TD>
		</TR>
		<TR>
			<TD colspan="9"></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD><bean:message key="Product.code" /></TD>
			<TD><bean:message key="Product.name" /></TD>
			<TD><bean:message key="Product.explanation" /></TD>
			<TD><bean:message key="Product.price" /></TD>
		</TR>
		<TR>
			<TD colspan="9"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/spacer6.gif"></TD>
		</TR>
		<TR>
			<TD colspan="9"><%for (int z = itemsStart; z < itemsEnd; z++) {%></TD>
		</TR>
		<TR>
			<TD><IMG
				border="0"
				src="<%=request.getContextPath()%>/image/product/<%=((TbProduct)searchList.get(z)).getThumbnail()%>_th.gif"
				></TD>
			<TD><%=((TbProduct)searchList.get(z)).getProductCode()%></TD>
			<TD><A
				href="<%=request.getContextPath()%>/productDetailsView.do?productId=<%=((TbProduct)searchList.get(z)).getId()%>"><%=((TbProduct)searchList.get(z)).getName()%></A></TD>
			<TD><%=ConverterUtility.getDisplaySize(((TbProduct)searchList.get(z)).getDescription(),15)%></TD>
			<TD><%=ConverterUtility.formatCurrency(ConverterUtility.getPriceCalculated(((TbProduct)searchList.get(z))))%></TD>
		</TR>
		<TR>
			<TD colspan="9"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/spacer6.gif"></TD>
		</TR>
		<TR>
			<TD colspan="9"><%}%></TD>
		</TR>
		<TR>
			<TD colspan="9" align="right"><bean:message key="System.page" />
			&raquo;| <%int i; for (i = 0; i < pager.getTotalPages(); i++) {%><A
				class="pages"
				href="<%=request.getContextPath()%>/jsp/<%if (session.getAttribute("user") != (null)){%>product<%}else{%>guest<%}%>/product_search.jsp?selectedPageNumber=<%=i + 1%>"><%=i + 1%></A>&nbsp;&nbsp;|&nbsp;<%}%></TD>
		</TR>
		<%} else {%>
		<TR>
			<TD colspan="9"><bean:message key="Error.search.empty" /></TD>
		</TR>
		<%}%>
	</TBODY>
</TABLE>




</BODY>
</html:html>
