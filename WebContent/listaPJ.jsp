<%@page import="br.com.marcos.projetoweb.model.PessoaJuridica"%>
<%@page import="br.com.marcos.projetoweb.model.Cliente"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PJ Lista</title>
</head>
<body>
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
	
</body>
</html>