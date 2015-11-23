package com.pixel.form;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.pixel.entities.Article;
import com.pixel.exceptions.FormValidationException;
import com.pixel.sessions.ArticleDAO;

public class ArticleForm extends Form {
	public ArticleForm(ArticleDAO articleDao){
		this.articleDao=articleDao;
	}
	
	public Article addArticle(HttpServletRequest request){
		List<String> lTag = new ArrayList<>();
		
		String taille = getValeurChamp( request, CHAMP_TAILLE );
	    String modele = getValeurChamp( request, CHAMP_MODEL );
	    String couleur = getValeurChamp( request, CHAMP_COULEUR );
	    String prix = getValeurChamp(request, CHAMP_PRIX);
	    String quantite = getValeurChamp(request, CHAMP_QUANT);
	    String tags = getValeurChamp(request, CHAMP_TAGS);
		
	    
	    String image = null;
	    
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
		try{
			lTag = traiterTags(tags); //validation + traitement
		}catch(FormValidationException e){
			setErreur(CHAMP_TAGS, e.getMessage());
		}
		article.setTags(lTag);
		
		InputStream contenuImage=null;
		try{
			Part part = request.getPart(CHAMP_IMAGE);
			image = getNomImage(part);
			if(image != null && !image.isEmpty()){
				image = image.substring(image.lastIndexOf('/') + 1).substring(image.lastIndexOf('\\') +1);
				contenuImage = part.getInputStream();
				contenuImage.read(new byte[15]);
			}
		}catch(IllegalStateException e){
			e.printStackTrace();
			setErreur(CHAMP_IMAGE, "Données trop volumineuse");
			
		} catch (IOException e) {
			e.printStackTrace();
			setErreur(CHAMP_IMAGE, "Erreur de configuration du serveur");
		} catch (ServletException e) {
			e.printStackTrace();
			setErreur(CHAMP_IMAGE, "Ce type de requête n'est pas supporté");
		}
		
		try{
			validationImage(image, contenuImage);
		}catch(Exception e){
			setErreur(CHAMP_IMAGE, e.getMessage());
		}
		
		if(erreurs.isEmpty()){
			articleDao.creer(article);
			resultat="Ajout correctement effectué";
		}else{
			resultat="Erreur lors de l'ajout";
		}
		return article;
	}
	
	private String getNomImage(Part part) {
		for(String contentDisposition : part.getHeader("content-disposition").split(";")){
			if(contentDisposition.trim().startsWith("filename")){
				return contentDisposition.substring(contentDisposition.indexOf('=')+1).trim().replace("\"","");
			}
		}
		return null;
	}

	private void validationImage(String image, InputStream contenuImage) throws Exception {
		if(image ==null || contenuImage == null ){
			throw new Exception("Veuillez sélectionner un fichier à envoyer");
		}
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
