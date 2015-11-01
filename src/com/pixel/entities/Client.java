package com.pixel.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Client extends Utilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -447927080229839997L;
	private Long age;
	private String adresse;
	private Long codePostal;
	private String ville;
	private String pays;
	
	@OneToOne(optional=false)
	@JoinColumn(name = "id_panier", nullable=false)
	private Panier panier;
	
	public Client(){
	}

	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Long getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(Long codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
}
