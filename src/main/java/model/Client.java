package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Client extends Utilisateur {

	@OneToMany(mappedBy="client")
	private List<Commande> commandes;
	
	public Client() {
		super();
	}
	
	public Client(String nom, String prenom, String email, String mdp) {
		super(nom, prenom, email, mdp);
	}

	
	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", mdp=" + mdp + "]";
	}
	
}
