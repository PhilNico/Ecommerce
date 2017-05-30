<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.js"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/jquery-3.2.1.min.js"/>"/>
<title>Formulaire User</title>
</head>
<body>



<h2>User</h2>
		<p>Formulaire d'ajout de client:</p>

<form:form action="ajouterClient" modelAttribute="uUser" method="POST" class="form-horizontal" >
 
 
      <form:input path="id" type="hidden"/>

 
  <div class="form-group">
    <label for="inputUserName" class="col-sm-2 control-label">Nom du client</label>
    <div class="col-sm-8">
      <form:input type="text" class="form-control" id="inputUserName" placeholder="Nom User" path="username"/>
    </div>
  </div>
  
  
  
  <div class="form-group">
    <label for="inputPassword" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-8">
      <form:input type="text" class="form-control" id="inputPassword" placeholder="Password" path="password"/>
    </div>
  </div>

  <div class="form-group">
    <label for="inputActived" class="col-sm-2 control-label">Actived</label>
    <div class="col-sm-8">
      <form:input type="text" class="form-control" id="inputActived" placeholder="Actived" path="actived"/>
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