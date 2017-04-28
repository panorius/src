package allConnexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class EntrepriseDaoImpl implements EntrepriseDao{
	
	private static java.sql.PreparedStatement state;
	@Override
	public void creer(Entreprise entreprise, Utilisateur user) throws DAOException {
		try {
			UtilisateurDaolmpl User = new UtilisateurDaolmpl();
			String SQL_INSERT = "INSERT INTO Entreprise (idUtilisateur, nom, numRue, ville, cPostal, mail, tel, secteur)"
					+ " VALUES (?,?,?,?,?,?,?,?)";
			
			state = SingletonBDD.getInstance().prepareStatement(SQL_INSERT);
			state.setInt(1, User.recupUtilisateur(user).getId());
			state.setString(2, entreprise.getNom());
			state.setString(3, entreprise.getNumRue());
			state.setString(4, entreprise.getVille());
			state.setInt(5, entreprise.getcPostal());
			state.setString(6, entreprise.getMail());
			state.setString(7, entreprise.getTel());
			state.setString(8, entreprise.getSecteur());
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
	
	public Entreprise userEntreprise(Utilisateur user) throws DAOException, SQLException{
		try {
			UtilisateurDaolmpl User = new UtilisateurDaolmpl();
			final String SQL_SELECT = "SELECT idEntreprise, nom, numRue, ville, cPostal, mail, tel, secteur "
					+ "FROM entreprise "
					+ "WHERE idUtilisateur = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			state.setInt(1, User.recupUtilisateur(user).getId());
			ResultSet result = state.executeQuery();
			System.out.println("TEST:"+User.recupUtilisateur(user).getId());
			if(result.next()){
				Entreprise entrepriseTrouver = new Entreprise(result.getInt(1),result.getString(2),result.getString(3),
						result.getInt(5),result.getString(4),result.getString(6),result.getString(7),
						result.getString(8));
				//entrepriseTrouver.setId(result.getInt(1));
				//entrepriseTrouver.setIdUtilisateur(result.getInt(2));
				System.out.println("TEST2:"+entrepriseTrouver.toString());
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
	
	public void modifierMail(Entreprise entreprise, String mail) throws SQLException{
		EntrepriseDaoImpl Business = new EntrepriseDaoImpl();
		try {
			int entrepriseId = Business.trouver(entreprise.getNom()).getId();
			final String SQL_UPDATE = "UPDATE entreprise SET mail = ? WHERE idEntreprise = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setString(1, mail);
			state.setInt(2, entrepriseId);
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(state!=null){
				state.close();
			}
		}
	}
	public void modifierAdresse(Entreprise entreprise, String numRue, String ville, int cPostal) throws SQLException{
		EntrepriseDaoImpl Business = new EntrepriseDaoImpl();
		try {
			int entrepriseId = Business.trouver(entreprise.getNom()).getId();
			final String SQL_UPDATE = "UPDATE entreprise SET numRue = ? AND ville = ? AND cPostal = ? WHERE idEntreprise = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setString(1, numRue);
			state.setString(2, ville);
			state.setInt(3, cPostal);
			state.setInt(4, entrepriseId);
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(state!=null){
				state.close();
			}
		}
	}
	public void modifierAdresse(Entreprise entreprise, String numRue, String ville) throws SQLException{
		EntrepriseDaoImpl Business = new EntrepriseDaoImpl();
		try {
			int entrepriseId = Business.trouver(entreprise.getNom()).getId();
			final String SQL_UPDATE = "UPDATE entreprise SET numRue = ? AND ville = ? WHERE idEntreprise = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setString(1, numRue);
			state.setString(2, ville);
			state.setInt(3, entrepriseId);
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(state!=null){
				state.close();
			}
		}
	}
	public void modifierAdresse(Entreprise entreprise, String numRue) throws SQLException{
		EntrepriseDaoImpl Business = new EntrepriseDaoImpl();
		try {
			int entrepriseId = Business.trouver(entreprise.getNom()).getId();
			final String SQL_UPDATE = "UPDATE entreprise SET numRue = ? WHERE idEntreprise = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setString(1, numRue);
			state.setInt(2, entrepriseId);
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(state!=null){
				state.close();
			}
		}
	}
	public void modifierNom(Entreprise entreprise, String nom) throws SQLException{
		EntrepriseDaoImpl Business = new EntrepriseDaoImpl();
		try {
			int entrepriseId = Business.trouver(entreprise.getNom()).getId();
			final String SQL_UPDATE = "UPDATE entreprise SET nom = ? WHERE idEntreprise = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setString(1, nom);
			state.setInt(2, entrepriseId);
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(state!=null){
				state.close();
			}
		}
	}
	public void modifierSecteur(Entreprise entreprise, String secteur) throws SQLException{
		EntrepriseDaoImpl Business = new EntrepriseDaoImpl();
		try {
			int entrepriseId = Business.trouver(entreprise.getNom()).getId();
			final String SQL_UPDATE = "UPDATE entreprise SET secteur = ? WHERE idEntreprise = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setString(1, secteur);
			state.setInt(2, entrepriseId);
			state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(state!=null){
				state.close();
			}
		}
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
