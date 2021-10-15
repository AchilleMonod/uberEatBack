package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOAdmin;
import model.Admin;
import util.Context;

public class DAOAdmin implements IDAOAdmin{

	@Override
	public Admin findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Admin objet = em.find(Admin.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Admin> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Admin a",Admin.class);
		List<Admin> admin = requete.getResultList();
		em.close();
		return admin;
	}


	@Override
	public Admin save(Admin a) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		a=em.merge(a);
		em.getTransaction().commit();
		em.close();
		return a;
	}

	@Override
	public void delete(Admin a) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		a=em.merge(a);
		em.remove(a);
		em.getTransaction().commit();
		em.close();
	}

}
