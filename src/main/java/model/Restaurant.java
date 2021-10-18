package model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_restaurant")
	private int id;
	
	@OneToMany(mappedBy="restaurant")
	private List<Commande> commandes;
	
	private transient List<Article> carte;
	
	@Enumerated(EnumType.STRING)
	private TypeResto typeresto;
	
	private String name;
	
	public Restaurant() {
		super();
	}

	public Restaurant(List<Article> carte, TypeResto typeresto,String name) {
		super();
		this.carte = carte;
		this.typeresto = typeresto;
		this.name =name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Article> getCarte() {
		return carte;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCarte(List<Article> carte) {
		this.carte = carte;
	}

	public TypeResto getTyperesto() {
		return typeresto;
	}

	public void setTyperesto(TypeResto typeresto) {
		this.typeresto = typeresto;
	}
	
	

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		return "Restaurant [carte=" + carte + ", typeresto=" + typeresto + ", name=" + name + "]";
	}

	
	
	
}
