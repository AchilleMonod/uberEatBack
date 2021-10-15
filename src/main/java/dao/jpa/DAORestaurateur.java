package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAORestaurateur;
import model.Restaurateur;
import util.Context;

public class DAORestaurateur implements IDAORestaurateur{

	@Override
	public Restaurateur findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Restaurateur objet = em.find(Restaurateur.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Restaurateur> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Restaurateur r",Restaurateur.class);
		List<Restaurateur> restaurateur = requete.getResultList();
		em.close();
		return restaurateur;
	}


	@Override
	public Restaurateur save(Restaurateur r) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		r=em.merge(r);
		em.getTransaction().commit();
		em.close();
		return r;
	}

	@Override
	public void delete(Restaurateur r) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		r=em.merge(r);
		em.remove(r);
		em.getTransaction().commit();
		em.close();
	}

}
