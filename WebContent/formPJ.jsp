<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
	<div id="cabecalho">
		<div id="menu">
			<div class="opt-menu">
				<a class="a-menu" href="opcoesCliente.jsp">Cadastrar cliente</a>
			</div>
			<div class="opt-menu">
				<a class="a-menu" href="">Cadastrar Conta</a>
			</div>
			<div class="opt-menu">
				<a class="a-menu" href="">Acessar conta</a>
			</div>
		</div>
	</div>
	<div id="sessao">
		<form action="sistema?logica=CadastrarPJ" method="post">
			<h3>Cadastro de Cliente Juridico</h3>
			Nome: <br> <input type="text" name="nome"> <br><br>
			Endereço: <br> <input type="text" name="endereco"> <br><br>
			Telefone: <br> <input type="text" name="telefone"> <br><br>
			CNPJ:  <br> <input type="text" name="cnpj"> <br><br>
			Nome Fantasia:  <br> <input type="text" name="nomeFantasia"> <br><br>
			
		
		<br> <input type="submit" value="Cadastrar Cliente">
		</form>
	</div>
</body>
</html>