<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.data.TbComment"%>
<%@ page import="com.odabasioglu.data.TbProduct"%>
<%@ page import="com.odabasioglu.config.SystemConstants"%>
<%@ page import="com.odabasioglu.utility.ConverterUtility"%>
<%@ page import="com.odabasioglu.manager.CommentManager"%>

<%TbProduct product = (TbProduct) request.getAttribute("product");
CommentManager commentManager = new CommentManager();

List productCommentList= commentManager.listProductComment(product.getId());

%>
<html:html>
<SCRIPT language="JavaScript">
function createfavouriteSubmit(){
		form.action= "<%=request.getContextPath()%>/userFavouriteCreate.do";
		form.submit();
		return true;
	}
function createOrderLineSubmit(){
		if(!isValid(AMOUNT,form.amount.value)){
			alert(MSG_AMOUNT);
			form.amount.select();
			return false;
		}

		form.action= "<%=request.getContextPath()%>/orderLineCreate.do";
		form.submit();
		return true;
	} 
</SCRIPT>
<BODY topmargin="0">
<FORM name="form" method="post">
<TABLE width="100%" align="center" border="0">
	<TBODY>
		<TR>
			<TD class="product_title">  <A
				href="<%=request.getContextPath()%>/productSubcategoryView.do?productSubcategoryId=<%=product.getCategory().getId()%> "><%=com.odabasioglu.utility.ConverterUtility.getDisplaySize(
						product.getCategory().getCategoryName(),15)%> &raquo;&raquo;</A> </TD><TD class="product_title" colspan="2">  <%=product.getName()%></TD>
		</TR>
		<TR>
			<TD rowspan="6" align="center" valign="middle">
			<CENTER><BR>
			<BR>
			<BR>
			<IMG border="0"
				<%if(product.getThumbnail()!=null){%>
					src="<%=request.getContextPath()%>/ImageServlet?type=thumbnail&id=<%=product.getId()%>"
				<% } else {%>
				
					src="<%=request.getContextPath()%>/image/application/no_picture.gif"
				<% } %>
				
				height="50"><BR>
			<BR>
			<%if (product.getThumbnail()!=null) {%> <A
				href="javascript:openWindow('<%=request.getContextPath()%>/jsp/product/product_picture.jsp?id=<%=product.getId()%>', 420,420);"><IMG
				border="0" src="<%=request.getContextPath()%>/image/application/zoom.gif"
				width="100" height="18"></A><%}%></CENTER>
			</TD>
			<TD ><bean:message key="Product.code"/> : </TD>
			<TD><%=product.getProductCode()%> <INPUT type="hidden"
				name="productId" size="1" maxlength="2" value="<%=product.getId()%>"></TD>
		</TR>
		<TR>
			<TD ><bean:message key="Product.price.other"/> :</TD>
			<TD class="product_price_other"><%=ConverterUtility.formatCurrencyOther(ConverterUtility.getPriceCalculated(product))%> + KDV</TD></TR>
		<TR>
			<TD><B><bean:message key="Product.price.our"/> :</B></TD>
			<TD><B><%=ConverterUtility.formatCurrency(ConverterUtility.getPriceCalculated(product))%> + KDV</B>  <%if (!product.getCurrencyType().equals(SystemConstants.CURRENCY_YTL)) {%><FONT
				color="#ff0000">(*)</FONT><%}%><INPUT
				type="hidden" name="price" size="1" maxlength="2" value="<%=ConverterUtility.getPriceCalculated(product)%>"></TD></TR>
		<TR>
			<TD ><bean:message key="Product.price.vat"/> :</TD>
			<TD><%=ConverterUtility.formatCurrencyVAT(ConverterUtility.getPriceCalculated(product))%></TD>
		</TR>
		<TR>
			<TD><bean:message key="Product.stock"/> :</TD>
			<TD ><%=ConverterUtility.getStockStatus(product.getStockStatus()) %></TD>
		</TR>
		<TR><TD><bean:message key="Point.message"/> :</TD>
			<TD><%=String.valueOf(ConverterUtility.getOrderPoints(product.getPrice()))%></TD>
		</TR>
		<TR>
			<TD align="center"></TD>
			<TD colspan="2"><INPUT type="hidden" name="productId" size="20"
				value="<%=product.getId()%>"><BR>
			<INPUT type="text" name="amount" size="1" maxlength="2" value="1" onkeypress="return OnlyNumeric(event)"> <A
				class="butonlar" href="#" onclick="createOrderLineSubmit()" ></A> <A
				href="#" onclick="createOrderLineSubmit()"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/sepet_bt.gif" width="85"
				height="16"></A> <A href="#" onclick="createfavouriteSubmit()"><IMG
				border="0"
				src="<%=request.getContextPath()%>/image/application/favourite_bt.gif"
				width="105" height="16"></A></TD>
		</TR>
		<TR>
			<TD align="center"></TD>
			<TD colspan="2"><BR><%if (productCommentList!=null && productCommentList.size()>0 ) { %> Bu ürünle ilgili toplam <%=productCommentList.size()%>  yorum var. <IMG border="0"
				src="<%=request.getContextPath()%>/image/application/rank<%=((TbComment)productCommentList.get(0)).getPoint()%>.gif" alt="Bu ürüne son puan veren müþterimiz 5 üzerinden <%=((TbComment)productCommentList.get(0)).getPoint()%> vermiþ."
				width="58" height="10"> <%} else {%><bean:message key="Error.comment.noComment"/><%}%><A class="butonlar"
				href="javascript:openWindow('<%=request.getContextPath()%>/jsp/product/product_comment_create.jsp?productId=<%=product.getId()%>', 500,250);"><BR>
			<BR>
			<BR>
			<bean:message key="Comment.create.button"/></A><%if (productCommentList!=null) {%>
			<A class="butonlar" href="javascript:openWindow('<%=request.getContextPath()%>/jsp/product/product_comment.jsp?productId=<%=product.getId()%>', 620,400);"><%if (productCommentList!=null && productCommentList.size()>0 ) { %><bean:message key="Comment.read.button"/></A><%} %>
			
			<%}%>
			<BR>
			</TD> 
		</TR>
		<TR>
			<TD colspan="3"><BR>
			<BR>
			</TD>
		</TR>
		<TR>
			<TD colspan="3"><bean:message key="Product.explanation.details" /></TD>
		</TR>
		<TR>
			<TD colspan="3"><IMG border="0"
				src="<%=request.getContextPath()%>/image/application/spacer6.gif"></TD>
		</TR>
		<TR>
			<TD colspan="3"><%=product.getDescription()%></TD>
		</TR>
		<%if (!product.getCurrencyType().equals(SystemConstants.CURRENCY_YTL)) {%>
		
		<TR>
			<TD colspan="3"><bean:message key="Product.price.currencyMessage" /><BR><BR><%=ConverterUtility.getCurrencyType(product.getCurrencyType())%> Satýþ Fiyatý :<%=product.getPrice()%> <%=ConverterUtility.getCurrencyType(product.getCurrencyType())%> + KDV</TD>
		</TR>
		<%}%>
		<TR>
			<TD colspan="3">
			<jsp:include page="/jsp/product/product_footer.jsp" flush="true" /></TD>
		</TR>
	</TBODY>
</TABLE>
</FORM>
</BODY>
</html:html>
