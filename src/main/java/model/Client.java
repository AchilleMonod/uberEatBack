package model;

import javax.persistence.Entity;

@Entity
public class Client extends Utilisateur {

	public Client() {
		super();
	}
	
	public Client(String nom, String prenom, String email, String mdp) {
		super(nom, prenom, email, mdp);
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", mdp=" + mdp + "]";
	}
	
	
	
}
