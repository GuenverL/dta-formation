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
		<c:forEach var="pizzas" items="${events.keySet()}">
			<c:choose>
				<c:when test="${pizzas =='CREATION'}">
					<div class="panel panel-success">
				</c:when>
				<c:when test="${pizzas =='MODIFICATION'}">
					<div class="panel panel-warning">
				</c:when>
				<c:otherwise>
					<div class="panel panel-danger">				
				</c:otherwise>
			</c:choose>
				<div class="panel-heading">Pizzas ${pizzas.toString()}</div>
				<div class="panel-body">
					<table class="table table-striped">
						<tr>
							<th>CODE</th>
							<th>Nom</th>
							<th>Prix</th>
							<th>Catégorie</th>
							<th>Heure de création</th>
						</tr>
						<c:forEach var="event" items="${events.get(pizzas)}">
							<tr>
								<td>${event.pizza.code}</td>
								<td>${event.pizza.nom}</td>
								<td>${event.pizza.prix}</td>
								<td>${event.pizza.categorie}</td>
								<td>${event.time}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</c:forEach>
	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>