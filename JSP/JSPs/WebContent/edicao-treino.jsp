<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualização de Treino</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
    <br>
	<center><h1>Edição de Treino</h1></center>
	<br>
	<c:if test="${not empty msg }">
	<div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${not empty erro }">
	<div class="alert alert-danger">${erro}</div>
    </c:if>
	<form action="treino" method="post">
		<input type="hidden" value="editar" name="acao">
		<input type="hidden" value="${treino.codigoTreino}" name="codigo">
		<div class="form-group">
			<label for="id-nome">Nome</label>
			<input type="text" name="nome" id="id-nome" class="form-control" value="${treino.nome}" >
		</div>
		<div class="form-group">
			<label for="id-descricao">Descrição</label>
			<input type="text" name="descricao" id="id-descricao" class="form-control" value="${treino.descricao}">
		</div>
		<div class="form-group">
			<label for="id-qtdCal">Calorias</label>
			<input type="text" name="qtdCal" id="id-qtdCal" class="form-control" value="${treino.qtdCal}">
		</div>
		<div class="form-group">
			<label for="id-validade">Validade</label>
			<input type="text" name="validade" id="id-validade" class="form-control" value="${treino.validade}">
		</div>
		<div class="form-group">
			<label for="id-frequencia">Frequência</label>
			<input type="text" name="frequencia" id="id-frequencia" class="form-control" value="${treino.frequencia}">
		</div>
		<br>
		<input type="submit" value="Salvar" class="btn btn-success">
		<a href="treino?acao=listar" class="btn btn-danger">Cancelar</a>
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>