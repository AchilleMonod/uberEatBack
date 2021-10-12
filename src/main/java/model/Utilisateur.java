package model;

public class Utilisateur {

protected String nom ;	
protected String prenom;
protected int id ;
protected String mdp;


public Utilisateur(String nom, String prenom, int id, String mdp) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.id = id;
	this.mdp = mdp;
}


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public String getPrenom() {
	return prenom;
}


public void setPrenom(String prenom) {
	this.prenom = prenom;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getMdp() {
	return mdp;
}


public void setMdp(String mdp) {
	this.mdp = mdp;
}


@Override
public String toString() {
	return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", mdp=" + mdp + "]";
} 



	
}
