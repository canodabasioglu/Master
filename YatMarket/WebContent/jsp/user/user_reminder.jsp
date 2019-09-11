<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<SCRIPT language="JavaScript">
	function onFormSubmit() {

		if (!isValid(EMAIL, form.email.value)) {
			alert(MSG_EMAIL);
			form.email.select();
			return false;
		}
		form.submit();
		return true;
		
	}
</SCRIPT>
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0" onkeypress="onEnter(event);">

<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD><jsp:include page="/jsp/guest/layout/guest_toppane.jsp"
				flush="true" /></TD>
		</TR>
		<TR vAlign=top>
			<TD>
			<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
				<TBODY>
					<TR vAlign=top>
						<TD align="left" width="200"><jsp:include
							page="/jsp/guest/layout/guest_leftpane.jsp" flush="true" /></TD>
						<TD width="20">&nbsp;</TD>
						<TD valign="top" align="center">
						<TABLE cellspacing="0" cellpadding="0" border="0" width="100%">
							<TBODY>
								<TR>
									<TD width="608" valign="top" align="center">
									<FORM name="form" method="post"
										action="<%=request.getContextPath()%>/userPasswordRemind.do">
									<TABLE border="0" width="557">
										<TBODY>
											<TR>
												<TD colspan="2" width="31%" class="page_title"><bean:message
													key="User.Header.remind" /></TD>
												<TD rowspan="4" align="left" width="6%"><IMG border="0"
													src="<%=request.getContextPath()%>/image/application/lock.gif"></TD>
											</TR>
											<TR>
												<TD width="31%" colspan="2"><%=com.odabasioglu.utility.MessageUtility
								.getMessage(request.getAttribute("message"))%></TD>
											</TR>
											<TR>
												<TD class="leftTitle"><bean:message
													key="User.remind.password" /></TD>
												<TD><INPUT class="textField" type="text" name="email"
													size="20"> <A href="#" onclick="onFormSubmit()"><bean:message
													key="Menu.remind.button" /></A></TD>
											</TR>
											<TR>
												<TD colspan="2" width="494"><bean:message
													key="PageContent.userRemindText1" /><A
													href="<%=request.getContextPath()%>/jsp/common/default_user.jsp"></A>&nbsp;<A
													href="<%=request.getContextPath()%>/jsp/user/user_create.jsp"><bean:message
													key="PageContent.clickHere" /></A>&nbsp; <bean:message
													key="PageContent.userRemindText3" /></TD>
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
						<TD valign="top" width="200"><jsp:include
							page="/jsp/guest/layout/guest_rightpane.jsp" flush="true" /></TD>
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
