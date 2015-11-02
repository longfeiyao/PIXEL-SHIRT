package com.pixel.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;
import org.joda.time.DateTime;

import com.pixel.tools.JodaDateTimeConverter;

@Entity
public class Commande implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1350779614440006133L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id_commande;
	
	@Column( columnDefinition = "TIMESTAMP" )
    @Converter( name = "dateTimeConverter", converterClass = JodaDateTimeConverter.class )
    @Convert( "dateTimeConverter" )
	private DateTime date;
	
	private boolean valide;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="commande")
	private Historique historique;
	
	@ManyToMany(cascade=CascadeType.PERSIST,targetEntity=com.pixel.entities.Article.class)
	private List<Article> articles = new ArrayList<Article>();
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Long getId_commande() {
		return id_commande;
	}

	public void setId_commande(Long id_commande) {
		this.id_commande = id_commande;
	}

	public Long getId() {
		return id_commande;
	}

	public void setId(Long id) {
		this.id_commande = id;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

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
