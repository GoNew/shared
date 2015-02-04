<%@page import="java.util.List"%>
<%@page import="jdbc.entity.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dept list</title>
</head>
<body>

		<table border="1px solid black">
			<tr>
				<th>부서ID</th><th>부서명</th><th>관리자ID</th><th>위치ID</th><th>비고</th>
			</tr>
			<%
				List<Department> depts = (List<Department>)request.getAttribute("depts");
				for(Department dept: depts) {
			%>
			<tr>
				<td><%=dept.getDepartmentId() %></td>
				<td><%=dept.getDepartmentName() %></td>
				<td><%=dept.getManagerId() %></td>
				<td><%=dept.getLocationId() %></td>
				<td>
					<a href="<%=request.getContextPath() %>/dept?departmentId=<%=dept.getDepartmentId() %>">
					<button>상세보기</button></a>
					<a href="<%=request.getContextPath() %>/dept/edit?departmentId=<%=dept.getDepartmentId() %>">
					<button>수정하기</button></a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		
</body>
</html>