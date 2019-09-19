<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="sessao">
		<form action="sistema?logica=CadastrarSeguro" method="post">
			Numero da apolice:  <br> <input type="text" name="numApolice"> <br><br>
			Valor:  <br> <input type="text" name="valorSeguro"> <br><br>
			<br> <input type="submit" value="Cadastrar Seguro">
		</form>
	</div>
</body>
</html>