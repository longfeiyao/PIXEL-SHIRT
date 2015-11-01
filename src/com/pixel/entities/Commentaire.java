package com.pixel.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3817601766253518197L;
	@Id
	private int id_commentaire;
	private String commentaire;

	@ManyToOne
	@JoinColumn( name = "id_article", nullable=false )
	private Article article;
	
	@ManyToOne
	@JoinColumn( name = "id_user", nullable=false )
	private Client client;
	
	public int getId_commentaire() {
		return id_commentaire;
	}
	public void setId_commentaire(int id_commentaire) {
		this.id_commentaire = id_commentaire;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}
