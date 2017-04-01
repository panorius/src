package allConnexion;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class UtilisateurDaolmpl implements UtilisateurDao {

	private static java.sql.PreparedStatement state;
	
	@Override
	public void creer(Utilisateur utilisateur) throws NoSuchAlgorithmException, SQLException {
		try {
			String SQL_INSERT = "INSERT INTO Utilisateur (nom, mdp, mail,role)"
					+ " VALUES (?,?,?,?)";
			
			byte[] msgdigest;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			msgdigest = md5.digest(utilisateur.getMdp().getBytes());
			BigInteger number = new BigInteger(1,msgdigest);
			String hashtext = number.toString(16);
			
			state = SingletonBDD.getInstance().prepareStatement(SQL_INSERT);
			state.setString(1, utilisateur.getNom());
			state.setString(2, hashtext);
			state.setString(3, utilisateur.getMail());
			state.setInt(4, utilisateur.getRole());
	        state.executeUpdate();  // execute la commmande SQL

	        System.out.println("Infos Utilisateur ajouté!");
		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException){ //On récupére l'exception quand deux utilisateur utilise le même nom.
				System.out.println("Utilisateur déjà pris");
			}
			else{ //on affiche les autres exceptions
				e.printStackTrace();
			}
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
	}

	@Override
	public boolean trouver(Utilisateur utilisateur) throws SQLException { // Connexion 
		boolean user = false;
		try {
			//Convertir le mot de passe de l'utilisateur pour pouvoir comparer les mdp
			byte[] msgdigest;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			msgdigest = md5.digest(utilisateur.getMdp().getBytes());
			BigInteger number = new BigInteger(1,msgdigest);
			String hashtext = number.toString(16); // Mot de passe de l'utilisateur en arg en MD5
			
			// Methode prepareStatement à utiliser.
			final String SQL_SELECT = "SELECT nom, mdp, role FROM Utilisateur WHERE nom = ?"
					+ " AND mdp = ? AND mail = ? AND role = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			state.setString(1, utilisateur.getNom());
			state.setString(2, hashtext);
			state.setString(3, utilisateur.getMail());
			state.setInt(4, utilisateur.getRole());
			ResultSet result = state.executeQuery();
			if(result.next()){
				if(utilisateur.getNom().equals(result.getObject(1)) && result.getObject(2).equals(hashtext)){ //on verifie que le mot de passe et l'utilisateur sont équivalent
					 user = true;
				}
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
		return user;
	}

	@Override
	public void supprimer(Utilisateur utilisateur) throws SQLException {
		try {
			//Convertir le mot de passe de l'utilisateur pour pouvoir comparer les mdp
			byte[] msgdigest;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			msgdigest = md5.digest(utilisateur.getMdp().getBytes());
			BigInteger number = new BigInteger(1,msgdigest);
			String hashtext = number.toString(16); // Mot de passe de l'utilisateur en arg en MD5
			
			final String SQL_DELETE = "DELETE FROM utilisateur WHERE nom = ? AND mdp = ? AND mail = ? ";
			state = SingletonBDD.getInstance().prepareStatement(SQL_DELETE);
			state.setString(1, utilisateur.getNom());
			state.setString(2, hashtext);
			state.setString(3, utilisateur.getMail());
			state.executeUpdate();
			//state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		finally{
			if(state!=null){
				state.close();
			}
		}
	}

}
