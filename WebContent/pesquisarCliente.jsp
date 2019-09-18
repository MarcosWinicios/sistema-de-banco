<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/sistema?logica=PesquisarCliente" method="post">
			<h3>Pesquidar PessoaFisica</h3>
			CPF:  <br> <input type="text" name="cpf"> <br><br>
		<br> <input type="submit" value="Pesquisar">
		</form>
</body>
</html>