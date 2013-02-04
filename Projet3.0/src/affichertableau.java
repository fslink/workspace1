

import java.awt.Graphics;
import java.awt.Image;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class affichertableau {

	 public affichertableau() {
		    traitement();
	 }


private void traitement() { 
	

FileReader monFichier = null;
BufferedReader tampon = null;

try {
monFichier = new FileReader("carte.csv");
tampon = new BufferedReader(monFichier);

while (true) {
// Lit une ligne de test.csv
String ligne = tampon.readLine();
// Vérifie la fin de fichier
if (ligne == null)
	
break;
System.out.println(ligne);

} // Fin du while
} catch (IOException exception) {
exception.printStackTrace();
} finally {
	
try {
tampon.close();
monFichier.close();
} catch(IOException exception1) {
exception1.printStackTrace();
}

}
} // Fin de main 
}