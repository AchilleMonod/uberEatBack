package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAORestaurant;
import model.Restaurant;
import model.TypeResto;
import util.Context;

public class DAORestaurant implements IDAORestaurant{

	@Override
	public Restaurant findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Restaurant objet = em.find(Restaurant.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Restaurant> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Restaurant r",Restaurant.class);
		List<Restaurant> restaurant = requete.getResultList();
		em.close();
		return restaurant;
	}
	@Override
	public List<Restaurant> findByType(TypeResto typeresto){
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Restaurant r where r.TypeResto:=typeresto",Restaurant.class);
		requete.setParameter("TypeResto", typeresto);
		List<Restaurant> restaurant = requete.getResultList();
		em.close();
		return restaurant;
		
	}
	
	public List<Restaurant> findByName(String Name){
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Restaurant r where r.name like %Name%",Restaurant.class);
		requete.setParameter("name", Name);
		List<Restaurant> restaurant = requete.getResultList();
		em.close();
		return restaurant;
		
	}


	@Override
	public Restaurant save(Restaurant r) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		r=em.merge(r);
		em.getTransaction().commit();
		em.close();
		return r;
	}

	@Override
	public void delete(Restaurant r) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		r=em.merge(r);
		em.remove(r);
		em.getTransaction().commit();
		em.close();
	}

}
