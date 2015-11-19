<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter Article</title>
<link type="text/css" rel="stylesheet" href="/Pixel_Shirt/form.css" />
</head>
<body>
<%@ include file="menu.jsp" %>
<form method="post" action="AjoutArticle">

            <fieldset>

                <legend>Ajouter Article</legend>

                <p>Vous pouvez ajouter un article dans la base via ce formulaire.</p>


                <label for="couleur">Couleur <span class="requis">*</span></label>
                <input type="text" id="couleur" name="couleur" value="<c:out value="${article.couleur}"/>" size="20" maxlength="60" />
				<span class="erreur">${form.erreurs['couleur']}</span>
                <br/>

                <label for="modele">Modele <span class="requis">*</span></label>

                <input type="text" id="modele" name="modele" value="<c:out value="${article.modele}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['modele']}</span>
                <br/>
                
                 <label for="taille">Taille <span class="requis">*</span></label>

                <input type="text" id="taille" name="taille" value="<c:out value="${article.taille}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['taille']}</span>
                <br/>

				<label for="prix">Prix <span class="requis">*</span></label>

                <input type="number" step="0.01" min=0 id="prix" name="prix" value="<c:out value="${article.prix}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['prix']}</span>
                <br/>
                
                <label for="quantite">Quantite <span class="requis">*</span></label>

                <input type="number" id="quantite" min=0 name="quantite" value="<c:out value="${article.quantite}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['quantite']}</span>
                <br/>
                
                 <label for="tags">Tags <span class="requis">*</span></label>
                <input type="text" id="tags" name="tags" value="<c:forEach var="tag" items="${lTags}">${tag} ' '</c:forEach>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['tags']}</span>
                <br/>
                
                <input type="submit" value="Ajouter Article" class="sansLabel" />

                <br/>
                 <p class="${empty erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
</body>
</html>