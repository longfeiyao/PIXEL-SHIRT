package com.pixel.sessions;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import com.pixel.entities.Article;
import com.pixel.entities.Client;
import com.pixel.entities.Commande;
import com.pixel.entities.Panier;

/**
 * Session Bean implementation class Panier
 */
@Stateful
public class PanierBean {
	private Panier panier;
	private float total=0;
	
	public Panier getPanier() {
		return panier;
	}

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
    
    public void addArticle(Article article, int quantite){
  
    		if(articles.contains(article)){
    			for(Article art : articles){
    				if(art.equals(article)){
    					art.setQuantite(art.getQuantite()+quantite);
    				}
    			}
				
			}else{
				article.setQuantite(quantite);
				articles.add(article);
			}
		total = total + article.getPrix() * quantite;
    	//sauvegarde des articles dans la BD mais pas encore écrit dans celle-ci
    	panier.getCommande().setArticles(articles);
    }
    
    public Client getClient(){
    	return panier.getClient();
    }
    
    public List<Article> getArticles(){
    	return panier.getCommande().getArticles();
    }
    
    public float getTotal(){
    	return total;
    }
    
    public void removeArticle(Article article, int quantite){
    	if(quantite >0)
    		articles.remove(article);
    }
    
    @Remove
    public void remove(){
    	if(panier.getClient() != null){
    		
    	}
    }

    // TODO modif champs envoie un DOPOST
	// Condition vérifiée : article appartient à la liste articles
    public void update(String article_id, int quantite) {
		Long id = Long.parseLong(article_id);
    	total = 0 ;
		for(Article art : articles){
			if(art.getId() == id){
				art.setQuantite(quantite);
			}
			total = total + art.getPrix() * art.getQuantite();
			System.out.println("/n total : "+ total);
		}
		panier.getCommande().setArticles(articles);
	}
    
 // Condition vérifiée : article appartient à la liste articles
	public void supprimer(String article_id) {
		Long id = Long.parseLong(article_id);
		for(Article art : articles){
			if(art.getId() == id){
				articles.remove(art);
				break;
			}
		}
		panier.getCommande().setArticles(articles);
	}

}
