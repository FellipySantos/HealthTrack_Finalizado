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

<br><br><br><br><br>



<center><body>
    <div>
         <h2>Login Health Track</h2>
        <form id="formLogin" method="Post" action="login"> <br><br>
            <label id="msg"></label>
            <input type="email" name="email" id="email" placeholder="Digite seu email..." required><br><br>
            <input type="password" name="senha" id="senha" placeholder="Digite sua senha..." required><br><br>
            <button type="submit">Entrar</button>
            <a href="cadastro-atleta.jsp" >Cadastre-se</a>
        </form>
    </div>
    
    </center>
</body>



<%@ include file="footer.jsp" %>
</body>
</html>