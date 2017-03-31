package allConnexion;

import java.security.NoSuchAlgorithmException;

public interface UtilisateurDao {

		public void creer(Utilisateur utilisateur) throws NoSuchAlgorithmException;
		public boolean trouver(Utilisateur utilisateur);
		public void supprimer(Utilisateur utilisateur);
}
