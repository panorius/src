package allConnexion;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListOffresDaoImpl implements ListOffresDao{

	private static java.sql.PreparedStatement state;
	@Override

	public List<Offres> recupListOffres(Utilisateur usr)throws DAOException, SQLException {
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
	public List<Integer> recupListOffresByID(int i)throws DAOException, SQLException {
		List<Integer> listIdOffres = new ArrayList<Integer>();
		try {
			final String SQL_SELECT = "SELECT idOffre FROM listoffres WHERE idUtilisateur = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_SELECT);
			state.setInt(1, i);
			ResultSet rs = state.executeQuery();
			while(rs.next()){
				//Offres offre = new Offres(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5),rs.getString(6));
				listIdOffres.add(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
		return listIdOffres;
	}
	public void changeStatut(String statut,int idOffre, int idUser) throws SQLException{
		try {
			final String SQL_UPDATE = "UPDATE listoffres SET validation = ? WHERE idUtilisateur = ? AND idOffre = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setString(1, statut);
			state.setInt(3, idOffre);
			state.setInt(2, idUser);
			state.executeUpdate();
			System.out.println("Candidature Accepter: idO: "+idOffre+" et idU: "+idUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
	}
	public List<String> recupStatutForEntr(int idOffre, int idEntr) throws SQLException{
		List<String> statut = new ArrayList<>();;
		try {
			final String SQL_UPDATE = "SELECT validation FROM listoffres WHERE idoffre = ? AND idEntreprise = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setInt(1, idOffre);
			state.setInt(2, idEntr);
			ResultSet rs = state.executeQuery();
			while(rs.next()){
				String a = rs.getString(1);
				statut.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
		return statut;
	}
	public List<String> recupStatut(int idOffre, int idUser) throws SQLException{
		List<String> statut = new ArrayList<>();
		try {
			final String SQL_UPDATE = "SELECT validation FROM listoffres WHERE idoffre = ? AND idutilisateur = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setInt(1, idOffre);
			state.setInt(2, idUser);
			ResultSet rs = state.executeQuery();
			while(rs.next()){
				String a = rs.getString(1);
				statut.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
		return statut;
	}
	public int recupIdUserByIdOffre(int idOffre) throws SQLException{
		int idUser =0;
		try {
			final String SQL_UPDATE = "SELECT idUtilisateur FROM listoffres WHERE idoffre = ?";
			state = SingletonBDD.getInstance().prepareStatement(SQL_UPDATE);
			state.setInt(1, idOffre);
			ResultSet rs = state.executeQuery();
			idUser = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
		return idUser;
	}
	@Override
	public void creer(int usr, int offr, int entr) throws SQLException, DAOException {
		System.out.println(usr+" "+offr);
		try{
			final String SQL_INSERT = "INSERT INTO listoffres (idUtilisateur, idOffre, idEntreprise) VALUES (?,?,?)";
			state = SingletonBDD.getInstance().prepareStatement(SQL_INSERT);
			state.setInt(1, usr);
			state.setInt(2, offr);
			state.setInt(3, entr);
			state.executeUpdate();
			System.out.println("Vous avez postulez !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(state!=null){
				state.close();
			}
		}
	}
	@Override
	public void supprimer(Entreprise entreprise) throws DAOException, SQLException {
		// TODO Auto-generated method stub

	}
}
