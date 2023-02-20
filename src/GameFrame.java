import javax.swing.*;
import java.util.HashMap;

/**
 * Classe GameFrame
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 */
public class GameFrame extends JFrame {

    private static final GamePanel panel = new GamePanel();

    /**
     * constructeur de la classe GameFrame
     * @param title String le titre
     */
    public GameFrame(String title){
        setTitle(title);


        //composant


        setSize(1200,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        add(panel);


        setVisible(true);



    }

    /**
     * accesseur de la commande du joueur
     * @return String renvoie la commande du joueur
     */
    public static String getCommand(){

        return GamePanel.getCommand();
    }

    /**
     * affiche un message dans la boite de dialogue du jeu
     * @param text String le message que l'on souhaite afficher
     */
    public static void PrintMSG(String text){
        if(!text.equals("")){
            GamePanel.PrintMSG(text);
        }
    }

    /**
     * mutateur de la liste des joueurs
     * @param ListJoueurP HashMap<Integer, Player> la liste des joueurs
     */
    public static void setPlayerList(HashMap<Integer, Player> ListJoueurP){
        GamePanel.setPlayerList(ListJoueurP);
    }

    /**
     * Mise à jour de l'affichage du jeu
     */

    public static void UpdateMoneyGUI(){
        GamePanel.UpdateMoneyGUI();
    }

    /**
     * mutateur du nombre de joueurs
     * @param Nb int le nombre de joueurs
     */
    public static void setNPlayer(int Nb){
        GamePanel.setNPlayer(Nb);
    }
}