<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="image"  items="${image_list }">
			<div>
				
				<img width="30%" height="30%" src="/myimages/${image}">
			
			</div>
			
	
	</c:forEach>
</body>
</html>