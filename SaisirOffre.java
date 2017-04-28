import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import allConnexion.*;

public class SaisirOffre extends Frame{

	private Utilisateur user;
	private Entreprise entr;

	private JPanel nameField = new JPanel(new GridBagLayout());

	private JLabel	lDomaine = new JLabel("Domaine de l'offre:"),
			lLibOffre = new JLabel("Libellé de l'offre:"),
			lDate = new JLabel("Date de début de stage:"),
			lDuree = new JLabel("Durée (mois):"),
			lSaveOffre = new JLabel("Chemin de stockage de l'offre de stage:"),
			lDescription = new JLabel("Description de l'offre:"),
			titre = new JLabel("SAISIE D'UNE OFFRE DE STAGE");

	private JTextField tNomEnt = new JTextField(),
			tDomaine = new JTextField(),
			tLibOffre = new JTextField(),
			tSaveOffre = new JTextField();
	private JComboBox c = new JComboBox();
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private JFormattedTextField date = new JFormattedTextField(format);
	private Date date2;
	private JTextArea tDescription = new JTextArea(4,20);
	private JScrollPane scroll = new JScrollPane(tDescription,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private Border brd = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
	private GridBagConstraints gc = new GridBagConstraints();
	private JDateChooser calendar = new JDateChooser();
	private JFileChooser fc = new JFileChooser();
	JButton search = new JButton("...");
	
	public SaisirOffre(Utilisateur user, Entreprise ent){
		super();
		setUser(user);
		setEntr(ent);
		System.out.println(getUser().getRole());
		c.addItem("1");
		c.addItem("2");
		c.addItem("3");
		c.addItem("4");
		c.addItem("5");
		c.addItem("6");
		c.addItem("7");
		c.addItem("8");
		c.addItem("9");
		c.addItem("10");
		c.addItem("11");
		c.addItem("12");

		calendar.setLocale(Locale.US);
		calendar.setDateFormatString("dd/MM/yyyy");

		titre.setFont(new Font("Tahoma", 1, 35));
		scroll.setBorder(brd);
		tDescription.setWrapStyleWord(true);
		tDescription.setLineWrap(true);
		tNomEnt.setPreferredSize(new Dimension(195, 20));
		tDomaine.setPreferredSize(tNomEnt.getPreferredSize());
		tLibOffre.setPreferredSize(tNomEnt.getPreferredSize());
		tSaveOffre.setPreferredSize(tNomEnt.getPreferredSize());
		calendar.setPreferredSize(new Dimension(216, 20));

		//Add Item
		super.add(center, BorderLayout.NORTH);
		super.add(center3, BorderLayout.SOUTH); 
		super.center.add(titre);
		super.add(nameField, BorderLayout.CENTER);
		super.center3.add(bottomButton);
		super.bottomButton.add(envoyer);
		super.bottomButton.add(retour);

		gc.insets = new Insets(2, 4, 2, 4);
		gc.weightx = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridy = 0;
		nameField.add(lDomaine, gc);

		gc.gridy = 1;
		nameField.add(lLibOffre, gc);

		gc.gridy = 2;
		nameField.add(lDate, gc);

		gc.weightx = 0.25;
		gc.gridx = 2;
		gc.gridy = 0;
		nameField.add(lDuree, gc);

		gc.gridy = 1;
		nameField.add(lSaveOffre, gc);

		gc.gridy = 4;
		nameField.add(lDescription, gc);

		//ADD des champs
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;		
		gc.gridy = 0;
		nameField.add(tDomaine, gc);

		gc.gridy = 1;
		nameField.add(tLibOffre, gc);

		gc.gridy = 2;
		nameField.add(calendar, gc);

		gc.gridx = 3;
		gc.gridy = 0;
		nameField.add(c, gc);

		gc.gridy = 1;
		nameField.add(tSaveOffre, gc);
		gc.gridy = 1;
		nameField.add(search, gc);

		gc.gridx = 3;
		gc.gridy = 4;
		gc.weightx= 1;
		nameField.add(scroll, gc);

		//Actions
		search.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new EssaiChoixFichier();
			}
		});
		super.retour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ChoixFrame(getUser());
				setVisible(false);
			}
		});

		super.envoyer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				/*try {
					business.trouver();
				} catch (DAOException e1) {
					e1.printStackTrace();
				}*/
				OffresDaoImpl offre = new OffresDaoImpl();
				//int i = Integer.parseInt(c.getSelectedItem());
				Offres o = new Offres(gettDomaine().getText(), gettLibOffre().getText(), getCalendar().getDate(), c.getSelectedIndex()+1, gettDescription().getText());

				//Date date = new Date(o.getDate().getTime());
				/*Date thisDate = new Date();
				String c = new SimpleDateFormat("dd/MM/yyyy").format(getCalendar());
		        try {
		            thisDate = (new SimpleDateFormat("MM/dd/yyyy")).parse(c);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }*/
				System.out.println(getCalendar().getDate());
				try {
					try {

						offre.creer(getEntr(),o);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new ChoixFrame(getUser());
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

	public JTextField gettDomaine() {
		return tDomaine;
	}

	public void settDomaine(JTextField tDomaine) {
		this.tDomaine = tDomaine;
	}

	public JTextField gettLibOffre() {
		return tLibOffre;
	}

	public void settLibOffre(JTextField tLibOffre) {
		this.tLibOffre = tLibOffre;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public JTextField gettSaveOffre() {
		return tSaveOffre;
	}

	public void settSaveOffre(JTextField tSaveOffre) {
		this.tSaveOffre = tSaveOffre;
	}

	public JTextArea gettDescription() {
		return tDescription;
	}

	public void settDescription(JTextArea tDescription) {
		this.tDescription = tDescription;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Entreprise getEntr() {
		return entr;
	}

	public void setEntr(Entreprise entr) {
		this.entr = entr;
	}

	public JDateChooser getCalendar() {
		return calendar;
	}

	public void setCalendar(JDateChooser calendar) {
		this.calendar = calendar;
	}
}
