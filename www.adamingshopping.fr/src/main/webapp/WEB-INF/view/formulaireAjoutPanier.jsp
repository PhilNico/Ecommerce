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
<title>Formulaire ajout produit</title>
</head>
<body>



	<h2>Produits</h2>
	<p>Formulaire d'ajout au panier :</p>

	<form:form action="ajouterAuPanier" modelAttribute="pProduit" method="POST"
		class="form-horizontal">


		<form:input path="idProduit" type="hidden" />


		<form:input type="hidden" class="form-control" id="inputDesignation"
			placeholder="Designation" path="designation" />


		<form:input type="hidden" class="form-control" id="inputDescription"
			placeholder="Description" path="description" />


		<form:input type="hidden" class="form-control" id="inputPrix"
			placeholder="Prix" path="prix" />


		<div class="form-group">
			<label for="inputQuantite" class="col-sm-2 control-label">Quantité
				souhaité</label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="inputQuantite"
					placeholder="Quantite" path="quantite" />
			</div>
		</div>


		<form:input type="hidden" class="form-control" id="inputPhoto"
			placeholder="lien de la photo" path="photo" />



		<button type="submit" class="btn btn-default">Ajouter au
			panier</button>



	</form:form>




 
</body>
</html>