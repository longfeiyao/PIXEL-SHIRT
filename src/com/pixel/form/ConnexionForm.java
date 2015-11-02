package com.pixel.form;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.pixel.entities.Utilisateur;
import com.pixel.exceptions.FormValidationException;
import com.pixel.sessions.ClientDAO;

public class ConnexionForm extends Form{

    
    public ConnexionForm(ClientDAO user){
		this.user=user;
	}
	
	public Utilisateur connexionUtilisateur(HttpServletRequest request) {
		String email = getValeurChamp( request, CHAMP_EMAIL );
	    String motDePasse = getValeurChamp( request, CHAMP_PASS );
	    Utilisateur utilisateur = null;
	    try {
			validationEmail(email);
		} catch (FormValidationException e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
	    if ( erreurs.isEmpty() ) {
	    	utilisateur = user.trouver(email);
			try {
				validationUtilisateur(utilisateur, motDePasse);
			} catch (FormValidationException e) {
				setErreur(CHAMP_EMAIL, e.getMessage());
			}
		}
	    
	    if ( erreurs.isEmpty() ) {
	        resultat = "Succès de la connexion.";
	    } else {
	        resultat = "Échec de la connexion.";
	    }
		return utilisateur;
		
	}

	
	private void validationUtilisateur(Utilisateur utilisateur, String password)throws FormValidationException {
		if(utilisateur != null){
			ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
			passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
			passwordEncryptor.setPlainDigest( false );
			if(!passwordEncryptor.checkPassword(password, utilisateur.getMdp())){
				throw new FormValidationException("Email ou mot de passe invalide"); 
			}
		}else{
			throw new FormValidationException("Email ou mot de passe invalide"); 
		}
		
	}

}
