package com.pixel.entities;

import java.io.Serializable;
import java.util.Set;

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
	private Long id;
	private String couleur;
	private String taille;
	private String modele;
	private float prix;
	private int quantite;
	
	@OneToMany(orphanRemoval=true)
	@JoinColumn(name="id_motif")
	private Set<Motif> motifs;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
