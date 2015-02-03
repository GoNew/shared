<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
		<link href="<%= request.getContextPath() %>/css/hello.css" rel="stylesheet" />
	</head> 
	<body>
		<h2>${message}</h2>
		<img src="<%= request.getContextPath() %>/img/Penguins.jpg" />
	</body>
</html>
