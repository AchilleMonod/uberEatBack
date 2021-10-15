package model;

import javax.persistence.Entity;

@Entity
public class Boisson extends Article {

	public Boisson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boisson(double prix, String libelle, Restaurant restaurant) {
		super(prix, libelle, restaurant);
		// TODO Auto-generated constructor stub
	}

	public Boisson(double prix, String libelle, String descritption, Restaurant restaurant) {
		super(prix, libelle, descritption, restaurant);
		// TODO Auto-generated constructor stub
	}

	

}
