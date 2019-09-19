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
		<form action="sistema?logica=Transferir" method="post">
			<h3>Tranferir</h3>
			Quantia: <br> <input type="text" name="nome"> <br><br>
			Numero da conta: <br> <input type="text" name="nome"> <br><br>
			<br> <input type="submit" value="Transferir">
		</form>
	</div>
</body>
</html>