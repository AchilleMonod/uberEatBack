package model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Inheritance
@Table(name="Utilisateur")
@DiscriminatorColumn(name="type_user")
public abstract class Utilisateur {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_utilisateur")
protected int id ;

protected String nom ;	
protected String prenom;

@Column(unique = true)
protected String email;

protected String mdp;



public Utilisateur() {
	super();
}


public Utilisateur(String nom, String prenom,String email, String mdp) {
	this.nom = nom;
	this.prenom = prenom;
	this.email=email;
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
