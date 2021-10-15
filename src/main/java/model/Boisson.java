package model;

public class Boisson extends Article {

	
	private double quantite;

	public Boisson(double prix, String libelle, String descritption, double quantite) {
		super(prix, libelle, descritption);
		this.quantite = quantite;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Boisson [quantite=" + quantite + ", prix=" + prix + ", libelle=" + libelle + ", descritption="
				+ descritption + "]";
	}
	
	
}
