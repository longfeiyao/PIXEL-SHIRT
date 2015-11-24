package com.pixel.tools;

public class Banque {
	
	// Solde
	private float solde ;
	private static final float maximum = 15000;
	private static final float minimum = 1000;

	// Client
	private String nom;
	private String prenom; 
	//private String numCompte;
	// Montant 
	
	public Banque (String nom, String prenom ) {
		this.nom = nom;
		this.prenom = prenom;
		this.solde = (float) (Math.random() * (maximum - minimum)) ;
	}
	
	/*
	 * this.Banque crédite un montant m au client de la banque b
	 */
	public synchronized void credit(Banque b, float m) {
		this.solde =- m;
		b.setSolde(b.getSolde() + m);
	}

	/*
	 * this.Banque débite un montant m au client de la banque b
	 */
	public synchronized void debit(Banque b, float m) {
		this.solde =+ m;
		b.setSolde(b.getSolde() - m);
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
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
}
