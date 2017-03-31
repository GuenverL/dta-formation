<%@page import="dta.pizzeria.stock.model.Ingredient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet"
			href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Liste des ingrédientss</title>
	</head>
	<body>
		<div class="container-fluid">
			
			<h1 class="jumbotron">Liste des ingredients</h1>
			<div class="table-responsive">
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Prix</th>
						<th>quantité</th>
						<th colspan="2"><a type="button"
							class="btn btn-success btn-block" href="ingredient/add">Ajouter un
								nouvel ingredient <span class="glyphicon glyphicon-plus pull-right"></span>
						</a></th>
						<th></th>
					</tr>
					<c:forEach var="ingredient" items="${ingredients}">
						<tr>
							<td>${ingredient.id}</td>						
							<td>${ingredient.nom}</td>
							<td>${ingredient.prix}</td>
							<td>${ingredient.quantite}</td>
							<td>
								<a type="button" class="btn btn-warning btn-block" href="ingredient/${ingredient.id}">
									Editer
									<span class="glyphicon glyphicon-pencil pull-right"></span>
								</a>
							</td>
							<td>
								<a type="button" class="btn btn-danger btn-block" id="delBtn" data-toggle="modal" href="#delModal" data-del-id="${ingredient.id}">
								Supprimer
								<span class="glyphicon glyphicon-remove pull-right"></span>
								</a>
							</td>
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
						<button type="button" class="btn btn-success" data-dismiss="modal">Annulez<span class="glyphicon glyphicon-remove pull-right"></span>
						</button>
						<a id="valBtn" href="" type="button" class="btn btn-danger">Continuez<span class="glyphicon glyphicon-ok pull-right"></span>
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
								'href', "ingredient/del/"+del));
					});
		</script>
	</body>
</html>