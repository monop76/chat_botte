<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>POST response</title>
	</head>

	<body>
		<h3>Simulation de mon application cliente android ChatApp'<br><br>
		requête HTTP POST - paramètres String</h3>
		
		<p>Je reçois la réponse : </p>
		<p>- pseudo : ${param.pseudo}</p>
		<p>- contact : ${param.contact}</p>
		<p>- message : ${param.message}</p>
		<p>- réponse : ${requestScope.reponse}</p>
	</body>
</html>