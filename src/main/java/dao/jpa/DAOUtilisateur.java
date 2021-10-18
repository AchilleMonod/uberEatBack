package dao.jpa;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOUtilisateur;
import model.Client;
import model.Restaurateur;
import model.Utilisateur;
import util.Context;

public class DAOUtilisateur implements IDAOUtilisateur{

	public static String saisieString(String msg) 
	{
		Scanner sc= new Scanner(System.in);		
		System.out.println(msg);
		return sc.nextLine();
	}

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

	@Override
	public Utilisateur connect(String email, String mdp) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Query requeteConnect = em.createQuery("Select u from Utilisateur u where u.email=:email and u.mdp=:mdp",Utilisateur.class);
		requeteConnect.setParameter("email", email);
		requeteConnect.setParameter("password", mdp);
		Utilisateur connected=null;

		try {
			connected =  (Utilisateur) requeteConnect.getSingleResult();
		}
		catch(Exception e) {}

		return connected;
	}

	public void creerUncompte(int choix) {
		String nom = saisieString("Entrez votre nom");
		String prenom = saisieString("Entrez votre prenom");
		String email = saisieString("Entrez votre email");
		String mdp = saisieString("Entrez votre mdp");
		if(choix==1) 
		{
			Client newUser = new Client(nom,prenom,email,mdp); 
			Context.getInstance().getDaoClient().save(newUser);
		}
		else if(choix==2) 
		{
			Restaurateur newUser = new Restaurateur(nom,prenom,email,mdp); 
			Context.getInstance().getDaoRestaurateur().save(newUser);
		}
	}

}
