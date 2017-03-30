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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import allConnexion.*;

public class ChoixFrame extends JFrame {
	
	private int qui;

	JButton bCreer = new JButton("Creer une entreprise");
	JButton bSaisir = new JButton("Saisir Offres");
	JButton bConsult = new JButton("Consulter Offre");
	JButton quitter = new JButton("Deconnexion");
	JLabel titre = new JLabel("GESTION DES OFFRES DE STAGE");
	JPanel bPan = new JPanel(new GridLayout(0,3));
	JPanel center = new JPanel(new FlowLayout());
	JPanel b1 = new JPanel(new FlowLayout());
	BorderLayout border = new BorderLayout();
	JButton profil = new JButton();
	//JTable pour lister des objet d'une base de donnée IMPORTANT

	public ChoixFrame(int a){
		super("Accueil");
		this.qui = a;
		
		//Conf
		border.setVgap(100);
		this.setLayout(border);
		this.setSize(1000, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		this.setVisible(true);

		//ConfObject
		bCreer.setSize(300, 50);
		titre.setFont(new Font("Tahoma", 1, 35));
		profil.setIcon(new ImageIcon("C:\\Users\\Panorius\\Desktop\\img\\adminIcon.png"));

		//ADD
		this.add(profil, BorderLayout.NORTH);
		//this.add(center, BorderLayout.NORTH);
		this.add(b1, BorderLayout.CENTER);
		this.add(quitter, BorderLayout.SOUTH);
		center.add(titre);
		if(a == 1){
			b1.add(bConsult);
		}
		if(a == 2){
			b1.add(bCreer);
			b1.add(bSaisir);
			b1.add(bConsult);
		}
		if(a == 3){
			b1.add(bCreer);
			b1.add(bSaisir);
			b1.add(bConsult);
		}

		//Actions

		bCreer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new CreerEntreprise(getQui());
				setVisible(false);
			}
		});
		bSaisir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SaisirOffre(getQui());
				setVisible(false);
			}
		});
		bConsult.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ConsultOffre(getQui());
				setVisible(false);
			}
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

	public int getQui() {
		return qui;
	}

	public void setQui(int qui) {
		this.qui = qui;
	}
}
