package com.pixel.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Article implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8779598285866996778L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id_article;
	private String couleur;
	private String taille;
	private String modele;
	private float prix;
	private int quantite;
	
	@OneToMany(orphanRemoval=true)
	@JoinColumn(name="id_motif")
	private Set<Motif> motifs;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="article")
	private List<Commentaire> commentaires;
	
	public Long getId_article() {
		return id_article;
	}
	public void setId_article(Long id_article) {
		this.id_article = id_article;
	}
	
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	public Long getId() {
		return id_article;
	}
	public void setId(Long id) {
		this.id_article = id;
	}
	public Set<Motif> getMotifs() {
		return motifs;
	}
	public void setMotifs(Set<Motif> motifs) {
		this.motifs = motifs;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
