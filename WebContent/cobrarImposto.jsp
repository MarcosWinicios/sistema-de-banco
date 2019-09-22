<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.marcos.projetoweb.model.Seguro" %>
<%@ page import="br.com.marcos.projetoweb.model.Conta" %>
<%@ page import="br.com.marcos.projetoweb.model.ContaCorrente" %>
<%@ page import="br.com.marcos.projetoweb.model.ContaPoupanca" %>
<%@ page import="br.com.marcos.projetoweb.model.Produto" %>
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
			<a id="retornar" class="a-menu" href="#">Voltar</a>
		</div>
	</div>
	<div id="sessao">
		<form action="sistema?logica=CobrarImposto" method="post">
			<%
				Produto p = (Produto)session.getAttribute("produto");
				if(p instanceof ContaCorrente){
					Conta conta = (Conta)p;
					%>
					<script>
					document.eventListener('onload',functio(){
						var link = document.getElementById("retorno");
						var href = document.createAttribute('href');
					    href.value = "conta.jsp";
					    link.setAttributeNode(href);
					});
					</script>
					<p>Numero da conta: <%= conta.getNumero() %></p>
					<p>Deseja cobrar imposto desta conta corrente?</p>
					Sim: <input name="opcao" type="radio" value="cobrar"> Não: <input name="opcao" type="radio" value="cancelar"> 
					<%
				}
				else if(p instanceof ContaPoupanca){
					Conta conta = (Conta)p;
						%>
						<script>
						document.eventListener('onload',functio(){
							var link = document.getElementById("retorno");
							var href = document.createAttribute('href');
						    href.value = "conta.jsp";
						    link.setAttributeNode(href);
						});
						</script>
						<p>Numero da conta: <%= conta.getNumero() %></p>
						<p>Deseja cobrar imposto desta conta poupanca?</p>
						Sim: <input name="opcao" type="radio" value="cobrar"> Não: <input name="opcao" type="radio" value="cancelar">
	
						<%
				}
				else if(p instanceof Seguro){
					Conta conta = (Conta)p;
						%>
						<script>
						document.eventListener('onload',functio(){
							var link = document.getElementById("retorno");
							var href = document.createAttribute('href');
						    href.value = "seguro.jsp";
						    link.setAttributeNode(href);
						});
						</script>
						<p>Numero do seguro: <%= conta.getNumero() %></p>
						<p>Deseja cobrar imposto deste segurp?</p>
						Sim: <input name="opcao" type="radio" value="cobrar"> Não: <input name="opcao" type="radio" value="cancelar"> 
						<%
				}
			%>
			<br> <input type="submit" value="Confirmar">
			
		</form>
	</div>
</body>
</html>