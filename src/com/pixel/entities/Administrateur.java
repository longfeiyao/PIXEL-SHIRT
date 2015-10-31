package com.pixel.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrateur extends Utilisateur{
	
	public Administrateur(){
		admin=true;
	}
	
}
