<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Sistema de Banco</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<div class="home">
		<div class="opt-home">
			<a class="a-menu" href="index.jsp">Home</a>
		</div>
		<div class="opt-home">
			<a class="a-menu" href="cliente.jsp">Voltar</a>
		</div>
	</div>
	<div id="sessao">
		<form action="sistema?logica=CadastrarConta" method="post">
			Numero da conta:  <br> <input type="text" name="numConta"> <br><br>
			Tipo: <br>
			<select name="tipoConta">
				<option value="corrente">Corrente</option>
				<option value="poupanca">Poupanca</option>
			</select><br>
			<br> <input type="submit" value="Cadastrar Conta">
		</form>
	</div>
</body>
</html>