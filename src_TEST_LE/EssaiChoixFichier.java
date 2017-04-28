import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

class EssaiChoixFichier {
	public EssaiChoixFichier(String i) throws IOException{
		
		JFileChooser dialogue = new JFileChooser(new File("."));
		PrintWriter sortie;
		File fichier;

		if (dialogue.showOpenDialog(null)== 
				JFileChooser.APPROVE_OPTION) {
			fichier = dialogue.getSelectedFile();
			sortie = new PrintWriter
					(new FileWriter(fichier.getPath(), true));
			sortie.println(i);
			sortie.close();
		}
	}
}