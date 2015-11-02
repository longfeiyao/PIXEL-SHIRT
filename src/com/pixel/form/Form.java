package com.pixel.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pixel.exceptions.FormValidationException;
import com.pixel.sessions.ClientDAO;

public class Form {
	protected ClientDAO user;
	protected String resultat;
	protected Map<String, String> erreurs      = new HashMap<String, String>();
	protected static final int TAILLE_MIN_MDP = 3;
	protected static final String CHAMP_EMAIL  = "email";
    protected static final String CHAMP_PASS   = "motdepasse";
    protected static final String CHAMP_CONF   = "confirmation";
    protected static final String CHAMP_NOM    = "nom";
    protected static final String CHAMP_PRENOM    = "prenom";
    protected static final String CHAMP_ADRESSE    = "adresse";
    protected static final String CHAMP_CODE_POSTAL= "codePostal";
    protected static final String CHAMP_PAYS = "pays";
    protected static final String ALGO_CHIFFREMENT = "SHA-256";
    
    protected void setErreur(String champ, String message) {
		erreurs.put( champ, message );
	}
    
    public String getResultat() {
 	   return resultat;
 	}

 	public Map<String, String> getErreurs() {
 	    return erreurs;
 	}
    
    
    protected void validationEmail(String email) throws FormValidationException {
		if ( email != null ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new FormValidationException( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new FormValidationException( "Merci de saisir une adresse mail." );
	    }
		
	}
    
    protected void validationNom(String nom) throws FormValidationException {
		if ( nom != null && nom.length() < 3 ) {
	        throw new FormValidationException( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
	    }
	}
    
    protected static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	    String valeur = request.getParameter( nomChamp );
	    if ( valeur == null || valeur.trim().length() == 0 ) {
	        return null;
	    } else {
	        return valeur.trim();
	    }
	}
    
    protected void validationMotsDePasse(String motDePasse, String confirmation) throws FormValidationException {
		if ( motDePasse != null && confirmation != null ) {
	        if ( !motDePasse.equals( confirmation ) ) {
	            throw new FormValidationException( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
	        } else if ( motDePasse.length() < TAILLE_MIN_MDP ) {
	            throw new FormValidationException( "Les mots de passe doivent contenir au moins 3 caractères." );
	        }
	    } else {
	        throw new FormValidationException( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}

}
