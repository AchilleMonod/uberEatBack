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
	
	private int idRestaurant;
	
	private int idClient;

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


	public int getIdRestaurant() {
		return idRestaurant;
	}


	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	@Override
	public String toString() {
		return "Commande [id=" + id + ", heure=" + heure + "]";
	}
	

}
