import javax.swing.table.AbstractTableModel;

import allConnexion.Offres;

import java.util.ArrayList;
import java.util.List;

public class TableModelPlus extends AbstractTableModel{

	protected List<Offres> data;            //données
	protected String statut;
	protected List<String> columnNames;    //noms de colonnes
	protected String[] nomCol= {"Nom_Entreprise", "Domaine", "Libelle", "Date", "Duree", "Description", "Statut"};
	protected String a="Nom_Entreprise", b="Domaine", c="Libelle", d="Date", e="Duree", f="Description", g="Statut";

	/** Creates a new instance of TableModelC */
	public TableModelPlus(List<Offres> data) {
		columnNames = new ArrayList<>();
		this.columnNames.add(this.a);
		this.columnNames.add(this.b);
		this.columnNames.add(this.c);
		this.columnNames.add(this.d);
		this.columnNames.add(this.e);
		this.columnNames.add(this.f);
		this.columnNames.add(this.g);
		this.data=data;
	}
	public int getRowCount() {
		return data.size();//data.size()/getColumnCount();
	}
	public int getColumnCount() {
		return columnNames.size();
	}
	/**
	 * noms des colonnes
	 */
	public String getColumnName(int columnIndex) {
		return this.nomCol[columnIndex];
	}
	/**
	 * type de contenu d'une colonne : ici il s'agit toujours de chaînes
	 * de caractères.
	 */
	public Class<? extends Object> getColumnClass(int c){
		return getValueAt(0,c).getClass();
	}
	/**
	 * possibilité d'édition des données
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	/**
	 * contenu d'une cellule
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			// NomEnt
			return data.get(rowIndex).getNomEnt();

		case 1:
			// Domaine
			return data.get(rowIndex).getDomaine();

		case 2:
			// Libelle
			return data.get(rowIndex).getLibelle();

		case 3:
			// Date
			return data.get(rowIndex).getDate();

		case 4:
			// Duree
			return data.get(rowIndex).getDuree();
			
		case 5:
			//Description
			return data.get(rowIndex).getDescriptif();
			
		case 6:
			//Statut
			return data.get(rowIndex).getStatut();

		default:
			throw new IllegalArgumentException();
		}
	}
	/**
	 * changement du contenu d'une cellule
	 */
	public void setValueAt(Offres aValue, int rowIndex, int columnIndex) {
		data.set((rowIndex*getColumnCount())+columnIndex, aValue); 
	}

	public void saveVectors() {

		saveAs();
	}

	public void saveAs()  {

	}
	public List<Offres> getData() {
		return data;
	}
	public void setData(List<Offres> data) {
		this.data = data;
	}

}