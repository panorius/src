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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import allConnexion.*;

public class Accueil extends JFrame {

	private int qui;

	public Accueil(){
		this.setSize(1000, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		this.setVisible(true);

		JPanel panBord = new JPanel(new BorderLayout());

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

		JLabel l = new JLabel("Utilisateur:");
		JTextField tNom = new JTextField();
		JLabel l2 = new JLabel("Mot de passe:");
		JPasswordField tMdp = new JPasswordField();
		JLabel l3 = new JLabel("Vous êtes:");
		JComboBox c = new JComboBox();

		admin.setIcon(new ImageIcon("C:\\Users\\Lyric\\Desktop\\img\\admin.png"));
		entreprise.setIcon(new ImageIcon("C:\\Users\\Lyric\\Desktop\\img\\pro.png"));
		etudiant.setIcon(new ImageIcon("C:\\Users\\Lyric\\Desktop\\img\\student.png"));
		newUser.setIcon(new ImageIcon("C:\\Users\\Lyric\\Desktop\\img\\new.png"));

		panBox.setLayout(new BoxLayout(panBox, BoxLayout.PAGE_AXIS));
		GridBagConstraints gc = new GridBagConstraints();
		GridBagConstraints gc2 = new GridBagConstraints();
		admin.setFocusPainted(false);
		entreprise.setFocusPainted(false);
		etudiant.setFocusPainted(false);
		newUser.setFocusPainted(false);

		/* pour dire qu'on ajoute un composant en position (i, j), on définit gridx=i et gridy=j */
		gc.gridx = 0;
		gc.gridy = 0;
		/* weight# définit le nombre de cases en abscisse/ordonnée */
		gc.weightx = 0;
		gc.weighty = 0;
		/* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
		gc.insets = new Insets(0, 10, 0, 10);
		gc2.insets = new Insets(5, 5, 5, 5);
		tNom.setPreferredSize(new Dimension(150,20));
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
		panGridLog.add(l,gc2);
		gc.gridx = 0;
		gc.gridy = 1;
		panGridLog.add(l2,gc);
		gc.gridx = 1;
		gc.gridy = 0;
		panGridLog.add(tNom,gc);
		gc.gridx = 1;
		gc.gridy = 1;
		panGridLog.add(tMdp,gc);
		gc.gridx = 0;
		gc.gridy = 2;
		panGridLog.add(l3,gc);
		gc.gridx = 1;
		gc.gridy = 2;
		panGridLog.add(c,gc);
		panFlow2.add(titre);

		panBord.add(panFlow2, BorderLayout.NORTH);
		panBord.add(panBox, BorderLayout.CENTER);
		panBord.add(quitter, BorderLayout.SOUTH);
		add(panBord);

		l.setVisible(false);
		l2.setVisible(false);
		tNom.setVisible(false);
		tMdp.setVisible(false);
		l3.setVisible(false);
		c.setVisible(false);
		envoyer.setVisible(false);
		connexion.setVisible(false);

		validate();

		admin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				l.setText("Administrateur:");
				l.setVisible(true);
				l2.setVisible(true);
				tNom.setVisible(true);
				tMdp.setVisible(true);
				l3.setVisible(false);
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
				l.setText("Entrepreneur:");
				l.setVisible(true);
				l2.setVisible(true);
				tNom.setVisible(true);
				tMdp.setVisible(true);
				l3.setVisible(false);
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
				l.setText("Etudiant:");
				l.setVisible(true);
				l2.setVisible(true);
				tNom.setVisible(true);
				tMdp.setVisible(true);
				l3.setVisible(false);
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
				l.setText("Nouvel utilisateur:");
				l.setVisible(true);
				l2.setVisible(true);
				tNom.setVisible(true);
				tMdp.setVisible(true);
				l3.setVisible(true);
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
				Utilisateur user = new Utilisateur(tNom.getText(),tMdp.getText(), getQui());
				UtilisateurDaolmpl User = new UtilisateurDaolmpl();		
				if(User.trouver(user)){
					System.out.println("Bienvenue "+user.getNom());
					new ChoixFrame(getQui());
					setVisible(false);
				}else
					System.out.println("Utilisateur ou mot de passe incorrecte");
			}
		});

		envoyer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UtilisateurDaolmpl n = new UtilisateurDaolmpl();
				Utilisateur e = new Utilisateur(tNom.getText(), tMdp.getText(), c.getSelectedIndex()+1);
				n.creer(e);
				setVisible(false);
				new ChoixFrame(getQui());
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
