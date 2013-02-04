import java.io.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class creertableau {

	   Colors color;
	   dimension dim;
	   JFrame fenetre;
	   JPanel p;
	   JPanel p3;
	   JTextField longueur;
	   JTextField largeur;
	   JButton enterbutton;
	   protected String destination;
  
  public creertableau(String destination) {
    this.destination = destination;
    traitement();
  }


  private void traitement() { 
	  fenetre = new JFrame();
      p = new JPanel(new BorderLayout());
      p3 = new JPanel(new GridLayout(1, 3));
      longueur = new JTextField();
      largeur = new JTextField();
      System.out.println(longueur.getText());
      System.out.println(largeur.getText());
      enterbutton = new JButton("Enter");
      enterbutton.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
        	 String coucou = longueur.getText();
        	 int longueur;
        	 longueur = Integer.parseInt(coucou); 
        	 
        	 String hehe = largeur.getText();
        	 int largeur;
        	 largeur = Integer.parseInt(hehe); 
        	 dimension dim = new dimension(largeur,longueur);

        	    try {
        	        BufferedWriter fichier = new BufferedWriter(new FileWriter(destination));
        	        
        	        int y = 0;
        	        int x = 0;

        	        int test[][] = new int[longueur][largeur];
        	       
        	        for(int i=0; i < longueur; i++)
        	        {
        	        if(i==0){
        	        
        	        }else{
        	        System.out.println();
        	        fichier.newLine();
        	        }
        	        //System.out.print(i);
        	        for(int j=0; j <= largeur; j++)
        	        {
        	        fichier.write(test[x][y]+ ";");
        	        System.out.print(test[x][y]+ ";");
        	        
        	        } 
        	        }

        	        fichier.close();
        	      } catch (Exception e1) {
        	        e1.printStackTrace();
        	      }     
        	      
         }
      });
      
      p3.add(longueur);
      p3.add(largeur);
      p3.add(enterbutton);
      
      
      
      fenetre.setContentPane(p3);
      fenetre.setTitle("Paramétrer la carte :");
      fenetre.setBounds(100, 100, 200, 75);
      fenetre.setSize(300, 150);
      fenetre.setVisible(true);
  }

}