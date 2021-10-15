package model;

public class Client extends Utilisateur {

	public Client(String nom, String prenom, int id, String mdp) {
		super(nom, prenom, id, mdp);
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", mdp=" + mdp + "]";
	}
	
	
	
}
