<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Dieta</title>
<%@ include file="header.jsp" %>
</head>
<body>

<%@ include file="menu.jsp" %>
	<div class="container">
	    <br>
		<center><h1>Consulta de Dieta</h1></center>
		<center> <img src="resources/img/card_imagem_1.jpg" class="card-img-top" alt="..."  style="width: 12rem;"></center>
		<br>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<table class="table table-striped">
			<tr>
				<th>C?digo</th>
				<th>Data</th>
				<th>Nome</th>
				<th>Descri??o</th>
				<th>Calorias</th>
				<th>Validade</th>
				<th></th>
			</tr>
			<c:forEach items="${dieta}" var="p">
				<tr>
					<td>${p.codigoDieta}</td>
					<td>${p.dataDieta}</td>
					<td>${p.nome}</td>
					<td>${p.descricao}</td>
					<td>${p.qtdCal}</td>
					<td>${p.validade}</td>
					
					<td>
						<c:url value="dieta" var="link">
							<c:param name="acao" value="abrir-form-edicao"/>
							<c:param name="codigo" value="${p.codigoDieta}"/>
						</c:url>
						<a href="${link}" class="btn btn-success btn-xs">Editar</a>
						<button type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#excluirModal" onclick="codigoExcluir.value = ${p.codigoDieta}">
  							Excluir
						</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<%@ include file="footer.jsp" %>

<!-- Modal -->
<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirma??o</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		Deseja realmente excluir essa press?o?
      </div>
      <div class="modal-footer">
      	<form action="dieta" method="post">
      		<input type="hidden" name="acao" value="excluir">
      		<input type="hidden" name="codigo" id="codigoExcluir">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
    </div>
  </div>
</div>


</body>
</html>