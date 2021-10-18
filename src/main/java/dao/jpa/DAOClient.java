package dao.jpa;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOClient;
import model.Client;
import model.Commande;
import model.Patient;
import model.Visite;
import util.Context;

public class DAOClient implements IDAOClient{

	public static int saisieInt(String msg) 
	{
		Scanner sc= new Scanner(System.in);		
		System.out.println(msg);
		return sc.nextInt();
	}
	
	@Override
	public Client findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Client objet = em.find(Client.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("from Client c",Client.class);
		List<Client> client = requete.getResultList();
		em.close();
		return client;
	}


	@Override
	public Client save(Client c) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		c=em.merge(c);
		em.getTransaction().commit();
		em.close();
		return c;
	}

	@Override
	public void delete(Client c) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		c=em.merge(c);
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void consulterHistorique() {
		int idClient= saisieInt("Saisir l'id du client");
		List<Commande> commandes = Context.getInstance().getDaoClient().findAllByIdClient(idClient);

		if(commandes.isEmpty()) 
		{
			System.out.println("Aucune commande n'a encore été passée");
		}

		for(Commande c : commandes) 
		{
			System.out.println(c);
		}
}
