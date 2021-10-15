package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOPlat;
import model.Plat;
import util.Context;

public class DAOPlat implements IDAOPlat{

	@Override
	public Plat findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Plat objet = em.find(Plat.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Plat> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Plat p",Plat.class);
		List<Plat> plat = requete.getResultList();
		em.close();
		return plat;
	}


	@Override
	public Plat save(Plat p) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		p=em.merge(p);
		em.getTransaction().commit();
		em.close();
		return p;
	}

	@Override
	public void delete(Plat p) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		p=em.merge(p);
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}

}
