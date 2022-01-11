<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualização de Nutricionista</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
    <br>
	<center><h1>Edição de Nutricionista</h1></center>
	<br>
	<c:if test="${not empty msg }">
	<div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${not empty erro }">
	<div class="alert alert-danger">${erro}</div>
    </c:if>
	<form action="nutri" method="post">
		<input type="hidden" value="editar" name="acao">
		<input type="hidden" value="${nutri.userID}" name="codigo">
		<div class="form-group">
			<label for="id-nome">Nome</label>
			<input type="text" name="nome" id="id-nome" class="form-control" value="${nutri.nome}" >
		</div>
		<div class="form-group">
			<label for="id-dtNasc">Data de Nascimento</label>
			<input type="text" name="dtNasc" id="id-dtNasc" class="form-control" value='<fmt:formatDate value="${nutri.dtNasc.time}" pattern="dd/MM/yyyy"/>'>
		</div>
		<div class="form-group">
			<label for="id-sexo">Sexo</label>
			<input type="text" name="sexo" id="id-sexo" class="form-control" value="${nutri.sexo}">
		</div>
		<div class="form-group">
			<label for="id-email">E-mail</label>
			<input type="text" name="email" id="id-email" class="form-control" value="${nutri.email}">
		</div>
		<div class="form-group">
			<label for="id-cnpj">CNPJ</label>
			<input type="text" name="cnpj" id="id-cnpj" class="form-control" value="${nutri.cnpj}">
		</div>
		<div class="form-group">
			<label for="id-crn">CRN</label>
			<input type="text" name="crn" id="id-crn" class="form-control" value="${nutri.crn}">
		</div>
		<br>
		<input type="submit" value="Salvar" class="btn btn-success">
		<a href="nutri?acao=listar" class="btn btn-danger">Cancelar</a>
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>