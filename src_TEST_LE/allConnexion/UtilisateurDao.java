package allConnexion;

import java.io.FileInputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface UtilisateurDao {

		public void creer(Utilisateur utilisateur) throws NoSuchAlgorithmException, SQLException;
		public boolean trouver(Utilisateur utilisateur) throws SQLException;
		public void supprimer(Utilisateur utilisateur) throws SQLException;
		public void ajoutCv(FileInputStream image) throws NoSuchAlgorithmException, SQLException;
		public void ajoutOffres(Utilisateur user, int offre) throws NoSuchAlgorithmException, SQLException;
		public Utilisateur recupUtilisateur(Utilisateur utilisateur) throws SQLException;
		public int recupUtilisateurById(Utilisateur utilisateur) throws SQLException;
		public boolean isEntCreer(Utilisateur utilisateur) throws SQLException;
		public void modifierNom(Utilisateur utilisateur, String nom) throws SQLException;
		public void modifierMail(Utilisateur utilisateur, String mail) throws SQLException;
		public void modifierMdp(Utilisateur utilisateur, String mdp) throws SQLException;
		public void uptdateEntCreer(Utilisateur utilisateur) throws SQLException;
}
