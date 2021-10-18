package dao;

import java.util.LinkedList;

import model.Restaurant;
import model.Restaurateur;

public interface IDAORestaurateur extends IDAO<Restaurateur,Integer> {

	public void addResto(LinkedList<Restaurant> nouveauRestaurant);
	public void modifCarte(Restaurant restaurant);
}