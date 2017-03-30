package allConnexion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBDD {

	public static void main(String[] args) throws DAOException, ParseException {
			 //nom, numRue, ville, cPostal, mail, tel, secteur
		     Entreprise entreprise = new Entreprise("Michel", "23 residence isbc",91900,"Evry","test@evry.fr","019231239","Informatique");
		     Entreprise entreprise2 = new Entreprise("Dupont", "ahah 23",91900,"Evry","test@evry.fr","012331239","Informatique");
		     EntrepriseDaoImpl Business = new EntrepriseDaoImpl();	//On test la création d'une entreprise.
		     Utilisateur user = new Utilisateur("Quentin", "123", 1);
		     Utilisateur user2 = new Utilisateur("LoL", "133", 1);
		     Utilisateur user3 = new Utilisateur("LoL", "153", 1);
		     UtilisateurDaolmpl User = new UtilisateurDaolmpl();
		     
		     //date
		     String date = "2017-03-01";
		     SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		     Date d1 = new Date();
		     d1 = formater.parse(date);
		     System.out.println(formater.format(d1));
		     
		     //offre
		     Offres o = new Offres("Stage","Libelle",d1,3,"Pour 6 mois minimum");
		     OffresDaoImpl offer = new OffresDaoImpl();
		     
		     // Try entreprise && offre;
		     
		     try {
				//Business.creer(entreprise2);
				//System.out.println(Business.trouver(entreprise.getNom()).getId());
				//System.out.println(Business.trouver(entreprise2.getNom()).getId());
				//Business.creer(entreprise);
		    	//Business.supprimer(entreprise);
		    	 offer.creer(entreprise2, o);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		     
		    // utilisateur
		     /*
		    User.creer(user2);
		    User.trouver(user2);
		    User.supprimer(user2);
			 */
		    
	}
	
}
