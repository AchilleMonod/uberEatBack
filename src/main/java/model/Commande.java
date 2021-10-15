package model;

import java.util.List;

public class Commande {

	
	private List<Article> panier;

	
	
	public Commande(List<Article> panier) {
		super();
		this.panier = panier;
	}

	public List<Article> getPanier() {
		return panier;
	}

	public void setPanier(List<Article> panier) {
		this.panier = panier;
	}

	@Override
	public String toString() {
		return "Commande [panier=" + panier + "]";
	}
	
	
	
}
