<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="tw.com.web.Product" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList <Product>resultList = 
				(ArrayList)request.getAttribute("resultList");
		
		for(var v : resultList){		
	%>
		<div><%=v.name() %> </div>	
		<div><%=v.price() %> </div>
		<div><%=v.stock() %> </div>
	
	<%} %>
</body>
</html>