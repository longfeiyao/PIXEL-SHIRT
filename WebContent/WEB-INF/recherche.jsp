<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recherche Article</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	
	<form method="post" action="Recherche">
		<input placeholder="Recherche ?" id="tags" name="tags" value="" size="20" maxlength="60" />
		<input type="submit" value="Recherche Article" class="sansLabel" />
	</form>
	
	<c:forEach var="article" items="${listeArticles}">
	    <tr>
	      <td><c:out value="${article.id_article}" /></td>
	      <td><c:out value="${article.couleur}" /></td>
	      <td><c:out value="${article.taille}" /></td>
	      <td><c:out value="${article.modele}" /></td>
	      <td><c:out value="${article.prix} €" /></td>	      
		</tr>
	</c:forEach>
	      
	
</body>
</html>