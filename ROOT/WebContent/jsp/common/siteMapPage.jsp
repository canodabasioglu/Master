<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@ page import="com.odabasioglu.manager.CategoryManager"%>
<%@ page import="com.odabasioglu.manager.ProductManager"%>
<%@ page import="com.odabasioglu.data.TbCategory"%>
<%@ page import="java.util.*"%>
<%
	CategoryManager categoryManager = new CategoryManager();
	ProductManager productManager = new ProductManager();
	List categoryList;
	List subcategoryList;
	if (session.getAttribute("category") == null) {
		categoryList = categoryManager.listMainCategory();
		session.setAttribute("category", categoryList);
	} else {
		categoryList = (List) session.getAttribute("category");
	}
%>
<html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">
<TABLE cellspacing="2" cellpadding="2" width="100%" border="0">

	<TBODY>
		<TR valign="bottom">
			<TD><A  href="#"></A>
			<TABLE border="0" width="100%">
				<TBODY>
					<TR>
						<TD class="page_title" width="490"><A href="#"><bean:message
							key="PageContent.categories" /> &raquo;&raquo;&raquo;</A><BR>
						<BR>
						<BR>
						</TD>
					</TR>
					<TR>
						<TD valign="top">
						<TABLE border="0" width="100%">
							<TBODY>
								<%
									if (categoryList != null) {
											for (int c = 0; c < categoryList.size(); c++) {
								%>
								<TR>
									<TD colspan="2"></TD>
									<TD></TD>
								</TR>
								<TR>
									<TD><SPAN class="menu_left_strong"><IMG border="0"
										src="<%=request.getContextPath()%>/image/application/arrow.png"
										width="9" height="9"></SPAN></TD>
									<TD><A class=menu_left
										href="<%=request.getContextPath()%>/productCategoryView.do?productCategoryId=<%=((TbCategory) categoryList.get(c)).getId()%>"><B><%=((TbCategory) categoryList.get(c))
										.getCategoryName()%></B></A></TD>
									<TD></TD>
								</TR>
								<%
									subcategoryList = categoryManager
														.listSubCategory(((TbCategory) categoryList
																.get(c)).getId());
								%>
								<%
									if (subcategoryList != null) {
													for (int z = 0; z < subcategoryList.size(); z++) {
								%>
								<TR>
									<TD></TD>
									<TD><SPAN class="menu_left_strong"><IMG border="0"
										src="<%=request.getContextPath()%>/image/application/arrow.png"
										width="9" height="9"><A
										href="<%=request.getContextPath()%>/productSubcategoryView.do?productSubcategoryId=<%=((TbCategory) subcategoryList.get(z))
												.getId()%>"><%=((TbCategory) subcategoryList.get(z))
												.getCategoryName()%></A></SPAN></TD>
									<TD>(<%=((TbCategory) subcategoryList.get(z))
												.getCategoryDescription()%>) (<%=productManager
														.getProductCountByCategoryId(((TbCategory) subcategoryList
																.get(z))
																.getId())%> Adet)</TD>
								</TR>
								<%
									}
												}
								%>
								<TR>
									<TD colspan="3"></TD>
								</TR>
								<%
									}
										}
								%>
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

</BODY>
</html>
