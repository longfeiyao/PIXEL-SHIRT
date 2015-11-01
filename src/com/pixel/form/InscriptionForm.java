package com.pixel.form;

import javax.servlet.http.HttpServletRequest;

import com.pixel.entities.Utilisateur;
import com.pixel.sessions.ClientDAO;

public class InscriptionForm {
	
	private ClientDAO user;
	
	public InscriptionForm(ClientDAO user) {
		this.user=user;
	}

	public Utilisateur inscrireUtilisateur(HttpServletRequest request) {
		return null;
	}

}
