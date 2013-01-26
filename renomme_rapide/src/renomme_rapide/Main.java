package renomme_rapide;

import gnu.getopt.Getopt;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;


public class Main {
    /**
     * @param args arguments de la ligne de commande ; celle-ci devra être de la forme indiquée dans la méthode printHelp plus bas. :
     * @remarks
     * - pour les expressions r�guli�res en java : http://docs.oracle.com/javase/tutorial/essential/regex/
     */
    public static void main(String[] args) {
        boolean recursive = false;
        String toMatch     = "";
        String toSubstitute = "";
        String directory   = "";
        
        Getopt opt = new Getopt("renomme_rapide", args, "Rp:n:d:?");

        int c;
        while ((c = opt.getopt()) != -1) {
            switch (c) {
                case 'R':recursive = true;break;
                case 'p':toMatch      = opt.getOptarg();break;
                case 'n':toSubstitute = opt.getOptarg();break;
                case 'd':directory    = opt.getOptarg();break;
                case '?':
                default:
            }
        }
        if (toMatch.isEmpty() || toSubstitute.isEmpty() || directory.isEmpty()) {
            printHelp();
            System.exit(1);
        }
        Pattern pattern = Pattern.compile(toMatch);
        String newName;
        String oldName;
        Matcher matcher;
        File root = new File(directory);
        try {
            Collection<File> files = FileUtils.listFiles(root, null, recursive);
            for (Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
                File file = (File) iterator.next();
                oldName = file.getName();
                
                matcher = pattern.matcher(file.getName());
                newName = matcher.replaceAll(toSubstitute);
                if (! oldName.equals(newName)) {
                    file.renameTo(new File(file.getParent()+File.separator+newName));
                    System.out.println(file.getAbsolutePath()+" ===> "+file.getParent()+File.separator+newName);
                }
                
            }

        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private static void printHelp() {
        System.out.println("Renomme Rapide\n"
                          +"--------------\n"
                          +"Usage: renomme_rapide [-R] -p \"motif_capture\" -n \"regle_renommage\" -d dossier\n"
                          +"o�\n"
                          +"   -R active le parcours des sous r�pertoires\n"
                          +"   -p motif_capture d�signe soit une expression r�guli�re, soit une expression avec jocker\n"
                          +"   -n regle_renommage d�signe soit une expression avec capture soit\n"
                          +"   -d dossier dans lequel le renommage devra être fait\n"
                          +" Exemples :\n"
                          +"           renomme_rapide -p \"(.*)\\.txt\" -n \"$1.TITITOTO.txt\" -d c:\\\n"
                          +"           renomme_rapide -p \"(.*)\\.TITITOTO\\.txt\" -n \"$1.txt\" -d c:\\\n"
                          +" Remarques :\n"
                          +"           contrairement �l'usage on n'utilise pas \\1 pour r�f�rencer la premi�re capture mais $1"
                          );
    }
}
