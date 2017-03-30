package allConnexion;

import java.util.Date;

public class Offres {

	private String Domaine, Libelle, Descriptif;
	private Date date;
	private int duree,id;
	
	public Offres(String Domaine, String Libelle, Date date, int duree, String Descriptif){
		this.Domaine = Domaine;
		this.Libelle = Libelle;
		this.date = date;
		this.duree = duree;
		this.Descriptif = Descriptif;
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
}
