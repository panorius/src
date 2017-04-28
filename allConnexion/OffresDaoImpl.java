package allConnexion;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
			String SQL_INSERT = "INSERT INTO Offres (idEntreprise, NomEnt, Domaine, Libelle, Date, Duree, Descriptif)"
					+ " VALUES (?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE idEntreprise=idEntreprise"; 
			state = SingletonBDD.getInstance().prepareStatement(SQL_INSERT);

			Date date = new Date(Offre.getDate().getTime());
			System.out.println(date);

			state.setInt(1, entrepriseId);
			state.setString(2, entreprise.getNom());
			state.setString(3, Offre.getDomaine());
			state.setString(4, Offre.getLibelle());
			state.setDate(5, date);
			state.setInt(6, Offre.getDuree());
			state.setString(7, Offre.getDescriptif());
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
			final String SQL_SELECT = "SELECT idOffre, idEntreprise, Domaine, Libelle, Date, Duree, Descriptif"
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

	public List<Offres> listOffreUser() throws DAOException, SQLException {
		List<Offres> listOffres = new ArrayList<Offres>();
		try {
			final String SQL_SELECT = "SELECT idOffre, idEntreprise, Domaine, Libelle, Date, Duree, Descriptif"
					+ "FROM offres "
					+ "WHERE idEntreprise = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			ResultSet rs = state.executeQuery();
			while(rs.next()){
				Offres offre = new Offres(rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6),rs.getString(7));
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

	public Offres recupOffre(int idOffre) throws DAOException, SQLException {
		Offres offre = null;
		try {
			final String SQL_SELECT = "SELECT idOffre, idEntreprise, NomEnt, Domaine, Libelle, Date, Duree, Descriptif "
					+ "FROM offres "
					+ "WHERE idOffre = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			state.setInt(1, idOffre);
			ResultSet rs = state.executeQuery();
			if(rs.next()){
				offre = new Offres(rs.getString(3), rs.getString(4),rs.getString(5),rs.getDate(6),rs.getInt(7),rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
		return offre;
	}
	public int recupOffreIdEntr(int id) throws DAOException, SQLException {
		int i=0;
		try {
			final String SQL_SELECT = "SELECT idOffre, idEntreprise"
					+ " FROM offres"
					+ " WHERE idOffre = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			state.setInt(1, id);
			ResultSet rs = state.executeQuery();
			if(rs.next()){
				i=rs.getInt(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
		return i;
	}

	public int idOffres(Offres offr) throws DAOException, SQLException {
		int id =0;
		try {
			final String SQL_SELECT = "SELECT idOffre FROM offres"
					+ " WHERE NomEnt = ? AND Domaine = ? AND Libelle = ? AND Duree = ? AND Descriptif = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);

			Date date = new Date(offr.getDate().getTime());

			state.setString(1, offr.getNomEnt());
			state.setString(2, offr.getDomaine());
			state.setString(3, offr.getLibelle());
			//state.setDate(4, date);
			state.setInt(4, offr.getDuree());
			state.setString(5, offr.getDescriptif());
			ResultSet rs = state.executeQuery();
			System.out.println("NomEnt = "+offr.getNomEnt()+" Domaine = "+offr.getDomaine()+" Libelle = "+offr.getLibelle()+" Date = "
					+date+" Duree = "+offr.getDuree()+ " Descriptif = "+offr.getDescriptif());
			if(rs.next()){
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
		return id;
	}

	public List<Offres> listOffreAll() throws DAOException, SQLException {
		List<Offres> listOffres = new ArrayList<Offres>();
		try {
			final String SQL_SELECT = "SELECT NomEnt, Domaine, Libelle, Date, Duree, Descriptif FROM offres";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			ResultSet rs = state.executeQuery();
			while(rs.next()){
				Offres offre = new Offres(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5),rs.getString(6));
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
