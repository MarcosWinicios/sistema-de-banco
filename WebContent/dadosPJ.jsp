<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="br.com.marcos.projetoweb.model.PessoaJuridica" %>
<%@ page import="br.com.marcos.projetoweb.model.Conta" %>
<%@ page import="br.com.marcos.projetoweb.model.ContaCorrente" %>
<%@ page import="br.com.marcos.projetoweb.model.ContaPoupanca" %>
<%@ page import="br.com.marcos.projetoweb.model.Seguro" %>
<%@ page import="br.com.marcos.projetoweb.model.Produto" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
	<div id="sessao">
		<div>
			<%
				PessoaJuridica cliente = (PessoaJuridica)session.getAttribute("cliente");
			%>
			Nome: <%= cliente.getNome() %>
			<br><br>
			Endereco: <%= cliente.getEndereco() %>
			<br><br>
			Telefone: <%= cliente.getTelefone() %>
			<br><br>
			Produtos: 
			<%
				for(Produto p : cliente.getProdutos()){
					if(p instanceof ContaPoupanca){
						Conta conta = (Conta)p;
						%>
						<p> - Conta Poupanca: <%= conta.getNumero() %></p>
						<%
					}
					else if(p instanceof ContaCorrente){
						Conta conta = (Conta)p;
						%>
						<p> - Conta Corrente: <%= conta.getNumero() %></p>
						<%
					}
					else if(p instanceof Seguro){
						Seguro seguro = (Seguro)p;
						%>
						<p> - Seguro: <%= seguro.getNumero() %></p>
						<%
					}
					
				}
			%>
			
			Cnpj: <%= cliente.getCnpj() %>
			<br><br>
			Nome fantasia: <%= cliente.getNomeFantasia() %>
			<br><br>
		</div>
	</div>
</body>
</html>