import java.util.Scanner;

public class Test {

	
	public static String saisieString(String msg) 
	{
		Scanner sc= new Scanner(System.in);		
		System.out.println(msg);
		return sc.nextLine();
	}
	
	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static void main(String[] args) {

		menuConnexion();
		
	}
	
	
	public static void main(String[] args) {

		menuConnexion();
		
	}


	public static void menuConnexion() {
		
		String login = saisieString("Entrer le login");
		
		String password = saisieString("Entrer le password");
		
		Utilisateur c = daoUtilisateur.connect(login,password);
		
		
		if(c instanceof Client) 
		{
			menuClient();
		}
		else if(c instanceof Restaurateur) 
		{
			menuRestaurateur();
		}
		else if(c instanceof Admin) 
		{
			menuAdmin();
		}
		else 
		{
			System.out.println("Identifiants invalides");menuConnexion();
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
	
}
