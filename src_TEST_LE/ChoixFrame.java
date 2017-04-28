import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import allConnexion.*;

public class ChoixFrame extends JFrame {

	private Utilisateur user;
	private Entreprise entr;

	//JTabbedPane tp = new JTabbedPane(JTabbedPane.LEFT);
	JButton bCreer = new JButton("Creer une entreprise");
	JButton bSaisir = new JButton("Saisir Offre");
	JButton bConsult = new JButton("Consulter Offres");
	JButton quitter = new JButton("Deconnexion");
	JLabel titre = new JLabel();
	JButton profil = new JButton();
	JPanel bPan = new JPanel(new GridLayout(0,3));
	JPanel center = new JPanel(new FlowLayout());
	JPanel b1 = new JPanel(new FlowLayout());
	BorderLayout border = new BorderLayout();
	//JTable pour lister des objet d'une base de donnée IMPORTANT

	public ChoixFrame(Utilisateur user){
		super("Accueil");
		setUser(user);

		if(getUser().getRole() == 2){
			EntrepriseDaoImpl Buisness = new EntrepriseDaoImpl();
			try {
				setEntr(Buisness.userEntreprise(user));
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//Conf
		border.setVgap(100);
		this.setLayout(border);
		this.setSize(1000, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		this.setVisible(true);
		System.out.println("User: "+getUser().toString());

		//ConfObject
		bCreer.setSize(300, 50);
		titre.setFont(new Font("Tahoma", 1, 35));
		titre.setText("Bienvenue "+user.getNom());
		//tp.addTab(null, new JPanel());
		//tp.setTabComponentAt(0, profil);
		profil.setIcon(new ImageIcon("C:\\Users\\PanoPort\\Desktop\\img\\icon-paper.png"));

		//ADD
		//this.add(titre, BorderLayout.NORTH);
		super.add(center, BorderLayout.NORTH);
		super.add(b1, BorderLayout.CENTER);
		super.add(quitter, BorderLayout.SOUTH);
		super.add(profil, BorderLayout.WEST);
		center.add(titre);

		System.out.println(user.getRole());

		if(user.getRole() == 1){
			b1.add(bConsult);
		}
		if(user.getRole() == 2){
			//b1.add(bCreer);
			b1.add(bSaisir);
			b1.add(bConsult);
		}
		if(user.getRole() == 3){
			b1.add(bCreer);
			b1.add(bSaisir);
			b1.add(bConsult);
		}

		//Actions

		bCreer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new CreerEntreprise(getUser());
				//new Frame("SAISIE D'UNE OFFRE DE STAGE", 7, 2);
				setVisible(false);
			}
		});
		bSaisir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SaisirOffre(getUser(), getEntr());
				setVisible(false);
			}
		});
		bConsult.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("id de l'user: "+getUser().getId());
				new ConsultOffre(getUser());
				setVisible(false);
			}
		});
		profil.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(getUser().getRole()==1){
					new Profil().createAndShowGUIEtu(getUser());
				}else{
					if(getUser().getRole()==2){
						new Profil().createAndShowGUIEnt(getUser(), getEntr());
					}else{
						new Profil().createAndShowGUIAdmin(getUser());
					}
					//setVisible(false);
				}}
		});		
		quitter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Accueil();
				setVisible(false);
			}
		});
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
}
