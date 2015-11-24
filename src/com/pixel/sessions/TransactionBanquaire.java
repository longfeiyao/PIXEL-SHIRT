package com.pixel.sessions;

import javax.ejb.AfterBegin;
import javax.ejb.AfterCompletion;
import javax.ejb.BeforeCompletion;
import javax.ejb.EJBContext;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pixel.entities.Utilisateur;
import com.pixel.servlets.AccueilServlet;
import com.pixel.tools.Banque;

/**
 * Session Bean implementation class TransactionBanquaire
 * Une transaction permet d'assurer l'intégrité des données
 * car soit elle s'exécute correctement dans son intégralité
 * soit elle ne fait aucune modification. transaction ACID
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TransactionBanquaire  {
	
	// Require connexion . méthode de transaction banquaire
	public void transaction(PanierBean p) {
		Banque client = new Banque(p.getClient().getNom(),p.getClient().getPrenom());
		Banque entreprise = AccueilServlet.banque;
		System.out.println("MONTANT :"+p.getTotal());
		System.out.println("Client début :"+ client.getNom()+" "+client.getPrenom()+" "+client.getSolde() );
		System.out.println("Entreprise début :"+ entreprise.getNom()+" "+entreprise.getPrenom()+" "+entreprise.getSolde() );
		entreprise.debit(client, Float.parseFloat(p.getTotal()));
		/*
		try {
			throw new Exception("test rollback");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Client fin :"+ client.getNom()+" "+client.getPrenom()+" "+client.getSolde() );
		System.out.println("Entreprise fin :"+ entreprise.getNom()+" "+entreprise.getPrenom()+" "+entreprise.getSolde() );
	}
	

	
	
    @AfterBegin
    private void afterBegin(){
        System.out.println("A new transaction has started.");
    }

    @BeforeCompletion
    private void beforeCompletion(){
        System.out.println("A transaction is about to be committed.");
    }

    @AfterCompletion
    private void afterCompletion(boolean committed) {
        System.out.println("a transaction commit protocol has completed, and tells the instance whether the transaction has been committed or rolled back , based on committed value : " + committed);
    }
}
