
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/client/accueil">Accueil</a>
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/settingCat/afficherCategorieAdmin">Catégories</a> <a class="navbar-brand"
				href="${pageContext.request.contextPath}/setting/afficherProduits">Produits</a>
				<a class="navbar-brand"
				href="${pageContext.request.contextPath}/settingCat/afficherUser">Users</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
			
			</ul>

			<form:form class="navbar-form navbar-left" action="rechercheParMotAdmin"
				modelAttribute="pProduit" method="POST">
				<div class="form-group">
					<form:input type="text" class="form-control" id="inputmot"
						placeholder="Search" path="designation" />
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>

			<ul class="nav navbar-nav navbar-right">
				<li><a style="color: black" type="button"
					class="btn btn-danger"
					href="<c:url value="/j_spring_security_logout"/>">Se
						deconnecter</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>

