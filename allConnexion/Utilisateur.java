package allConnexion;


public class Utilisateur {
	private String nom, mdp;
	int role;
	
	public Utilisateur(String nom, String mdp, int role){ // 1 = étudiant, 2 = entrepeneur, 3 = administrateur
		this.nom = nom;
		this.mdp = mdp;
		this.role = role;
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
