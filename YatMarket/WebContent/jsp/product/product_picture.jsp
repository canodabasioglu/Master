<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY onClick="javascript:window.close();">
<TABLE width="100%" border="0">
	<TBODY>
		<TR>
			<TD align="center">
			<IMG border="0"
				
					src="<%=request.getContextPath()%>/ImageServlet?type=picture&id=<%=request.getParameter("id")%>"
				
				
				width="250">
			
			</TD>
		</TR>
	</TBODY>
</TABLE>

</BODY>
</html:html>
