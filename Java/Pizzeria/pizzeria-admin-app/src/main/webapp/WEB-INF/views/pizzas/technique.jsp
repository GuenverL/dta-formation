<%@page import="dta.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Page de login</title>
</head>
<body>
	<div class="container">
		Nombre de session ouvertes : ${applicationScope.cpt}
		Nombre de pizzas créées : ${pizzas}
	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>