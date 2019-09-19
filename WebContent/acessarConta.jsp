<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Sistema de Banco</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<div id="sessao">
		<form action="sistema?logica=CadastrarSeguro" method="post">
			Numero da conta:  <br> <input type="text" name="numConta"> <br><br>
			<br> <input type="submit" value="Fazer login">
		</form>
	</div>
</body>
</html>