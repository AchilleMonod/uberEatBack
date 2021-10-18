package dao.jpa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOAdmin;
import model.Admin;
import model.Client;
import model.Restaurant;
import model.Restaurateur;
import model.Utilisateur;
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
	
	public static String saisieString(String msg) 
	{
		Scanner sc= new Scanner(System.in);		
		System.out.println(msg);
		return sc.nextLine();
	}
	
	public void validerUnRestau (LinkedList<Restaurant> nouveauRestaurant)
	{
		Restaurant r= new Restaurant();
		String choix;
		while (nouveauRestaurant.size()>0)
		{
			r=nouveauRestaurant.poll();
			System.out.println(r);
			choix=saisieString("Voulez vous ajouter ce restaurant à l'appli ? (oui/non)");
			if (choix.equalsIgnoreCase("oui"))
			{
				r=Context.getInstance().getDaoRestaurant().save(r);
			}
		}
		System.out.println("Il n'y a pas d'autres restaurants à ajouter");
	}
	
	public void supprimerRestau()
	{
		List<Restaurant> restaurant= new ArrayList();
		restaurant= Context.getInstance().getDaoRestaurant().findAll();
		System.out.println(restaurant);
		String choix=saisieString("nom du restaurant à supprimer:");
		for (Restaurant r :restaurant)
		{
			if (r.getName().equalsIgnoreCase(choix)) 
			{
				if (saisieString("Voulez vous vraiment supprimer "+r +" (oui/non)").equalsIgnoreCase("oui"))
				{
					Context.getInstance().getDaoRestaurant().delete(r);
				}
				
			}
		}
	}
	
	public void supprimerCompte()
	{
		List<Utilisateur> user= new ArrayList();
		user= Context.getInstance().getDaoUtilisateur().findAll();
		String choix=saisieString("nom du compte à supprimer:");
		for (Utilisateur u :user)
		{
			if (u.getNom().equalsIgnoreCase(choix)) 
			{
				if (saisieString("Voulez vous vraiment supprimer "+u +" (oui/non)").equalsIgnoreCase("oui"))
				{
					Context.getInstance().getDaoUtilisateur().delete( u);
				}
			}
		}
	}

	

	public void creerUnAdmin() {
		String nom = saisieString("Entrez votre nom");
		String prenom = saisieString("Entrez votre prenom");
		String email = saisieString("Entrez votre email");
		String mdp = saisieString("Entrez votre mdp");
		Admin newUser = new Admin(nom,prenom,email,mdp); 
		Context.getInstance().getDaoAdmin().save(newUser);

		
	}
}
