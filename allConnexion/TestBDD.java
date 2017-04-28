package allConnexion;

import java.awt.List;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestBDD {

	public static void main(String[] args) throws DAOException, ParseException, SQLException, NoSuchAlgorithmException {
		     Utilisateur user = new Utilisateur("Quentin", "123", "mail@mail.com", 1);
		     Utilisateur user2 = new Utilisateur("LoL", "133", "mail@mail.com", 1);
		     Utilisateur user3 = new Utilisateur("LoL", "153", "mail@mail.com", 1);
		     UtilisateurDaolmpl User = new UtilisateurDaolmpl();
		     
			 //nom, numRue, ville, cPostal, mail, tel, secteur
		     Entreprise entreprise = new Entreprise("Michel", "23 residence isbc",91900,"Evry","test2@evry.fr","019231239","Informatique");
		     Entreprise entreprise2 = new Entreprise("ahah 23","rien de rien", 91900,"Evry","test@evry.fr","012331239","Informatique");
		     EntrepriseDaoImpl Business = new EntrepriseDaoImpl();	//On test la création d'une entreprise.
		     
		     //date
		     String date = "2017-03-01";
		     SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		     Date d1 = new Date();
		     d1 = formater.parse(date);
		     System.out.println(formater.format(d1));
		     
		     //offre
		     Offres o = new Offres("Stage de ralouf","Libelle",d1,3,"Pour 6 mois minimum");
		     OffresDaoImpl offer = new OffresDaoImpl();
		     
		     // Try entreprise && offre;
		     
		     try {
		    	 User.creer(user2);
				//Business.creer(entreprise2, user);
				Business.creer(entreprise, user2);
				//System.out.println(Business.trouver(entreprise.getNom()).getId());
				//System.out.println(Business.trouver(entreprise2.getNom()).getId());
				//System.out.println(Business.trouver(entreprise.getNom()).getNom());;
		    	//Business.supprimer(entreprise);
		    	 //offer.creer(entreprise2, o);
		    	 ArrayList<Offres> list = (ArrayList<Offres>) offer.listOffre(entreprise);
		    	 System.out.println(list.size());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     
		     
		    // utilisateur
		     
		    //User.creer(user3);
		    System.out.println(User.trouver(user2));
		    try {
				System.out.println(User.recupUtilisateur(user2).getNom());
			} catch (Exception e) {
				e.printStackTrace();
			}
		    //User.supprimer(user2);
			 
		    
	}
	
}
