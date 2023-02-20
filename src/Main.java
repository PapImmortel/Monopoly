import java.util.HashMap;


/**
 * Classe Main
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 */
public class Main {
    /**
     * Fonction main du programme
     * @param args les args :)
     */
    public static void main(String[] args)
    {
        Frame Menu = new Frame("Menu Javapoly");
        String[] ListCouleur;

        int Joueur;

        while(!Frame.isFinish()){
            System.out.print("");
        }

        HashMap<Integer, String> ListJoueur = Frame.getPlayerList();
        ListCouleur = Frame.getColorList();
        Joueur = Frame.getIndex();
        Menu.setVisible(false);
        new VideoGame(Joueur,ListJoueur, ListCouleur);//Constructeur paramétrique de VideoGame


    }//main(.)
}//Main
