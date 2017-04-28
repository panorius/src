package allConnexion;

import java.util.List;

public class Utilisateur {
	private String nom, mdp, mail;
	int role, id;
	boolean entCreer;
	
	public Utilisateur(String nom, String mdp,String mail, int role, boolean entCreer){ // 1 = étudiant, 2 = entrepeneur, 3 = administrateur
		this.id=0;
		this.nom = nom;
		this.mdp = mdp;
		this.mail = mail;
		this.role = role;
		this.entCreer = entCreer;
	}
	public Utilisateur(String nom, String mdp,String mail, int role){
		this.id = 0;
		this.nom = nom;
		this.mdp = mdp;
		this.mail = mail;
		this.role = role;
	}
	public Utilisateur(String mdp,String mail, int role, boolean entCreer){
		this.id=0;
		this.mdp = mdp;
		this.mail = mail;
		this.role = role;
		this.entCreer = entCreer;
	}
	public Utilisateur(String mail, int role, boolean entCreer){
		this.id=0;
		this.mail = mail;
		this.role = role;
		this.entCreer = entCreer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString(){
		return "Utilisateur "+getId()+" et "+getNom()+" et "+getMdp()+" et "+getMail()+" et "+getRole()+" et "+isEntCreer(); //test
	}
	
	public boolean isEntCreer() {
		return entCreer;
	}
	public void setEntCreer(boolean entCreer) {
		this.entCreer = entCreer;
	}
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}
	public String getMdp() {
		return mdp;
	}
	public int getRole() {
		return role;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public void setRole(int role) {
		this.role = role;
	}
}
