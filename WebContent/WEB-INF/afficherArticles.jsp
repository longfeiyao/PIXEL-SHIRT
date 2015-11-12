<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="/Pixel_Shirt/tab.css" />
<title>Ajout d'articles</title>
</head>
<body>
<%@ include file="menu.jsp" %>
	<table class="Tableau">
		 <tr class="legende">
	      <td><c:out value="Id" /></td>
	      <td><c:out value="Couleur" /></td>
	      <td><c:out value="Taille" /></td>
	      <td><c:out value="Modele" /></td>
	      <td><c:out value="Prix" /></td>
	      <td><c:out value="Stock" /></td>
	   	</tr>
	   <c:forEach var="article" items="${listeArticles}">
	    <tr>
	      <td><c:out value="${article.id_article}" /></td>
	      <td><c:out value="${article.couleur}" /></td>
	      <td><c:out value="${article.taille}" /></td>
	      <td><c:out value="${article.modele}" /></td>
	      <td><c:out value="${article.prix} €" /></td>
	      <td><c:out value="${article.quantite}" /></td>
	      <td><input type="number" id="quantite" min=0 name="quantite" value="<c:out value=""/>"/></td>
	   </tr>
	  </c:forEach>
	</table>
</body>
</html>