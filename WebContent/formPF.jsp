<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Sistema de Banco</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<div class="home">
		<div class="opt-home">
			<a class="a-menu" href="index.jsp">Home</a>
		</div>
		<div class="opt-home">
			<a class="a-menu" href="cadastrarCliente.jsp">Voltar</a>
		</div>
	</div>
	<div id="sessao">
		<form action="sistema?logica=CadastrarPF" method="post">
			<h3>Cadastro de Cliente Físico</h3>
			Nome: <br> <input type="text" name="nome"> <br><br>
			Endereço: <br> <input type="text" name="endereco"> <br><br>
			Telefone: <br> <input type="text" name="telefone"> <br><br>
			CPF:  <br> <input type="text" name="cpf"> <br><br>
			Nome da Mãe:  <br> <input type="text" name="nomeMae"> <br><br>
			Nome do Pai: <br> <input type="text" name="nomePai"> <br><br>
			<br> <input type="submit" value="Cadastrar Cliente">
		</form>
	</div>
</body>
</html>