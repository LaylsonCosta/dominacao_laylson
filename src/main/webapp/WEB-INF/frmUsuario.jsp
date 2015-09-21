<%@page import="br.com.laylson.dominacao.persistencia.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include file="menu.jsp" %>

	<%
		Usuario u = (Usuario)request.getAttribute("usu");
		u.setSenha("");
	%>
	<form action="usucontroller.do" method="post">
		ID: <input type="number" name="id" value="<%=u.getId()%>"><br>
		Nome: <input type="text" name="nome" value="<%=u.getNome()%>"> <br>
		Login: <input type="text"name="login" value="<%=u.getLogin()%>"> <br>
		Senha: <input type="text" name="senha" value="<%=u.getSenha()%>"><br>
		
		<input type="submit" value="Salvar">
		
	</form>

</body>
</html>