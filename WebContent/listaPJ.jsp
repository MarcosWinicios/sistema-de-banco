<%@page import="br.com.marcos.projetoweb.model.PessoaJuridica"%>
<%@page import="br.com.marcos.projetoweb.model.Cliente"%>

<%@page import="java.util.List"%>
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
			<h2>PJ Lista</h2>
			<table border="1">
				<tr>
					<!-- <th>Id</th> -->
					<th>Nome</th>
					<th>Endereco</th>
					<th>Telefone</th>
					<th>CNPJ</th>
					<th>Nome Fantasia</th>
					<th>Excluir</th>
				</tr>
		
				<%
					List<PessoaJuridica> lista = (List<PessoaJuridica>) request.getAttribute("lista");
					for (PessoaJuridica pj : lista) {
				%>
		
		
		
				<tr>
					<td><%=pj.getNome()%></td>
					<td><%=pj.getEndereco()%></td>
					<td><%=pj.getTelefone()%></td>
					<td><%=pj.getCnpj()%></td>
					<td><%=pj.getNomeFantasia()%></td>
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