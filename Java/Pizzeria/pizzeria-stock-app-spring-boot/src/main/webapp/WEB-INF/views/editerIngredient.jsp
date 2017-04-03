<%@page import="dta.pizzeria.stock.boot.model.Ingredient"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edition d'ingrédient</title>
</head>
<body>
	<c:set var="ingredient" scope="session" value="${ingredient}" />
	<div class="container-fluid col-xs-10 col-xs-offset-1">
		<form:form class="form-horizontal" method="post"
			modelAttribute="ingredient">
			<fieldset>
				<legend>Editez votre ingredient.</legend>
				<fieldset disabled>
					<div class="form-group">
						<label>id de l'ingredient</label>
						<form:input type="text" class="form-control" path="nom"
							value="${id}" />
					</div>
				</fieldset>

				<div class="form-group">
					<label>Nom de l'ingredient</label>
					<form:input type="text" class="form-control" path="nom" />
				</div>
				<div class="form-group">
					<label>Prix de l'ingredient</label>
					<form:input type="number" step="0.5" class="form-control"
						path="prix" />
				</div>

				<div class="form-group">
					<label>Quantité d'ingredient</label>
					<form:input type="number" step="0.5" class="form-control"
						path="quantite" />
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-success">
						Valider<span class="glyphicon glyphicon-ok pull-right"></span>
					</button>
				</div>
			</fieldset>
		</form:form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>