<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.js"/>"/>
<link rel="stylesheet"
	href="<c:url value="/assets/jquery-3.2.1.min.js"/>"/>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h2>Produits</h2>
		<p>Voici la liste des Produits:</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID Produit</th>
					<th>Designation</th>
					<th>Description</th>
					<th>Prix</th>
					<th>Quantité</th>
					<th>Photo</th>
					<th>Opération</th>
				</tr>
			</thead>
			<c:forEach var="prod" items="${pListe}">
				<tbody>
					<tr>
						<td>${prod.idProduit}</td>
						<td>${prod.designation}</td>
						<td>${prod.description}</td>
						<td>${prod.prix}</td>
						<td>${prod.quantite}</td>
						<td>${prod.photo}</td>
						
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>

</body>
</html>