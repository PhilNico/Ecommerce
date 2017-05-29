<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.js"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/jquery-3.2.1.min.js"/>"/>
<title>Formulaire categorie</title>
</head>
<body>

<%@include file="../templates/navBar.jsp" %>

	<div class="container">
		<h2>Hover Rows</h2>
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
			<c:forEach var="categorie" items="${listCategorie}">
			<tbody>
				<tr>
					<td>${categorie.idCategorie}</td>
					<td>${categorie.nomCategorie}</td>
					<td>${categorie.description}</td>
					<td><img src="${pageContext.request.contextPath}/settingCat/photoCat?idCategorie=${categorie.idCategorie}" /></td>
					<td><a href="${pageContext.request.contextPath}/settingCat/delete?idCategorie=${categorie.idCategorie}">Supprimer</a> | <a href="${pageContext.request.contextPath}/settingCat/modifier?idCategorie=${categorie.idCategorie}"" >modifier</a></td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>
	



<form:form action="rechercherCategorie" modelAttribute="cCategorie" method="POST" class="form-horizontal">
<div class="form-group">
    <label for="inputId" class="col-sm-2 control-label">ID de la categorie recherché</label>
    <div class="col-sm-8">
      <form:input type="text" class="form-control" id="inputId" placeholder="ID" path="idCategorie"/>
    </div>
  </div>
  
   <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Rechercher</button>
    </div>
  </div>
</form:form>

	<a href="${pageContext.request.contextPath}/settingCat/formulaireCategorie" style="text-align: center;" >ajouter un produit</a>
	<br/>
	<a href="${pageContext.request.contextPath}/settingCat/rechercherCategorie" style="text-align: center;" >rechercher un produit</a>
	<br/>
<%@include file="../templates/footer.jsp" %>
</body>
</html>

 