<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Atleta</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
    <br>
    
	<h1><center>Cadastro de Atleta</center></h1>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<c:if test="${not empty erro }">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	<form action="atleta" method="post">
		<input type="hidden" value="cadastrar" name="acao">
		<div class="form-group">
			<label for="id-nome">Nome</label>
			<input type="text" name="nome" id="id-nome" class="form-control" placeholder="Digite o nome">
		</div>
		<div class="form-group">
			<label for="id-dtNasc">Data de Nascimento</label>
			<input type="text" name="dtNasc" id="id-dtNasc" class="form-control"  placeholder="DD/MM/AAAA">
		</div>
		<div class="form-group">
			<label for="id-sexo">Sexo</label>
			<input type="text" name="sexo" id="id-sexo" class="form-control"   placeholder="M ou F">
		</div>
		<div class="form-group">
			<label for="id-email">E-mail</label>
			<input type="email" name="email" id="id-email" class="form-control"  placeholder="email@email.com">
		</div>
		<div class="form-group">
			<label for="id-senha">Senha</label>
			<input type="password" name="senha" id="id-senha" class="form-control" placeholder="*******">
		</div>
		<div class="form-group">
			<label for="id-cpf">CPF</label>
			<input type="text" name="cpf" id="id-cpf" class="form-control"  placeholder="99.999.999-99">
		</div>

		<br>
		<input type="submit" value="Salvar" class="btn btn-success">
	</form>
</div>


<%@ include file="footer.jsp" %>
</body>
</html>