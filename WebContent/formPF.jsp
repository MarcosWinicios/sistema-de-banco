<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de Cadastro C. Fisico</title>
</head>
<body>
	
	<h3>Cadastro de Cliente Físico</h3>
	<form action="sistema?logica=CadastrarFisico" method="post">
		Nome: <br> <input type="text" name="nome"> <br><br>
		Endereço: <br> <input type="text" name="endereco"> <br><br>
		Telefone: <br> <input type="text" name="telefone"> <br><br>
		CPF:  <br> <input type="text" name="cpf"> <br><br>
		Nome da Mãe:  <br> <input type="text" name="nomeMae"> <br><br>
		Nome do Pai: <br> <input type="text" name="nomePai"> <br><br>
	
	<br> <input type="submit" value="Cadastrar Cliente">
	</form>
</body>
</html>