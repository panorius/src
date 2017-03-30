package allConnexion;


public interface EntrepriseDao {

	public void creer(Entreprise entreprise) throws DAOException;
	public Entreprise trouver(String nom) throws DAOException;
	public void supprimer(Entreprise entreprise) throws DAOException;
	
}
