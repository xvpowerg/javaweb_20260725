<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>CanShow Test</h1>
	<c:if test="${canShow}">
			<p>ShowValue!!</p>
	</c:if>
	
	<c:choose>
		<c:when test="${action == 1 }">
			<p>Play</p>
		</c:when>
		<c:when test="${action == 2 }">
			<p>Stop</p>
		</c:when>
		<c:otherwise>
			<p>Error</p>		
		</c:otherwise>
	</c:choose>
</body>
</html>