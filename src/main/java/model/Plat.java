package model;

import javax.persistence.Entity;

@Entity
public class Plat extends Article {

	public Plat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plat(double prix, String libelle, Restaurant restaurant) {
		super(prix, libelle, restaurant);
		// TODO Auto-generated constructor stub
	}

	public Plat(double prix, String libelle, String descritption, Restaurant restaurant) {
		super(prix, libelle, descritption, restaurant);
		// TODO Auto-generated constructor stub
	}

	
	
}
