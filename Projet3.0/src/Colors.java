import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Colors extends JPanel {
	creertableau coucou;
	int largeur;
	int hauteur;
	
	public void recupDimensions(dimension d){
		this.largeur = d.getLargeur();
		this.hauteur = d.getHauteur();
	}
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        this.setBackground(new Color(200,200,200));
        Graphics2D g2d = (Graphics2D) g;


        int y = 0;
        int x = 0;

        int test[][] = new int[100][100];
       
       
        for(int i=0; i < 100; i++)
        {
        	
        for(int j=0; j < 100; j++)
        {
        	
            g2d.setColor(new Color(217, 146, 54));
            g2d.fillRect(i*10, j*10, 9, 9);

        } 
        }
        int z;
        g2d.setColor(new Color(200, 100, 50));

    }

   
    public static void main(String[] args) {
    	
    	creertableau coucou = new creertableau("carte.csv");
        JFrame frame = new JFrame("Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100*10+98,10*101+99);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Colors color = new Colors();
        larg = color.recupDimensions(d.getLargeur);
        System.out.println(largeur);
    }
}
