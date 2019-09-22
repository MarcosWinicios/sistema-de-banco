<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sistema de Banco</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<div id="sessao">
		<h2>Falha ao realizar opeção</h2>
		<div id="menu">
			<div class="opt-menu">
				<a target="sessao" class="a-menu" href="<%= request.getParameter("pagina")%>">Retornar</a>
			</div>
		</div>
	</div>
</body>
</html>