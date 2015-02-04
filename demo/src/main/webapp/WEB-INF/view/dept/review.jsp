<%@page import="jdbc.entity.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정보 확인</title>
</head>
<body>
	<%
		Department dept = (Department)request.getAttribute("editDept");
	%>
	<h2>이걸로 저장할건가요?</h2>
	<form method="post" action="<%=request.getContextPath() %>/dept/review">
		<label>부서명</label> : <%=dept.getDepartmentName() %><br>
		<label>부서ID</label> : <%=dept.getDepartmentId() %><br>
		<label>관리자ID</label> : <%=dept.getManagerId() %><br>
		<label>부서위치</label> : <%=dept.getLocationId() %><br>
		<br>
		<button type="submit" name="_event_confirmed">갱신</button>
		<button type="submit" name="_event_reverse">재 입력</button>
	</form>

</body>
</html>