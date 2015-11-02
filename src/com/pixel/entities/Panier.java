package com.pixel.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Panier implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5447060023679502392L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id_panier;
	
	@OneToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name = "id_commande", nullable=false)
	private Commande commande;
	
	@OneToOne(optional=false,mappedBy="panier")
	private Client client;
	
	public Long getId() {
		return id_panier;
	}
	public void setId(Long id) {
		this.id_panier = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
}
