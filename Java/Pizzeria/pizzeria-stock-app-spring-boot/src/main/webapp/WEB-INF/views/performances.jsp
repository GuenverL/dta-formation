<%@page import="dta.pizzeria.stock.boot.model.Ingredient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="webjars/bootstrap/3.3.7-1/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Performances</title>
</head>
<body>
	<div class="container-fluid">
	
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Pizzeria</a>
				</div>
				<div class="navbar-collapse collapse" aria-expanded="false"
					style="height: 1px;">
					<ul class="nav navbar-nav">
						<li><a href="/">Accueil</a></li>
						<li><a href="ingredients">Ingredients</a></li>
						<li class="active"><a href="performances">Performances</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>

		<h1 class="jumbotron">Historique des actions</h1>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>Action</th>
					<th>Date</th>
					<th>Durée</th>
				</tr>
				<c:forEach var="perf" items="${performances}">
					<tr>
						<td>${perf.service}</td>
						<td>${perf.date}</td>
						<td>${perf.temps}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>