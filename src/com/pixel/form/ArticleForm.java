package com.pixel.form;

import javax.servlet.http.HttpServletRequest;

import com.pixel.entities.Article;
import com.pixel.exceptions.FormValidationException;
import com.pixel.sessions.ArticleDAO;

public class ArticleForm extends Form {
	public ArticleForm(ArticleDAO articleDao){
		this.articleDao=articleDao;
	}
	
	public Article addArticle(HttpServletRequest request){
		String taille = getValeurChamp( request, CHAMP_TAILLE );
	    String modele = getValeurChamp( request, CHAMP_MODEL );
	    String couleur = getValeurChamp( request, CHAMP_COULEUR );
	    String prix = getValeurChamp(request, CHAMP_PRIX);
	    String quantite = getValeurChamp(request, CHAMP_QUANT);
		
		Article article = new Article();
		try{
			validerCouleur(couleur);
		}catch(FormValidationException e){
			setErreur(CHAMP_COULEUR, e.getMessage());
		}
		article.setCouleur(couleur);
		
		try{
			validerPrix(article,prix);
		}catch(FormValidationException e){
			setErreur(CHAMP_PRIX, e.getMessage());
		}
		try{	
			validerQuantite(article,quantite);
		}catch(FormValidationException e){
			setErreur(CHAMP_QUANT, e.getMessage());
		}
		try{
			validerTaille(taille);
		}catch(FormValidationException e){
			setErreur(CHAMP_TAILLE, e.getMessage());
		}
		article.setTaille(taille);
		try{
			validerModele(modele);
		}catch(FormValidationException e){
			setErreur(CHAMP_MODEL, e.getMessage());
		}
		article.setModele(modele);
		
		if(erreurs.isEmpty()){
			articleDao.creer(article);
			resultat="Ajout correctement effectué";
		}else{
			resultat="Erreur lors de l'ajout";
		}
		return article;
	}

	private void validerModele(String modele) throws FormValidationException {
		if(modele == null){
			throw new FormValidationException("Veuillez renseigner ce champ");
		}
	}

	private void validerTaille(String taille) throws FormValidationException{
		if(taille == null){
			throw new FormValidationException("Veuillez renseigner ce champ");
		}
	}

	private void validerQuantite(Article article, String quantite) throws FormValidationException{
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

	private void validerPrix(Article article, String prix) throws FormValidationException {
		if(prix != null){
			try{
				float prixf = Float.parseFloat(prix);
				article.setPrix(prixf);
			}catch(NumberFormatException e){
				throw new FormValidationException("Ceci n'est pas un nombre valide");
			}
		}else{
			throw new FormValidationException("Veuillez renseigner ce champ");
		}
		
	}

	private void validerCouleur(String couleur) throws FormValidationException {
		if(couleur == null){
			throw new FormValidationException("Veuillez renseigner ce champ");
		}
	}
	
	
}
