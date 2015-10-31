package com.pixel.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Client extends Utilisateur{

	private Long age;
	private String adresse;
	private Long codePostal;
	private String ville;
	private String pays;
	private List<Historique> historiques;
	
	public Client(){
		historiques=new ArrayList<>();
		admin=false;
	}
	
	public List<Historique> getHistoriques() {
		return historiques;
	}
	
	public void addHistorique(Historique historique){
		if(!historiques.contains(historique)){
			if(historique.getClient()!=null){
				historique.getClient().remove(historique);
			}
			historique.setClient(this);
			historiques.add(historique);
		}
	}
	
	public void remove(Historique historique) {
		historiques.remove(historique);
	}

	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Long getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(Long codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
}
