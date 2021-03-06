<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
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


<%@include file="../templates/navBar.jsp" %>

	<div class="container">
		<h2>Produits</h2>
		<p>Voici la liste des Produits de la Cat�gorie selectionn�e:</p>
		<table class="table table-hover">
			<thead>
				<tr>
				
					<th>Le petit Nom</th>
					<th>Description</th>
					<th>Prix</th>
					<th>Quantit� disponible</th>
					<th>Photo</th>
					<th>Op�ration</th>
				</tr>
			</thead>
			<c:forEach var="prod" items="${pListe}">
				<tbody>
					<tr>
					
						<td>${prod.designation}</td>
						<td>${prod.description}</td>
						<td>${prod.prix}</td>
						<td>${prod.quantite}</td>
						<td><img src="photoProd?idProd=${prod.idProduit}" /></td>
						<td><a href="${pageContext.request.contextPath}/client/formulaireAjout?idProduit=${prod.idProduit}">Ajouter au panier</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
 
 <%@include file="../templates/footer.jsp" %>
 
</body>
</html>