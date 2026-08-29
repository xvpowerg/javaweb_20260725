<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
int seseionCount = 0;

Integer sessionCountTmp = (Integer) session.getAttribute("session_count");
if (sessionCountTmp != null){
	seseionCount = sessionCountTmp;
}

%>

</head>
<body>
	<h2>seseionCount:<%=seseionCount%></h2>
</body>
</html>