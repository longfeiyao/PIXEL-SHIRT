package com.pixel.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client extends Utilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -447927080229839997L;
	private int age;
	private String adresse;
	private int codePostal;
	private String ville;
	private String pays;
	@Column( name = "date_inscription" )
	private Timestamp dateInscription;
	
	@OneToOne(optional=false)
	@JoinColumn(name = "id_panier", nullable=false)
	private Panier panier;
	
	@OneToMany(mappedBy="client")
	private List<Historique> historiques;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="client")
	private List<Commentaire> commentaires;
	
	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public List<Historique> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
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
	
	public Timestamp getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Timestamp dateInscription) {
		this.dateInscription = dateInscription;
	}
	
}
