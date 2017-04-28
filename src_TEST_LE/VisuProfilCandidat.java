import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import allConnexion.ListOffresDaoImpl;

public class VisuProfilCandidat extends Frame{//Nous n'avons pas implémenter l'upload d'une image sur notre BDD 
	//donc voici un semblant de visualisation
	JPanel p = new JPanel(new BorderLayout());
	JPanel centrer = new JPanel(new FlowLayout());
	JButton b = new JButton();
	JButton acc = new JButton("Accepter");
	JButton refu = new JButton("Refuser");
	JButton att = new JButton("En_Attente");

	public VisuProfilCandidat(int idO, int idU){
		b.setIcon(new ImageIcon("src/img/cv-a-telecharger.jpg"));
		p.add(new JScrollPane(b), BorderLayout.CENTER);
		centrer.add(acc);
		centrer.add(refu);
		centrer.add(att);
		p.add(centrer, BorderLayout.SOUTH);
		this.add(p);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		System.out.println("idO: "+idO+" et idU: "+idU);
		acc.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListOffresDaoImpl lodi = new ListOffresDaoImpl();
				try {
					System.out.println(idO+" "+idU);
					lodi.changeStatut("Accepter", idO, idU);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		refu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListOffresDaoImpl lodi = new ListOffresDaoImpl();
				try {
					System.out.println(idO+" "+idU);
					lodi.changeStatut("Refuser", idO, idU);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		att.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListOffresDaoImpl lodi = new ListOffresDaoImpl();
				try {
					System.out.println(idO+" "+idU);
					lodi.changeStatut("En_Attente", idO, idU);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
}
