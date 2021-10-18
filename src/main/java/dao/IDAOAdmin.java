package dao;

import java.util.LinkedList;

import model.Admin;
import model.Restaurant;

public interface IDAOAdmin extends IDAO<Admin,Integer> {

	public void validerUnRestau (LinkedList<Restaurant> nouveauRestaurant);
	public void supprimerRestau();
	public void supprimerCompte();
}
