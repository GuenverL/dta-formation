<%@page import="dta.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lister Pizzas</title>
</head>
<body>
	<div class="container-fluid">
	<h1 class="jumbotron">liste des pizzas</h1>				
	<% 
		List<Pizza> pizzas = (List<Pizza>)request.getAttribute("pizzas");		
	%>
	
	<table class="table table-striped">
		<tr>
			<th>CODE</th><th>Nom</th><th>Prix</th><th>Catégorie</th>
		</tr>
		<% for(Pizza p : pizzas){%>
		
		<tr>
			<td><%=p.getCode()%></td><td><%=p.getNom()%></td><td><%=p.getPrix()%></td><td><%=p.getCategorie()%></td>
		</tr>		
		
		<% }%>
	</table>
	</div>
</body>
</html>