package allConnexion;

import java.sql.SQLException;

public interface EntrepriseDao {

	public Entreprise trouver(String nom) throws DAOException, SQLException;
	public void supprimer(Entreprise entreprise) throws DAOException, SQLException;
	void creer(Entreprise entreprise, Utilisateur user) throws DAOException;
	public Entreprise userEntreprise(Utilisateur user) throws DAOException, SQLException;
	public void modifierMail(Entreprise entreprise, String mail) throws SQLException;
	public void modifierAdresse(Entreprise entreprise, String numRue, String ville, int cPostal) throws SQLException;
	public void modifierAdresse(Entreprise entreprise, String numRue, String ville) throws SQLException;
	public void modifierAdresse(Entreprise entreprise, String numRue) throws SQLException;
	public void modifierNom(Entreprise entreprise, String nom) throws SQLException;
	public void modifierSecteur(Entreprise entreprise, String secteur) throws SQLException;
}
