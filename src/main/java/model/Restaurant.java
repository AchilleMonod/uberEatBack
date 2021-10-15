package model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_restaurant")
	private int id;
	

	private transient List<Article> carte;
	
	@Enumerated(EnumType.STRING)
	private TypeResto typeresto;
	
	
	public Restaurant() {
		super();
	}

	public Restaurant(List<Article> carte, TypeResto typeresto) {
		super();
		this.carte = carte;
		this.typeresto = typeresto;
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

	public void setCarte(List<Article> carte) {
		this.carte = carte;
	}

	public TypeResto getTyperesto() {
		return typeresto;
	}

	public void setTyperesto(TypeResto typeresto) {
		this.typeresto = typeresto;
	}

	@Override
	public String toString() {
		return "Restaurant [carte=" + carte + ", typeresto=" + typeresto + "]";
	}
	
	
}
