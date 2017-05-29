<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.js"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/jquery-3.2.1.min.js"/>" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>

<%@include file="../templates/Header.jsp" %>
</head>
<body>
<%@include file="../templates/navBar2.jsp"%>

	<a style="color: black" class="btn btn-info"
		href="${pageContext.request.contextPath}/settingCat/afficherFormUser">Ajouter
		un user</a>
	<br />

<div class="container">
		<h2>Catégorie</h2>
		<p>Voici la liste des Catégories :</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>UserName</th>
					<th>Password</th>
					<th>Actived</th>
					<th>Opération</th>
				</tr>
			</thead>
			<c:forEach var="user" items="${listeUser}">
				<tbody>
					<tr>
						<td>${user.id}</td>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.actived}</td>
						<td><a href="${pageContext.request.contextPath}/settingCat/deleteUser?id=${user.id}">Supprimer</a>|<a href="${pageContext.request.contextPath}/settingCat/modifierUser?id=${user.id}">modifier</a></td>
<%-- 							${pageContext.request.contextPath}/settingCat/modifier?idCategorie=${categorie.idCategorie} --%>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>

<!-- 	<a -->
<%-- 		href="${pageContext.request.contextPath}/settingCat/rechercherCategorie">Rechercher --%>
<!-- 		une catégorie</a> -->

<%@include file="../templates/footer.jsp" %>

</body>
</html>