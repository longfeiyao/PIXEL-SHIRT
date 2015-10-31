package com.pixel.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utilisateur {
	
	@Id
	private int Id;
	private String nom;
	private String prenom;
	private String mail;
	private long mdp;
	
}
