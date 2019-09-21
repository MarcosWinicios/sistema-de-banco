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
	<div id="sessao">
		<%
		Conta conta = (Conta)session.getAttribute("conta");
		%>
		Numero: <%= conta.getNumero()%>
		<br><br>
		Tipo:  <%= conta.getTipo()%>
		<br><br>
		Saldo:  <%= conta.getSaldo()%>
		<br><br>
		Situacao:  <%= conta.getSituacao()%>
		<br><br>
	</div>
</body>
</html>