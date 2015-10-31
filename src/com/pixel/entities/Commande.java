package com.pixel.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commande {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private Historique historique;
	private boolean valide;
	
	public boolean isValide() {
		return valide;
	}
	
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	
	public Historique getHistorique() {
		return historique;
	}
	
	public void setHistorique(Historique historique) {
		this.historique = historique;
	}
	
}
