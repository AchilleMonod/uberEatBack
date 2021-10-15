package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_article")
	protected int id;
	
	
	protected double prix;
	protected String libelle;
	protected String descritption;
	
	@ManyToOne
	protected Restaurant restaurant;
	
	public Article() {
	}
	
	public Article(double prix, String libelle,Restaurant restaurant) {
		this.prix = prix;
		this.libelle = libelle;
		this.restaurant=restaurant;
	}

	public Article(double prix, String libelle, String descritption,Restaurant restaurant) {
		this.prix = prix;
		this.libelle = libelle;
		this.descritption = descritption;
		this.restaurant=restaurant;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescritption() {
		return descritption;
	}

	public void setDescritption(String descritption) {
		this.descritption = descritption;
	}

	@Override
	public String toString() {
		return "Article [prix=" + prix + ", libelle=" + libelle + ", descritption=" + descritption + "]";
	}
	
	
}
