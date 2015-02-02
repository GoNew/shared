<%@page import="jdbc.entity.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="jdbc.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
		IService service = ctx.getBean(IService.class);
		out.print(service);
		
		out.print(service.getDepartment(120));
	%>
</body>
</html>