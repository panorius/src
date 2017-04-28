import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import allConnexion.DAOException;
import allConnexion.Entreprise;
import allConnexion.ListOffresDaoImpl;
import allConnexion.Offres;
import allConnexion.OffresDaoImpl;
import allConnexion.Utilisateur;
import allConnexion.UtilisateurDaolmpl;

public class Profil {
	JButton cv = new JButton(".."),
			good = new JButton(new ImageIcon("src/img/29380bis.png")),
			good2 = new JButton(new ImageIcon("src/img/29380bis.png")),
			mod = new JButton(new ImageIcon("src/img/6244.png")),
			mod2 = new JButton(new ImageIcon("src/img/6244.png")),
			visu = new JButton("Visualiser");
	JTextField fNom = new JTextField(),
			fMail = new JTextField(),
			chemin = new JTextField(13);
	JLabel lNom = new JLabel("Nom: "),
			lMail = new JLabel("Mail: "),
			vNom,
			vMail,
			cNom = new JLabel("Nom: "),
			cMail = new JLabel("Mail: ");
	JPanel p2 = new JPanel(new BorderLayout());
	JPanel panGridLog = new JPanel(new GridBagLayout());
	JPanel panGridLog2 = new JPanel(new GridBagLayout());
	GridBagConstraints gc = new GridBagConstraints();
	GridBagConstraints gc2 = new GridBagConstraints();
	TableModel modele;
	JTable table;
	Offres o, o2;
	Date date;
	DateFormat formatter;
	String date2;
	Utilisateur user;
	Entreprise entr;
	int duree, idO, idE;
	
	List<Offres> listOffres = new ArrayList<Offres>();
	List<Integer> listId = new ArrayList<Integer>();
	void createAndShowGUIEtu(Utilisateur user) {
		JXTabbedPane tabbedPane = new JXTabbedPane(JTabbedPane.LEFT);
		AbstractTabRenderer renderer = (AbstractTabRenderer)tabbedPane.getTabRenderer();
		renderer.setPrototypeText("This text is a prototype");
		renderer.setHorizontalTextAlignment(SwingConstants.LEADING);
		panGridLog.setPreferredSize(new Dimension(400, 300));
		p2.setPreferredSize(new Dimension(400, 300));
		panGridLog2.setPreferredSize(new Dimension(400, 300));
		vNom = new JLabel(user.getNom());
		vMail = new JLabel(user.getMail());
		mod.setBorderPainted(false);
		mod.setContentAreaFilled(false);
		mod.setFocusable(false);
		mod2.setBorderPainted(false);
		mod2.setContentAreaFilled(false);
		mod2.setFocusable(false);
		good.setFocusable(false);
		good.setBorderPainted(false);
		good.setContentAreaFilled(false);
		good2.setBorderPainted(false);
		good2.setContentAreaFilled(false);
		good2.setFocusable(false);
		fNom.setPreferredSize(new Dimension(147, 20));
		fMail.setPreferredSize(new Dimension(147, 20));
		cv.setPreferredSize(new Dimension(20, 20));
		gc.anchor = GridBagConstraints.LINE_START;
		gc2.anchor = GridBagConstraints.LINE_START;

		gc.gridx = 0;
		gc.gridy = 0;
		panGridLog.add(lNom,gc);
		gc.gridx = 1;
		gc.gridy = 0;
		panGridLog.add(vNom,gc);		
		gc.gridx = 0;
		gc.gridy = 1;
		panGridLog.add(lMail,gc);		
		gc.gridx = 1;
		gc.gridy = 1;
		panGridLog.add(vMail,gc);
		
		gc2.gridx = 0;
		gc2.gridy = 0;
		panGridLog2.add(cNom,gc2);
		gc2.gridx = 1;
		gc2.gridy = 0;
		panGridLog2.add(fNom,gc2);
		gc2.gridx = 2;
		gc2.gridy = 0;
		panGridLog2.add(mod, gc2);
		gc2.insets = new Insets(0,-20,0,-20);
		gc2.gridx = 3;
		gc2.gridy = 0;
		panGridLog2.add(good, gc2);
		gc2.insets = new Insets(0,0,0,0);
		gc2.gridx = 0;
		gc2.gridy = 1;
		panGridLog2.add(cMail,gc2);
		gc2.gridx = 1;
		gc2.gridy = 1;
		panGridLog2.add(fMail,gc2);
		gc2.gridx = 2;
		gc2.gridy = 1;
		panGridLog2.add(mod2, gc2);	
		gc2.insets = new Insets(0,-20,0,-20);
		gc2.gridx = 3;
		gc2.gridy = 1;
		panGridLog2.add(good2, gc2);
		gc2.insets = new Insets(0,0,0,0);
		gc2.gridx = 1;
		gc2.gridy = 2;
		panGridLog2.add(chemin,gc2);
		gc2.gridx = 2;
		gc2.gridy = 2;
		panGridLog2.add(cv,gc2);
		
		int i =0;
		UtilisateurDaolmpl udi = new UtilisateurDaolmpl();
		OffresDaoImpl odi = new OffresDaoImpl();
		ListOffresDaoImpl ldi = new ListOffresDaoImpl();
		try {
			i = udi.recupUtilisateurById(user);
			setListId(ldi.recupListOffresByID(i));
			System.out.println("maliste: "+getListId());
			for (Iterator<Integer> iter = getListId().iterator(); iter.hasNext();){
				int a = iter.next();
				getListOffres().add(odi.recupOffre(a));
			}
			//listOffres = odi.listOffreAllByIdOffre(getListId());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		modele = new TableModel(getListOffres());
		table = new JTable(modele);		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		p2.add(visu, BorderLayout.SOUTH);
		p2.add(new JScrollPane(table), BorderLayout.CENTER);
		
		visu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int selection = table.getSelectedRow();
				setDuree((int) table.getValueAt(selection, 4));
				formatter = new SimpleDateFormat("YYYY-MM-DD");
				date = new Date();
				setDate2(table.getValueAt(selection, 3).toString());
				try {
					setDate(getFormatter().parse(getDate2()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				o = new Offres((String) table.getValueAt(selection, 0),
						(String) table.getValueAt(selection, 1),
						(String) table.getValueAt(selection, 2),
						getDate(),
						getDuree(),
						(String) table.getValueAt(selection, 5));
				OffresDaoImpl odi = new OffresDaoImpl();
				UtilisateurDaolmpl udi = new UtilisateurDaolmpl();
				try {
					setUser(udi.recupUtilisateur(user));
					setIdO(odi.idOffres(o));
					setIdE(odi.recupOffreIdEntr(getIdO()));
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new ConsultFrame(getUser(), getIdO());
			}
		});

		tabbedPane.addTab("Informations", UIManager.getIcon("OptionPane.informationIcon"), panGridLog, "Information tool tip");
		tabbedPane.addTab("Demandes de Stage", UIManager.getIcon("OptionPane.warningIcon"), p2, "Warning tool tip");
		tabbedPane.addTab("Parametres", UIManager.getIcon("OptionPane.errorIcon"), panGridLog2, "Error tool tip");

		JFrame frame = new JFrame("Profil");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(tabbedPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		cv.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// On définit les extensions que l'on accepte
				FileFilter imagesFilter = new FileNameExtensionFilter("jpg", "jpeg", "png");

				// Ouverture du Gestionnaire de fichier
				JFileChooser choix = new JFileChooser();
				choix.setFileFilter(imagesFilter);
				choix.setDialogTitle("Choisir une image");
				choix.addChoosableFileFilter(imagesFilter);
				int retour = choix.showOpenDialog(null);

				if (retour == JFileChooser.APPROVE_OPTION) {
					String name = choix.getSelectedFile().getName();
					String path = choix.getSelectedFile().getAbsolutePath();              
					System.out.println("Fichier "+name+" choisis au chemin suivant: "+path);

					File f = choix.getSelectedFile();
					BufferedImage im = null;
					try {
						im = ImageIO.read(f);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JLabel monImage = new JLabel();
					monImage.setIcon(new ImageIcon(im));
					gc.gridx = 0;
					gc.gridy = 2;
					panGridLog.add(monImage, gc);
					/*
					 * Téléchargement du fichier image à l'endroit que l'on aura décidé
					 */
					//src = name; // À mettre à jour quand on aura décidé du chemin où placer les images//
					chemin.setText(path);
					// Fermeture de la fenêtre
					//dispose();
				}
			}
		});
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				good.setIcon(new ImageIcon("src/img/29380bis.png"));
			}
		});
		Timer timer2 = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				good2.setIcon(new ImageIcon("src/img/29380bis.png"));
			}
		});
		mod.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UtilisateurDaolmpl udi = new UtilisateurDaolmpl();
				good.setIcon(new ImageIcon("src/img/29380.png"));
				timer.start();
				try {
					udi.modifierNom(user, fNom.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Nom modifier");

			}
		});
		mod2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UtilisateurDaolmpl udi = new UtilisateurDaolmpl();
				good2.setIcon(new ImageIcon("src/img/29380.png"));
				timer2.start();
				try {
					udi.modifierMail(user, fMail.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Mail modifier");
			}
		});
	}

	void createAndShowGUIEnt(Utilisateur user, Entreprise ent) {

		JXTabbedPane tabbedPane = new JXTabbedPane(JTabbedPane.LEFT);
		AbstractTabRenderer renderer = (AbstractTabRenderer)tabbedPane.getTabRenderer();
		renderer.setPrototypeText("This text is a prototype");
		renderer.setHorizontalTextAlignment(SwingConstants.LEADING);
		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p2 = new JPanel(new FlowLayout());
		JPanel p3 = new JPanel(new FlowLayout());
		p1.setPreferredSize(new Dimension(400, 300));
		p2.setPreferredSize(new Dimension(400, 300));
		p3.setPreferredSize(new Dimension(400, 300));

		JLabel lNom = new JLabel("Nom: ");
		JLabel lMail = new JLabel("Mail: ");
		JLabel lEntCreer = new JLabel("Entreprise crée: ");
		JLabel lNomEnt = new JLabel("Nom: ");
		JLabel lAdr = new JLabel("Adresse: ");
		JLabel lVille = new JLabel("Ville: ");
		JLabel lCp = new JLabel("Code Postal: ");
		JLabel lTel = new JLabel("Telephone: ");
		JLabel lSect = new JLabel("Secteur: ");
		JLabel vNom = new JLabel(user.getNom());
		JLabel vMail = new JLabel(user.getMail());
		JLabel vNomEnt = new JLabel(ent.getNom());
		JLabel vAdr = new JLabel(ent.getNumRue());
		JLabel vVille = new JLabel(ent.getVille());
		JLabel vCp = new JLabel(String.valueOf(ent.getcPostal()));
		JLabel vTel = new JLabel(ent.getTel());
		JLabel vSect = new JLabel(ent.getSecteur());
		JLabel test = new JLabel("BONJOUR");
		JPanel panGridLog = new JPanel(new GridBagLayout());
		//JPanel panGridLog2 = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		//GridBagConstraints gc2 = new GridBagConstraints();

		/* weight# définit le nombre de cases en abscisse/ordonnée */

		/* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
		gc.insets = new Insets(2,4,2,4);
		//gc2.insets = new Insets(0, 10, 0, 10);
		gc.anchor = GridBagConstraints.LINE_END;
		panGridLog.add(lNom,gc);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		panGridLog.add(vNom,gc);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		panGridLog.add(lMail,gc);
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		panGridLog.add(vMail,gc);
		gc.gridx = 0;
		gc.gridy = 2;
		//gc.fill = GridBagConstraints.HORIZONTAL;
		panGridLog.add(lEntCreer,gc);
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		panGridLog.add(lNomEnt,gc);
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		panGridLog.add(vNomEnt,gc);
		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_END;
		panGridLog.add(lAdr,gc);
		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_START;
		panGridLog.add(vAdr,gc);
		gc.gridx = 0;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_END;
		panGridLog.add(lVille,gc);
		gc.gridx = 1;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_START;
		panGridLog.add(vVille,gc);
		gc.gridx = 0;
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.LINE_END;
		panGridLog.add(lCp,gc);
		gc.gridx = 1;
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.LINE_START;
		panGridLog.add(vCp,gc);
		gc.gridx = 0;
		gc.gridy = 7;
		gc.anchor = GridBagConstraints.LINE_END;
		panGridLog.add(lTel,gc);
		gc.gridx = 1;
		gc.gridy = 7;
		gc.anchor = GridBagConstraints.LINE_START;
		panGridLog.add(vTel,gc);
		gc.gridx = 0;
		gc.gridy = 8;
		gc.anchor = GridBagConstraints.LINE_END;
		panGridLog.add(lSect,gc);
		gc.gridx = 1;
		gc.gridy = 8;
		gc.anchor = GridBagConstraints.LINE_START;
		panGridLog.add(vSect,gc);

		//Parametres

		/*panGridLog2.add(lNom,gc2);
		gc2.gridx = 1;
		gc2.gridy = 0;
		panGridLog2.add(vNom,gc2);
		gc2.gridx = 0;
		gc2.gridy = 1;
		panGridLog2.add(lMail,gc2);
		gc2.gridx = 1;
		gc2.gridy = 1;
		panGridLog2.add(vMail,gc2);
		gc2.gridx = 0;
		gc2.gridy = 2;
		panGridLog2.add(lEntCreer,gc2);
		gc2.gridx = 0;
		gc2.gridy = 3;
		panGridLog2.add(lNomEnt,gc2);
		gc2.gridx = 1;
		gc2.gridy = 3;
		panGridLog2.add(vNomEnt,gc2);
		gc2.gridx = 0;
		gc2.gridy = 4;
		panGridLog2.add(lAdr,gc2);
		gc2.gridx = 1;
		gc2.gridy = 4;
		panGridLog2.add(vAdr,gc2);
		gc2.gridx = 0;
		gc2.gridy = 5;
		panGridLog2.add(lVille,gc2);
		gc2.gridx = 1;
		gc2.gridy = 5;
		panGridLog2.add(vVille,gc2);
		gc2.gridx = 0;
		gc2.gridy = 6;
		panGridLog2.add(lCp,gc2);
		gc2.gridx = 1;
		gc2.gridy = 6;
		panGridLog2.add(vCp,gc2);
		gc2.gridx = 0;
		gc2.gridy = 7;
		panGridLog2.add(lTel,gc2);
		gc2.gridx = 1;
		gc2.gridy = 7;
		panGridLog2.add(vTel,gc2);
		gc2.gridx = 0;
		gc2.gridy = 8;
		panGridLog2.add(lSect,gc2);
		gc2.gridx = 1;
		gc2.gridy = 8;
		panGridLog2.add(vSect,gc2);*/

		tabbedPane.addTab("Informations", UIManager.getIcon("OptionPane.informationIcon"), panGridLog, "Information tool tip");
		tabbedPane.addTab("Demandes de Stage", UIManager.getIcon("OptionPane.warningIcon"), p2, "Warning tool tip");
		tabbedPane.addTab("Parametres", UIManager.getIcon("OptionPane.errorIcon"), p3, "Error tool tip");

		JFrame frame = new JFrame("Profil");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(tabbedPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

	}
	void createAndShowGUIAdmin(Utilisateur user) {

		JXTabbedPane tabbedPane = new JXTabbedPane(JTabbedPane.LEFT);
		AbstractTabRenderer renderer = (AbstractTabRenderer)tabbedPane.getTabRenderer();
		renderer.setPrototypeText("This text is a prototype");
		renderer.setHorizontalTextAlignment(SwingConstants.LEADING);
		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p2 = new JPanel(new FlowLayout());
		JPanel p3 = new JPanel(new FlowLayout());

		JLabel lNom = new JLabel("Nom: ");
		JLabel lMail = new JLabel("Mail: ");
		JLabel lEntCreer = new JLabel("Entreprise crée: ");
		JLabel lNomEnt = new JLabel("Nom: ");
		JLabel lAdr = new JLabel("Adresse: ");
		JLabel lVille = new JLabel("Ville: ");
		JLabel lCp = new JLabel("Code Postal: ");
		JLabel lTel = new JLabel("Telephone: ");
		JLabel lSect = new JLabel("Secteur: ");
		JLabel vNom = new JLabel(user.getNom());
		JLabel vMail = new JLabel(user.getMail());
		/*JLabel vNomEnt = new JLabel(ent.getNom());
		JLabel vAdr = new JLabel(ent.getNumRue());
		JLabel vVille = new JLabel(ent.getVille());
		JLabel vCp = new JLabel(String.valueOf(ent.getcPostal()));
		JLabel vTel = new JLabel(ent.getTel());
		JLabel vSect = new JLabel(ent.getSecteur());*/

		p1.add(lNom);
		p1.add(vNom);
		p1.add(lMail);
		p1.add(vMail);
		p1.add(lEntCreer);
		p1.add(lNomEnt);
		/*p1.add(vNomEnt);
		p1.add(lAdr);
		p1.add(vAdr);
		p1.add(lVille);
		p1.add(vVille);
		p1.add(lCp);
		p1.add(vCp);
		p1.add(lTel);
		p1.add(vTel);
		p1.add(lSect);
		p1.add(vSect);*/

		tabbedPane.addTab("Informations", UIManager.getIcon("OptionPane.informationIcon"), p1, "Information tool tip");
		tabbedPane.addTab("Demandes de Stage", UIManager.getIcon("OptionPane.warningIcon"), p2, "Warning tool tip");
		tabbedPane.addTab("Parametres", UIManager.getIcon("OptionPane.errorIcon"), p3, "Error tool tip");

		JFrame frame = new JFrame("Profil");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(tabbedPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

	}

	private JPanel createEmptyPanel() {
		JPanel dummyPanel = new JPanel() {

			@Override
			public Dimension getPreferredSize() {
				return isPreferredSizeSet() ?
						super.getPreferredSize() : new Dimension(400, 300);
			}

		};
		return dummyPanel;
	}

	/*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().createAndShowGUI();
            }
        });
    }*/

	class JXTabbedPane extends JTabbedPane {

		private ITabRenderer tabRenderer = new DefaultTabRenderer();

		public JXTabbedPane() {
			super();
		}

		public JXTabbedPane(int tabPlacement) {
			super(tabPlacement);
		}

		public JXTabbedPane(int tabPlacement, int tabLayoutPolicy) {
			super(tabPlacement, tabLayoutPolicy);
		}

		public ITabRenderer getTabRenderer() {
			return tabRenderer;
		}

		public void setTabRenderer(ITabRenderer tabRenderer) {
			this.tabRenderer = tabRenderer;
		}

		@Override
		public void addTab(String title, Component component) {
			this.addTab(title, null, component, null);
		}

		@Override
		public void addTab(String title, Icon icon, Component component) {
			this.addTab(title, icon, component, null);
		}

		@Override
		public void addTab(String title, Icon icon, Component component, String tip) {
			super.addTab(title, icon, component, tip);
			int tabIndex = getTabCount() - 1;
			Component tab = tabRenderer.getTabRendererComponent(this, title, icon, tabIndex);
			super.setTabComponentAt(tabIndex, tab);
		}
	}

	interface ITabRenderer {

		public Component getTabRendererComponent(JTabbedPane tabbedPane, String text, Icon icon, int tabIndex);

	}

	abstract class AbstractTabRenderer implements ITabRenderer {

		private String prototypeText = "";
		private Icon prototypeIcon = UIManager.getIcon("OptionPane.informationIcon");
		private int horizontalTextAlignment = SwingConstants.CENTER;
		private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

		public AbstractTabRenderer() {
			super();
		}

		public void setPrototypeText(String text) {
			String oldText = this.prototypeText;
			this.prototypeText = text;
			firePropertyChange("prototypeText", oldText, text);
		}

		public String getPrototypeText() {
			return prototypeText;
		}

		public Icon getPrototypeIcon() {
			return prototypeIcon;
		}

		public void setPrototypeIcon(Icon icon) {
			Icon oldIcon = this.prototypeIcon;
			this.prototypeIcon = icon;
			firePropertyChange("prototypeIcon", oldIcon, icon);
		}

		public int getHorizontalTextAlignment() {
			return horizontalTextAlignment;
		}

		public void setHorizontalTextAlignment(int horizontalTextAlignment) {
			this.horizontalTextAlignment = horizontalTextAlignment;
		}

		public PropertyChangeListener[] getPropertyChangeListeners() {
			return propertyChangeSupport.getPropertyChangeListeners();
		}

		public PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
			return propertyChangeSupport.getPropertyChangeListeners(propertyName);
		}

		public void addPropertyChangeListener(PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(listener);
		}

		public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
		}

		protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
			PropertyChangeListener[] listeners = getPropertyChangeListeners();
			for (int i = listeners.length - 1; i >= 0; i--) {
				listeners[i].propertyChange(new PropertyChangeEvent(this, propertyName, oldValue, newValue));
			}
		}
	}

	public List<Offres> getListOffres() {
		return listOffres;
	}

	public void setListOffres(List<Offres> listOffres) {
		this.listOffres = listOffres;
	}

	public List<Integer> getListId() {
		return listId;
	}

	public void setListId(List<Integer> listId) {
		this.listId = listId;
	}

	public Offres getO() {
		return o;
	}

	public void setO(Offres o) {
		this.o = o;
	}

	public Offres getO2() {
		return o2;
	}

	public void setO2(Offres o2) {
		this.o2 = o2;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DateFormat getFormatter() {
		return formatter;
	}

	public void setFormatter(DateFormat formatter) {
		this.formatter = formatter;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
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

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getIdO() {
		return idO;
	}

	public void setIdO(int idO) {
		this.idO = idO;
	}

	public int getIdE() {
		return idE;
	}

	public void setIdE(int idE) {
		this.idE = idE;
	}

	class DefaultTabRenderer extends AbstractTabRenderer implements PropertyChangeListener {

		private Component prototypeComponent;

		public DefaultTabRenderer() {
			super();
			prototypeComponent = generateRendererComponent(getPrototypeText(), getPrototypeIcon(), getHorizontalTextAlignment());
			addPropertyChangeListener(this);
		}

		private Component generateRendererComponent(String text, Icon icon, int horizontalTabTextAlignmen) {
			JPanel rendererComponent = new JPanel(new GridBagLayout());
			rendererComponent.setOpaque(false);

			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(2, 4, 2, 4);
			c.fill = GridBagConstraints.HORIZONTAL;
			rendererComponent.add(new JLabel(icon), c);

			c.gridx = 1;
			c.weightx = 1;
			rendererComponent.add(new JLabel(text, horizontalTabTextAlignmen), c);

			return rendererComponent;
		}

		@Override
		public Component getTabRendererComponent(JTabbedPane tabbedPane, String text, Icon icon, int tabIndex) {
			Component rendererComponent = generateRendererComponent(text, icon, getHorizontalTextAlignment());
			int prototypeWidth = prototypeComponent.getPreferredSize().width;
			int prototypeHeight = prototypeComponent.getPreferredSize().height;
			rendererComponent.setPreferredSize(new Dimension(prototypeWidth, prototypeHeight));
			return rendererComponent;
		}

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			String propertyName = evt.getPropertyName();
			if ("prototypeText".equals(propertyName) || "prototypeIcon".equals(propertyName)) {
				this.prototypeComponent = generateRendererComponent(getPrototypeText(), getPrototypeIcon(), getHorizontalTextAlignment());
			}
		}
	}
}