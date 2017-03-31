package allConnexion;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OffresDaoImpl implements OffresDao{

	private static java.sql.PreparedStatement state;
	@Override
	public void creer(Entreprise entreprise, Offres Offre) throws SQLException, DAOException {
		EntrepriseDaoImpl Business = new EntrepriseDaoImpl();
		int entrepriseId = Business.trouver(entreprise.getNom()).getId();
		// Avec PreparedStatement
		try {
			String SQL_INSERT = "INSERT INTO Offres (idEntreprise, Domaine, Libelle, Date, Duree, Descriptif)"
					+ " VALUES (?,?,?,?,?,?) ON DUPLICATE KEY UPDATE idEntreprise=idEntreprise"; 
			state = SingletonBDD.getInstance().prepareStatement(SQL_INSERT);
			
			Date date = new Date(Offre.getDate().getTime());
			System.out.println(date);
			
			state.setInt(1, entrepriseId);
			state.setString(2, Offre.getDomaine());
			state.setString(3, Offre.getLibelle());
			state.setDate(4, date);
			state.setInt(5, Offre.getDuree());
			state.setString(6, Offre.getDescriptif());
			state.executeUpdate();
			
			
	        System.out.println("Offre ajouté!");
	        //state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(state!= null){
				state.close();
			}
		}
	}

	@Override
	public void supprimer(Offres Offre) throws SQLException {
		final String SQL_DELETE = "DELETE FROM offres WHERE idOffre = ? ";
		try {
			state = SingletonBDD.getInstance().prepareStatement(SQL_DELETE);
			state.setInt(1, Offre.getIdOffre());
			state.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
		
	}

	public List<Offres> listOffre(Entreprise entreprise) throws DAOException, SQLException {
		EntrepriseDaoImpl Business = new EntrepriseDaoImpl();
		List<Offres> listOffres = new ArrayList<Offres>();
		int entrepriseId = Business.trouver(entreprise.getNom()).getId();
		try {
			final String SQL_SELECT = "SELECT idOffre, idEntreprise, Domaine, Libelle, Date, Duree, Descriptif "
					+ "FROM offres "
					+ "WHERE idEntreprise = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			state.setInt(1, entrepriseId);
			ResultSet rs = state.executeQuery();
			while(rs.next()){
				Offres offre = new Offres(rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6),rs.getString(7));
				offre.setIdEntreprise(entrepriseId);
				offre.setIdOffre(rs.getInt(1));
				listOffres.add(offre);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
		return listOffres;
	}

	@Override
	public List<Offres> listDate(Date date) throws DAOException, SQLException {
		List<Offres> list = new ArrayList<Offres>();
		try {
			final String SQL_SELECT = "SELECT idOffre, idEntreprise, Domaine, Libelle, Date, Duree, Descriptif "
					+ "FROM offres "
					+ "WHERE Date = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			state.setDate(1, date);
			ResultSet rs = state.executeQuery();
			while(rs.next()){
				Offres offre = new Offres(rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6),rs.getString(7));
				offre.setIdOffre(rs.getInt(1));
				offre.setIdEntreprise(rs.getInt(2));
				list.add(offre);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
		return list;
	}

	@Override
	public List<Offres> listDomaine(String domaine) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offres> listLibelle(String Libelle) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offres> listDuree(int durée) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
