import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import allConnexion.*;
import img.*;

public class Accueil extends JFrame {

	private int qui;
	private String nom;
	private JTextField tMail;
	private JTextField tNom;

	private Utilisateur user;

	public Accueil(){
		this.setSize(1000, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		this.setVisible(true);

		JPanel panBord = new JPanel(new BorderLayout());

		JPanel panTest = new JPanel(new FlowLayout());
		JPanel panFlow = new JPanel(new FlowLayout());
		JPanel panFlow2 = new JPanel(new FlowLayout());
		JPanel panFlow3 = new JPanel(new FlowLayout());
		JPanel panBox = new JPanel();
		JPanel panGridLog = new JPanel(new GridBagLayout());
		JLabel titre = new JLabel("GESTION DES OFFRES DE STAGE");
		JButton admin = new JButton();
		JButton entreprise = new JButton();
		JButton etudiant = new JButton();
		JButton newUser = new JButton();
		JButton quitter = new JButton("Quitter");
		JButton connexion = new JButton("Connexion");
		JButton envoyer = new JButton("Envoyer");

		JLabel luser = new JLabel("Utilisateur:");
		tNom = new JTextField("m");
		JLabel lmail = new JLabel("Mail:");
		tMail = new JTextField("m@");
		JLabel lmdp = new JLabel("Mot de passe:");
		JPasswordField tMdp = new JPasswordField("123");
		JLabel lqui = new JLabel("Vous êtes:");
		JComboBox c = new JComboBox();

		admin.setIcon(new ImageIcon("src/img/admin.png"));
		entreprise.setIcon(new ImageIcon("src/img/pro.png"));
		etudiant.setIcon(new ImageIcon("src/img/student.png"));
		newUser.setIcon(new ImageIcon("src/img/new.png"));

		panBox.setLayout(new BoxLayout(panBox, BoxLayout.PAGE_AXIS));
		GridBagConstraints gc = new GridBagConstraints();
		GridBagConstraints gc2 = new GridBagConstraints();
		admin.setFocusPainted(false);
		entreprise.setFocusPainted(false);
		etudiant.setFocusPainted(false);
		newUser.setFocusPainted(false);

		/* pour dire qu'on ajoute un composant en position (i, j), on définit gridx=i et gridy=j */
		gc.gridx = 1;
		gc.gridy = 0;

		gc2.gridx = 0;
		gc2.gridy = 0;
		/* weight# définit le nombre de cases en abscisse/ordonnée */
		gc.weightx = 0;
		gc.weighty = 0;

		gc2.weightx = 0;
		gc2.weighty = 0;
		/* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
		gc.insets = new Insets(0, 10, 0, 10);
		gc2.insets = new Insets(5, 5, 5, 5);
		tNom.setPreferredSize(new Dimension(150,20));
		tMail.setPreferredSize(new Dimension(150,20));
		tMdp.setPreferredSize(new Dimension(150,20));
		titre.setFont(new Font("Tahoma", 1, 35));

		c.addItem("Etudiant");
		c.addItem("Entrepreneur");

		panFlow.add(admin);
		panFlow.add(entreprise);
		panFlow.add(etudiant);
		panFlow.add(newUser);
		panFlow3.add(connexion);
		panFlow3.add(envoyer);

		panBox.add(panFlow);
		panBox.add(panGridLog);
		panBox.add(panFlow3);

		panGridLog.add(luser,gc2);
		panGridLog.add(tNom,gc);
		gc.gridx = 0;//lmail
		gc.gridy = 1;
		panGridLog.add(lmail,gc);
		gc.gridx = 1;//tmail
		gc.gridy = 1;
		panGridLog.add(tMail,gc);
		gc.gridx = 0;//lmdp
		gc.gridy = 2;
		panGridLog.add(lmdp,gc);
		gc.gridx = 1;//tmdp
		gc.gridy = 2;
		panGridLog.add(tMdp,gc);
		gc.gridx = 2;//lqui
		gc.gridy = 0;
		panGridLog.add(lqui,gc);
		gc.gridx = 2;//c
		gc.gridy = 1;
		panGridLog.add(c,gc);
		panFlow2.add(titre);

		panBord.add(panFlow2, BorderLayout.NORTH);
		panBord.add(panBox, BorderLayout.CENTER);
		panBord.add(quitter, BorderLayout.SOUTH);
		add(panBord);

		luser.setVisible(false);
		tNom.setVisible(false);
		lmail.setVisible(false);
		tMail.setVisible(false);
		tMdp.setVisible(false);
		lmdp.setVisible(false);
		lqui.setVisible(false);
		c.setVisible(false);
		envoyer.setVisible(false);
		connexion.setVisible(false);

		validate();

		admin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				luser.setText("Administrateur:");
				luser.setVisible(true);
				tNom.setVisible(true);
				lmail.setVisible(true);
				tMail.setVisible(true);
				tMdp.setVisible(true);
				lmdp.setVisible(true);
				lqui.setVisible(false);
				c.setVisible(false);
				envoyer.setVisible(false);
				connexion.setVisible(true);
				setQui(3);
			}
		});

		entreprise.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				luser.setText("Entrepreneur:");
				luser.setVisible(true);
				tNom.setVisible(true);
				lmail.setVisible(true);
				tMail.setVisible(true);
				tMdp.setVisible(true);
				lmdp.setVisible(true);
				lqui.setVisible(false);
				c.setVisible(false);
				envoyer.setVisible(false);
				connexion.setVisible(true);
				setQui(2);
			}
		});

		etudiant.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				luser.setText("Etudiant:");
				luser.setVisible(true);
				tNom.setVisible(true);
				lmail.setVisible(true);
				tMail.setVisible(true);
				tMdp.setVisible(true);
				lmdp.setVisible(true);
				lqui.setVisible(false);
				c.setVisible(false);
				envoyer.setVisible(false);
				connexion.setVisible(true);
				setQui(1);
			}
		});

		newUser.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				luser.setText("Nouvel utilisateur:");
				luser.setVisible(true);
				tNom.setVisible(true);
				lmail.setVisible(true);
				tMail.setVisible(true);
				tMdp.setVisible(true);
				lmdp.setVisible(true);
				lqui.setVisible(true);
				c.setVisible(true);
				envoyer.setVisible(true);
				connexion.setVisible(false);
			}
		});

		quitter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		connexion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				user = new Utilisateur(tNom.getText(), tMdp.getText(), tMail.getText(), getQui(), true);
				UtilisateurDaolmpl User = new UtilisateurDaolmpl();
				try {
					if(User.trouver(getUser())){
						System.out.println("Bienvenue "+getUser().getNom());
						if(getUser().getRole()==2){
							if(User.isEntCreer(getUser())==false){
								new CreerEntreprise(getUser());
								setVisible(false);
							}else{
								new ChoixFrame(getUser());
								setVisible(false);
							}
						}else{
							new ChoixFrame(getUser());
							setVisible(false);
						}
					}else{
						System.out.println("Mail ou mot de passe incorrecte");
					}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		envoyer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UtilisateurDaolmpl n = new UtilisateurDaolmpl();
				Utilisateur e = new Utilisateur(tNom.getText(), tMdp.getText(), tMail.getText(), c.getSelectedIndex()+1, false);
				setUser(e);
				try {
					n.creer(e);
					if(getUser().getRole()==2){
						if(n.isEntCreer(getUser())==false){
							new CreerEntreprise(getUser());
							setVisible(false);
						}else{
							new ChoixFrame(getUser());
							setVisible(false);
						}
					}else{
						new ChoixFrame(getUser());
						setVisible(false);
					}
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public int getQui() {
		return qui;
	}

	public void setQui(int qui) {
		this.qui = qui;
	}
	/*
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public JTextField gettMail() {
		return tMail;
	}

	public void settMail(JTextField tMail) {
		this.tMail = tMail;
	}

	public JTextField gettNom() {
		return tNom;
	}

	public void settNom(JTextField tNom) {
		this.tNom = tNom;
	}*/
}
