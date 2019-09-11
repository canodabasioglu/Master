<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>
<%@ page import="com.odabasioglu.data.TbCurrency"%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.utility.PagerUtility"%>
<%@ page import="com.odabasioglu.config.SystemConstants"%>

<%TbParameters parameters = ParametersManager.getParameter(Integer.valueOf(request.getParameter("id")));%>


<%@page import="com.odabasioglu.data.TbParameters"%>
<%@page import="com.odabasioglu.manager.ParametersManager"%><html:html>
<SCRIPT language="JavaScript">
function onFormSubmit(){

			
		form.submit();
		return true;
	}
</SCRIPT>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY  leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">
<FORM name="form" method="post"	action="<%=request.getContextPath()%>/parameterUpdate.do" >
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
									<TD colspan="5"><bean:message key="Admin.currency.details" /></TD>
								</TR>
								<TR>
									<TD colspan="5"><%=com.odabasioglu.utility.MessageUtility.getMessage(request.getAttribute("message"))%></TD>
								</TR>
								<TR>
									<TD width="110"><bean:message key="Admin.parameters.name" /></TD>
									<TD width="110"><bean:message key="Admin.parameters.value" /></TD>
									<TD width="110"><bean:message key="Admin.parameters.condition" /></TD>
									<TD width="110"><bean:message key="Admin.parameters.custom" /></TD>
								
								</TR>
								<TR>
									<TD><%=parameters.getName()%><INPUT type="hidden" size="30" name="name" maxlength="10" value="<%=parameters.getName()%>"><INPUT type="hidden" size="30" name="id" maxlength="10" value="<%=parameters.getId()%>"></TD>
									<TD><INPUT type="text" size="30" name="value"  value="<%=parameters.getValue()%>"></TD>
									
									<TD><INPUT type="text" size="30" name="condition" value="<%=parameters.getCondition()%>"></TD>
									<TD><INPUT type="text" size="5" name="custom"  value="<%=parameters.getCustom()%>"></TD>
									
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
