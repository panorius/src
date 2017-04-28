package allConnexion;

import java.sql.SQLException;
import java.util.List;

public interface ListOffresDao {
	public void creer(int usr, int offr, int entr)throws SQLException, DAOException;
	public void supprimer(Entreprise entreprise) throws DAOException, SQLException;
	public List<Offres> recupListOffres(Utilisateur usr)throws DAOException, SQLException;
	public List<Integer> recupListOffresByID(int i)throws DAOException, SQLException;
}
