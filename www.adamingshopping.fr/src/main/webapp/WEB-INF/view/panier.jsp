<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.js"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/jquery-3.2.1.min.js"/>"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votre panier</title>

<%@include file="../templates/Header.jsp" %>
</head>
<body>

<%@include file="../templates/navBar.jsp" %>

<h1 style="text-align: center;">Votre panier :</h1>


<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Produit</th>
					<th>Quantite</th>
					<th>Prix</th>
					<th>Opération</th>
				</tr>
			</thead>
			<c:forEach var="ligneCommande" items="${listeCommande}">
				<tbody>
					<tr>
						<td>${ligneCommande.produit.designation}</td>
						<td>${ligneCommande.quantite}</td>
						<td>${ligneCommande.prix}</td>
						<td><a href="">Modifier</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>



 <%@include file="../templates/footer.jsp" %>
</body>
</html>