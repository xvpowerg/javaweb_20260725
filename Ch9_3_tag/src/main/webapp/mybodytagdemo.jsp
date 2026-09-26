<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/customtag.tld" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String message = "Hello World";
	pageContext.setAttribute("message", message);

%>
</head>
<body>
	<div>
		<c:mybody message="${message}">
			<h2>你好 ${message}</h2>
		</c:mybody>
	
	</div>
</body>
</html>