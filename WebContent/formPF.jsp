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
		<form action="sistema?logica=CadastrarFisico" method="post">
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