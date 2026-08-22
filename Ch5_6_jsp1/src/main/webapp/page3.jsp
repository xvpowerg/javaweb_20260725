<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String appValue =(String)application.getAttribute("appValue");
		out.println(appValue);
		String sessionValue = (String)session.getAttribute("sessionValue");
	%>
	<table>
	<tr>
	
	</tr>
	
	</table>
	<h2><%=appValue %></h2>
	
	<p><%=sessionValue %></p>
</body>
</html>