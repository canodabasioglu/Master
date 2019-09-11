<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="com.odabasioglu.manager.OrderManager"%>
<%@ page import="com.odabasioglu.data.TbOrder"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>
<%
List orderList =null;
if (OrderManager.listOrder(null)!=null){ 
orderList = OrderManager.listOrder(null);
}
request.setAttribute( "orderList", orderList );
%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<BODY leftMargin=0 topMargin=0 rightmargin="0"
	bottommargin="0">
<FORM name="form" method="post" action="<%=request.getContextPath()%>/newsCreate.do">
<TABLE width="989" align="center" border="0">
	<TBODY>
		<TR>
			<TD><jsp:include page="/jsp/admin/layout/admin_toppane.jsp" flush="true" /></TD>
		</TR>
		<TR vAlign=top>
			<TD>
			<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
				<TBODY>
					<TR vAlign=top>
						<TD align="left" width="200"><jsp:include
							page="/jsp/admin/layout/admin_leftpane.jsp" flush="true" /></TD>
						<TD width="20">&nbsp;</TD>
						<TD valign="top" align="center" colspan="3">
						<TABLE cellspacing="0" cellpadding="0" border="0" width="100%">
							<TBODY>
								<TR>
									<TD valign="top" align="center">
									<TABLE width="100%" border="0">
										<TBODY>					
												
							<display:table name="orderList" pagesize="30" >
  							<display:caption><bean:message key="Admin.order.title" /></display:caption>
  							<display:column property="users.name" title="Müþteri Adý"  sortable="true" headerClass="sortable" />
  							<display:column property="users.surname" title="Müþteri Soyadý"  sortable="true" headerClass="sortable" />
  							<display:column property="shipmentType" title="Nakliye Tipi"  sortable="true" headerClass="sortable" />
  							<display:column property="orderStatus" title="Sipariþ Durumu"  sortable="true" headerClass="sortable" />
  							<display:column property="paymentType" title="Ödeme Tipi"  sortable="true" headerClass="sortable" />
  							<display:column property="modifiedDate" title="Sipariþ Tarihi"  sortable="true" format="{0,date,dd/MM/yyyy hh:mm:ss}" headerClass="sortable" /> 
							<display:column paramProperty="id" url="/orderDetails.do?page=admin&orderId=" paramId="orderId"><img src="<%=request.getContextPath()%>/image/application/edit.gif"></display:column>		
  							<display:column paramProperty="id" url="/orderDelete.do?id=" paramId="id"><img src="<%=request.getContextPath()%>/image/application/sil.gif"></display:column>
  							</display:table>
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
		
		<TR>
			<TD align="center"></TD>
		</TR>
	</TBODY>
</TABLE>
</FORM>
</BODY>
</html:html>
