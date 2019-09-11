<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.odabasioglu.manager.ProductManager"%>
<%@ page import="com.odabasioglu.data.TbComment"%>
<html:html>
<jsp:include page="/jsp/common/header.jsp" flush="true" />
<script type="text/javascript" language="javascript">
function TextareaKeyPress(objTextArea)
{
//get value:
var strValue=objTextArea.value;

//get max chars:
var maxChars=parseInt(objTextArea.attributes['MaxChars'].value);

//check if exceeded:
if (strValue.length >= maxChars) {
//crop to maximum size:
objTextArea.value = strValue.substr(0, maxChars);
return false;
}

return true;
}

function TextareaKeyUp(objTextArea)
{
//get id of control:
var strID=objTextArea.name+"_charsCount";

//get pointer to text container:
var objSpan=document.getElementById(strID);

//get value:
var strValue=objTextArea.value;

//get max chars:
var maxChars=parseInt(objTextArea.attributes['MaxChars'].value);

//check if exceeded:
if (strValue.length >= maxChars) {
//crop to maximum size and refresh:
objTextArea.value = strValue.substr(0, maxChars);
strValue=objTextArea.value;
}

//set container text:
objSpan.innerHTML = (maxChars-strValue.length)+" karakter daha yazabilirsiniz.";
}

function TextareaPaste(objTextArea)
{
var s1=setTimeout("TextareaKeyPress();", 100, objTextArea);
var s2=setTimeout("TextareaKeyUp();", 500, objTextArea);
}
</script>
<TITLE><%=request.getParameter("productId")%></TITLE>
<SCRIPT language="JavaScript">
function onFormSubmit(){
		
		if(!isValid(COMMENT,commentForm.comment.value)){
			alert(MSG_COMMENT);
			commentForm.comment.select();
			return false;
		}
		
		commentForm.submit();
		return true;
	}
</SCRIPT>		


<BODY>
<FORM name="commentForm" action="<%=request.getContextPath()%>/commentCreate.do">
<TABLE width="100%" border="0">
	<TBODY>
		<TR>
			<TD align="center">
			
			<TABLE width="100%" border="0">
				<TBODY>
				<%if (session.getAttribute("user") != (null)) {
					if (request.getAttribute("message")!=null) {
					%>
					<TR>
						<TD><bean:message key="Success.comment.create" /> :</TD>
						<SCRIPT type="text/javascript">
						function selfclose()
								{
								window.close();
								}
								var StayAlive = 3; // Number of seconds to keep window open
								setTimeout("selfclose()",StayAlive * 1000);
	
						</SCRIPT>
					</TR>	
					<%} else {%>
					<TR>
						<TD><bean:message key="Point.message" /> :</TD>
						<TD><SELECT name="point">
							<OPTION value="5" selected>5 <bean:message key="Point.message" /></OPTION>
							<OPTION value="4">4 <bean:message key="Point.message" /></OPTION>
							<OPTION value="3">3 <bean:message key="Point.message" /></OPTION>
							<OPTION value="2">2 <bean:message key="Point.message" /></OPTION>
							<OPTION value="1">1 <bean:message key="Point.message" /></OPTION>
						</SELECT> <INPUT
							type="hidden" name="productId" size="20" value="<%=request.getParameter("productId")%>"></TD>
					</TR>
					<TR>
						<TD valign="top"><bean:message key="Comment.Header" /></TD>
						
						<TD height="82"><TEXTAREA rows="5" cols="40"  MaxChars="1000" 
							name="comment" onkeypress="return TextareaKeyPress(this);" onkeyup="TextareaKeyUp(this);" onbeforepaste="TextareaPaste(this);"></TEXTAREA><br />
							<span id="comment_charsCount">Bu alana toplam 1000 karakter yazabilirsiniz.</span> 
						</TD>
					</TR>
					<TR>
						<TD></TD>
						<TD align="right"><A class="butonlar" href="#" onclick="onFormSubmit()"><bean:message
					key="Menu.create.button" /></A></TD>
					</TR>
					<%}  } else { %>
					<TR>
						<TD><bean:message key="Error.comment.loginRequired" /></TD>
						<SCRIPT type="text/javascript">
						function selfclose()
								{
								window.close();
								}
								var StayAlive = 3; // Number of seconds to keep window open
								setTimeout("selfclose()",StayAlive * 1000);
						</SCRIPT>
					</TR>
					<%}%>
				</TBODY>
			</TABLE>
	
		
	</TBODY>
</TABLE>
</FORM>
</BODY>
</html:html>
