import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public abstract class Frame extends JFrame{

	BorderLayout border = new BorderLayout();
	JButton envoyer = new JButton("Envoyer");
	JButton retour = new JButton("Retour");
	JButton deconnexion = new JButton("Deconnexion");
	//JLabel titre2;
	JPanel center = new JPanel(new FlowLayout());
	JPanel center2 = new JPanel(new FlowLayout());
	JPanel center3 = new JPanel(new FlowLayout());
	//JPanel nameField;
	JPanel bottomButton = new JPanel(new GridLayout(1, 2, 50, 0));
	
	public Frame(){
		
		/*this.add(center, BorderLayout.NORTH);
		this.add(center2, BorderLayout.CENTER);
		this.add(center3, BorderLayout.SOUTH);
		//center.add(titre2);
		//center2.add(nameField);
		center3.add(bottomButton);
		bottomButton.add(envoyer);
		bottomButton.add(retour);*/
		
		//this.titre2.setFont(new Font("Tahoma", 1, 35));
		
		//border.setVgap(50);		
		this.setLayout(border);
		this.setSize(1000, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		this.setVisible(true);
	}
/*
	public BorderLayout getBorder() {
		return border;
	}

	public void setBorder(BorderLayout border) {
		this.border = border;
	}

	public JButton getEnvoyer() {
		return envoyer;
	}

	public void setEnvoyer(JButton envoyer) {
		this.envoyer = envoyer;
	}

	public JButton getRetour() {
		return retour;
	}

	public void setRetour(JButton retour) {
		this.retour = retour;
	}

	public JLabel getTitre2() {
		return titre2;
	}

	public void setTitre2(JLabel titre2) {
		this.titre2 = titre2;
	}

	public JPanel getCenter() {
		return center;
	}

	public void setCenter(JPanel center) {
		this.center = center;
	}

	public JPanel getCenter2() {
		return center2;
	}

	public void setCenter2(JPanel center2) {
		this.center2 = center2;
	}

	public JPanel getCenter3() {
		return center3;
	}

	public void setCenter3(JPanel center3) {
		this.center3 = center3;
	}

	public JPanel getNameField() {
		return nameField;
	}

	public void setNameField(JPanel nameField) {
		this.nameField = nameField;
	}

	public JPanel getBottomButton() {
		return bottomButton;
	}

	public void setBottomButton(JPanel bottomButton) {
		this.bottomButton = bottomButton;
	}
*/
}
