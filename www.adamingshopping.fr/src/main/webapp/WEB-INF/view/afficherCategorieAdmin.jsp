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
<title>Categorie</title>

<%@include file="../templates/Header.jsp" %>
</head>
<body>
	<%@include file="../templates/navBar2.jsp"%>

<a style="color: black" href="${pageContext.request.contextPath}/settingCat/formulaireCategorie" class="btn btn-info" >Ajouter une Catégorie</a>

	<div class="container">
		<h2>Catégorie</h2>
		<p>Voici la liste des Catégories :</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Description</th>
					<th>Photo</th>
					<th>Opération</th>
				</tr>
			</thead>
			<c:forEach var="categorie" items="${listeCategorie}">
				<tbody>
					<tr>
						<td>${categorie.idCategorie}</td>
						<td>${categorie.nomCategorie}</td>
						<td>${categorie.description}</td>
						<td><img src="photoCat?idCat=${categorie.idCategorie}" /></td>
						<td><a
							href="${pageContext.request.contextPath}/settingCat/delete?idCategorie=${categorie.idCategorie}">Supprimer</a>
							| <a
							href="${pageContext.request.contextPath}/settingCat/modifier?idCategorie=${categorie.idCategorie}">modifier</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>


<%@include file="../templates/footer.jsp" %>
</body>
</html>