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
<title>Liste des ingrédients</title>
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
						<li class="active"><a href="ingredients">Ingredients</a></li>
						<li><a href="performances">Performances</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>

		<h1 class="jumbotron">Liste des ingredients</h1>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>Nom</th>
					<th>Prix</th>
					<th>quantité</th>
					<th colspan="2"><a type="button"
						class="btn btn-success btn-block" href="ingredients/add">Ajouter
							un nouvel ingredient <span
							class="glyphicon glyphicon-plus pull-right"></span>
					</a></th>
					<th></th>
				</tr>
				<c:forEach var="ingredient" items="${ingredients}">
					<tr>
						<td>${ingredient.nom}</td>
						<td>${ingredient.prix}</td>
						<td>${ingredient.quantite}</td>
						<td><a type="button" class="btn btn-warning btn-block"
							href="ingredients/${ingredient.id}"> Editer <span
								class="glyphicon glyphicon-pencil pull-right"></span>
						</a></td>
						<td><a type="button" class="btn btn-danger btn-block"
							id="delBtn" data-toggle="modal" href="#delModal"
							data-del-id="${ingredient.id}"> Supprimer <span
								class="glyphicon glyphicon-remove pull-right"></span>
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div id="delModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Attention</h4>
				</div>
				<div class="modal-body">
					<p>Voulez-vous vraiment supprimer cet ingrédient ?.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">
						Annulez<span class="glyphicon glyphicon-remove pull-right"></span>
					</button>
					<a id="valBtn" href="" type="button" class="btn btn-danger">Continuez<span
						class="glyphicon glyphicon-ok pull-right"></span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script>
		$("#delModal").on(
				"show.bs.modal",
				function(e) {
					var del = $(e.relatedTarget).data("del-id");
					console.log($(e.currentTarget).find('a[id="valBtn"]').attr(
							'href', "ingredients/del/" + del));
				});
	</script>
</body>
</html>