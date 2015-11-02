package com.pixel.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.eclipse.persistence.annotations.Convert;
import org.joda.time.DateTime;


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
	@Column( name = "date_inscription", columnDefinition = "TIMESTAMP" )
    @Convert( "dateTimeConverter" )
	private DateTime date;
	
	@OneToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name = "id_panier", nullable=false)
	private Panier panier;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="client")
	private List<Historique> historiques;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="client")
	private List<Commentaire> commentaires;
	
	
	public Client(){
		historiques = new ArrayList<>();
		commentaires = new ArrayList<>();
	}
	
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

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
}
