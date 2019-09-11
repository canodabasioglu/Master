<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-9"
pageEncoding="ISO-8859-9"
%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.data.TbUsers"%>
<%@ page import="com.odabasioglu.data.TbNews"%>
<%@ page import="com.odabasioglu.data.TbCurrency"%>
<%@ page import="com.odabasioglu.data.TbTopsales"%>
<%@ page import="com.odabasioglu.data.TbLastvisit"%>

<%@ page import="com.odabasioglu.manager.CurrencyManager"%>
<%@ page import="com.odabasioglu.manager.NewsManager"%>
<%@ page import="com.odabasioglu.manager.ProductManager"%>

<%TbUsers user = (TbUsers) session.getAttribute("user");

//SET TOPSALES
List listTopSales = ProductManager.listTopSales();
//SET CURRENCY
TbCurrency currency = CurrencyManager.getTodaysCurrency();
//SET NEWS
List listNews = NewsManager.listNews();
//SET LASTVISIT
List lastvisit = ProductManager.listLastvisit(user.getId(),null);
%>

<BODY>
<TABLE border="0" width="200">
	<TBODY>
		<TR>
			<TD>
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
												<TD class="box_title" valign="top" align="center"><bean:message
													key="Menu.info" /></TD>
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
									<TABLE cellSpacing=0 cellPadding=4 width="100%">
										<TBODY>
											<TR>
												<TD align="left">
												<TABLE cellSpacing=2 cellPadding=0 width="100%" border=0>
													<TBODY>
														<TR>
															<TD align="center"><FONT color="#ff8000"><%=com.odabasioglu.utility.ConverterUtility.getCurrentDate()%><BR>
															</FONT><BR>
															</TD>
														</TR>
														<TR>
															<TD><bean:message key="Menu.Currency.dollar" /><B><%=currency.getUsd()%></B>
															<bean:message key="Menu.Currency.euro" /><B><%=currency.getEuro()%></B><BR>
															<BR>
															</TD>
														</TR>
														<TR>
															<TD><FONT color="#ff8000"> </FONT>Sn. &nbsp;<A
																href="<%=request.getContextPath()%>/siteManager.do?url=userUpdate"><%=user.getName()%>
															<%=user.getSurname()%><BR>
															</A></TD>
														</TR>
														<TR>
															<TD><bean:message key="Menu.lastLogin" /> <%=com.odabasioglu.utility.ConverterUtility.getShortDateTime(user.getLoginDate())%>
															<BR>
															<BR>
															</TD>
														</TR>
														<TR>
															<TD></TD>
														</TR>
														<TR>
															<TD align=right><A class=light
																href="<%=request.getContextPath()%>/siteManager.do?url=orderLines"><bean:message
																key="Menu.user.orderlines" /></A> <IMG hspace=2
																src="<%=request.getContextPath()%>/image/application/icon_mini_delivery.gif"
																border=0></TD>
														</TR>
														<TR>
															<TD align=right><A class=light
																href="<%=request.getContextPath()%>/siteManager.do?url=favourites"><bean:message
																key="Menu.user.favourites" /></A> <IMG hspace=2
																src="<%=request.getContextPath()%>/image/application/icon_mini_int.gif"
																border=0></TD>
														</TR>
														<TR>
															<TD align=right><A class=light
																href="<%=request.getContextPath()%>/siteManager.do?url=orders"><bean:message
																key="Menu.user.orders" /></A> <IMG hspace=2
																src="<%=request.getContextPath()%>/image/application/icon_mini_help.gif"
																border=0></TD>
														</TR>
														<TR>
															<TD align=right><A class="light"
																href="<%=request.getContextPath()%>/siteManager.do?url=points"><bean:message
																key="Menu.user.points" /></A> <IMG hspace="2"
																src="<%=request.getContextPath()%>/image/application/icon_mini_int.gif"
																border="0"></TD>
														</TR>
														<TR>
															<TD align="right"><A class="light"
																href="<%=request.getContextPath()%>/siteManager.do?url=addressList"><bean:message
																key="Menu.user.address" /></A> <IMG hspace="2"
																src="<%=request.getContextPath()%>/image/application/icon_mini_mail.gif"
																border="0"></TD>
														</TR>
														<TR>
															<TD align="right"><A class="light"
																href="<%=request.getContextPath()%>/siteManager.do?url=userUpdate"><bean:message
																key="Menu.user.info" /></A> <IMG hspace="2"
																src="<%=request.getContextPath()%>/image/application/icon_mini_mail.gif"
																border="0"></TD>
														</TR>
														<TR>
															<TD align="right"><BR>
															<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/ico_tel.gif"
																width="20" height="20"><bean:message
																key="Menu.telephoneNo" /></TD>
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
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<BR>
			<DIV id=beacon_2
				style="LEFT: 0px; VISIBILITY: hidden; POSITION: absolute; TOP: 0px"><IMG
				style="WIDTH: 0px; HEIGHT: 0px" height="0" alt="#"
				src="<%=request.getContextPath()%>/image/application/adlog(6).gif" width="0"></DIV>
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
												<TD class="box_title" valign="top" align="center"><bean:message
													key="Menu.news" /></TD>
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
									<TABLE cellSpacing=0 cellPadding=4 width="100%">
										<TBODY>
											<TR>
												<TD>
												<TABLE cellSpacing=2 cellPadding=0 width="100%" border=0>
													<TBODY>
														<TR>
															<TD align="center"><script type="text/javascript">

var scrollerdelay='10000' //delay between msg scrolls. 3000=3 seconds.
var scrollerwidth='100%'
var scrollerheight='160px'
var scrollerbgcolor='#ffffff'
var scrollerbackground='scrollerback.gif'
var messages=new Array()

<%for (int i = 0; i < listNews.size(); i++) {%>
messages[<%=i%>]="<B><%=((TbNews) listNews.get(i)).getTitle()%></B><BR><BR><%=((TbNews) listNews.get(i)).getNewsdescription()%>"
<%}%>
var ie=document.all
var dom=document.getElementById
if (messages.length>2)
i=2
else
i=0
function move(whichdiv){
tdiv=eval(whichdiv)
if (parseInt(tdiv.style.top)>0&&parseInt(tdiv.style.top)<=5){
tdiv.style.top=0+"px"
setTimeout("move(tdiv)",scrollerdelay)
setTimeout("move2(second2_obj)",scrollerdelay)
return
}
if (parseInt(tdiv.style.top)>=tdiv.offsetHeight*-1){
tdiv.style.top=parseInt(tdiv.style.top)-5+"px"
setTimeout("move(tdiv)",50)
}
else{
tdiv.style.top=parseInt(scrollerheight)+"px"
tdiv.innerHTML=messages[i]
if (i==messages.length-1)
i=0
else
i++
}
}
function move2(whichdiv){
tdiv2=eval(whichdiv)
if (parseInt(tdiv2.style.top)>0&&parseInt(tdiv2.style.top)<=5){
tdiv2.style.top=0+"px"
setTimeout("move2(tdiv2)",scrollerdelay)
setTimeout("move(first2_obj)",scrollerdelay)
return
}
if (parseInt(tdiv2.style.top)>=tdiv2.offsetHeight*-1){
tdiv2.style.top=parseInt(tdiv2.style.top)-5+"px"
setTimeout("move2(second2_obj)",50)
}
else{
tdiv2.style.top=parseInt(scrollerheight)+"px"
tdiv2.innerHTML=messages[i]
if (i==messages.length-1)
i=0
else
i++
}
}
function startscroll(){
first2_obj=ie? first2 : document.getElementById("first2")
second2_obj=ie? second2 : document.getElementById("second2")
move(first2_obj)
second2_obj.style.top=scrollerheight
second2_obj.style.visibility='visible'
}
if (ie||dom){
document.writeln('<div id="main2" style="position:relative;width:'+scrollerwidth+';height:'+scrollerheight+';overflow:hidden;background-color:'+scrollerbgcolor+' ;background-image:url('+scrollerbackground+')">')
document.writeln('<div style="position:absolute;width:'+scrollerwidth+';height:'+scrollerheight+';clip:rect(0 '+scrollerwidth+' '+scrollerheight+' 0);left:0px;top:0px">')
document.writeln('<div id="first2" style="position:absolute;width:'+scrollerwidth+';left:0px;top:1px;">')
document.write(messages[0])
document.writeln('</div>')
document.writeln('<div id="second2" style="position:absolute;width:'+scrollerwidth+';left:0px;top:0px;visibility:hidden">')
document.write(messages[dyndetermine=(messages.length==1)? 0 : 1])
document.writeln('</div>')
document.writeln('</div>')
document.writeln('</div>')
}
if (window.addEventListener)
window.addEventListener("load", startscroll, false)
else if (window.attachEvent)
window.attachEvent("onload", startscroll)
else if (ie||dom)
window.onload=startscroll
</script></TD>
														</TR>
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
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR vAlign=bottom>
						<TD align=center></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR vAlign=bottom>
						<TD align=center><BR>
						<TABLE cellspacing="1" cellpadding="0" width="100%"
							bgcolor="#dddddd">
							<TBODY>
								<TR>
									<TD>
									<TABLE cellspacing="0" cellpadding="0" width="100%"
										bgcolor="#ffffff">
										<TBODY>
											<TR>
												<TD>
												<TABLE cellspacing="0" cellpadding="1" width="100%"
													border="0">
													<TBODY>
														<TR>
															<TD class="box_title" valign="top" align="center"><bean:message
																key="Menu.topSeller" /></TD>
														</TR>
													</TBODY>
												</TABLE>
												<TABLE height="1" cellspacing="0" cellpadding="0"
													width="100%">
													<TBODY>
														<TR>
															<TD bgcolor="#aaaaaa"></TD>
														</TR>
													</TBODY>
												</TABLE>
												<TABLE cellspacing="0" cellpadding="4" width="100%">
													<TBODY>
														<TR>
															<TD>
															<TABLE cellspacing="2" cellpadding="0" width="100%"
																border="0">
																<TBODY>
																	<TR>
																		<TD align="left">
																	<TR>
																		<TD class="yuzde" width="10%" colspan="4"></TD>
																	</TR>
																	<%for (int i = 0; i < listTopSales.size(); i++) {%>
																	<TR>
																		<TD class="yuzde"><A href="<%=request.getContextPath()%>/productDetailsView.do?productId=<%=((TbTopsales) listTopSales.get(i)).getProduct().getId()%>"><%=com.odabasioglu.utility.ConverterUtility.getDisplaySize(
																		((TbTopsales) listTopSales.get(i)).getProduct().getName(),10)%></A></TD>
																		<TD class="yuzde"></TD>
																		<TD class="yuzde"><IMG border="0"
																			src="<%=request.getContextPath()%>/image/application/percentage.gif"
																			height="16"	width="<%=((TbTopsales) listTopSales.get(i)).getPercentage()%>"></TD>
																		<TD class="yuzde"><B><%=((TbTopsales) listTopSales.get(i)).getPercentage()%>
																		%</B></TD>
																	</TR>
																	<%}%>

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
								</TR>
							</TBODY>
						</TABLE>
						</TD>
					</TR>
				</TBODY>
			</TABLE>

			<SPAN class=light></SPAN>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR vAlign=bottom>
						<TD align=center><BR>
						<TABLE cellspacing="1" cellpadding="0" width="100%"
							bgcolor="#dddddd">
							<TBODY>
								<TR>
									<TD>
									<TABLE cellspacing="0" cellpadding="0" width="100%"
										bgcolor="#ffffff">
										<TBODY>
											<TR>
												<TD>
												<TABLE cellspacing="0" cellpadding="1" width="100%"
													border="0">
													<TBODY>
														<TR>
															<TD class="box_title" valign="top" align="center"><bean:message
																key="Menu.lastvisit" /></TD>
														</TR>
													</TBODY>
												</TABLE>
												<TABLE height="1" cellspacing="0" cellpadding="0"
													width="100%">
													<TBODY>
														<TR>
															<TD bgcolor="#aaaaaa"></TD>
														</TR>
													</TBODY>
												</TABLE>
												<TABLE cellspacing="0" cellpadding="4" width="100%">
													<TBODY>
														<TR>
															<TD>
															<TABLE cellspacing="2" cellpadding="0" width="100%"
																border="0">
																<TBODY>
																	<TR>
																		<TD align="left">
																	<TR>
																		<TD colspan="2"></TD>
																	</TR>
																	<%if (lastvisit != null) {
	for (int i = 0;
		i
			< com.odabasioglu.utility.PagerUtility.getLastVisitSize(
				lastvisit.size());
		i++) {%>
																	<TR>
																		<TD class="yuzde"><IMG border="0"
																			src="<%=request.getContextPath()%>/image/application/arr.gif"
																			width="13" height="13"></TD>
																		<TD class="yuzde"><A
																			href="<%=request.getContextPath()%>/productDetailsView.do?productId=<%=((TbLastvisit) lastvisit.get(i)).getProduct().getId()%>"><%=((TbLastvisit) lastvisit.get(i)).getProduct().getName()%></A>
																		&nbsp;</TD>
																	</TR>
																	<%}
} else {%>
																	<TR>
																		<TD class="yuzde"><bean:message
																			key="Error.lastvisit.noProduct" /></TD>

																	</TR>
																	<%}%>
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
								</TR>
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
</html:html>