<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-9"
pageEncoding="ISO-8859-9"
%>
<SCRIPT language="JavaScript">
function onFormSubmitMail(){
		if(!isValid(SEARCH,search.keyword.value)){
		alert(MSG_SEARCH);
		search.keyword.select();
}		
		else{
		search.action="<%=request.getContextPath()%>/searchProduct.do";
		search.submit();
		} }
</SCRIPT>
	<FORM method="post" name="search">
<TABLE cellspacing="0" cellpadding="0" width="989" align="center"
	border="0">
	<TBODY>
		<TR>
			<TD align=right>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR vAlign=bottom>
						<TD align=left><IMG
							src="<%=request.getContextPath()%>/image/application/yatmarketi_logo.gif"
							border="0" alt="<bean:message key="Menu.pictureInfo"/>"></TD>
						<TD align=right width=500></TD>
					</TR>
				</TBODY>

			</TABLE>
			</TD>
		</TR>
		<TR vAlign="middle">
			<TD align=left bgColor=#dddddd>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR valign="middle">
						<TD vAlign=bottom align="center" width=200
							background="<%=request.getContextPath()%>/image/application/top1a_bg.gif">

	<TABLE cellSpacing=2 cellPadding=0 border=0>
							<TBODY>
								<TR valign="middle">
									<TD align=center width=200><bean:message key="Menu.search"/>&nbsp;
									<INPUT class=top_bar_search size=22 name="keyword"></TD>
									<TD align=center width=50><A href="#" onclick="onFormSubmitMail()"><IMG border="0"
										src="<%=request.getContextPath()%>/image/application/ico_search.gif"
										height="19" width="22" alt="<bean:message key="Menu.searchMessage"/>"></A>
									</TD>
							</TBODY>
						</TABLE>
				
						</TD>
						<TD width=30
							background="<%=request.getContextPath()%>/image/application/top1a_bg.gif"><IMG
							height=32 hspace=0
							src="<%=request.getContextPath()%>/image/application/top1_ab.gif" width=30
							border=0></TD>
						<TD class=top_bar vAlign=top
							background="<%=request.getContextPath()%>/image/application/top1b_bg.gif">
						<TABLE cellspacing="0" cellpadding="5" width="743" border="0">
							<TBODY>
								<TR valign="middle">
									<TD class="top_bar" align="center" width="72"><A class=top_bar
										href="<%=request.getContextPath()%>/siteManager.do?url=homepage"><bean:message key="Menu.homepage"/></A></TD>
									<TD class="top_bar" width="0">|</TD>
									<TD class="top_bar" align="center" width="98"><A class=top_bar
										href="<%=request.getContextPath()%>/siteManager.do?url=promotion"><bean:message key="Menu.promotion"/></A></TD>
									<TD class="top_bar">|</TD>
									<TD class="top_bar" align="center" width="91"><A class=top_bar
										href="<%=request.getContextPath()%>/siteManager.do?url=aboutUs"><bean:message key="Menu.aboutUs"/></A></TD>
									<TD class="top_bar">|</TD>
									<TD class="top_bar" align="center" width="125"><A class=top_bar
										href="<%=request.getContextPath()%>/siteManager.do?url=orderDelivery"><bean:message key="Menu.orderDelivery"/></A></TD>
									<TD class="top_bar" width="11">|</TD>
									<TD class="top_bar" align="center" width="123"><A class=top_bar
										href="<%=request.getContextPath()%>/siteManager.do?url=customerRelations"><bean:message key="Menu.customerRelations"/></A></TD>
									<TD class="top_bar" width="9">|</TD>
									<TD class="top_bar" align="center" width="87"><A class=top_bar
										href="<%=request.getContextPath()%>/jsp/user/login.jsp"><bean:message key="Menu.login"/></A></TD>
								</TR>
							</TBODY>
						</TABLE>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
		<TR vAlign=top>
			<TD bgColor=#bbbbbb></TD>
		</TR>
		<TR vAlign=top>
			<TD
				background="<%=request.getContextPath()%>/image/application/top_shadow_bg_5.gif"><IMG
				height=5 hspace=0 src="<%=request.getContextPath()%>/image/application/top_shadow_bg_5.gif" width=1 border=0></TD>
		</TR>

	</TBODY>
</TABLE>
</FORM>
