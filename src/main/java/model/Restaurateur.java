package model;

public class Restaurateur extends Utilisateur  {

	public Restaurateur(String nom, String prenom, int id, String mdp) {
		super(nom, prenom, id, mdp);
	}


	public String toString() {
		return "Restaurateur [nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", mdp=" + mdp + "]";
	}

	
}
