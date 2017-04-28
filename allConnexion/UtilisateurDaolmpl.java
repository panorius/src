package allConnexion;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.ImageIcon;

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

	public void ajoutCv(FileInputStream image) throws NoSuchAlgorithmException, SQLException {
		try {
			String SQL_INSERT = "INSERT INTO Utilisateur (image)"
					+ " VALUES (?)";

			state = SingletonBDD.getInstance().prepareStatement(SQL_INSERT);
			state.setBinaryStream(1, image);
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

	public void ajoutOffres(Utilisateur user, int offre) throws NoSuchAlgorithmException, SQLException {
		try {
			String SQL_INSERT = "INSERT INTO Utilisateur (listOffres)"
					+ " VALUES (?) WHERE idUtilisateur = ?";

			state = SingletonBDD.getInstance().prepareStatement(SQL_INSERT);
			state.setInt(1, offre);
			state.setInt(2, user.getId());
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
			final String SQL_SELECT = "SELECT mdp, mail, role FROM Utilisateur WHERE mdp = ? AND mail = ? AND role = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			state.setString(1, hashtext);
			state.setString(2, utilisateur.getMail());
			state.setInt(3, utilisateur.getRole());
			ResultSet result = state.executeQuery();
			if(result.next()){
				if(result.getObject(2).equals(utilisateur.getMail()) && result.getObject(1).equals(hashtext)){ //on verifie que le mot de passe et l'utilisateur sont équivalent
					user = true;
				}System.out.println(result.getObject(2)+" "+result.getObject(1)+" "+result.getObject(3));
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
	public Utilisateur recupUtilisateur(Utilisateur utilisateur) throws SQLException{
		try {
			//Convertir le mot de passe de l'utilisateur pour pouvoir comparer les mdp
			byte[] msgdigest;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			msgdigest = md5.digest(utilisateur.getMdp().getBytes());
			BigInteger number = new BigInteger(1,msgdigest);
			String hashtext = number.toString(16); // Mot de passe de l'utilisateur en arg en MD5

			// Methode prepareStatement à utiliser.
			final String SQL_SELECT = "SELECT idUtilisateur, nom ,mdp, mail, role FROM Utilisateur WHERE mdp = ? AND mail = ? AND role = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			state.setString(1, hashtext);
			state.setString(2, utilisateur.getMail());
			state.setInt(3, utilisateur.getRole());
			ResultSet result = state.executeQuery();
			if(result.next()){
				if(result.getObject(4).equals(utilisateur.getMail()) && result.getObject(3).equals(hashtext)){ //on verifie que le mot de passe et l'utilisateur sont équivalent
					Utilisateur userTrouver= new Utilisateur(result.getString(2), utilisateur.getMdp(), result.getString(4), result.getInt(5));
					userTrouver.setId(result.getInt(1));
					return userTrouver;
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
		return null;
	}
	public int recupUtilisateurById(Utilisateur utilisateur) throws SQLException{
		int i = 0;
		try {
			//Convertir le mot de passe de l'utilisateur pour pouvoir comparer les mdp
			byte[] msgdigest;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			msgdigest = md5.digest(utilisateur.getMdp().getBytes());
			BigInteger number = new BigInteger(1,msgdigest);
			String hashtext = number.toString(16); // Mot de passe de l'utilisateur en arg en MD5

			// Methode prepareStatement à utiliser.
			final String SQL_SELECT = "SELECT idUtilisateur FROM Utilisateur WHERE mdp = ? AND mail = ? AND role = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			state.setString(1, hashtext);
			state.setString(2, utilisateur.getMail());
			state.setInt(3, utilisateur.getRole());
			ResultSet result = state.executeQuery();
			if(result.next()){
				i = result.getInt(1);
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
		return i;
	}
	public boolean isEntCreer(Utilisateur utilisateur) throws SQLException { // Connexion 
		boolean creer = false;
		try {
			// Methode prepareStatement à utiliser.
			final String SQL_SELECT = "SELECT mail, entCreer FROM Utilisateur WHERE mail = ? AND entCreer = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			state.setString(1, utilisateur.getMail());
			state.setBoolean(2, utilisateur.isEntCreer());
			ResultSet result = state.executeQuery();
			if(result.next()){
				creer = true;
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
		return creer;
	}
	public void modifierNom(Utilisateur utilisateur, String nom) throws SQLException{
		try {
			final String SQL_UPDATE = "UPDATE utilisateur SET nom = ? WHERE mail = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setString(1, nom);
			state.setString(2, utilisateur.getMail());
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
	public void modifierMail(Utilisateur utilisateur, String mail) throws SQLException{
		try {
			final String SQL_UPDATE = "UPDATE utilisateur SET mail = ? WHERE mail = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setString(1, mail);
			state.setString(2, utilisateur.getMail());
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
	public void modifierMdp(Utilisateur utilisateur, String mdp) throws SQLException{
		try {
			//Convertir le mot de passe de l'utilisateur pour pouvoir comparer les mdp
			byte[] msgdigest;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			msgdigest = md5.digest(mdp.getBytes());
			BigInteger number = new BigInteger(1,msgdigest);
			String hashtext = number.toString(16); // Mot de passe de l'utilisateur en arg en MD5

			final String SQL_UPDATE = "UPDATE utilisateur SET mdp = ? WHERE mail = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setString(1, hashtext);
			state.setString(2, utilisateur.getMail());
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
	public void uptdateEntCreer(Utilisateur utilisateur) throws SQLException { // Connexion 
		try {
			// Methode prepareStatement à utiliser.
			final String SQL_UPDATE = "UPDATE utilisateur SET entCreer = 1 WHERE mail = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setString(1, utilisateur.getMail());
			state.executeUpdate();

			System.out.println("Creation de l'entreprise réussi !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
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
