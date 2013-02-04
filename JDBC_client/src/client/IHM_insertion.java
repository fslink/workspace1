package client;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import dataAccess.domain.Employee;
import dataAccess.EmployeeSimpleDAO;

class IHM_insertion extends JFrame{


	JLabel label_nom = new JLabel("Nom");
	JLabel label_prenom = new JLabel("Prenom");
	JTextField textf_nom = new JTextField(20);
	JTextField textf_prenom = new JTextField(20);
	JButton button_valider = new JButton("Valider");
	JButton button_annuler = new JButton("Annuler");
	String N;
	String F;
	Employee empl;
	EmployeeSimpleDAO dao;
	
	// Gestion de la répartition des composants
	
	GridBagLayout Grid = new GridBagLayout();
	GridBagConstraints c;
	Container pane = getContentPane();
	
	
	
	
	public IHM_insertion(){
		Initialiser();
	}
	
	public void Initialiser(){
		
		
		this.setResizable(false);
		this.setSize(350, 300);
		this.setBackground(Color.white);
		
		pane.setLayout(Grid);
		
		//positionnement
			c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.weighty = 1;
		Grid.setConstraints(label_nom, c);
		pane.add(label_nom);
		
			c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.weighty = 1;
		Grid.setConstraints(label_prenom, c);
		pane.add(label_prenom);
		
			c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.weighty = 1;
		Grid.setConstraints(textf_nom, c);
		
		pane.add(textf_nom);
		
			c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.weighty = 1;
		Grid.setConstraints(textf_prenom, c);
		
		pane.add(textf_prenom);
		
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		c.weightx = 1;
		c.weighty = 1;
		Grid.setConstraints(button_valider, c);
		
		button_valider.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				N = textf_nom.getText();
				F = textf_prenom.getText();
				Employee empl = new Employee(N, F);
				
				try{
					
					EmployeeSimpleDAO dao = new EmployeeSimpleDAO();
					dao.addEmployee(empl);
					
				}catch(Exception e){
					System.out.println("erreur es la suivante" +e);}
			}
		});
		
		//event insertion
		
		pane.add(button_valider);
		
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		c.weightx = 1;
		c.weighty = 1;
		Grid.setConstraints(button_annuler, c);
		//event quitter
		
		button_annuler.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
		
		pane.add(button_annuler);
		
		
		
	}
	
	
}
