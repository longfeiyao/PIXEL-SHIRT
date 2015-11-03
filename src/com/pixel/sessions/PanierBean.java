package com.pixel.sessions;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import com.pixel.entities.Article;
import com.pixel.entities.Commande;
import com.pixel.entities.Panier;

/**
 * Session Bean implementation class Panier
 */
@Stateful
public class PanierBean {
	private Panier panier;
	private List<Article> articles = new ArrayList<Article>();
    /**
     * Default constructor. 
     */
    public PanierBean() {
    	panier=new Panier();
    	Commande commande = new Commande();
    	commande.setValide(false);
    	panier.setCommande(commande);
    }
    
    public void addArticle(Article article){
    	if(!articles.contains(article)){
    		article.setQuantite(1);
    		articles.add(article);
    	}else{	
			for(Article arti=null ;articles.iterator().hasNext(); arti = articles.iterator().next()){
    			if(arti.equals(article)){
    				article.setQuantite(arti.getQuantite()+1);
    			}
    		}
    	}
    	//sauvegarde des articles dans la BD mais pas encore écrit dans celle-ci
    	panier.getCommande().setArticles(articles);
    }
    
    

}
