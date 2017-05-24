<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  

	<div align="center">
		<table>
			<tr style="background-color: blue; color: white; text-align: center">
				<th>ID Produit</th>
				<th>Designation</th>
				<th>Description</th>
				<th>Prix</th>
				<th>Quantité</th>
				<th>Photo</th>
				<th>Opération</th>
			</tr>
			<c:forEach var="produit" items="${listeProduit}">
				<tr>
					<td>${produit.idProduit}</td>
					<td>${produit.designation}</td>
					<td>${produit.description}</td>
					<td>${produit.prix}</td>
					<td>${produit.quantite}</td>
					<td>${produit.photo}</td>
					<td><a href="${pageContext.request.contextPath}/setting/delete?idProduit=${produit.idProduit}">Supprimer</a> | modifier</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>