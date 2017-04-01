package allConnexion;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface UtilisateurDao {

		public void creer(Utilisateur utilisateur) throws NoSuchAlgorithmException, SQLException;
		public boolean trouver(Utilisateur utilisateur) throws SQLException;
		public void supprimer(Utilisateur utilisateur) throws SQLException;
}
