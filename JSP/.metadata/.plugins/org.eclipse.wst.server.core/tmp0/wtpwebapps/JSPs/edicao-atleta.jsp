<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualiza??o de Atleta</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
    <br>
	<center><h1>Edi??o de Atleta</h1></center>
	<br>
	<c:if test="${not empty msg }">
	<div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${not empty erro }">
	<div class="alert alert-danger">${erro}</div>
    </c:if>
	<form action="atleta" method="post">
		<input type="hidden" value="editar" name="acao">
		<input type="hidden" value="${atleta.userID}" name="codigo">
		<div class="form-group">
			<label for="id-nome">Nome</label>
			<input type="text" name="nome" id="id-nome" class="form-control" value="${atleta.nome}" >
		</div>
		<div class="form-group">
			<label for="id-dtNasc">Data de Nascimento</label>
			<input type="text" name="dtNasc" id="id-dtNasc" class="form-control" value='<fmt:formatDate value="${atleta.dtNasc.time}" pattern="dd/MM/yyyy"/>'>
		</div>
		<div class="form-group">
			<label for="id-sexo">Sexo</label>
			<input type="text" name="sexo" id="id-sexo" class="form-control" value="${atleta.sexo}">
		</div>
		<div class="form-group">
			<label for="id-email">E-mail</label>
			<input type="text" name="email" id="id-email" class="form-control" value="${atleta.email}">
		</div>
		<div class="form-group">
			<label for="id-cpf">CPF</label>
			<input type="text" name="cpf" id="id-cpf" class="form-control" value="${atleta.cpf}">
		</div>
		<br>
		<input type="submit" value="Salvar" class="btn btn-success">
		<a href="atleta?acao=listar" class="btn btn-danger">Cancelar</a>
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>