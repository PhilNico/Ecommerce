<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.js"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/jquery-3.2.1.min.js"/>" />
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h2>Hover Rows</h2>
		<p>Voici la liste des Catégories :</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nom Categorie</th>
					<th>Description</th>
					<th>Photo</th>
					<th>Produits de la categorie</th>
				</tr>
			</thead>
			<c:forEach var="categorie" items="${listeCategorie}">
				<tbody>
					<tr>
						<td>${categorie.idCategorie}</td>
						<td>${categorie.description}</td>
						<td>${categorie.photo}</td>
						<td><a href="${pageContext.request.contextPath}/client/afficherProduitCat/1">Afficher Produit</a>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>

	<br/>
	<a href="${pageContext.request.contextPath}/client/rechercheParMot" style="text-align: center;" >rechercher un produit par mot clé</a>

</body>
</html>