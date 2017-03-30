package allConnexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class EntrepriseDaoImpl implements EntrepriseDao{
	
	private static Statement state;
	@Override
	public void creer(Entreprise entreprise) throws DAOException {
		if(state==null){
			try {
				state = SingletonBDD.getInstance().createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}//endif
		try {
			String SQL_INSERT = "INSERT INTO Entreprise (nom, numRue, ville, cPostal, mail, tel, secteur)"
					+ " VALUES ('"+entreprise.getNom()+"', '"+entreprise.getNumRue()+"', '"+entreprise.getVille()+"'"
							+ ","+entreprise.getcPostal()+",'"+entreprise.getMail()+"','"+entreprise.getTel()+"'"
									+ ",'"+entreprise.getSecteur()+"')";
			/* String SQL_INSERT = "EEINSERT INTO Entreprise (nom, numRue, ville, cPostal, mail, tel, secteur)"
					+ " VALUES ('"+entreprise.getNom()+"', '26 residence isbc','Evry',91940,'test@evry.fr','019231239','Informatique')";
	        */
	        state.execute(SQL_INSERT); // execute la commmande SQL
	        state.clearBatch(); // Vide le state de ses commandes SQL
	        System.out.println("Infos entreprise ajouté!");
	        //state.close();
		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException){ //On récupére l'exception quand deux utilisateur utilise le même nom.
				System.out.println("Entreprise déjà crée");
			}
			else{
				e.printStackTrace();
			}
		}
		
	}
	
	public Entreprise trouver(String nom) throws DAOException{
		if(state==null){
			try {
				state = SingletonBDD.getInstance().createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}// endif
		try {
			final String SQL_SELECT = "SELECT idEntreprise, nom, numRue, ville, cPostal, mail, tel, secteur FROM Entreprise WHERE nom = '"+nom+"'";
			ResultSet result = state.executeQuery(SQL_SELECT);
			//ResultSetMetaData ResultMeta = result.getMetaData();
			result.beforeFirst();
			if(result.next()){
				int id = Integer.parseInt(result.getString(1));
				String nom1 = result.getObject(2).toString(); 
				String numRue = result.getObject(3).toString();
				String ville = result.getObject(4).toString();
				int cPostal = Integer.parseInt(result.getObject(5).toString());
				String mail = result.getObject(6).toString();
				String tel = result.getObject(7).toString();
				String secteur = result.getObject(8).toString();
				Entreprise entrepriseTrouver = new Entreprise(nom1,numRue,cPostal,ville,mail,tel,secteur);
				entrepriseTrouver.setId(id);
				return entrepriseTrouver;
			}
			
			 //On affiche le nom des colonnes
			/*
		      for(int i = 1; i <= ResultMeta.getColumnCount(); i++)
		        System.out.print("\t" + ResultMeta.getColumnName(i).toUpperCase() + "\t *");
		         
		      System.out.println("\n**********************************");
		         
		      while(result.next()){         
		        for(int i = 1; i <= ResultMeta.getColumnCount(); i++)
		          System.out.print("\t" + result.getObject(i).toString() + "\t |");
		            
		        System.out.println("\n---------------------------------");
		      }
		     */
			result.close();
			//state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void supprimer(Entreprise entreprise) throws DAOException {
		if(state==null){
			try {
				state = SingletonBDD.getInstance().createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			final String SQL_DELETE = "DELETE FROM Entreprise WHERE nom = '"+entreprise.getNom()+"' ";
			state.execute(SQL_DELETE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
