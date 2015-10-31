package com.pixel.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Historique {
	
	@Id
	private int Id;
	private Commande commande;
}
