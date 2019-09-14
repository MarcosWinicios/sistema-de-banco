<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Cadastro C. Juridico</title>
</head>
<body>
	<h3>Cadastro de Cliente Juridico</h3>
	
	<form action="sistema?logica=CadastrarPJ" method="post">
		Nome: <br> <input type="text" name="nome"> <br><br>
		Endereço: <br> <input type="text" name="endereco"> <br><br>
		Telefone: <br> <input type="text" name="telefone"> <br><br>
		CNPJ:  <br> <input type="text" name="cnpj"> <br><br>
		Nome Fantasia:  <br> <input type="text" name="nomeFantasia"> <br><br>
		
	
	<br> <input type="submit" value="Cadastrar Cliente">
	</form>
</body>
</html>