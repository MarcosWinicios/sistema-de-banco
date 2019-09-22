<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%@ page import="br.com.marcos.projetoweb.model.Conta" %>
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
			<a class="a-menu" href="conta.jsp">Voltar</a>
		</div>
	</div>
	<div id="sessao">
		<%
		Conta conta = (Conta)session.getAttribute("produto");
		%>
		Numero: <%= conta.getNumero()%>
		<br><br>
		Tipo:  <%= conta.getTipo()%>
		<br><br>
		Saldo:  <%= conta.getSaldo()%>
		<br><br>
		Situacao:  <%= conta.getSituacao()==true?"ativada":"desativada"%>
		<br><br>
	</div>
</body>
</html>