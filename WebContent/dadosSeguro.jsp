<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%@ page import="br.com.marcos.projetoweb.model.Seguro" %>
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
			<a class="a-menu" href="seguro.jsp">Voltar</a>
		</div>
	</div>
	<div id="sessao">
		<%
		Seguro seguro = (Seguro)session.getAttribute("produto");
		%>
		Numero: <%= seguro.getNumero()%>
		<br><br>
		Valor: R$ <%= seguro.getValor()%>
		<br><br>
		Situacao:  <%= seguro.getSituacao()==true?"ativada":"desativada"%>
		<br><br>

	</div>
</body>
</html>