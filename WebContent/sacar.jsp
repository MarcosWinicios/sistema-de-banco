<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Sistema de Banco</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<div id="sessao">
		<form action="sistema?logica=Sacar" method="post">
			<h3>Sacar</h3>
			Quantia: <br> <input type="text" name="nome"> <br><br>
			<br> <input type="submit" value="Sacar">
		</form>
	</div>
</body>
</html>