<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-9"
pageEncoding="ISO-8859-9"
%>
<BODY topmargin="0" bottommargin="0" leftmargin="0" rightmargin="0">
<TABLE border="0" width="200">
	<TBODY>
		<TR>
			<TD>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
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
															<TD class=box_title vAlign=top align="center">SYSTEM MENU</TD>
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
															<TD>ADMINISTRATOR<BR>
															<BR>
															</TD>
														</TR>
													</TBODY>
												</TABLE>
												<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
													<TBODY>
														<TR>
															<SPAN class=menu_left_strong>&nbsp;<IMG
																border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<A class=menu_left
																href="<%=request.getContextPath()%>/siteManager.do?url=contact"><B>Kullan�c�
															Listesi</B></A></SPAN><BR>
															<BR>
																<SPAN class=menu_left_strong>&nbsp;<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<A class=menu_left href="<%=request.getContextPath()%>/siteManager.do?url=news"><B>Haberler</B>
															</A></SPAN>
															<BR>
															<BR>
															<SPAN class=menu_left_strong>&nbsp;<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<A class=menu_left href="<%=request.getContextPath()%>/siteManager.do?url=currency"><B>D�viz
															Kurlar�</B> </A></SPAN>
															<BR>
															<BR>
															<SPAN class=menu_left_strong>&nbsp;<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<A class=menu_left
																href="<%=request.getContextPath()%>/siteManager.do?url=category"><B>Kategoriler</B>
															</A></SPAN><BR>
															<BR>
															<SPAN class=menu_left_strong>&nbsp;<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<A class=menu_left href="<%=request.getContextPath()%>/siteManager.do?url=product"><B>�r�nler</B></A>
															</SPAN><BR>														
															<BR>
															<SPAN class=menu_left_strong>&nbsp;<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<A class=menu_left href="<%=request.getContextPath()%>/siteManager.do?url=order"><B>Sipari�
															Bilgileri</B> </A></SPAN>
															<BR>
															<BR>
															<SPAN class=menu_left_strong>&nbsp;<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<A class=menu_left href="#"><B>�deme
															Bilgileri</B> </A></SPAN>
															<BR>
															<BR>
															
															<SPAN class=menu_left_strong>&nbsp;<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<A class=menu_left href="<%=request.getContextPath()%>/siteManager.do?url=campaign"><B>�ok
															Sat�lanlar</B> </A></SPAN>
															<BR>
															<BR>
															
															<SPAN class=menu_left_strong>&nbsp;<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<A class=menu_left href="<%=request.getContextPath()%>/siteManager.do?url=log"><B>Sistem Loglar�</B> </A></SPAN>
															<BR>
															<BR>
															<SPAN class=menu_left_strong>&nbsp;<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<A class=menu_left href="<%=request.getContextPath()%>/siteManager.do?url=role"><B>Rol</B></A> ve <A class=menu_left href="<%=request.getContextPath()%>/siteManager.do?url=right"><B>Haklar</B> </A></SPAN>
															
															<BR>
															<BR>
															<SPAN class=menu_left_strong>&nbsp;<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<A class=menu_left href="<%=request.getContextPath()%>/siteManager.do?url=parameters"><B>Parametreler</B> </A><BR>
															</SPAN>
															<BR>
															<BR>
														</TR>
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
							border="0" alt="Zahmetsiz - Kap�n�za �r�n Teslimat�"></A> <A
							href="#"><IMG hspace="2"
							src="<%=request.getContextPath()%>/image/application/info_przesylka2.gif"
							border="0" alt="H�zl� - Birka� dakikada yorulmadan al��veri�"></A>
						<A href="#"><IMG hspace="2"
							src="<%=request.getContextPath()%>/image/application/info_przesylka3.gif"
							border="0" alt="Hediyeli - Al��veri� yapt�k�a puan kazanma"></A>
						<A href="#"><IMG hspace="2"
							src="<%=request.getContextPath()%>/image/application/info_filozofia.gif"
							border="0" alt="Do�ru �r�n - �r�nlerle ilgili detayl� bilgiler"></A><BR>
						</TD>
					</TR>
					<TR valign="top">
						<TD align="center"><BR>
						<B>IP'niz :</B> <%out.print(request.getRemoteAddr());%></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</html:html>
