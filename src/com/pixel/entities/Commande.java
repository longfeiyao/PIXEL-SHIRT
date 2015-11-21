package com.pixel.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
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
	
	@Column( columnDefinition = "TIMESTAMP")
    @Converter( name = "dateTimeConverter", converterClass = JodaDateTimeConverter.class )
    @Convert( "dateTimeConverter" )
	private DateTime date=new DateTime();
	
	@Column(nullable=false)
	private boolean valide;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="commande")
	private Historique historique;
	
	@ElementCollection
	@MapKeyClass(com.pixel.entities.Article.class)
	@MapKeyColumn(name="id_article")
	private Map<Article,Integer> articles = new HashMap<Article,Integer>();
	
	public Map<Article, Integer> getArticles() {
		return articles;
	}

	public void setArticles(Map<Article, Integer> articles) {
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
