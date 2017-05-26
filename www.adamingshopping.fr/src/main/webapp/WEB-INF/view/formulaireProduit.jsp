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
<title>Formulaire produit</title>
</head>
<body>

<h2>Produits</h2>
		<p>Formulaire d'ajout ou de modification de produit:</p>

<form:form action="ajouterProduit" modelAttribute="pProduit" method="POST" class="form-horizontal">
 
 
      <form:input path="idProduit" type="hidden"/>

 
  <div class="form-group">
    <label for="inputDesignation" class="col-sm-2 control-label">Designation</label>
    <div class="col-sm-8">
      <form:input type="text" class="form-control" id="inputDesignation" placeholder="Designation" path="designation"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputDescription" class="col-sm-2 control-label">Description</label>
    <div class="col-sm-8">
      <form:input type="text" class="form-control" id="inputDescription" placeholder="Description" path="description"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPrix" class="col-sm-2 control-label">Prix</label>
    <div class="col-sm-8">
      <form:input type="text" class="form-control" id="inputPrix" placeholder="Prix" path="prix"/>
    </div>
  </div>
  
   <div class="form-group">
    <label for="inputQuantite" class="col-sm-2 control-label">Quantite</label>
    <div class="col-sm-8">
      <form:input type="text" class="form-control" id="inputQuantite" placeholder="Quantite" path="quantite"/>
    </div>
  </div>
  
  
  <div class="form-group">
    <label for="inputPhoto" class="col-sm-2 control-label">Photo</label>
    <div class="col-sm-8">
      <form:input type="text" class="form-control" id="inputPhoto" placeholder="lien de la photo" path="photo"/>
    </div>
  </div>
  
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Ajouter/ modifier</button>
    </div>
  </div>

 
 
 </form:form>
 
 
 
</body>
</html> 