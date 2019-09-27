<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
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
			<a class="a-menu" href="cliente.jsp">Voltar</a>
		</div>
	</div>
	<div id="menu">
		<div class="opt-menu">
			<a target="sessao" class="a-menu" href="dadosSeguro.jsp">Ver Dados</a>
		</div>
		<div class="opt-menu">
			<a target="sessao" class="a-menu" href="cobrarImposto.jsp">Cobrar Imposto</a>
		</div>
		<div class="opt-menu">
			<a target="sessao" class="a-menu" href="situacao.jsp">Situação</a>
		</div>		
	</div>
</body>
</html>