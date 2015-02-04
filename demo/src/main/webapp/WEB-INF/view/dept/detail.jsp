<%@page import="jdbc.entity.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세부내역</title>
</head>
<body>
	<%
		Department dept = (Department)request.getAttribute("dept");
	%>
	<h1>부서 정보</h1>
	<p>부서명 : <%=dept.getDepartmentName() %></p>
	<p>부서ID : <%=dept.getDepartmentId() %></p>
	<p>관리자ID : <%=dept.getManagerId() %></p>
	<p>부서위치 : <%=dept.getLocationId() %></p>
	<br>
	<a href="<%=request.getContextPath() %>/dept/list">
	<button>목록 보기</button></a>
</body>
</html>