package allConnexion;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface OffresDao {
	
	public void supprimer(Offres Offre) throws SQLException;
	public void creer(Entreprise entreprise, Offres Offre) throws SQLException, DAOException;
	public List<Offres> listOffre(Entreprise entreprise) throws DAOException, SQLException;
	public List<Offres> listDate(Date date) throws DAOException, SQLException;
	public List<Offres> listDomaine(String domaine) throws DAOException;
	public List<Offres> listLibelle(String Libelle) throws DAOException;
	public List<Offres> listDuree(int durée) throws DAOException;
	public List<Offres> listOffreUser() throws DAOException, SQLException;
	public Offres recupOffre(int idOffre) throws DAOException, SQLException;
	public int recupOffreIdEntr(int id) throws DAOException, SQLException;
	public int idOffres(Offres offr) throws DAOException, SQLException;
	public List<Offres> listOffreAll() throws DAOException, SQLException;
	
}
