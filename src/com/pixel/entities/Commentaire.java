package com.pixel.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Commentaire {

	@Id
	private int Id;
	private String commentaire;
	
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}
