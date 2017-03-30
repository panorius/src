import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import allConnexion.*;

public class ConsultOffre extends JFrame{

	private int qui;
	
	BorderLayout border = new BorderLayout();
	JButton retour = new JButton("Retour");
	JButton envoyer = new JButton("Envoyer");
	JLabel titre = new JLabel("CONSULTATION DES OFFRES DE STAGE");
	JPanel center = new JPanel(new FlowLayout());
	JPanel center2 = new JPanel();
	JPanel center3 = new JPanel(new FlowLayout());
	JPanel nameField = new JPanel(new FlowLayout());
	JPanel bottomButton = new JPanel(new GridLayout(1,2, 50, 0));

	private JLabel lNom = new JLabel("Nom de l'entreprise:"),
			lVille = new JLabel("Ville du stage:"),
			lMail = new JLabel("Mail du contact:"),
			lDomaine = new JLabel("Domaine:"),
			lLibOffice = new JLabel("Libellé de l'offre:"),
			lDate = new JLabel("Date de début du stage:"),
			lDuree = new JLabel("Durée du stage:"),
			lDescription = new JLabel("Description de l'offre:");
	
	private JTextField tNom = new JTextField(),
			tVille = new JTextField(),
			tMail = new JTextField(),
			tDomaine = new JTextField(),
			tLibOffice = new JTextField(),
			tDate = new JTextField(),
			tDuree = new JTextField(),
			tDescription = new JTextField();
	private JScrollPane scroll = new JScrollPane(tDescription);
	
	private String nom;//nom de l'entreprise
	private String ville;//ville du stage
	private String mail;//mail du contact
	private String domaine;//ENUMERATION ?
	private String libOffre;//libellÃ© de l'offre
	private Date date;//date de dÃ©but du stage
	private int duree; //durÃ©e du stage
	private String description; //description de l'offre
	

	public ConsultOffre(int a){
		super("Consulter Offre");
		this.qui = a;
		
		//Conf
		this.setLayout(border);
		this.setSize(1000, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		this.setVisible(true);
		
		//ConfObject
		titre.setFont(new Font("Tahoma", 1, 35));
		tDescription.setBounds(4, 100, 300, 50);
		center2.setLayout(new BoxLayout(center2, BoxLayout.PAGE_AXIS));

		//Add
		this.add(center, BorderLayout.NORTH);
		this.add(center2, BorderLayout.WEST);
		this.add(center3, BorderLayout.SOUTH); 
		//this.add(retour, BorderLayout.SOUTH);
		center.add(titre);
		center2.add(nameField);
		center3.add(bottomButton);
		bottomButton.add(envoyer);
		bottomButton.add(retour);
		nameField.add(lVille);
		nameField.add(tVille);
		nameField.add(lNom);
		nameField.add(tNom);
		/*nameField.add(lMail);
		nameField.add(tMail);
		nameField.add(lDomaine);
		nameField.add(tDomaine);
		nameField.add(lLibOffice);
		nameField.add(tLibOffice);
		nameField.add(lDate);
		nameField.add(tDate);
		nameField.add(lDuree);
		nameField.add(tDuree);
		nameField.add(lDescription);
		nameField.add(scroll);*/

		//Actions
		retour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ChoixFrame(getQui());
				setVisible(false);
			}
		});
	}


	public int getQui() {
		return qui;
	}


	public void setQui(int qui) {
		this.qui = qui;
	}
}
