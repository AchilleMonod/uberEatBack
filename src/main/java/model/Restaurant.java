package model;

import java.util.List;

public class Restaurant {

	private List<Article> carte;
	private TypeResto typeresto;
	
	public Restaurant(List<Article> carte, TypeResto typeresto) {
		super();
		this.carte = carte;
		this.typeresto = typeresto;
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
