package allConnexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class EntrepriseDaoImpl implements EntrepriseDao{
	
	private static java.sql.PreparedStatement state;
	@Override
	public void creer(Entreprise entreprise) throws DAOException {
		try {
			String SQL_INSERT = "INSERT INTO Entreprise (nom, numRue, ville, cPostal, mail, tel, secteur)"
					+ " VALUES (?,?,?,?,?,?,?)";
			
			state = SingletonBDD.getInstance().prepareStatement(SQL_INSERT);
			state.setString(1, entreprise.getNom());
			state.setString(2, entreprise.getNumRue());
			state.setString(3, entreprise.getVille());
			state.setInt(4, entreprise.getId());
			state.setString(5, entreprise.getMail());
			state.setString(6, entreprise.getTel());
			state.setString(7, entreprise.getSecteur());
			state.executeUpdate();
			
	        System.out.println("Infos entreprise ajouté!");
	        //state.close();
		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException){ //On récupére l'exception quand deux utilisateur utilise le même nom.
				System.out.println("Entreprise déjà crée");
			}
			else{
				e.printStackTrace();
			}
		}
		
	}
	
	public Entreprise trouver(String nom) throws DAOException, SQLException{
		try {
			final String SQL_SELECT = "SELECT idEntreprise, nom, numRue, ville, cPostal, mail, tel, secteur "
					+ "FROM Entreprise "
					+ "WHERE nom = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			state.setString(1, nom);
			ResultSet result = state.executeQuery();
			
			if(result.next()){
				Entreprise entrepriseTrouver = new Entreprise(result.getString(2),result.getString(3),
						result.getInt(5),result.getString(4),result.getString(6),result.getString(7),
						result.getString(8));
				entrepriseTrouver.setId(result.getInt(1));
				return entrepriseTrouver;
			}
			
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}

		return null;
	}

	public void supprimer(Entreprise entreprise) throws DAOException, SQLException {
		try {
			final String SQL_DELETE = "DELETE FROM Entreprise WHERE nom = ? ";
			state = SingletonBDD.getInstance().prepareStatement(SQL_DELETE);
			state.setString(1, entreprise.getNom());
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null)
			state.close();
		}
	}



}
