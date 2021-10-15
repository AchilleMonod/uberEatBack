package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOBoisson;
import model.Boisson;
import util.Context;

public class DAOBoisson implements IDAOBoisson{

	@Override
	public Boisson findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Boisson objet = em.find(Boisson.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Boisson> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Boisson b",Boisson.class);
		List<Boisson> boisson = requete.getResultList();
		em.close();
		return boisson;
	}


	@Override
	public Boisson save(Boisson b) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		b=em.merge(b);
		em.getTransaction().commit();
		em.close();
		return b;
	}

	@Override
	public void delete(Boisson b) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		b=em.merge(b);
		em.remove(b);
		em.getTransaction().commit();
		em.close();
	}

}
