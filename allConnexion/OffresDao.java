package allConnexion;

public interface OffresDao {
	
	public void supprimer(Offres Offre);
	public Offres trouver(Offres Offre);
	void creer(Entreprise entreprise, Offres Offre) throws DAOException;
	
}
