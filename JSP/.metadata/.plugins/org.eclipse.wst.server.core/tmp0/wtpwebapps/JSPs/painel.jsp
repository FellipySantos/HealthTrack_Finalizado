<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Health Track</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
		      <div class="alert alert-success" role="alert">
		      
 <div class="container"> <h4><b><center>PAINEL DE CONTROLE</center></b></h4> <br><br>
        <div class="row"> 
          <div class="col-3"> 

            <div class="card" style="width: 16rem;">
              <img src="resources/img/card_imagem_1.jpg" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Dieta</h5>
                <p class="card-text">Clique aqui para cadastrar novas dietas.</p>
                <a href="cadastro-dieta.jsp" class="btn btn-success">Cadastrar</a>
              </div>
            </div>

          </div>

          <div class="col-3">

            <div class="card" style="width: 16rem;">
              <img src="resources/img/card_imagem_2.jpg" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Press?o</h5>
                <p class="card-text">Clique aqui para cadastrar a suas press?es.</p>
                <a href="cadastro-pressao.jsp" class="btn btn-success">Cadastrar</a>
              </div>
            </div>

          </div>

          <div class="col-3">

            <div class="card" style="width: 16rem;">
              <img src="resources/img/card_imagem_3.jpg" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Treino</h5>
                <p class="card-text">Clique aqui para cadastrar novos treinos.</p>
                <a href="cadastro-treino.jsp" class="btn btn-success">Cadastrar</a>
              </div>
            </div>

          </div>

          <div class="col-3">

            <div class="card" style="width: 16rem;">
              <img src="resources/img/card_imagem_4.jpg" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Imc</h5>
                <p class="card-text">Clique aqui para cadastrar novas medidas corporais.</p>
                <a href="cadastro-imc.jsp" class="btn btn-success">Cadastrar</a>
              </div>
            </div>

          </div>

      </div>
    



<%@ include file="footer.jsp" %>
</body>
</html>