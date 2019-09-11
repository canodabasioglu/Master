<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-9"
pageEncoding="ISO-8859-9"
%>
<%@ page import="com.odabasioglu.manager.CategoryManager"%>
<%@ page import="com.odabasioglu.data.TbCategory"%>
<%@ page import="java.util.*"%>

<%
CategoryManager categoryManager = new CategoryManager();
List categoryList = categoryManager.listMainCategory();
%>
<BODY topmargin="0" bottommargin="0" leftmargin="0" rightmargin="0">
<FORM>
<TABLE border="0" width="200">
	<TBODY>
		<TR>
			<TD><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR vAlign=top>
						<TD align="center">
						<TABLE cellSpacing=1 cellPadding=0 width="100%" bgColor=#dddddd>
							<TBODY>
								<TR>
									<TD>
									<TABLE cellSpacing=0 cellPadding=0 width="100%" bgColor=#ffffff>
										<TBODY>
											<TR>
												<TD>
												<TABLE cellSpacing=0 cellPadding=1 width="100%" border=0>
													<TBODY>
														<TR>
															<TD class=box_title vAlign=top align="center"><bean:message key="Menu.categories"/></TD>
														</TR>
													</TBODY>
												</TABLE>
												<TABLE height=1 cellSpacing=0 cellPadding=0 width="100%">
													<TBODY>
														<TR>
															<TD bgColor=#aaaaaa></TD>
														</TR>
													</TBODY>
												</TABLE>
												<BR>
												<TABLE cellSpacing=2 cellPadding=2 width="100%" border=0>
													<TBODY>
														<TR vAlign=bottom>
															<TD><A class=menu_left_strong href="<%=request.getContextPath()%>/siteManager.do?url=siteMap"><bean:message key="Menu.siteMap"/>
															&raquo;&raquo;&raquo;</A> <BR>
															<BR>
															</TD>
														</TR>
													</TBODY>
												</TABLE>
												<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
													<TBODY>
														<% if(categoryList!=null){ for (int i=0 ; i<categoryList.size(); i++) {%>
														<TR>															
															<TD>
															<SPAN class=menu_left_strong>&nbsp;<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<A class=menu_left
																href="<%=request.getContextPath()%>/productCategoryView.do?productCategoryId=<%=((TbCategory)categoryList.get(i)).getId()%>"><B><%=((TbCategory)categoryList.get(i)).getCategoryName()%></B>
															 </A></SPAN><BR><BR></TD>
															
														</TR>
														<%}}%>
													</TBODY>
												</TABLE>
												<BR>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						<A href="#"><IMG hspace="2"
							src="<%=request.getContextPath()%>/image/application/info_przesylka.gif"
							border="0" alt="<bean:message key="Menu.easyOrder"/>"></A> <A href="#"><IMG hspace="2"
							src="<%=request.getContextPath()%>/image/application/info_przesylka2.gif"
							border="0" alt="<bean:message key="Menu.quickOrder"/>"></A> <A href="#"><IMG hspace="2"
							src="<%=request.getContextPath()%>/image/application/info_przesylka3.gif"
							border="0" alt="<bean:message key="Menu.giftOrder"/>"></A> <A href="#"><IMG hspace="2"
							src="<%=request.getContextPath()%>/image/application/info_filozofia.gif"
							border="0" alt="<bean:message key="Menu.correctOrder"/>"></A><BR>
						</TD>
					</TR>
					<TR valign="top">
						<TD align="center"><BR>
						<A href="#" onClick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.yatmarketi.com');"><IMG border="0"
							src="<%=request.getContextPath()%>/image/application/home.gif"
							width="20" height="22"></A> <A href="#" onClick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.yatmarketi.com');">Ana Sayfama Ekle</A><BR>
						<A href="javascript:addbookmark()"><IMG border="0"
							src="<%=request.getContextPath()%>/image/application/favourites.gif"
							width="20" height="19"></A> <A href="javascript:addbookmark()">Sýk Kullanýlanlara Ekle</A><BR>
						<BR>
						<BR>
						<bean:message key="Menu.IP" /><%out.print( request.getRemoteAddr() );%><BR>
						<BR>
						</TD>
						</TR>
				</TBODY>
						</TABLE></TD>
		</TR>
	</TBODY>
</TABLE>

</FORM>

</BODY>
</html:html>
