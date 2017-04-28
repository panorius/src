import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import allConnexion.*;


public class CreerEntreprise extends Frame{

	Utilisateur user;
	
	private JPanel nameField = new JPanel(new GridLayout(10,2));
	
	private JLabel titre = new JLabel("CREATION D'UNE ENTREPRISE"),
			lNomEnt = new JLabel("Nom de l'entreprise:"),
			lAdresse = new JLabel("Adresse(Numero et rue):"),
			lCp = new JLabel("Code Postale:"),
			lVille = new JLabel("Ville:"),
			lMail = new JLabel("Mail du contact:"),
			lTel = new JLabel("Telephone du contact:"),
			lSecteurEnt = new JLabel("Secteur d'activité de l'entreprise:");
	
	private JTextField tNomEnt = new JTextField(),
			tAdresse = new JTextField(),
			tVille = new JTextField(),
			tMail = new JTextField(),
			tSecteurEnt = new JTextField();
	
	private MaskFormatter m = new MaskFormatter(),
			m2 = new MaskFormatter();
	
	private JFormattedTextField tCp,
			tTel;
	
/*	
	private String nomEnt;//nom de l'entreprise
	private String Adresse;//adresse(numero et rue)
	private String cp;//code postale
	private String ville;//nom de la ville
	private String mail;//mail du contact
	private String tel;//telephone du contact
	private String secteurEnt;//secteur d'activitÃ© de l'entreprise
*/

	public CreerEntreprise(Utilisateur user){
		super();
		setUser(user);
		
		System.out.println(getUser().getMail());
		tMail.setText(getUser().getMail());
		
		//Conf Item
		titre.setFont(new Font("Tahoma", 1, 35));
		try {
			m.setMask("#####");
			m2.setMask("##########");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tCp = new JFormattedTextField(m);
		tTel = new JFormattedTextField(m2);
		
		//Add Item
		super.add(center, BorderLayout.NORTH);
		super.add(center2, BorderLayout.CENTER);
		super.add(center3, BorderLayout.SOUTH); 
		super.center.add(titre);
		super.center2.add(nameField);
		super.center3.add(bottomButton);
		super.bottomButton.add(envoyer);
		super.bottomButton.add(deconnexion);
		nameField.add(lNomEnt);
		nameField.add(tNomEnt);
		nameField.add(lAdresse);
		nameField.add(tAdresse);
		nameField.add(lCp);
		nameField.add(tCp);
		nameField.add(lVille);
		nameField.add(tVille);
		nameField.add(lMail);
		nameField.add(tMail);
		nameField.add(lTel);
		nameField.add(tTel);
		nameField.add(lSecteurEnt);
		nameField.add(tSecteurEnt);

		//Actions
		super.deconnexion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Accueil();
				setVisible(false);
			}
		});
		
		super.envoyer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UtilisateurDaolmpl User = new UtilisateurDaolmpl();
				EntrepriseDaoImpl business = new EntrepriseDaoImpl();
				int i = Integer.parseInt(gettCp().getText());
				Entreprise e = new Entreprise(gettNomEnt().getText(), gettAdresse().getText(), i, gettVille().getText(), gettMail().getText(), gettTel().getText(), gettSecteurEnt().getText());
				try {
					business.creer(e, getUser());
					try {
						User.uptdateEntCreer(getUser());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new ChoixFrame(user);
				setVisible(false);
			}
		});
		
	}
	public JTextField gettNomEnt() {
		return tNomEnt;
	}


	public void settNomEnt(JTextField tNomEnt) {
		this.tNomEnt = tNomEnt;
	}


	public JTextField gettAdresse() {
		return tAdresse;
	}


	public void settAdresse(JTextField tAdresse) {
		this.tAdresse = tAdresse;
	}


	public JFormattedTextField gettCp() {
		return tCp;
	}


	public void settCp(JFormattedTextField tCp) {
		this.tCp = tCp;
	}


	public JTextField gettVille() {
		return tVille;
	}


	public void settVille(JTextField tVille) {
		this.tVille = tVille;
	}


	public JTextField gettMail() {
		return tMail;
	}


	public void settMail(JTextField tMail) {
		this.tMail = tMail;
	}


	public JFormattedTextField gettTel() {
		return tTel;
	}


	public void settTel(JFormattedTextField tTel) {
		this.tTel = tTel;
	}


	public JTextField gettSecteurEnt() {
		return tSecteurEnt;
	}


	public void settSecteurEnt(JTextField tSecteurEnt) {
		this.tSecteurEnt = tSecteurEnt;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
}
