package allConnexion;

import javax.swing.JTextField;

public class Entreprise {
	
	private int id,idUtilisateur;
	private String nom;
	private String numRue;
	private int cPostal;
	private String Ville, mail, tel, secteur;
	
	public Entreprise(int idEntr, String nom, String numRue, int cPostal, String Ville, String mail, String tel, String secteur){
		this.id=idEntr;
		this.idUtilisateur=0;
		this.nom = nom;
		this.numRue = numRue;
		this.cPostal = cPostal;
		this.Ville = Ville;
		this.mail = mail;
		this.tel = tel;
		this.secteur = secteur;
	}
	public Entreprise(String nom, String numRue, int cPostal, String Ville, String mail, String tel, String secteur){
		this.id=0;
		this.idUtilisateur=0;
		this.nom = nom;
		this.numRue = numRue;
		this.cPostal = cPostal;
		this.Ville = Ville;
		this.mail = mail;
		this.tel = tel;
		this.secteur = secteur;
	}	
	
	public Entreprise(JTextField gettNomEnt, JTextField gettAdresse, JTextField gettCp, JTextField gettVille,
			JTextField gettMail, JTextField gettTel, JTextField gettSecteurEnt) {
		// TODO Auto-generated constructor stub
	}

	public int getId(){
		return id;
	}
	public int setId(int id){
		return this.id=id;
	}
	public String getNom() {
		return nom;
	}
	public String getNumRue() {
		return numRue;
	}
	public int getcPostal() {
		return cPostal;
	}
	public String getVille() {
		return Ville;
	}
	public String getMail() {
		return mail;
	}
	public String getTel() {
		return tel;
	}
	public String getSecteur() {
		return secteur;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}
	public void setcPostal(int cPostal) {
		this.cPostal = cPostal;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}


	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}


	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", numRue=" + numRue
				+ ", cPostal=" + cPostal + ", Ville=" + Ville + ", mail=" + mail + ", tel=" + tel + ", secteur="
				+ secteur + "]";
	}
}
