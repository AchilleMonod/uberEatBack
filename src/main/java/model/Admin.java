package model;

import javax.persistence.Entity;

@Entity
public class Admin extends Utilisateur  {

	
	public Admin() {
		super();
	}
	
	public Admin(String nom, String prenom,String email, String mdp) {
		super(nom, prenom,email, mdp);
	}

}
