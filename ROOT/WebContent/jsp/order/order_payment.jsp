<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.odabasioglu.config.SystemConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>

<%@page import="java.util.List"%>
<%@page import="com.odabasioglu.manager.ListOfValueManager"%>
<%@page import="com.odabasioglu.data.TbLov"%>
<%@page import="com.odabasioglu.manager.ParametersManager"%>
<%@page import="com.odabasioglu.data.TbParameters"%><html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<SCRIPT language="JavaScript">

		function onFormSubmit(){
		if(!isRadioChecked(paymentForm.paymentType,MSG_PAYMENT_TYPE)){			
			}
			else{
		paymentForm.action="<%=request.getContextPath()%>/orderCreate.do";
		paymentForm.submit();
		} }
</SCRIPT>
<BODY leftMargin=0 topMargin=0 rightmargin="0" bottommargin="0">

<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD><jsp:include page="/jsp/user/layout/user_toppane.jsp"
				flush="true" /></TD>
		</TR>
		<TR vAlign=top>
			<TD>
			<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
				<TBODY>
					<TR vAlign=top>
						<TD align="left" width="200"><jsp:include
							page="/jsp/user/layout/user_leftpane.jsp" flush="true" /></TD>
						<TD width="20">&nbsp;</TD>
						<TD valign="top" align="center">
						<TABLE cellspacing="0" cellpadding="0" border="0" width="100%">
							<TBODY>
								<TR>
									<TD width="580" valign="top" align="center">
									<TABLE border="0" width="100%">
										<TBODY>
											<TR>
												<TD colspan="6" class="topmenu">
												<FORM name="paymentForm" method="post">
												<TABLE border="0" width="100%">
													<TBODY>
														<TR>
															<TD colspan="6" class="topmenu"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/arrow.png"
																width="9" height="9">&nbsp;<bean:message
																key="Payment.Header.message" /></TD>
														</TR>
														<TR>
															<TD class="topmenu" colspan="6"><bean:message
																key="Payment.Header.description" /> <bean:message
																key="Payment.Header.select" /></TD>
														</TR>
														<TR>
															<TD class="topTitle" width="46" colspan="6"><IMG
																border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1"></TD>
														</TR><%List paymentTypeList = ListOfValueManager.paymentTypeList();%>
														<%for (int i = 0; i < paymentTypeList.size(); i++) {%>
														<TR><TD width="46"><INPUT type="radio"
																name="paymentType" value="<%=((TbLov) paymentTypeList.get(i)).getValue()%>"></TD>
															<TD colspan="5" width="454"><%=((TbLov) paymentTypeList.get(i)).getLabel()%></TD>															
														</TR>
														<%}%>
														<TR>
															<TD width="46" colspan="6"><IMG border="0"
																src="<%=request.getContextPath()%>/image/application/spacer6.gif"
																height="1"></TD>
														</TR>
														<TR>
															<TD class="topTitle" align="right" colspan="6"><A
																class="butonlar" href="#" onclick="onFormSubmit()"><bean:message
																key="Order.continue.button" /></A></TD>
														</TR>
														<TR>
															<TD class="topTitle" align="center" colspan="6"><IMG
																border="0"
																src="<%=request.getContextPath()%>/image/application/payment.gif"
																width="80" height="85"></TD>
														</TR>


														<%List accountNumber = ParametersManager.parameterByName("AccountNumber");%>
														<TR>
															<TD class="topTitle" align="center" colspan="6"><b>Banka
															Hesap Numaralarýmýz</b>
															</TD>
															</TR>
															
															
															<TR><TD class="topTitle" align="center" colspan="6">
															<IMG border="0"
																src="<%=request.getContextPath()%>/image/application/ortak_odeme.gif">
															</TD>
															</TR>


													
													</TBODY>
												</TABLE><br/><br/>
															<%for (int j = 0; j < accountNumber.size(); j++) {%>														
															<LI><%=((TbParameters) accountNumber.get(j)).getValue()%></LI>
															<br/>	<br/>												 
															<%}%>	
												</FORM>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						</TD>
						<TD width="20"></TD>
						<TD valign="top" width="200"><jsp:include
							page="/jsp/user/layout/user_rightpane.jsp" flush="true" /></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		<TR>
			<TD align="center"><jsp:include
				page="/jsp/guest/layout/guest_bottompane.jsp" flush="true" /></TD>
		</TR>
	</TBODY>
</TABLE>

</BODY>
</html:html>
