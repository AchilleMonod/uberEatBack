package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOCommande;
import model.Commande;
import util.Context;

public class DAOCommande implements IDAOCommande{

	@Override
	public Commande findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Commande objet = em.find(Commande.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Commande> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Commande c",Commande.class);
		List<Commande> commande = requete.getResultList();
		em.close();
		return commande;
	}


	@Override
	public Commande save(Commande c) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		c=em.merge(c);
		em.getTransaction().commit();
		em.close();
		return c;
	}

	@Override
	public void delete(Commande c) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		c=em.merge(c);
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

}
