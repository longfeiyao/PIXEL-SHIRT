package com.pixel.form;

import javax.servlet.http.HttpServletRequest;

import com.pixel.sessions.ClientDAO;
import com.pixel.sessions.PanierBean;

public class PanierForm extends Form {
	
	private boolean suppr=false;

	public PanierForm(ClientDAO client){
		this.user=client;
	}
	
	public void update(HttpServletRequest request, PanierBean panier){
		suppr=false;
		// Recupération du paramètre article_id dans la balise input de type "hidden" du fichier panierGestion.jsp
		String article_id = request.getParameter(CHAMP_ART_ID);
		if (request.getParameter(CHAMP_QUANT) != null) {
			// Recupération du paramètre quantite dans le fichier panierGestion.jsp
			String q = request.getParameter(CHAMP_QUANT);
			int quantite = Integer.parseInt(q);
			// Update panier (ID,TOTAL,QUANTITE)
			panier.update(article_id,quantite);

	    } else if (request.getParameter("supprimer") != null) {
	          panier.supprimer(article_id);
	    } else if (request.getParameter("deconnexion") != null){
	    	  panier.getPanier().setClient(null);
	    }
		if(request.getParameter("supprimerCompte") != null){
	    	user.supprimer(panier.getClient());
	    	panier.getPanier().setClient(null);
	    	suppr=true;
		}
	
	}

	public boolean supprimerCompte(){
		return suppr;
	}
}