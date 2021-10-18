package dao.jpa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAORestaurateur;
import model.Article;
import model.Boisson;
import model.Plat;
import model.Restaurant;
import model.Restaurateur;
import model.TypeResto;
import util.Context;

public class DAORestaurateur implements IDAORestaurateur{

	public static String saisieString(String msg) 
	{
		Scanner sc= new Scanner(System.in);		
		System.out.println(msg);
		return sc.nextLine();
	}
	
	public static int saisieInt(String msg) 
	{
		Scanner sc= new Scanner(System.in);		
		System.out.println(msg);
		return sc.nextInt();
	}
	
	public static double saisieDouble(String msg) 
	{
		Scanner sc= new Scanner(System.in);		
		System.out.println(msg);
		return sc.nextDouble();
	}
	
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
	
	public void addResto(LinkedList<Restaurant> nouveauRestaurant) {
		String nom=saisieString("Saisir le nom du restaurant");
		
		System.out.println("Types disponibles : ");
		TypeResto[] type = TypeResto.values();

		int i;
		for(i=0;i<type.length;i++) 
		{
			TypeResto b = type[i];
			System.out.println(i+1+" "+b);
		}
		
		TypeResto t = type[saisieInt("Veuillez choisir un type de restaurant")-1];
		
		Restaurant resto = new Restaurant(null,t,nom);
		
		List<Article> carte = new ArrayList();
	
		Article a = null;
		double prix;
		String libelle;
		String description;
		String choix;
		String choix2;
		System.out.println("Ajouter un article");
		do 
		{
			choix = saisieString("Ajoutez-vous un plat ou une boisson ?");
			libelle = saisieString("Entrer le libelle de l'article");
			prix = saisieDouble("Entrer le prix de l'article");
			description = saisieString("Entrer la description de l'article");
			
			if (choix.equals("plat")) {
			a = new Plat(prix,libelle,description,resto);}
			else if(choix.equals("boisson")) {
			a = new Boisson(prix,libelle,description,resto);
			}
			carte.add(a);
			choix2 = saisieString("Voulez vous ajouter un autre article ? (y/n)");
		}
		while (choix2.equals("y"));
		resto.setCarte(carte);
		nouveauRestaurant.add(resto);	
		
	}

	
}
