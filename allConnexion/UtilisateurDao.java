package allConnexion;


public interface UtilisateurDao {

		public void creer(Utilisateur utilisateur);
		public boolean trouver(Utilisateur utilisateur);
		public void supprimer(Utilisateur utilisateur);
}
