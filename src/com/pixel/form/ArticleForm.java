package com.pixel.form;

import javax.servlet.http.HttpServletRequest;

import com.pixel.entities.Article;
import com.pixel.sessions.ArticleDAO;

public class ArticleForm extends Form {
	public ArticleForm(ArticleDAO articleDao){
		this.articleDao=articleDao;
	}
	
	public Article addArticle(HttpServletRequest request){
		String taille = getValeurChamp( request, CHAMP_TAILLE );
	    String modele = getValeurChamp( request, CHAMP_MODEL );
	    String couleur = getValeurChamp( request, CHAMP_COULEUR );
	    float prix = Float.parseFloat(getValeurChamp(request, CHAMP_PRIX));
	    int quantite = Integer.parseInt(getValeurChamp(request, CHAMP_QUANT));
		
		Article article = new Article();
		article.setCouleur(couleur);
		article.setPrix(prix);
		article.setQuantite(quantite);
		article.setTaille(taille);
		article.setModele(modele);
		
		if(erreurs.isEmpty()){
			articleDao.creer(article);
			resultat="Ajout correctement effectué";
		}else{
			resultat="Erreur lors de l'ajout";
		}
		return article;
	}
}
