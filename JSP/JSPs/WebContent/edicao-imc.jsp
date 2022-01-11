<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualização de Imc</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
    <br>
	<center><h1>Edição de Imc</h1></center>
	<br>
	<c:if test="${not empty msg }">
	<div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${not empty erro }">
	<div class="alert alert-danger">${erro}</div>
    </c:if>
	<form action="imc" method="post">
		<input type="hidden" value="editar" name="acao">
		<input type="hidden" value="${imc.codigoImc}" name="codigo">
		<div class="form-group">
			<label for="id-peso">Peso</label>
			<input type="text" name="peso" id="id-peso" class="form-control" value="${imc.peso}" >
		</div>
		<div class="form-group">
			<label for="id-altura">Altura</label>
			<input type="text" name="altura" id="id-altura" class="form-control" value="${imc.altura}">
		</div>
		<br>
		<input type="submit" value="Salvar" class="btn btn-success">
		<a href="imc?acao=listar" class="btn btn-danger">Cancelar</a>
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>