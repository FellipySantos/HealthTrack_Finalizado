<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Imc</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
    <br>
	<h1><center>Cadastro de Imc</center></h1>
	<center> <img src="resources/img/card_imagem_4.jpg" class="card-img-top" alt="..."  style="width: 12rem;"></center>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<c:if test="${not empty erro }">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	<form action="imc" method="post">
		<input type="hidden" value="cadastrar" name="acao">
		<div class="form-group">
			<label for="id-peso">Peso</label>
			<input type="text" name="peso" id="id-peso" class="form-control"  placeholder="99.9">
		</div>
		<div class="form-group">
			<label for="id-altura">Altura</label>
			<input type="text" name="altura" id="id-altura" class="form-control"  placeholder="1.80">
	    </div>
		<br>
		<input type="submit" value="Salvar" class="btn btn-success">
	</form>
</div>


<%@ include file="footer.jsp" %>
</body>
</html>