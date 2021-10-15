package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	private List<Article> panier;
	
	private LocalDate heure;
	
	@ManyToOne
	private Restaurant restaurant;
	
	@ManyToOne
	private Client client;

	public Commande() {}
	
	
	public Commande(List<Article> panier) {
		this.panier = panier;
		this.setHeure(LocalDate.now());
	}

	public List<Article> getPanier() {
		return panier;
	}

	public void setPanier(List<Article> panier) {
		this.panier = panier;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getHeure() {
		return heure;
	}


	public void setHeure(LocalDate heure) {
		this.heure = heure;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Commande [id=" + id + ", heure=" + heure + "]";
	}
	

}
