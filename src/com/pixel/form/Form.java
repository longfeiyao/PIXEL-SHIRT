package com.pixel.form;

import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pixel.entities.Article;
import com.pixel.exceptions.FormValidationException;
import com.pixel.sessions.ArticleDAO;
import com.pixel.sessions.ClientDAO;

public class Form {
	
	protected ClientDAO user;
	protected ArticleDAO articleDao;
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
    protected static final String CHAMP_QUANT = "quantite";
    protected static final String CHAMP_COULEUR = "couleur";
    protected static final String CHAMP_TAILLE = "taille";
    protected static final String CHAMP_MODEL = "modele";
    protected static final String CHAMP_PRIX = "prix";
    protected static final String CHAMP_TAGS = "tags";
    protected static final String CHAMP_IMAGE = "image";
    protected static final String CHAMP_ART_ID = "article_id";
    
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
	    try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
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
	            throw new FormValidationException( "Les mots de passe doivent contenir au moins" + TAILLE_MIN_MDP + "caractères." );
	        }
	    } else {
	        throw new FormValidationException( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}
    
    protected List<String> traiterTags(String tags) throws FormValidationException {
		List<String> lTag = new ArrayList<>();
		if(tags == null){
			throw new FormValidationException("Veuillez renseigner ce champ");
		}
		else{
			//Traitement du String
			tags = Normalizer.normalize(tags, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
			tags = tags.toLowerCase();
			String[] s = tags.split(" ");
			for(String tag : s){
				lTag.add(tag);
			}
			return lTag;
		}
	}
    
    protected void validerQuantite(Article article, String quantite) throws FormValidationException{
		if(quantite != null){
			try{
				int quantitei = Integer.parseInt(quantite);
				article.setQuantite(quantitei);
			}catch(NumberFormatException e){
				throw new FormValidationException("Ceci n'est pas un nombre valide");
			}
		}else{
			throw new FormValidationException("Veuillez renseigner ce champ");
		}
	}

}
