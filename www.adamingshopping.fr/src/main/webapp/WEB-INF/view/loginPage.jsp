<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.js"/>"/>
<link rel="stylesheet" href="<c:url value="/assets/jquery-3.2.1.min.js"/>"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="container">
  <h2>Entrez vos identifiants</h2>
  	<form action="j_spring_security_check" method="post">
    <div class="form-group">
      <label for="login">Login :</label>
      <input type="text" class="form-control" id="login" placeholder="Entrez votre login" name="j_username">
    </div>
    <div class="form-group">
      <label for="pwd"> Mot de passe :</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="j_password">
    </div>
    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Se souvenir de moi</label>
    </div>
    <button type="submit" class="btn btn-default">Se connecter</button>
  </form>
</div>

	<c:if test="${not empty erreur}">
		<h1 style="color: red">Tu t'es trompé sur le Login ou Mdp tu n'as
			plus qu'a trouvé lequel</h1>
	</c:if>
</body>
</html>