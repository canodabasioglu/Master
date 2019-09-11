<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>

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


<SCRIPT language="JavaScript">

		function onFormSubmit(){
		if(!isValid(FEEDBACK_FORM,form.explanation.value)){
		alert(MSG_FEEDBACK_FORM);
		return false;
		}
		form.action="<%=request.getContextPath()%>
	/customerFeedbackCreate.do";
		form.submit();
		return true;
	}
</SCRIPT>

<BODY topmargin="0" leftmargin="0" bottommargin="0" rightmargin="0">
<FORM name="form" method="post">
<TABLE border="0" width="100%">
	<TBODY>
		<TR>
			<TD class="page_title"><bean:message key="Menu.customerRelations" /><BR>
			<BR>
			</TD>
		</TR>
		<TR>
			<TD style="text-align: justify"><FONT
				face="Arial, Helvetica, sans-serif" size="2">
			<LI><bean:message key="PageContent.customerRelationsText1" /></LI>
			</FONT></TD>
		</TR>
		<TR align="right">
			<%
				if (session.getAttribute("user") != (null)) {
			%>
			<TD style="text-align: justify" align="right">
			<TABLE border="0" width="98%">
				<TBODY>
					<TR>
						<TD class=menu_left_strong colspan="2"><BR>
						<bean:message key="PageContent.customerRelationsHeader" /> <BR>
						<BR>
						</TD>
					</TR>
					<TR>
						<TD class=menu_left_strong><bean:message
							key="PageContent.customerRelationsTopic" /></TD>
						<TD><SELECT name="topic">
							<OPTION selected value="-"><bean:message
								key="PageContent.customerRelationsTopicSelect" /></OPTION>
							<OPTION value="Teslimat ve Sipariþ"><bean:message
								key="PageContent.customerRelationsTopic1" /></OPTION>
							<OPTION value="Arýzalý Eksik Ürün"><bean:message
								key="PageContent.customerRelationsTopic2" /></OPTION>
							<OPTION value="Ýade ve Deðiþim"><bean:message
								key="PageContent.customerRelationsTopic3" /></OPTION>
							<OPTION value="Ýstek Öneri"><bean:message
								key="PageContent.customerRelationsTopic4" /></OPTION>
							<OPTION value="Diðer"><bean:message
								key="PageContent.customerRelationsTopic5" /></OPTION>
						</SELECT></TD>
					</TR>
					<TR>
						<TD class=menu_left_strong valign="top" height="82"><bean:message
							key="PageContent.description" /> :</TD>
						<TD height="82"><TEXTAREA rows="7" cols="50" MaxChars="1000"
							name="explanation" onkeypress="return TextareaKeyPress(this);"
							onkeyup="TextareaKeyUp(this);"
							onbeforepaste="TextareaPaste(this);"></TEXTAREA><br />
						<span id="explanation_charsCount"><bean:message
							key="PageContent.max1000chars" /></span></TD>
					</TR>
					<TR>
						<TD height="24"></TD>
						<TD height="24" align="right"><A class="butonlar" href="#"
							onclick="onFormSubmit(this)"><bean:message
							key="Button.sendForm" /></A></TD>
					</TR>
				</TBODY>
			</TABLE>
			<B><BR>
			<A class=menu_left_strong
				href="<%=request.getContextPath()%>/jsp/user/feedback_view.jsp"><bean:message
				key="PageContent.feedbacksList" /></A><BR>

			<BR>
			</B>
			<LI><FONT face="Arial, Helvetica, sans-serif" size="2"><bean:message
				key="PageContent.feedbacksShow" /></FONT>
			</TD>
			<%
				} else {
			%>
			<TD style="text-align: justify" align="right"><BR>
			<FONT color="#ff0000" face="Arial, Helvetica, sans-serif" size="2">
			<LI><bean:message
				key="PageContent.customerRelationsLoginRequired" />
			</FONT><BR>
			<BR>
			</TD>

			<%}%>


		</TR>
		<TR align="right">
			<TD style="text-align: justify" align="right"><B><BR>
			<bean:message key="PageContent.pageName" /></B></TD>
			<TD></TD>
		</TR>
	</TBODY>
</TABLE>
</FORM>
</BODY>
</html:html>
