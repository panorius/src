package allConnexion;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SingletonBDD {

	private static final String url = "jdbc:mysql://localhost:3306/projetoffresstage?autoReconnect=true&useSSL=false";
	private static final String utilisateur = "root";
	private static final String motDePasse = "";
	String filename = null;
	private static String path;
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
			//System.out.println("Connexion existante");
		}
		return connexion;
	}

	public Connection createConnection(){
		Connection connexion= null;
		return connexion;
	}
	public void deco() throws SQLException{
		connexion.close();
	}

	public void filen(){
		try{

			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File f = chooser.getSelectedFile();
			filename = f.getAbsolutePath();
			this.path = (filename);
		}catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Veuillez choisir votre CV");
		}
	}
	public String getPath(){
		return path;
	}
}
