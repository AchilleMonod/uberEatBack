package model;

import javax.persistence.Entity;

@Entity
public class Restaurateur extends Utilisateur  {

	
	
	public Restaurateur() {
		super();
	}


	public Restaurateur(String nom, String prenom, String email, String mdp) {
		super(nom, prenom, email, mdp);
	}


	public String toString() {
		return "Restaurateur [nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", mdp=" + mdp + "]";
	}

	
}
