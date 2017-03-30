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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import allConnexion.*;


public class SaisirOffre extends JFrame{

	private int qui;
	
	BorderLayout border = new BorderLayout();
	JButton envoyer = new JButton("Envoyer");
	JButton retour = new JButton("Retour");
	JLabel titre = new JLabel("SAISIE D'UNE OFFRE DE STAGE");
	JPanel center = new JPanel(new FlowLayout());
	JPanel center2 = new JPanel();
	JPanel center3 = new JPanel(new FlowLayout());
	//JPanel nameField = new JPanel(new GridLayout(7,2));
	JPanel nameField = new JPanel(new FlowLayout());
	JPanel bottomButton = new JPanel(new GridLayout(1,2, 50, 0));

	private JLabel lNomEnt = new JLabel("Nom de l'entreprise:");
	private JLabel lDomaine = new JLabel("Domaine de l'offre:");
	private JLabel lLibOffre = new JLabel("Libellé de l'offre:");
	private JLabel lDate = new JLabel("Date de début de stage:");
	private JLabel lDuree = new JLabel("Durée:");
	private JLabel lSaveOffre = new JLabel("Chemin de stockage de l'offre de stage:");
	private JLabel lDescription = new JLabel("Description de l'offre:");
	
	private JTextField tNomEnt = new JTextField();
	private JTextField tDomaine = new JTextField();
	private JTextField tLibOffre = new JTextField();
	private JTextField tDate = new JTextField();
	private JTextField tDuree = new JTextField();
	private JTextField tSaveOffre = new JTextField();
	private JTextArea tDescription = new JTextArea(4,10);
	private JScrollPane scroll = new JScrollPane(tDescription);
	
	private String nomEnt;
	private String domaine;
	private String libOffre;
	private Date date;
	private int duree;
	private String saveOffre;//chemin de stockage..
	private String description;
	
	public SaisirOffre(int a){
		super("Saisir Offre");
		this.qui = a;
		
		//Conf
		border.setVgap(25);
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
		nameField.add(lNomEnt);
		nameField.add(tNomEnt);
		nameField.add(lDomaine);
		nameField.add(tDomaine);
		nameField.add(lLibOffre);
		nameField.add(tLibOffre);
		nameField.add(lDate);
		nameField.add(tDate);
		nameField.add(lDuree);
		nameField.add(tDuree);
		nameField.add(lSaveOffre);
		nameField.add(tSaveOffre);
		nameField.add(lDescription);
		nameField.add(scroll);

		
		
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
