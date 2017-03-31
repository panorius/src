package allConnexion;

import java.sql.SQLException;

public interface EntrepriseDao {

	public void creer(Entreprise entreprise) throws DAOException;
	public Entreprise trouver(String nom) throws DAOException, SQLException;
	public void supprimer(Entreprise entreprise) throws DAOException, SQLException;
	
}
