package model;

import javax.persistence.Entity;

@Entity
public class Restaurateur extends Utilisateur  {

	private Restaurant restaurant;
	
	public Restaurateur() {
		super();
	}


	public Restaurateur(String nom, String prenom, String email, String mdp) {
		super(nom, prenom, email, mdp);
	}


	public String toString() {
		return "Restaurateur [nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", mdp=" + mdp + "]";
	}


	public Restaurant getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
