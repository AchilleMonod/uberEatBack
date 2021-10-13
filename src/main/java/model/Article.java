package model;

public class Article {

	protected double prix;
	protected String libelle;
	protected String descritption;
	
	
	
	public Article(double prix, String libelle) {
		super();
		this.prix = prix;
		this.libelle = libelle;
	}

	public Article(double prix, String libelle, String descritption) {
		super();
		this.prix = prix;
		this.libelle = libelle;
		this.descritption = descritption;
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
