import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.SimpleFormatter;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import allConnexion.*;

public class ConsultOffre extends Frame{

	private Utilisateur user;
	private Entreprise entr;
	private DefaultTableModel dtm = null;
	private String tableTitle[] = {"Nom_Entreprise", "Domaine", "Libelle", "Date", "Duree", "Descriptif"};
	private List<Offres> listOffres = new ArrayList<Offres>();
	private int taille = 0, idO, idE, duree=0;
	private TableModel modele;
	private JTable table;
	private Offres o, o2;
	private Date date;
	private DateFormat formatter;
	private String date2;

	public ConsultOffre(Utilisateur user){
		super();
		setUser(user);
		OffresDaoImpl Offres = new OffresDaoImpl();
		try {
			setListOffres(Offres.listOffreAll());
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

		//Add Item
		super.envoyer.setText("Visualiser");
		super.add(center, BorderLayout.NORTH);
		super.add(new JScrollPane(table), BorderLayout.CENTER);
		super.add(center3, BorderLayout.SOUTH); 
		super.center3.add(bottomButton);
		super.bottomButton.add(envoyer);
		super.bottomButton.add(retour);
		//System.out.println("User ConsultOffre: "+getUser().toString());

		//Actions
		super.envoyer.addActionListener(new ActionListener(){
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
				new ConsultFrame(getUser(), getIdO(), getIdE());
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
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	public String[] getTableTitle() {
		return tableTitle;
	}

	public void setTableTitle(String[] tableTitle) {
		this.tableTitle = tableTitle;
	}

	public List<Offres> getListOffres() {
		return listOffres;
	}

	public void setListOffres(List<Offres> listOffres) {
		this.listOffres = listOffres;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public Offres getO() {
		return o;
	}

	public void setO(Offres o) {
		this.o = o;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int i) {
		this.duree = i;
	}
	public Offres getO2() {
		return o2;
	}

	public void setO2(Offres o2) {
		this.o2 = o2;
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
	public Entreprise getEntr() {
		return entr;
	}

	public void setEntr(Entreprise entr) {
		this.entr = entr;
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
}
