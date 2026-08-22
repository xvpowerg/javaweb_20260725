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
		int count = (Integer)request.getAttribute("count");		
	%>
	<ul>
		<%for (int i =1;i<=count;i++){ %>
			<li><%=i %></li>
		<%} %>
	</ul>
</body>
</html>