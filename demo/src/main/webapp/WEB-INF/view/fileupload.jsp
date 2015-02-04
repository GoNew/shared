<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 업로드</h2>
	<form method="post" enctype="multipart/form-data"
		action="<%=request.getContextPath() %>/upload">
		<input type="text" name="string">
		file 선택 : <input type="file" name="uploadFile">
		<button type="submit">upload</button>
	</form>
</body>
</html>