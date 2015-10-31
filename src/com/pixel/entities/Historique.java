package com.pixel.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Historique {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	private Commande commande;
	private Client client;
	
	public void setClient(Client client) {
		this.client = client;
	}
	public Client getClient() {
		return client;
	}
	
	public void addClient(Client client){
		if(client != null){
			if( !client.getHistoriques().contains(this)){
				if(this.client !=null){
					this.client.remove(this);
				}
				setClient(client);
				this.client.getHistoriques().add(this);
			}
		}
	}
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
}
