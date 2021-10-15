package model;

public class Client extends Utilisateur {
<<<<<<< HEAD
=======

	public Client(String nom, String prenom, int id, String mdp) {
		super(nom, prenom, id, mdp);
		// TODO Auto-generated constructor stub
	}
	
>>>>>>> master

	public Client(String nom, String prenom, int id, String mdp) {
		super(nom, prenom, id, mdp);
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", mdp=" + mdp + "]";
	}
	
	
	
}
