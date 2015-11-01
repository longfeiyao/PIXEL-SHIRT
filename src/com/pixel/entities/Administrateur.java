package com.pixel.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Administrateur extends Utilisateur implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2368223807126389250L;

	public Administrateur(){
		admin=true;
	}
	
}
