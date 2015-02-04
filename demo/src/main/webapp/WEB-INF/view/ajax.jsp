<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax 전송</title>

<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>

<script type="text/javascript">
	$(document).ready(function () {
		function clickTransfer() {
			$.ajax({
				url: "<%=request.getContextPath() %>/ajax",
				type: "post",
				data: {msg:$("#textInput").val()},
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success: function(responseText) {
					$("#printText").append(responseText + "<br>");
				}
			});
			$("#textInput").val("");
		}
		
		$("#transfer").click(clickTransfer);
		$("#textInput").keypress(function (key) {
			if(key.keyCode ==13) {
				clickTransfer();
			}
		});
		
	});
</script>

</head>
<body>
	<div>
		<input type="text" id="textInput"><button id="transfer">전송</button>
	</div>
	<div id="printText">
	</div>
</body>
</html>