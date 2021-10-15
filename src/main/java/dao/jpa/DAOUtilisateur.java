package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOUtilisateur;
import model.Utilisateur;
import util.Context;

public class DAOUtilisateur implements IDAOUtilisateur{

	@Override
	public Utilisateur findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Utilisateur objet = em.find(Utilisateur.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Utilisateur> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Utilisateur u",Utilisateur.class);
		List<Utilisateur> utilisateur = requete.getResultList();
		em.close();
		return utilisateur;
	}


	@Override
	public Utilisateur save(Utilisateur u) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		u=em.merge(u);
		em.getTransaction().commit();
		em.close();
		return u;
	}

	@Override
	public void delete(Utilisateur u) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		u=em.merge(u);
		em.remove(u);
		em.getTransaction().commit();
		em.close();
	}

}
