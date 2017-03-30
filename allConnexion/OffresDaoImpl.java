package allConnexion;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class OffresDaoImpl implements OffresDao{

	private static PreparedStatement state;
	@Override
	public void creer(Entreprise entreprise, Offres Offre) throws DAOException {
		EntrepriseDaoImpl Business = new EntrepriseDaoImpl();
		int entrepriseId = Business.trouver(entreprise.getNom()).getId();
		// Avec PreparedStatement
		try {
			state = SingletonBDD.getInstance().prepareStatement(
					"INSERT INT Offres(idEntreprise, Domaine, Libelle, Date, Duree, Descriptif)"+
			"");
			entrepriseId = Business.trouver(entreprise.getNom()).getId();
			
			Date date = new Date(Offre.getDate().getTime());
			System.out.println(date);
			
			String SQL_INSERT = "INSERT INTO Offres (idEntreprise, Domaine, Libelle, Date, Duree, Descriptif)"
					+ " VALUES ('"+entrepriseId+"', '"+Offre.getDomaine()+"', '"+Offre.getLibelle()+"'"
							+ ",'to_date('"+date+"','yyyy-MM-dd')','"+Offre.getDuree()+"','"+Offre.getDescriptif()+"') ";

	        System.out.println("Offre ajouté!");
	        //state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/* Avec Statement
		if(state==null){
			try {
				state = SingletonBDD.getInstance().createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}//endif
		try {
			entrepriseId = Business.trouver(entreprise.getNom()).getId();
			
			Date date = new Date(Offre.getDate().getTime());
			System.out.println(date);
			
			String SQL_INSERT = "INSERT INTO Offres (idEntreprise, Domaine, Libelle, Date, Duree, Descriptif)"
					+ " VALUES ('"+entrepriseId+"', '"+Offre.getDomaine()+"', '"+Offre.getLibelle()+"'"
							+ ",'to_date('"+date+"','yyyy-MM-dd')','"+Offre.getDuree()+"','"+Offre.getDescriptif()+"') ";
	        state.executeUpdate(SQL_INSERT); // execute la commmande SQL
	        state.clearBatch(); // Vide le state de ses commandes SQL
	        System.out.println("Offre ajouté!");
	        //state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}

	@Override
	public void supprimer(Offres Offre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Offres trouver(Offres Offre) {
		// TODO Auto-generated method stub
		return null;
	}

}
