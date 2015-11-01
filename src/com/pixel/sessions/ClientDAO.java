package com.pixel.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pixel.entities.Utilisateur;
import com.pixel.exceptions.DAOException;

@Stateless
public class ClientDAO {
	private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.mail=:mail AND u.mdp=:mdp";
    private static final String PARAM_EMAIL = "mail";
    private static final String PARAM_MDP = "mdp";


    // Injection du manager, qui s'occupe de la connexion avec la BDD

    @PersistenceContext( unitName = "bdd_pixel_shirt" )
    private EntityManager em;

    // Enregistrement d'un nouvel utilisateur

    public void creer( Utilisateur utilisateur ) throws DAOException {
        try {
            em.persist( utilisateur );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }

    }
    // Recherche d'un utilisateur à partir de son adresse email

    public Utilisateur trouver( String email, Long mdp ) throws DAOException {
        Utilisateur utilisateur = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
        requete.setParameter( PARAM_EMAIL, email );
        //Le mot de passe doit avoir subit l'encryptage pour comparaison dans la BD
        requete.setParameter(PARAM_MDP, mdp);
        try {
            utilisateur = (Utilisateur) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }

        return utilisateur;

    }
    
    public void supprimer( Utilisateur user ) throws DAOException {
        try {
            em.remove( em.merge( user ) );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }

    }

}
