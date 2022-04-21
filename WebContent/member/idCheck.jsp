<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/member.js"></script>
</head>
<body>
<h3>중복확인</h3>
<form action="IdCheckServlet" method="get" name="frm">
	아이디 : <input type="text" name="user_id" value="${user_id }"/>
	<input type="submit" value="중복 체크"/>
	<br />
<%
	if (request.getAttribute("result") == "-1") {
		%>
			<input type="button" value="사용하기" onclick="Available()"/>
		<%
	}
	if (request.getAttribute("result") == "1") {
		%>
			<script type="text/javascript">
				opener.document.frm.user_id.value="";
			</script>
		<%
	}
%>	
</form>
${message }
</body>
</html>