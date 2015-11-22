<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="/Pixel_Shirt/tab.css" />
<title>Gestion Panier</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<p>Recapitulatif des articles dans le panier + possibilité de valider</p>
<p>Bonjour ${client.nom} ${client.prenom} voici le panier</p>
<table class="Tableau">
		 <tr class="legende">
	      <td><c:out value="Id" /></td>
	      <td><c:out value="Couleur" /></td>
	      <td><c:out value="Taille" /></td>
	      <td><c:out value="Modele" /></td>
	      <td><c:out value="Prix" /></td>
	      <td><c:out value="QuantiteTest" /></td>
	      <td><c:out value="Quantite" /></td>
	      <td><c:out value="Bouton" /></td>	      
	   	</tr>
	   <c:forEach var="article" items="${listeArticles}">
	    <tr>
	      <td><c:out value="${article.key.id_article}" /></td>
	      <td><c:out value="${article.key.couleur}" /></td>
	      <td><c:out value="${article.key.taille}" /></td>
	      <td><c:out value="${article.key.modele}" /></td>
	      <td><c:out value="${article.key.prix} €" /></td>
	      <td><c:out value="${article.value}" /></td>
	      <td>
	      	<form name="quantitearticleform${article.key.id_article}" method="POST" action="Gestion" id="form${article.key.id_article}">
		      	<input type="hidden" name="article_id" value="${article.key.id_article}">
		      	<input type="number" id="quantite" min="1" name="quantite" size="5" value="${article.value}">
		      	<input type="submit" id="quantite2" name="quantite2" value="ok" />
		    </form>
	      </td>
	      <td>
	      	<form name="supprimerarticleform${article.key.id_article}" method="POST" action="Gestion" id="form${article.key.id_article}">
		      	<input type="hidden" name="article_id" value="${article.key.id_article}">
		      	<input type="submit" id="supprimer" name="supprimer" value="Supprimer" class="sansLabel" />
		    </form>
	      </td>
	   </tr>
	  </c:forEach>
	</table>
<p>Total : ${total} €</p> <span>
							<c:choose>
								<c:when test="${not empty client}">
								<form name="supprimercompteform" method="POST" action="Gestion" id="formSupprCompte">
								<input type="submit" id="supprimerCompte" name="supprimerCompte" value="Supprimer son Compte" class="sansLabel" />
								</form>
								</c:when>
							</c:choose>
						</span>
<form name="commanderarticleform${article.id_article}" method="POST" action="Connexion" id="form${article.id_article}">
	<input type="submit" id="commander" name="commander" value="Commander" class="sansLabel" />
</form>
</body>
</html>