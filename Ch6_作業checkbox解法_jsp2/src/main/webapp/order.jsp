<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="java.util.HashMap" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
希望checkbox 勾選的保持勾選狀態
重新整理後 還可保持勾選
 -->
 <%
  HashMap<String,Boolean> checkboxedMap =
  (HashMap) session.getAttribute("fruitChecked");
 %>
 <%=checkboxedMap %>
	<form action="order" method="post">
		<p>
		<input type="checkbox" value="0" <%=checkboxedMap.get("0")?"checked":"" %> name="fruit"/>蘋果
		</p>
		<p>
		<input type="checkbox" value="1" <%=checkboxedMap.get("1")?"checked":"" %> name="fruit"/>西瓜
		</p>
		<p>
		<input type="checkbox" value="2" <%=checkboxedMap.get("2")?"checked":"" %> name="fruit"/>香蕉
		</p>
		<button>確定</button>
	</form>
</body>
</html>