<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.js"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/jquery-3.2.1.min.js"/>" />
<title>Insert title here</title>

<%@include file="../templates/Header.jsp" %>
</head>
<body>
	<%@include file="../templates/navBar.jsp"%>


	<div class="container">
		<h2>Catégories</h2>
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
						<td>${categorie.nomCategorie}</td>
						<td>${categorie.description}</td>
						<td><img src="photoCat?idCat=${categorie.idCategorie}"></td>
						<td><a href="${pageContext.request.contextPath}/client/afficherProduitCat?categorieId=${categorie.idCategorie}">Afficher les Produits de la Catégorie</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>

<%@include file="../templates/footer.jsp" %>
</body>
</html>