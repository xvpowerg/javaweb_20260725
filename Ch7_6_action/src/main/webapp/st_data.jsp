<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="student" class="tw.com.beans.Student" ></jsp:useBean>
	<jsp:setProperty property="*" name="student"/>
	<div>Name:${student.stName}</div>
	<div>Email:${student.stEmail}</div>

</body>
</html>