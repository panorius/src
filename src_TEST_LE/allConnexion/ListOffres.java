package allConnexion;

public class ListOffres {
	private Utilisateur usr;
	private Offres offr;
	public ListOffres(Utilisateur user, Offres offre){
		this.usr = user;
		this.offr = offre;
	}
	public Utilisateur getUsr() {
		return usr;
	}
	public void setUsr(Utilisateur usr) {
		this.usr = usr;
	}
	public Offres getOffr() {
		return offr;
	}
	public void setOffr(Offres offr) {
		this.offr = offr;
	}
}
