package allConnexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonBDD {

	private static final String url = "jdbc:mysql://localhost:3306/projetoffresstage?autoReconnect=true&useSSL=false";
	private static final String utilisateur = "root";
	private static final String motDePasse = "";
	private static Connection connexion;
	
	// Création connexion BDD 
	private SingletonBDD(){
		try{
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
		}
		catch( SQLException e ){
			System.out.println(e);
		}
	}
	
	// Instancier la connexion
	public static Connection getInstance(){
		if(connexion==null){
			new SingletonBDD();
			System.out.println("Connexion avec bdd établie!");
		}
		else {
			System.out.println("Connexion existante");
		}
		return connexion;
	}
	
	public Connection createConnection(){
		Connection connexion= null;
		return connexion;
	}
}
