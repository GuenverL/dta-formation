<%@page import="dta.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Ajout de pizza</title>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" method="post">		
			<fieldset>
				<legend>Ajoutez votre pizza.</legend>
				
				<div class="form-group">
					<label>Code de la pizza</label> <input type="text" maxlength="4" class="form-control" name="pizzaCode" required>
				</div>
				<div class="form-group">
					<label>Nom de la pizza</label> <input type="text" class="form-control" name="pizzaName" required>
				</div>
				<div class="form-group">
					<label>Prix de la pizza</label> <input type="number" step="0.5" class="form-control" name="pizzaPrice" required>
				</div>
				
				<div class="form-group">
					<label>Catégorie de la pizza</label>
					
					<div class="input-group">
    					<select name="pizzaCat" class="form-control">
      						<option value="Viande">Viande</option>
      						<option value="Poisson">Poisson</option>
      						<option value="Sans_Viande">Sans_Viande</option>
    					</select>
					</div>
				</div>
				
				<div class="form-group">
					<button type="submit" class="btn btn-success">
						Valider<span class="glyphicon glyphicon-ok pull-right"></span>
					</button>
				</div>
			</fieldset>
		</form>
	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>