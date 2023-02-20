import javax.swing.*;
import java.util.HashMap;
/**
 * Classe Frame
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 */
public class Frame extends JFrame{

    private static final Panel panel = new Panel();

    /**
     * Cosntructeur de la classe Frame
     * @param title String le titre
     */
    public Frame(String title){
        //Titre de la fenêtre
        setTitle(title);


        //Ajout du panel sur l'écran
        add(panel);

        //Paramètres de l'écran
        setSize(1200,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    /**
     * accesseur indiquant la fin du Panel
     * @return boolean retourne Panel.getIsFinish()
     */
    public static boolean isFinish(){
        return Panel.getIsFinish();
    }

    /**
     * accessseur de la liste des noms des joueurs
     * @return HashMap<Integer,String> retourne la liste des noms des joueurs
     */
    public static HashMap<Integer,String> getPlayerList(){
        return Panel.getPlayerList();
    }

    /**
     * accesseur de la couleur des joueurs
     * @return String[] retourne la liste des couleurs
     */
    public static String[] getColorList(){
        return Panel.getColorList();
    }

    /**
     * retourne l'index du joueur
     * @return int retourne l'index du joueur
     */
    public static int getIndex(){
        return Panel.getIndexPlayer();
    }
}