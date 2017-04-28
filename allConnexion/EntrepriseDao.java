package allConnexion;

import java.sql.SQLException;

public interface EntrepriseDao {

	public Entreprise trouver(String nom) throws DAOException, SQLException;
	public void supprimer(Entreprise entreprise) throws DAOException, SQLException;
	void creer(Entreprise entreprise, Utilisateur user) throws DAOException;
	
}
