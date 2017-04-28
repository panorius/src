import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VisuProfilCandidat extends Frame{//Nous n'avons pas implémenter l'upload d'une image sur notre BDD 
	//donc voici un semblant de visualisation
	JPanel p = new JPanel(new BorderLayout());
	JPanel centrer = new JPanel(new FlowLayout());
	JButton b = new JButton();
	JButton acc = new JButton("Accepter");
	JButton refu = new JButton("Refuser");
	JButton att = new JButton("En_Attente");

	public VisuProfilCandidat(){
		b.setIcon(new ImageIcon("src/img/cv-a-telecharger.jpg"));
		p.add(new JScrollPane(b), BorderLayout.CENTER);
		centrer.add(acc);
		centrer.add(refu);
		centrer.add(att);
		p.add(centrer, BorderLayout.SOUTH);
		this.add(p);

		acc.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}
}
