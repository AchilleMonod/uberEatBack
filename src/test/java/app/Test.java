import java.util.Scanner;

import model.Admin;
import model.Client;
import model.Restaurateur;
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

	public static void menuClient() 
	{
		System.out.println("Menu Client");
		System.out.println("1- ");
		System.out.println("2- Deconnexion");


		int choix = saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : ;break;
		case 2 : menuConnexion();break;

		}
		menuClient();
	}

	public static void menuRestaurateur() 
    {
        System.out.println("Menu Restaurateur");
        System.out.println("1- ");
        System.out.println("2- Deconnexion");


        int choix = saisieInt("Choisir un menu :");
        switch(choix) 
        {
        case 1 : ;break;
        case 2 : menuConnexion();break;

        }
        menuRestaurateur();
    }

	public static void menuAdmin() 
    {
        System.out.println("Menu Admin");
        System.out.println("1- ");
        System.out.println("2- Deconnexion");


        int choix = saisieInt("Choisir un menu :");
        switch(choix) 
        {
        case 1 : ;break;
        case 2 : menuConnexion();break;

        }
        menuAdmin();
    }
	


	public static void main(String[] args) {

		menuConnexion();
		
	}
}
