package com.pixel.form;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.joda.time.DateTime;

import com.pixel.entities.Commande;
import com.pixel.entities.Panier;
import com.pixel.entities.Utilisateur;
import com.pixel.entities.Client;
import com.pixel.exceptions.FormValidationException;
import com.pixel.sessions.ClientDAO;

public class InscriptionForm extends Form{
	
    
	public InscriptionForm(ClientDAO user) {
		this.user=user;
	}

	public Utilisateur inscrireUtilisateur(HttpServletRequest request) {
		 	String email = getValeurChamp( request, CHAMP_EMAIL );
		    String motDePasse = getValeurChamp( request, CHAMP_PASS );
		    String confirmation = getValeurChamp( request, CHAMP_CONF );
		    String nom = getValeurChamp( request, CHAMP_NOM );
		    String prenom = getValeurChamp(request, CHAMP_PRENOM);
		    
		    Client utilisateur = new Client();
		    Panier panier = new Panier();
		    
		    Commande commande =new Commande();
		    commande.setDate(new DateTime());
		    commande.setValide(false);
		    
		    panier.setCommande(commande);
		    panier.setClient(utilisateur);
		    
		    utilisateur.setPanier(panier);
		    utilisateur.setDate(new DateTime());
		    traiterEmail(email, utilisateur);
		    traiterMotsDePasse(motDePasse, confirmation, utilisateur);
		    try {
		        validationNom( nom );
		    } catch ( FormValidationException e ) {
		        setErreur( CHAMP_NOM, e.getMessage() );
		    }
		    utilisateur.setNom(nom);
		    try {
		        validationNom( prenom );
		    } catch ( FormValidationException e ) {
		        setErreur( CHAMP_PRENOM, e.getMessage() );
		    }
		    utilisateur.setPrenom(prenom);
		    if ( erreurs.isEmpty() ) {
		    	user.creer(utilisateur);
		        resultat = "Succès de l'inscription.";
		    } else {
		        resultat = "Échec de l'inscription.";
		    }
		    return utilisateur;
	}
	
	private void traiterMotsDePasse( String motDePasse, String confirmation, Utilisateur utilisateur ) {
	    try {
	        validationMotsDePasse( motDePasse, confirmation );
	    } catch ( FormValidationException e ) {
	        setErreur( CHAMP_PASS, e.getMessage() );
	        setErreur( CHAMP_CONF, null );
	    }
	    /*
	     * Utilisation de la bibliothèque Jasypt pour chiffrer le mot de passe
	     * efficacement.
	     * 
	     * L'algorithme SHA-256 est ici utilisé, avec par défaut un salage
	     * aléatoire et un grand nombre d'itérations de la fonction de hashage.
	     * 
	     * La String retournée est de longueur 56 et contient le hash en Base64.
	     */
	    ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
	    passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
	    passwordEncryptor.setPlainDigest( false );
	    String motDePasseChiffre = passwordEncryptor.encryptPassword( motDePasse );
	    utilisateur.setMdp( motDePasseChiffre );

	}
	
	private void traiterEmail( String email, Utilisateur utilisateur ) {
	    try {
	        validationEmail(email);
	    } catch ( FormValidationException e ) {
	        setErreur( CHAMP_EMAIL, e.getMessage() );
	    }
	    utilisateur.setMail( email );
	}
	
	@Override
	protected void validationEmail(String email) throws FormValidationException {
		if ( email != null ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new FormValidationException( "Merci de saisir une adresse mail valide." );
	        } else if ( user.trouver( email ) != null) {
	            throw new FormValidationException( "Cette adresse email est déjà utilisée, merci d'en choisir une autre." );
	        }
	    } else {
	        throw new FormValidationException( "Merci de saisir une adresse mail." );
	    }
		
	}

}
