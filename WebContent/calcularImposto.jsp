<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.marcos.projetoweb.model.ContaCorrente"%>
<%@ page import="br.com.marcos.projetoweb.model.ContaPoupanca"%>
<%@ page import="br.com.marcos.projetoweb.model.Seguro"%>
<%@ page import="br.com.marcos.projetoweb.model.Produto"%>
<%@ page import="br.com.marcos.projetoweb.model.Relatorio"%>
<!DOCTYPE html>
<html>
<head>
	<title>Sistema de Banco</title>
	<link rel="stylesheet" type="text/css" href="main.css" />
<head>
<body>
<div id="menu">
		<div class="opt-menu">
			<a target="sessao" class="a-menu" href="dadosCliente.jsp">Ver Dados</a>
		</div>
		<div class="opt-menu">
			<a target="sessao" class="a-menu" href="produtos.jsp">Acessar Produto</a>
		</div>
	</div>
<div id="sessao">
<%
Produto produto = (Produto)session.getAttribute("produto");
Relatorio relatorio = new Relatorio();

if(produto instanceof ContaCorrente){
ContaCorrente cC = (ContaCorrente)produto;
%>
Saldo atual: R$ <%=cC.getSaldo()%><br>
O Valor a ser cobrado de imposto: R$ <%=cC.valorImposto()%><br>
Saldo após ser cobrado o imposto: R$ <%=cC.getSaldo() - relatorio.calcularImposto(cC)%>
<%
}
else if(produto instanceof ContaPoupanca){
ContaPoupanca cP = (ContaPoupanca)produto;
%>
Saldo atual: R$ <%=cP.getSaldo()%><br>
O Valor a ser cobrado de imposto: R$ <%=cP.valorImposto()%><br>
Saldo após ser cobrado o imposto: R$ <%=cP.getSaldo() - relatorio.calcularImposto(cP)%>
<%
}
else{
Seguro s = (Seguro)produto;
%>
Valor atual: R$ <%=s.getValor()%><br>
O Valor a ser cobrado de imposto: R$ <%=s.valorImposto()%><br>
Saldo após ser cobrado o imposto: R$ <%=s.getValor() - relatorio.calcularImposto(s)%>
<%
}
%>
</div>
</body>
</html>