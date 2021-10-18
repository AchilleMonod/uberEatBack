package dao;

import model.Utilisateur;

public interface IDAOUtilisateur extends IDAO<Utilisateur,Integer> {

	public Utilisateur connect(String email, String mdp);
	public void creerUncompte(int choix);
}