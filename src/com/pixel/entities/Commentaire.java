package com.pixel.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Commentaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3817601766253518197L;
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
