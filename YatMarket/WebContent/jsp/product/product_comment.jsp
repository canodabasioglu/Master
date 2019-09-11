<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.CommentManager"%>
<%@ page import="com.odabasioglu.data.TbComment"%>
<%
CommentManager commentManager = new CommentManager();
Integer  productId = Integer.valueOf(request.getParameter("productId"));
List productCommentList= commentManager.listProductComment(productId);
%>

<TITLE><%=request.getParameter("productId")%></TITLE>
<jsp:include page="/jsp/common/header.jsp" flush="true" />

<BODY>
<TABLE width="100%" border="0">
	<TBODY>
		<TR>
			<TD align="center">
			
			<TABLE width="100%" border="0">
				<TBODY>
					<%for (int i=0 ; i<productCommentList.size(); i++) {%>
					<TR>
						<TD><IMG border="0"
							src="<%=request.getContextPath()%>/image/application/rank<%=((TbComment)productCommentList.get(i)).getPoint()%>.gif"
							width="58" height="10"><%=com.odabasioglu.utility.ConverterUtility.getShortDate(((TbComment)productCommentList.get(i)).getModifiedDate())%> </TD>
					</TR>
					<TR>
					<TD><IMG border="0"	src="<%=request.getContextPath()%>/image/application/spacer6.gif" width="560" height="1"></TD>
					</TR>
					<TR>
						<TD><%=((TbComment)productCommentList.get(i)).getComment()%></TD>
					</TR>
					<TR>
						<TD><I><%=((TbComment)productCommentList.get(i)).getUsers().getName()+" "+((TbComment)productCommentList.get(i)).getUsers().getSurname()%></I> - <%=((TbComment)productCommentList.get(i)).getUsers().getBirthPlace()%></TD>
					
					</TR>
					<TR>
					<TD><BR>
						<BR>
						</TD>
					</TR>
					<%}%>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>

</BODY>
</html:html>
