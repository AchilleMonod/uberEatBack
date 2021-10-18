package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.LinkedList;

import model.Admin;
import model.Boisson;
import model.Client;
import model.Restaurant;
import model.Restaurateur;
import model.TypeResto;
import model.Utilisateur;
import util.Context;

public class Test {


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

	public static void menuPrincipal() {

		System.out.println("Menu Principal");
		System.out.println("1- Creer un compte");
		System.out.println("2- Se connecter");


		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : menuInscription();break;
		case 2 : menuConnexion();break;

		}
		menuRestaurateur();
	}


	public static void menuConnexion() {

		String login = saisieString("Entrer le login");

		String password = saisieString("Entrer le password");

		Utilisateur user = Context.getInstance().getDaoPersonne().connect(login, password);

		if(user instanceof Client) 
		{
			menuClient();
		}
		else if(user instanceof Restaurateur) 
		{
			menuRestaurateur();
		}
		else if(user instanceof Admin) 
		{
			menuAdmin();
		}
		else 
		{
			System.out.println("Identifiants invalides");menuConnexion();
		}
	}

	public static void menuInscription() {

		System.out.println("Inscription :");
		System.out.println("1- Consommateur");
		System.out.println("2- Vendeur");
		System.out.println("3- Retour");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : inscritpionClient();break;
		case 2 : inscritpionRestaurateur();break;
		case 3 : menuPrincipal();break;

		}
	}


	public static void menuAdmin() 
	{
		System.out.println("Menu Admin");
		System.out.println("1- Valider un restaurant");
		System.out.println("2- Creer un admin");
		System.out.println("3- Supprimer un restaurant");
		System.out.println("4- Supprimer un compte");
		System.out.println("5- Deconnexion");


		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : showListResto();break;
		case 2 : createAdmin();break;
		case 3 : deleteResto();break;
		case 4 : deleteAdmin();break;
		case 5 : menuPrincipal();break;
		}
		menuAdmin();
	}


	public static void menuClient() 
	{
		System.out.println("Menu Client");
		System.out.println("1- Commander");
		System.out.println("2- Historique Commande");
		System.out.println("3- Modifier infos perso");
		System.out.println("4- Deconnexion");


		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : menuResto();break;
		case 2 : consulterHistorique();break;
		case 3 : modifInfosClient();break;
		case 4 : menuPrincipal();break;

		}
		menuClient();
	}


	public static void menuRestaurateur() 
	{
		System.out.println("Menu Restaurateur");
		System.out.println("1- Ajouter un Resto");
		System.out.println("2- Modifier carte/infos resto");
		System.out.println("3- Modifier infos perso");
		System.out.println("4- Deconnexion");


		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : addResto();break;
		case 2 : modifInfosResto();break;
		case 3 : modifInfosRestaurateur();break;
		case 4 : menuConnexion();break;

		}
		menuRestaurateur();
	}


	public static void  menuResto() {

		System.out.println("vous voulez trier par ");
		System.out.println("1- type de restaurant ");
		System.out.println("2- nom du resto ");
		System.out.println("3- adresse");
		System.out.println("4- Deconnexion");

		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : findByType();break;
		// case 2 : findByName();break;
		// case 3 : findByLocation();break;
		case 4 : menuConnexion();break;
		}
		menuResto();

	}

	public static void findByType() {



		TypeResto[] type = TypeResto.values();

		int i;
		for(i=0;i<type.length;i++) 
		{
			TypeResto b = type[i];
			System.out.println(i+1+" "+b);
		}
		System.out.println((i+1)+" exit");
		int choix = saisieInt("Veuillez choisir le type de resto");
		if (choix<1 || choix>(type.length+1))
			findByType();
		else if (choix == ((type.length)+1))
			menuResto();
		else 	
			Context.getInstance().getDaoRestaurant().findByType(type[choix-1]);

	}




	public static void main(String[] args) {
		//inscritpionClient();
		findByType();

	}
}
