<%@page import="java.util.List"%>
<%@page import="br.com.marcos.projetoweb.model.PessoaFisica"%>
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
				<a class="a-menu" href="">Cadastrar cliente</a>
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
		<div>
			<h2>Pessoa Física Lista</h2>
			<table border="1">
				<tr>
					<!-- <th>Id</th> -->
					<th>Nome</th>
					<th>Endereco</th>
					<th>Telefone</th>
					<th>CPF</th>
					<th>Nome Mãe</th>
					<th>Nome Pai</th>
					<th>Excluir</th>
				</tr>
		
				<%
					List<PessoaFisica> lista = (List<PessoaFisica>) request.getAttribute("lista");
					for (PessoaFisica pf : lista) {
				%>
		
		
		
				<tr>
					<td><%=pf.getNome()%></td>
					<td><%=pf.getEndereco()%></td>
					<td><%=pf.getTelefone()%></td>
					<td><%=pf.getCpf()%></td>
					<td><%=pf.getNomeMae()%></td>
					<td><%=pf.getNomePai()%></td>
					<td>X</td>
				</tr>
		
				<%
					}
				%>
		
			</table>
		</div>
	</div>
</body>
</html>