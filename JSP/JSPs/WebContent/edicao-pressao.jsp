<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualização de Pressão</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
    <br>
	<center><h1>Edição de Pressao</h1></center>
	<br>
	<c:if test="${not empty msg }">
	<div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${not empty erro }">
	<div class="alert alert-danger">${erro}</div>
    </c:if>
	<form action="pressao" method="post">
		<input type="hidden" value="editar" name="acao">
		<input type="hidden" value="${pressao.codigoPressao}" name="codigo">
		<div class="form-group">
			<label for="id-sistolica">Sistolica</label>
			<input type="text" name="sistolica" id="id-sistolica" class="form-control" value="${pressao.sistolica}" >
		</div>
		<div class="form-group">
			<label for="id-diastolica">Diastolica</label>
			<input type="text" name="diastolica" id="id-diastolica" class="form-control" value="${pressao.diastolica}">
		</div>
		<div class="form-group">
			<label for="id-bpm">Bpm</label>
			<input type="text" name="bpm" id="id-bpm" class="form-control" value="${pressao.bpm}">
		</div>
		<br>
		<input type="submit" value="Salvar" class="btn btn-success">
		<a href="pressao?acao=listar" class="btn btn-danger">Cancelar</a>
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>