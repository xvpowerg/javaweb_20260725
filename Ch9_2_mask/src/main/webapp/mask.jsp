<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>    
<%@ page import="tw.com.beans.Mask" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>口罩系統</title>
</head>
<body>
<%List<Mask> myList = (List<Mask>)request.getAttribute("maskList");%>

<%for(var mask : myList){ %>
<p>ID:<%=mask.id() %></p>
<p>Name:<%=mask.name() %></p>
<p>Adult:<%=mask.maskAdult() %></p>
<p>Child:<%=mask.maskChild() %></p>

<%} %>
	
</body>
</html>