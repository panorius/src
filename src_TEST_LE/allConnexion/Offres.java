package allConnexion;

import java.util.ArrayList;
import java.util.Date;

public class Offres {

	private String NomEnt, Domaine, Libelle, Descriptif, statut;
	private Date date;
	private int duree,idEntreprise, idOffre;
	private ArrayList<Utilisateur> listUtilisateur;
	
	public Offres(String Domaine, String Libelle, Date date, int duree, String Descriptif){
		this.listUtilisateur = new ArrayList<Utilisateur>();
		this.idEntreprise=0;
		this.idOffre=0;
		this.Domaine = Domaine;
		this.Libelle = Libelle;
		this.date = date;
		this.duree = duree;
		this.Descriptif = Descriptif;
	}
	public Offres(int id, String NomEnt, String Domaine, String Libelle, Date date, int duree, String Descriptif){
		this.listUtilisateur = new ArrayList<Utilisateur>();
		this.idEntreprise=0;
		this.idOffre=id;
		this.NomEnt = NomEnt;
		this.Domaine = Domaine;
		this.Libelle = Libelle;
		this.date = date;
		this.duree = duree;
		this.Descriptif = Descriptif;
	}
	public Offres(String NomEnt, String Domaine, String Libelle, Date date, int duree, String Descriptif){
		this.listUtilisateur = new ArrayList<Utilisateur>();
		this.idEntreprise=0;
		this.idOffre=0;
		this.NomEnt = NomEnt;
		this.Domaine = Domaine;
		this.Libelle = Libelle;
		this.date = date;
		this.duree = duree;
		this.Descriptif = Descriptif;
	}
	public Offres(String NomEnt, String Domaine, String Libelle, Date date, int duree, String Descriptif, String statut){
		this.listUtilisateur = new ArrayList<Utilisateur>();
		this.idEntreprise=0;
		this.idOffre=0;
		this.NomEnt = NomEnt;
		this.Domaine = Domaine;
		this.Libelle = Libelle;
		this.date = date;
		this.duree = duree;
		this.Descriptif = Descriptif;
		this.statut = statut;
	}

	public int getIdEntreprise() {
		return idEntreprise;
	}


	public int getIdOffre() {
		return idOffre;
	}


	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}


	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}


	public String getDomaine() {
		return Domaine;
	}

	public String getLibelle() {
		return Libelle;
	}

	public String getDescriptif() {
		return Descriptif;
	}

	public Date getDate() {
		return date;
	}

	public int getDuree() {
		return duree;
	}


	public void setDomaine(String domaine) {
		Domaine = domaine;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	public void setDescriptif(String descriptif) {
		Descriptif = descriptif;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getNomEnt() {
		return NomEnt;
	}

	public void setNomEnt(String nomEnt) {
		NomEnt = nomEnt;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
}
