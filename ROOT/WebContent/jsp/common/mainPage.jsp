<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@page import="com.odabasioglu.manager.ProductManager"%><html:html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY topmargin="0" leftmargin="0" bottommargin="0" rightmargin="0">
<%
	boolean isDBAlive = ProductManager.checkDBConnection();
%>
<TABLE width="400" border=0 height="866">
	<TBODY valign="top">
		<TR>
			<TD>
			<TABLE width="100%" border=0>
				<TBODY>
					<%
						if (!isDBAlive) {
					%>
					<TR>
						<TD colspan="4" align="center"><B><FONT size="+1"
							color="#ff0000"><bean:message key="Error.unknown" /></FONT></B></TD>
					</TR>
					<%
						}
					%>

					<TR>
						<TD align="center" width="129"><A class=light href="#"><IMG
							src="<%=request.getContextPath()%>/image/application/03000000.gif"
							width="53" height="72" border="0"><BR>
						<BR>
						Boya ve Vernikler</A><BR>
						</TD>
						<TD align="center"><A class=light href="#"><IMG
							src="<%=request.getContextPath()%>/image/application/06000000.gif"
							width="81" height="68" border="0"><BR>
						<BR>
						Elektronik �r�nler</A><BR>
						</TD>
						<TD align="center" width="147"><IMG
							src="<%=request.getContextPath()%>/image/application/11000000.gif"
							width="84" height="57" border="0"><A class=light href="#"><BR>
						<BR>
						Navigasyon</A><BR>
						</TD>
						<TD align="center" width="102"><A class=light href="#"><IMG
							src="<%=request.getContextPath()%>/image/application/10000000.gif"
							width="65" height="65" border="0"><BR>
						<BR>
						Motor Ekipmanlar�</A><BR>
						</TD>
						<TD align=center><A class=light
							href="<%=request.getContextPath()%>/siteManager.do?url=siteMap"><IMG
							hspace=2
							src="<%=request.getContextPath()%>/image/application/ico_next.gif"
							border=0 alt="T�m Kategorilere Ula�mak ��in T�klay�n�z"><BR>
						</A><BR>
						</TD>
						<TD align=center></TD>
					</TR>
				</TBODY>
			</TABLE>
			<BR>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
				<TBODY>
					<TR valign="middle">
						<TD></TD>
						<TD class=list_cat align=center width=20></TD>
						<TD align=center></TD>
						<TD class=list_cat align=center width=20></TD>
						<TD align=center></TD>
						<TD class=list_cat align=center width=20></TD>
						<TD align=center></TD>
						<TD class=list_cat align=center width=20></TD>
						<TD class=list_cat align=center width=20></TD>
						<TD class=list_cat align=center width=20></TD>
						<TD align=center></TD>
						<TD class=list_cat align=center width=20></TD>
						<TD align="right"><A class=list_cat
							href="<%=request.getContextPath()%>/siteManager.do?url=siteMap">T�m
						Kategoriler &raquo;&raquo;&raquo;</A></TD>
					</TR>
				</TBODY>
			</TABLE>
			<BR>
			<CENTER>
			<TABLE width="100%" border=0>
				<TBODY>
					<TR>
						<TD vAlign=top><IMG alt=arrow hspace=2
							src="<%=request.getContextPath()%>/image/application/arr.gif"
							align=left><SPAN class=tah8>Boya ve Vernikler -
						International Yat </SPAN>�r�nleri
						<HR>

						<TABLE style="WIDTH: 500px" cellSpacing=0 cellPadding=0 border=0>
							<TBODY>
								<TR>
									<TD vAlign="middle" align="center" width="50%"><IMG
										border="0"
										src="<%=request.getContextPath()%>/image/application/16380064_th.gif"
										width="106" height="94"></TD>
									<TD vAlign=top align=left width="50%"><B>Interstrip
									Paint Remover</B><BR>
									<BR>
									International&reg; Paint?in yeni �r�n� Interstrip Paint
									Remover, zehirli boya, astar ve vernik gibi tek bile�enli yat
									boyalar�n� ��karmak i�in haz�rlanm��t�r. Interstrip Paint
									Remover, boyay� yumu�atarak ya da kabarc�kland�rarak kolayca
									kaz�n�p ��karacak hale getirir.<BR>
									<BR>
									<A class="butonlar" href="#"><A class="butonlar" href="#">DETAY
									&raquo;</A></A></TD>
								</TR>
							</TBODY>
						</TABLE>
						<DIV id=beacon_27
							style="LEFT: 0px; VISIBILITY: hidden; POSITION: absolute; TOP: 0px"><IMG
							style="WIDTH: 0px; HEIGHT: 0px" height=0 alt="#"
							src="<%=request.getContextPath()%>/image/application/adlog.gif"
							width=0></DIV>
						</TD>
					</TR>
					<TR>
						<TD width="100%">
						<TABLE cellSpacing=5 width="100%" border=0>
							<TBODY>
								<TR>
									<TD vAlign=top>
									<DIV style="WIDTH: 250px" align=left><IMG alt=arrow
										hspace=2
										src="<%=request.getContextPath()%>/image/application/arr.gif"
										align=left><SPAN class=tah8>Garmin El Tipi GPS</SPAN>
									<HR>


									<DIV align="right">60 - 24 Mb. Dahili Haf�za<BR>
									6,1x15,5 cm,<BR>
									Su Ge�irmez Kasa <BR>
									28 Saat Pil �mr�<BR>
									A��rl�k : 153 Gr.<BR>
									50 Adet Rota <BR>
									1000 Waypoint Noktas� Kaydedebilme<BR>
									<BR>
									<DIV style="TEXT-ALIGN: right"><A class="butonlar"
										href="#">DETAY &raquo;</A></DIV>
									</DIV>
									</DIV>
									<DIV id=beacon_24
										style="LEFT: 0px; VISIBILITY: hidden; POSITION: absolute; TOP: 0px"></DIV>
									</TD>
									<TD vAlign=top align=right><!-- STREFA 2b -->
									<DIV style="WIDTH: 240px; TEXT-ALIGN: justify"><IMG
										alt=arrow hspace=2
										src="<%=request.getContextPath()%>/image/application/arr.gif"
										align=left><SPAN class=tah8>Garmin Bal�k Bulucu</SPAN>
									<HR>


									</DIV>

									<DIV id=beacon_23
										style="LEFT: 0px; VISIBILITY: hidden; POSITION: absolute; TOP: 0px"><IMG
										style="WIDTH: 0px; HEIGHT: 0px" height="0" alt="#"
										src="<%=request.getContextPath()%>/image/application/adlog(2).gif"
										width="0"></DIV>
									Ekran 16X15,7 cm. Frekans 50/500 kHz. (10 Derece) <BR>
									450mt. Derinlik 40 Derece konik a��<BR>
									Derinlik-S�� Su ve Bal�k alarm� <BR>
									Su S�cakl��� ve Su ak�� h�z� G�sterme <BR>
									500 W. (Peak to Peak) ��k�� G�c� <BR>
									3 Farkl� boyda bal�k tan�mlama <BR>
									TFT Renkli Ekran - 320 Pixel Ekran ��z�n�rl���<BR>
									<BR>
									<DIV style="TEXT-ALIGN: right"><A class="butonlar"
										href="#">DETAY &raquo;</A></DIV>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						</TD>
					</TR>
					<TR>
						<TD align=center>
						<TABLE cellSpacing=10 width="100%" border=0>
							<TBODY>
								<TR>
									<TD vAlign=top align=left>
									<TABLE style="WIDTH: 150px" cellSpacing=0 cellPadding=0>
										<TBODY>
											<TR>
												<TD><IMG alt=arrow hspace=2
													src="<%=request.getContextPath()%>/image/application/arr.gif"
													align=left><SPAN class=tah8>G�verte
												Ekipmanlar�</SPAN>
												<HR>
												</TD>
											</TR>
											<TR>
												<TD style="HEIGHT: 100px" valign="middle" align=center><IMG
													border="0"
													src="<%=request.getContextPath()%>/image/application/16380061_th.gif"
													width="85" height="81"></TD>
											</TR>
											<TR>
												<TD align="center">Klasik D�men Simidi<BR>
												<BR>
												�ap 70 cm. <BR>
												<BR>
												425.00 YTL<BR>
												<BR>
												<A class="butonlar" href="#">DETAY &raquo;</A><BR>
												<DIV style="TEXT-ALIGN: right" align="center"><A
													class="butonlar" href="#"></A></DIV>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
									<DIV id=beacon_21
										style="LEFT: 0px; VISIBILITY: hidden; POSITION: absolute; TOP: 0px"><IMG
										style="WIDTH: 0px; HEIGHT: 0px" height="0" alt="#"
										src="<%=request.getContextPath()%>/image/application/adlog(3).gif"
										width="0"></DIV>
									</TD>
									<TD vAlign=top align=center>
									<TABLE style="WIDTH: 150px" cellSpacing=0 cellPadding=0>
										<TBODY>
											<TR>
												<TD><IMG alt=arrow hspace=2
													src="<%=request.getContextPath()%>/image/application/arr.gif"
													align=left><SPAN class=tah8></SPAN>R�ht�m Ekipmanlar�
												<HR>
												</TD>
											</TR>
											<TR>
												<TD style="HEIGHT: 100px" valign="middle" align=center><IMG
													border="0"
													src="<%=request.getContextPath()%>/image/application/16380062_th.gif"
													width="85" height="81"></TD>
											</TR>
											<TR>
												<TD align="center">Galvanizli �apa<BR>
												<BR>
												Danford<BR>
												<BR>
												4,5 Kg<BR>
												<BR>
												105.20 YTL<BR>
												<BR>
												<A class="butonlar" href="#">DETAY &raquo;</A>
												<DIV style="TEXT-ALIGN: right"><A class="butonlar"
													href="#"><BR>
												</A></DIV>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
									<DIV id=beacon_18
										style="LEFT: 0px; VISIBILITY: hidden; POSITION: absolute; TOP: 0px"><IMG
										style="WIDTH: 0px; HEIGHT: 0px" height="0" alt="#"
										src="<%=request.getContextPath()%>/image/application/adlog(4).gif"
										width="0"></DIV>
									</TD>
									<TD vAlign=top align=right>
									<TABLE style="WIDTH: 150px" cellSpacing=0 cellPadding=0>
										<TBODY>
											<TR>
												<TD><IMG alt=arrow hspace=2
													src="<%=request.getContextPath()%>/image/application/arr.gif"
													align=left><SPAN class=tah8>Elektrik
												Malzemeleri</SPAN>
												<HR>
												</TD>
											</TR>
											<TR>
												<TD style="HEIGHT: 100px" valign="middle" align=center><IMG
													border="0"
													src="<%=request.getContextPath()%>/image/application/16380063_th.gif"
													width="85" height="81"></TD>
											</TR>
											<TR>
												<TD align="center">TMC Sintine Pompas�<BR>
												<BR>
												3000Ghp. 24V.<BR>
												<BR>
												121.43 YTL<BR>
												<BR>
												<A class="butonlar" href="#">DETAY &raquo;</A><BR>
												<DIV style="TEXT-ALIGN: right"><A class="butonlar"
													href="#"></A></DIV>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
									<DIV id=beacon_22
										style="LEFT: 0px; VISIBILITY: hidden; POSITION: absolute; TOP: 0px"><IMG
										style="WIDTH: 0px; HEIGHT: 0px" height="0" alt="#"
										src="<%=request.getContextPath()%>/image/application/adlog(5).gif"
										width="0"></DIV>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</CENTER>
			</TD>


		</TR>
	</TBODY>
</TABLE>
</BODY>
</html:html>
