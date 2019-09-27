<%@page import="br.com.marcos.projetoweb.model.Cliente"%>
<%@page import="br.com.marcos.projetoweb.model.Relatorio"%>
<%@page import="br.com.marcos.projetoweb.model.Produto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
			<a id="retornar" class="a-menu" href="cliente.jsp">Voltar</a>
		</div>
	</div>
	<div>
		<%
			Cliente cliente =(Cliente) session.getAttribute("cliente");
			Relatorio relatorio =  new Relatorio();
			
			double imposto = relatorio.calcularImposto(cliente); 
			
		%>
			<p>Valor total do calculos de impostos de todos os produtos do cliente
			<br>
			<p>Valor total do imposto: <%= imposto %> </p>
		
	</div>
		
</body>
</html>