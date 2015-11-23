package com.pixel.entities;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] image;
	
	@ElementCollection
	@CollectionTable(
			name="TAGS",
			joinColumns=@JoinColumn(name="id_article")
			)
	private List<String> tags = new ArrayList<>();
	
	@OneToMany(orphanRemoval=true)
	@JoinColumn(name="id_motif")
	private Set<Motif> motifs = new HashSet<>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="article")
	private List<Commentaire> commentaires=new ArrayList<Commentaire>();
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(BufferedImage bufferedimage){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(bufferedimage, "jpeg", baos);
			baos.flush();
			this.image = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
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
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	@Override
	public boolean equals (Object o){
		if (o instanceof Article){
			if(this.id_article!=null && ((Article) o).id_article!=null && this.id_article.equals(((Article) o).id_article)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}

}
