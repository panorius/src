import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import allConnexion.*;


public class CreerEntreprise extends JFrame{

	private int qui;
	
	BorderLayout border = new BorderLayout();
	JButton envoyer = new JButton("Envoyer");
	JButton retour = new JButton("Retour");
	JLabel titre = new JLabel("CREATION D'UNE ENTREPRISE");
	JPanel center = new JPanel(new FlowLayout());
	JPanel center2 = new JPanel(new FlowLayout());
	JPanel center3 = new JPanel(new FlowLayout());
	JPanel nameField = new JPanel(new GridLayout(8,2));
	JPanel bottomButton = new JPanel(new GridLayout(1,2, 50, 0));
	
	private JLabel lNomEnt = new JLabel("Nom de l'entreprise:");
	private JLabel lAdresse = new JLabel("Adresse(Numero et rue):");
	private JLabel lCp = new JLabel("Code Postale:");
	private JLabel lVille = new JLabel("Ville:");
	private JLabel lMail = new JLabel("Mail du contact:");
	private JLabel lTel = new JLabel("Telephone du contact:");
	private JLabel lSecteurEnt = new JLabel("Secteur d'activité de l'entreprise:");
	
	private JTextField tNomEnt = new JTextField();
	private JTextField tAdresse = new JTextField();
	private MaskFormatter m = new MaskFormatter();
	private MaskFormatter m2 = new MaskFormatter();
	private JFormattedTextField tCp;
	private JTextField tVille = new JTextField();
	private JTextField tMail = new JTextField();
	private JFormattedTextField tTel;
	private JTextField tSecteurEnt = new JTextField();
/*	
	private String nomEnt;//nom de l'entreprise
	private String Adresse;//adresse(numero et rue)
	private String cp;//code postale
	private String ville;//nom de la ville
	private String mail;//mail du contact
	private String tel;//telephone du contact
	private String secteurEnt;//secteur d'activitÃ© de l'entreprise
*/

	public CreerEntreprise(int a){
		super("Creation Entreprise");
		this.qui = a;
		
		//Conf
		//border.setHgap(100);
		border.setVgap(50);		
		this.setLayout(border);
		this.setSize(1000, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		this.setVisible(true);
		
		//ConfObject
		titre.setFont(new Font("Tahoma", 1, 35));
		try {
			m.setMask("#####");
			m2.setMask("##.##.##.##.##");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		tCp = new JFormattedTextField(m);
		tTel = new JFormattedTextField(m2);
		
		//Add
		this.add(center, BorderLayout.NORTH);
		this.add(center2, BorderLayout.CENTER);
		this.add(center3, BorderLayout.SOUTH); 
		//this.add(retour, BorderLayout.SOUTH);
		center.add(titre);
		center2.add(nameField);
		center3.add(bottomButton);
		bottomButton.add(envoyer);
		bottomButton.add(retour);
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
		retour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ChoixFrame(getQui());
				setVisible(false);
			}
		});
		
		envoyer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EntrepriseDaoImpl business = new EntrepriseDaoImpl();
				int i = Integer.parseInt(gettCp().getText());
				Entreprise e = new Entreprise(gettNomEnt().getText(), gettAdresse().getText(), i, gettVille().getText(), gettMail().getText(), gettTel().getText(), gettSecteurEnt().getText());
				try {
					business.creer(e);
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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

	public int getQui() {
		return qui;
	}

	public void setQui(int qui) {
		this.qui = qui;
	}
}
