package model;

public class Plat extends Article {

	

	public Plat(double prix, String libelle, String descritption) {
		super(prix, libelle, descritption);

	}
	

	@Override
	public String toString() {
		return "Plat [prix=" + prix + ", libelle=" + libelle + ", descritption=" + descritption + "]";
	}

	
}
