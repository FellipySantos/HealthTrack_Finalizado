<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Dieta</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
<br>
	<h1><center>Cadastro de Dieta</center></h1>
<center> <img src="resources/img/card_imagem_1.jpg" class="card-img-top" alt="..."  style="width: 12rem;"></center>

	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<c:if test="${not empty erro }">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	<form action="dieta" method="post">
		<input type="hidden" value="cadastrar" name="acao">
		<div class="form-group">
			<label for="id-nome">Nome</label>
			<input type="text" name="nome" id="nome" class="form-control" placeholder="Digite o nome">
		</div>
		<div class="form-group">
			<label for="id-descricao">Descri??o</label>
			<input type="text" name="descricao" id="id-descricao" class="form-control"  placeholder="Digite uma descri??o">
		</div>
		<div class="form-group">
			<label for="id-qtdCal">Calorias</label>
			<input type="text" name="qtdCal" id="id-qtdCal" class="form-control"  placeholder="9999">
		</div>
		<div class="form-group">
			<label for="id-validade">Validade</label>
			<input type="text" name="validade" id="id-validade" class="form-control"  placeholder="Digite uma validade">
		</div>
		<br>
		<input type="submit" value="Salvar" class="btn btn-success">
	</form>
</div>


<%@ include file="footer.jsp" %>
</body>
</html>