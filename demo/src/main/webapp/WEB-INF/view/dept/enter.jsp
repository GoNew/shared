<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정보 입력</title>
</head>
<body>
	<h1>정보 입력</h1>
	<c:url value="/dept/enter" var="action"></c:url>
	<form:form modelAttribute="editDept" method="post"
	action="${action }">
		<label>부서ID</label> : <form:input path="departmentId" readonly="true"/><br>
		<label>부서명</label> : <form:input path="departmentName"/><br>
		<label>관리자ID</label> : <form:input path="managerId"/><br>
		<label>부서위치</label> : <form:input path="locationId"/><br>
		<button type="submit" name="proceed">다음</button>
	</form:form>
	
	<%-- <form method="post" action="">
	</form> --%>
</body>
</html>