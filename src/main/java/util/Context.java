package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOAdmin;
import dao.IDAOArticle;
import dao.IDAOBoisson;
import dao.IDAOClient;
import dao.IDAOCommande;
import dao.IDAOPlat;
import dao.IDAORestaurant;
import dao.IDAORestaurateur;
import dao.IDAOUtilisateur;
import dao.jpa.DAOAdmin;
import dao.jpa.DAOArticle;
import dao.jpa.DAOBoisson;
import dao.jpa.DAOClient;
import dao.jpa.DAOCommande;
import dao.jpa.DAOPlat;
import dao.jpa.DAORestaurant;
import dao.jpa.DAORestaurateur;
import dao.jpa.DAOUtilisateur;
import model.Utilisateur;



public class Context {
	
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ubereat");
	private IDAOAdmin daoAdmin=new DAOAdmin();
	private IDAOArticle daoArticle=new DAOArticle();
	private IDAOBoisson daoBoisson=new DAOBoisson();
	private IDAOClient daoClient=new DAOClient();
	private IDAOCommande daoCommande=new DAOCommande();
	private IDAOPlat daoPlat=new DAOPlat();
	private IDAORestaurant daoRestaurant=new DAORestaurant();
	private IDAORestaurateur daoRestaurateur=new DAORestaurateur();
	private IDAOUtilisateur daoUtilisateur=new DAOUtilisateur();
	private Utilisateur connected;
	
	
	//SINGLETON
		private static Context _instance;
		
		
		private Context() {}
		
		
		
		public static Context getInstance() 
		{
			if(_instance==null)
			{_instance=new Context();}
			
			return _instance;
		}
		//FIN SINGLETON



		public EntityManagerFactory getEmf() {
			return emf;
		}

		
		
		public IDAOAdmin getDaoAdmin() {
			return daoAdmin;
		}
		
		public IDAOArticle getDaoArticle() {
			return daoArticle;
		}
		
		public IDAOBoisson getDaoBoisson() {
			return daoBoisson;
		}
		
		public IDAOClient getDaoClient() {
			return daoClient;
		}

		public IDAOCommande getDaoCommande() {
			return daoCommande;
		}
		public IDAOPlat getDaoPlat() {
			return daoPlat;
		}
		
		public IDAORestaurant getDaoRestaurant() {
			return daoRestaurant;
		}
		
		public IDAORestaurateur getDaoRestaurateur(){
			return daoRestaurateur;
		}
		public IDAOUtilisateur getDaoUtilisateur(){
			return daoUtilisateur;
		}
		
		public void setConnected(Utilisateur connected) {
			this.connected = connected;
		}
		
		public void closeEmf() 
		{
			this.emf.close();
		}

		
		
	
}
