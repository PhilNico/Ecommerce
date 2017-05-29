
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/client/accueil">Adaming Shopping</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/client/afficherCategories">Categories <span class="sr-only">(current)</span></a></li>
        <li><a href="${pageContext.request.contextPath}/client/afficherProduitClient">Tout les Produits</a></li>
<!--         <li class="dropdown"> -->
<!--           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a> -->
<!--           <ul class="dropdown-menu"> -->
<!--             <li><a href="#">Action</a></li> -->
<!--             <li><a href="#">Another action</a></li> -->
<!--             <li><a href="#">Something else here</a></li> -->
<!--             <li role="separator" class="divider"></li> -->
<!--             <li><a href="#">Separated link</a></li> -->
<!--             <li role="separator" class="divider"></li> -->
<!--             <li><a href="#">One more separated link</a></li> -->
<!--           </ul> -->
<!--         </li> -->
      </ul>
      
      <form:form class="navbar-form navbar-left" action="rechercheParMot" modelAttribute="pProduit" method="POST">
        <div class="form-group">
          <form:input type="text" class="form-control" id="inputmot" placeholder="Search" path="designation"/>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form:form>
      
      <ul class="nav navbar-nav navbar-right">
    
        <li><a style="color: white" href="${pageContext.request.contextPath}/setting/afficherProduits" class="btn btn-info">Admin</a></li>
       <li><a style="color: white" href="${pageContext.request.contextPath}/client/panier" class="btn btn-success" >Panier</a></li>
     
<!--         <li class="dropdown"> -->
<!--           <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Administrateur<span class="caret"></span></a> -->
<!--          <ul class="dropdown-menu"> -->
<%--             <li><a href="${pageContext.request.contextPath}/settingCat/adminCat/afficherCategorieAdmin">Admin Categorie</a></li> --%>
<%--             <li><a href="${pageContext.request.contextPath}/settingCat/admin/afficherProduits">Admin Produit</a></li> --%>
<!--           </ul> -->
<!--         </li> -->
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

