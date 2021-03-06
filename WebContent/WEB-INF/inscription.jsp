<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
<%@ include file="menu.jsp" %>
<form method="post" action="Inscription">

            <fieldset>

                <legend>Inscription</legend>

                <p>Vous pouvez vous inscrire via ce formulaire.</p>


                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.mail}"/>" size="20" maxlength="60" />
				<span class="erreur">${form.erreurs['email']}</span>
                <br/>


                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>

                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['motdepasse']}</span>
                <br/>


                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>

                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['confirmation']}</span>
                <br/>


                <label for="nom">Nom d'utilisateur</label>

                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['nom']}</span>
                <br/>
                
                 <label for="nom">Prenom d'utilisateur</label>

                <input type="text" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom}"/>" size="20" maxlength="20" />
				<span class="erreur">${form.erreurs['prenom']}</span>
                <br/>


                <input type="submit" value="Inscription" class="sansLabel" />

                <br/>
                 <p class="${empty erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>

        </form>
</body>
</html>