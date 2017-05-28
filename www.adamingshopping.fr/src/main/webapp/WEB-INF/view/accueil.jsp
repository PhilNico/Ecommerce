<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.js"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/jquery-3.2.1.min.js"/>"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>

<%@include file="../templates/navBar.jsp" %>

<h1 style="text-align: center;">Bienvenue sur Adaming Shopping</h1>


<div class="container">
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
						<td>${categorie.nomCategorie}</td>
						<td>${categorie.description}</td>
						<td>${categorie.photo}</td>
						<td><a href="${pageContext.request.contextPath}/client/afficherProduitCat?categorieId=${categorie.idCategorie}">Afficher Produit</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>

<a href="${pageContext.request.contextPath}/client/panier">afficher panier</a>


</body>
</html>