package com.pixel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1172262412560356852L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id_user;
	private String nom;
	private String prenom;
	private String mail;
	@Column( name = "mot_de_passe" )
	private Long mdp;
	protected boolean admin;
	
	public Long getId() {
		return id_user;
	}

	public void setId(Long id) {
		this.id_user = id;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	

	public void setMdp(Long mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getMdp() {
		return mdp;
	}
	public void setMdp(long mdp) {
		this.mdp = mdp;
	}
	
	
}
