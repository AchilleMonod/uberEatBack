package dao;

import java.util.List;

import model.Restaurant;
import model.TypeResto;

public interface IDAORestaurant extends IDAO<Restaurant,Integer> {



	List<Restaurant> findByType(TypeResto typeresto);
	 
	List<Restaurant> findByName(String name);

}