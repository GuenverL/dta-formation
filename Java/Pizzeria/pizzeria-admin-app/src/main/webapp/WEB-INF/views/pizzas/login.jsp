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
<title>Page de login</title>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" method="post">
				<legend>Authentifiez-vous.</legend>
				
				<div class="form-group">
					<label>Email</label> 
					<input type="email" class="form-control" name="userMail" required>
				</div>
				<div class="form-group">
					<label>Mot de passe</label> 
					<input type="password" class="form-control" name="UserPass" required>
				</div>
								
				<div class="form-group">
					<button type="submit" class="btn btn-success btn-block">
						Valider<span class="glyphicon glyphicon-ok pull-right"></span>
					</button>
				</div>
		</form>
	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>