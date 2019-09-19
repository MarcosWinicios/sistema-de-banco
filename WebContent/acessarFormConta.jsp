<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sistema de Banco</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<div id="sessao">
		<form action="sistema?logica=AcessarConta" method="post">
			Numero da Conta:  <br> <input type="text" name="cpf"> <br><br>
			Tipo: <br>
			<select name="tipoConta">
				<option value="corrente">Corrente</option>
				<option value="poupanca">Poupanca</option>
			</select><br>
			<br> <input type="submit" value="Fazer login">
		</form>
	</div>
</body>
</html>