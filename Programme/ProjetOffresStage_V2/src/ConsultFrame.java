import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ViewportLayout;
import javax.swing.border.Border;

import allConnexion.DAOException;
import allConnexion.Entreprise;
import allConnexion.EntrepriseDaoImpl;
import allConnexion.ListOffresDaoImpl;
import allConnexion.Offres;
import allConnexion.OffresDaoImpl;
import allConnexion.Utilisateur;
import allConnexion.UtilisateurDaolmpl;

public class ConsultFrame extends Frame{
	private Utilisateur utilisateur;
	private Entreprise entr;
	private Offres offre;
	private JPanel p;
	private int idof, iduser, idEntr;
	private JTextArea ta = new JTextArea(10,30);
	private JLabel libelle, duree, nomEnt;
	
	public ConsultFrame(Utilisateur user, int idOffre, int idEntr){
		super();
		setIdEntr(idEntr);
		OffresDaoImpl odi = new OffresDaoImpl();
		try {
			//setEntr(edi.userEntreprise(getUtilisateur()));
			setOffre(odi.recupOffre(idOffre));
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
;		setUtilisateur(user);
		setIduser(user.getId());
		setIdof(idOffre);
		SimpleDateFormat sdf = new SimpleDateFormat("EEEEEE d MMM yyyy");
		String s = sdf.format(getOffre().getDate());
		this.ta.setText(getOffre().getDescriptif());
		Border brd = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.CYAN);
		JScrollPane scroll = new JScrollPane(this.ta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBorder(brd);
		this.p = new JPanel(new GridBagLayout());
		this.ta.setEditable(false);
		this.ta.setWrapStyleWord(true);
		this.ta.setLineWrap(true);
		this.libelle = new JLabel(getOffre().getLibelle());
		this.libelle.setFont(new Font("Tahoma", 1, 35));
		this.nomEnt = new JLabel("L'entreprise "+getOffre().getNomEnt()+"\n"
				+" dans le domaine: "+ getOffre().getDomaine());
		this.nomEnt.setFont(new Font("Tahoma", 1, 20));
		this.duree = new JLabel("durée: "+getOffre().getDuree()+" mois à partir du: "+s);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.p.add(this.nomEnt, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.p.add(this.duree, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.p.add(scroll, gbc);
		
		super.envoyer.setText("Postuler");
		super.retour.setText("Fermer");
		super.add(center, BorderLayout.NORTH);
		super.add(this.p, BorderLayout.CENTER);
		super.add(center3, BorderLayout.SOUTH); 
		super.center.add(this.libelle);
		super.center3.add(bottomButton);
		if(getUtilisateur().getRole()==1){
			super.bottomButton.add(envoyer);
		}
		super.bottomButton.add(retour);
		//System.out.println("User ConsultFrame: "+getUtilisateur().toString());
		
		super.envoyer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				ListOffresDaoImpl lod = new ListOffresDaoImpl();
				
				try {
					System.out.println(getUtilisateur()+" TRY "+getIdof());
					lod.creer(getIduser(), getIdof(), getIdEntr());
				} catch (SQLException | DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setVisible(false);
			}
		});
		super.retour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}
	
	public ConsultFrame(Utilisateur user, int idOffre){
		super();
		setIdEntr(idEntr);
		OffresDaoImpl odi = new OffresDaoImpl();
		try {
			//setEntr(edi.userEntreprise(getUtilisateur()));
			setOffre(odi.recupOffre(idOffre));
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
;		setUtilisateur(user);
		setIduser(user.getId());
		setIdof(idOffre);
		SimpleDateFormat sdf = new SimpleDateFormat("EEEEEE d MMM yyyy");
		String s = sdf.format(getOffre().getDate());
		this.ta.setText(getOffre().getDescriptif());
		Border brd = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.CYAN);
		JScrollPane scroll = new JScrollPane(this.ta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBorder(brd);
		this.p = new JPanel(new GridBagLayout());
		this.ta.setEditable(false);
		this.ta.setWrapStyleWord(true);
		this.ta.setLineWrap(true);
		this.libelle = new JLabel(getOffre().getLibelle());
		this.libelle.setFont(new Font("Tahoma", 1, 35));
		this.nomEnt = new JLabel("L'entreprise "+getOffre().getNomEnt()+"\n"
				+" dans le domaine: "+ getOffre().getDomaine());
		this.nomEnt.setFont(new Font("Tahoma", 1, 20));
		this.duree = new JLabel("durée: "+getOffre().getDuree()+" mois à partir du: "+s);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.p.add(this.nomEnt, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.p.add(this.duree, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.p.add(scroll, gbc);
		
		super.envoyer.setText("Postuler");
		super.retour.setText("Fermer");
		super.add(center, BorderLayout.NORTH);
		super.add(this.p, BorderLayout.CENTER);
		super.add(center3, BorderLayout.SOUTH); 
		super.center.add(this.libelle);
		super.center3.add(bottomButton);
		super.bottomButton.add(retour);
		//System.out.println("User ConsultFrame: "+getUtilisateur().toString());
		super.retour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public int getIdof() {
		return idof;
	}

	public void setIdof(int idof) {
		this.idof = idof;
	}

	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public Offres getOffre() {
		return offre;
	}
	public void setOffre(Offres offre) {
		this.offre = offre;
	}
	public Entreprise getEntr() {
		return entr;
	}

	public void setEntr(Entreprise entr) {
		this.entr = entr;
	}

	public int getIdEntr() {
		return idEntr;
	}

	public void setIdEntr(int idEntr) {
		this.idEntr = idEntr;
	}
}
