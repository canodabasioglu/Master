<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.manager.CurrencyManager"%>
<%CurrencyManager currencyManager = new CurrencyManager();
List currencyList = currencyManager.listCurrency();
request.setAttribute( "currencyList", currencyList );
%>

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
<FORM name="form" method="post"
	action="<%=request.getContextPath()%>/currencyCreate.do" >
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

						<TABLE width="440" border="0">
							<TBODY>
								<TR>
									<TD colspan="5"></TD>
								</TR>
								<TR>
									<TD colspan="5"><%=com.odabasioglu.utility.MessageUtility.getMessage(request.getAttribute("message"))%></TD>
								</TR>
								<TR>
									<TD width="80"><bean:message key="Admin.currency.date" /></TD>
									<TD width="80"><bean:message key="Admin.currency.usd" /></TD>
									<TD width="80"><bean:message key="Admin.currency.euro" /></TD>
									<TD width="80"><bean:message key="Admin.currency.status" /></TD>
									<TD width="120"><bean:message key="Admin.button.delete" /></TD>
								</TR>
								<TR>
									<TD><%=com.odabasioglu.utility.ConverterUtility.getShortDate(new Date())%></TD>
												<TD><INPUT type="text" size="4" name="usd" maxlength="6"></TD>
												<TD><INPUT type="text" size="4"
													name="euro" maxlength="6"></TD>
												<TD><SELECT name="status">
													<OPTION value="1" selected>Aktif</OPTION>
													<OPTION value="0">Pasif</OPTION>
												</SELECT></TD>
												<TD><A class="butonlar" href="#" onclick="onFormSubmit()"><bean:message
										key="Menu.create.button" /></A></TD>
								</TR>
								
							<display:table name="currencyList" pagesize="20" >
  							<display:caption><bean:message key="Admin.currency.title" /></display:caption>
  							<display:column property="currencyDate" title="Kur Tarihi" sortable="true" headerClass="sortable" format="{0,date,dd/MM/yyyy}"/>
  							<display:column property="euro" title="Euro" sortable="true" headerClass="sortable" />
  							<display:column property="usd" title="Dolar" sortable="true" headerClass="sortable" />  		
  							<display:column paramProperty="id" url="/jsp/admin/currency_details.jsp?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/edit.gif"></display:column>     
							<display:column paramProperty="id" url="/currencyDelete.do?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/sil.gif"></display:column>
  							
  							
  							</display:table>
								
								
							
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
