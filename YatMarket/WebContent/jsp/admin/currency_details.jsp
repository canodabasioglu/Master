<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.CurrencyManager"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>
<%@ page import="com.odabasioglu.data.TbCurrency"%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.utility.PagerUtility"%>
<%@ page import="com.odabasioglu.config.SystemConstants"%>

<%TbCurrency currency = CurrencyManager.getCurrency(Integer.valueOf(request.getParameter("id")));%>

<html:html>
<SCRIPT language="JavaScript">
function onFormSubmit(){

			
		if(!isValid(CURRENCY,form.usd.value)){
			alert(MSG_CURRENCY);
			form.usd.select();
			return false;
		}
		if(!isValid(CURRENCY,form.euro.value)){
			alert(MSG_CURRENCY);
			form.euro.select();
			return false;
		}
		form.submit();
		return true;
	}
</SCRIPT>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY  leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">
<FORM name="form" method="post"	action="<%=request.getContextPath()%>/currencyUpdate.do" >
<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD><jsp:include page="/jsp/admin/layout/admin_toppane.jsp"
				flush="true" /></TD>
		</TR>
		<TR vAlign=top>
			<TD>
			<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
				<TBODY>
					<TR vAlign=top>
						<TD align="left" width="200"><jsp:include
							page="/jsp/admin/layout/admin_leftpane.jsp" flush="true" /></TD>
						<TD width="20">&nbsp;</TD>
						<TD valign="top" align="left" colspan="3">

						<TABLE width="340" border="0">
							<TBODY>
								<TR>
									<TD colspan="5"><bean:message key="Admin.currency.details" /></TD>
								</TR>
								<TR>
									<TD colspan="5"><%=com.odabasioglu.utility.MessageUtility.getMessage(request.getAttribute("message"))%></TD>
								</TR>
								<TR>
									<TD width="60"><bean:message key="Admin.currency.date" /></TD>
									<TD width="60"><bean:message key="Admin.currency.usd" /></TD>
									<TD width="60"><bean:message key="Admin.currency.euro" /></TD>									
									<TD width="60"><bean:message key="Admin.currency.status" /></TD>
									<TD width="100"></TD>
								
								</TR>
								<TR>
									<TD valign="top"><INPUT type="hidden" name="currencyId"  value="<%=currency.getId()%>"><INPUT type="text" size="7" name="currencyDate"
										maxlength="10" value="<%=currency.getCurrencyDate()%>"></TD>
									
									<TD><INPUT type="text" size="4" name="usd" maxlength="6" value="<%=currency.getUsd()%>"></TD>
									<TD><INPUT type="text" size="4" name="euro" maxlength="6" value="<%=currency.getEuro()%>"></TD>
									<TD valign="top"><SELECT name="status">
										<OPTION value="<%=currency.getStatus()%>" selected><%=com.odabasioglu.utility.ConverterUtility.getStatus(currency.getStatus())%></OPTION>
										<OPTION value="<%=com.odabasioglu.config.SystemConstants.STATUS_PASSIVE%>"><%=ConverterUtility
											.getStatus(SystemConstants.STATUS_PASSIVE)%></OPTION>
										<OPTION value="<%=com.odabasioglu.config.SystemConstants.STATUS_ACTIVE%>"><%=ConverterUtility
											.getStatus(SystemConstants.STATUS_ACTIVE)%></OPTION>
									</SELECT></TD>
									<TD valign="top"><A class="butonlar" href="#" onclick="onFormSubmit()"><bean:message
										key="Menu.create.button" /></A></TD>
									
								</TR>
						
								
								<TR>
									
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
