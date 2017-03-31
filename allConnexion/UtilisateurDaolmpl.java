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
	public void creer(Utilisateur utilisateur) throws NoSuchAlgorithmException {
		try {
			String SQL_INSERT = "INSERT INTO Utilisateur (nom, mdp, role)"
					+ " VALUES (?,?,?)";
			byte[] msgdigest;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			msgdigest = md5.digest(utilisateur.getMdp().getBytes());
			BigInteger number = new BigInteger(1,msgdigest);
			String hashtext = number.toString(16);
			
			state = SingletonBDD.getInstance().prepareStatement(SQL_INSERT);
			state.setString(1, utilisateur.getNom());
			state.setString(2, hashtext);
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
	}

	@Override
	public boolean trouver(Utilisateur utilisateur) { // Connexion 
		boolean user = false;
		Statement state = null;
		if(state==null){
			try {
				state = SingletonBDD.getInstance().createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}// endif
		try {
			//Convertir le mot de passe de l'utilisateur pour pouvoir comparer les mdp
			byte[] msgdigest;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			msgdigest = md5.digest(utilisateur.getMdp().getBytes());
			BigInteger number = new BigInteger(1,msgdigest);
			String hashtext = number.toString(16); // Mot de passe de l'utilisateur en arg en MD5
			
			// Methode prepareStatement à utiliser.
			final String SQL_SELECT = "SELECT nom, mdp, role FROM Utilisateur WHERE nom = '"+utilisateur.getNom()+"'"
					+ " AND mdp = MD5('"+utilisateur.getMdp()+"')"
							+ "AND role = '"+utilisateur.getRole()+"' ";
			ResultSet result = state.executeQuery(SQL_SELECT);
			//ResultSetMetaData ResultMeta = result.getMetaData();
			if(result.next()){
				if(utilisateur.getNom().equals(result.getObject(1)) && result.getObject(2).equals(hashtext)){ //on verifie que le mot de passe et l'utilisateur sont équivalent
					 user = true;
				}
			}
			 //On affiche le nom des colonnes
			/*
		      for(int i = 1; i <= ResultMeta.getColumnCount(); i++)
		        System.out.print("\t" + ResultMeta.getColumnName(i).toUpperCase() + "\t *");
		         
		      System.out.println("\n**********************************");
		         
		      while(result.next()){         
		    	user = true;
		        for(int i = 1; i <= ResultMeta.getColumnCount(); i++){
		          System.out.print("\t" + result.getObject(i).toString() + "\t |");
		        }
		            
		        System.out.println("\n---------------------------------");
		      }
		    */
			result.close();
			//state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void supprimer(Utilisateur utilisateur) {
		Statement state = null;
		if(state==null){
			try {
				state = SingletonBDD.getInstance().createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			final String SQL_DELETE = "DELETE FROM utilisateur WHERE nom = '"+utilisateur.getNom()+"' AND mdp = MD5('"+utilisateur.getMdp()+"') ";
			state.execute(SQL_DELETE);
			//state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
