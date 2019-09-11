<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">

<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD><jsp:include page="/jsp/guest/layout/guest_toppane.jsp" flush="true" /></TD>
		</TR>
		<TR vAlign=top>
			<TD>
			<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
				<TBODY>
					<TR vAlign=top>
						<TD align="left" width="200"><jsp:include page="/jsp/guest/layout/guest_leftpane.jsp" flush="true" /></TD>
						<TD width="20">&nbsp;</TD>
						<TD valign="top" align="center">
						<TABLE cellspacing="0" cellpadding="0" border="0" width="100%">
							<TBODY>
								<TR>
									<TD width="608" valign="top" align="center">
										<FORM name="form" method="post"	action="<%=request.getContextPath()%>/passwordReminder.do"	>
									<TABLE border="0" width="557">
										<TBODY>
											<TR>
												<TD colspan="3" width="31%" align="center"><jsp:include
													page="jsp/common/mainPage.jsp" flush="true" /></TD>
											</TR>
										</TBODY>
									</TABLE>
									</FORM>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						</TD>
						<TD width="20"></TD>
						<TD valign="top" width="200"><jsp:include page="/jsp/guest/layout/guest_rightpane.jsp"  flush="true" /></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		
		<TR>
			<TD align="center"><jsp:include page="/jsp/guest/layout/guest_bottompane.jsp" flush="true" /></TD>
		</TR>
	</TBODY>
</TABLE>

</BODY>
</html:html>
