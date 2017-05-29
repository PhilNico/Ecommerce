<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.js"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/jquery-3.2.1.min.js"/>" />
<title>Formulaire produit</title>
<%@include file="../templates/Header.jsp"%>
</head>
<body>

	<%@include file="../templates/navBar2.jsp"%>

	<div class="container">
		<h2>Produits</h2>
		<p>Voici la liste des Produits:</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Designation</th>
					<th>Description</th>
					<th>Prix</th>
					<th>Quantité</th>
					<th>Photo</th>
					<th>Opération</th>
				</tr>
			</thead>
			<c:forEach var="produit" items="${listeProduitMot}">
				<tbody>
					<tr>
						<td>${produit.designation}</td>
						<td>${produit.description}</td>
						<td>${produit.prix}</td>
						<td>${produit.quantite}</td>
						<td><img src="photoProd?idProd=${produit.idProduit}" /></td>
						<td><a
							href="${pageContext.request.contextPath}/setting/delete?idProduit=${produit.idProduit}">Supprimer</a>
							| <a
							href="${pageContext.request.contextPath}/setting/modifierProduit?idProduit=${produit.idProduit}">modifier</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>




	<%-- <form:form action="rechercheParMot" modelAttribute="mProduit" method="POST" class="form-horizontal"> --%>
	<!-- <div class="form-group"> -->
	<!--     <label for="inputmot" class="col-sm-2 control-label">Mot clé</label> -->
	<!--     <div class="col-sm-8"> -->
	<%--       <form:input type="text" class="form-control" id="inputmot" placeholder="Mot Clé" path="designation"/> --%>
	<!--     </div> -->
	<!--   </div> -->

	<!--    <div class="form-group"> -->
	<!--     <div class="col-sm-offset-2 col-sm-10"> -->
	<!--       <button type="submit" class="btn btn-default">Rechercher</button> -->
	<!--     </div> -->
	<!--   </div> -->
	<%-- </form:form> --%>

	<%-- 	<a href="${pageContext.request.contextPath}/setting/formulaireProduit" style="text-align: center;" >ajouter un produit</a> --%>
	<!-- 	<br/> -->
	<%-- 	<a href="${pageContext.request.contextPath}/setting/rechercheProduit" style="text-align: center;" >rechercher un produit</a> --%>
	<!-- 	<br/> -->
	<%-- 	<a href="${pageContext.request.contextPath}/client/rechercheParMot" style="text-align: center;" >rechercher un produit par mot clé</a> --%>
	<%@include file="../templates/footer.jsp"%>
</body>
</html>

