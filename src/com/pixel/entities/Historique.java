package com.pixel.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Historique implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -246168510728536661L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id_historique;
	
	@OneToOne
	@JoinColumn( name = "id_commande", nullable=false)
	private Commande commande;
	
	@ManyToOne(optional=false)
    @JoinColumn( name = "id_user", nullable=false)
	private Client client;
	
	public void setClient(Client client) {
		this.client = client;
	}
	public Client getClient() {
		return client;
	}
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
}
