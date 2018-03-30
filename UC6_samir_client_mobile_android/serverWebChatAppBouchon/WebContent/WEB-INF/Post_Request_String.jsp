<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	</head>

	<body>
			${param.pseudo}<br>
			${param.message}<br><br>
			${param.contact}<br>
			${requestScope.reponse}
	</body>
</html>