package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOArticle;
import model.Article;
import util.Context;

public class DAOArticle implements IDAOArticle{

	@Override
	public Article findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Article objet = em.find(Article.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Article> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Article a",Article.class);
		List<Article> article = requete.getResultList();
		em.close();
		return article;
	}


	@Override
	public Article save(Article a) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		a=em.merge(a);
		em.getTransaction().commit();
		em.close();
		return a;
	}

	@Override
	public void delete(Article a) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		a=em.merge(a);
		em.remove(a);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Article> findByRestaurantId(int idResto) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Article a where a.restaurant=:restaurant",Article.class);
		requete.setParameter("restaurant",Context.getInstance().getDaoRestaurant().findById(idResto));
		List<Article> carte = requete.getResultList();
		em.close();
		return carte;
	}

}
