import javax.swing.*;
import java.awt.*;
 //Cette classe a été implémenté juste pour le coté esthetique des profils mais n'a pas encore placé
public class Dessin extends JPanel {
     
    public Dessin() {
        setBackground(Color.RED);
    }
     
    public void paintcomponent(Graphics g) {
        super.paintComponent(g);
        int width = 5;
        int height = 1;
        Color color1 = getForeground();
        Color color2 = getBackground();
        Paint gp = new GradientPaint(0, 0, color1, width, 0, color2);
        Graphics2D g2 = (Graphics2D)g;
        g2.setPaint(gp);
        g2.fillRect(0, 0, width, height);
    }
 
}