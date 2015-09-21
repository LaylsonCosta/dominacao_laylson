
<%@page import="br.com.laylson.dominacao.persistencia.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Bem Vindo</title>
</head>
<body>

<%@include file="menu.jsp" %>

Bem vindo, <%
	Usuario usuario = (Usuario)request.getSession().getAttribute("usuAutenticado");
	out.print(usuario.getNome());
%>
</body>
</html>