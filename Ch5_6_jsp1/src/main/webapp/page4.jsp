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
		int trCount = (Integer)request.getAttribute("trCount");
		int tdCount = (Integer)request.getAttribute("tdCount");
		int count = 1;
	%>
	
	<table border="1">
	
		<%for(int i =1; i<= trCount;i++){ %>
			<tr>
			
			<%for(int k = 1;k<=tdCount;k++,count++){ %>
				<td>
					<%=count %>				
				</td>
			<%} %>
			</tr>
		<%} %>	
	</table>
</body>
</html>