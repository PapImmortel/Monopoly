import javax.swing.*;

public class GameFrame extends JFrame {
    /*
    Pour créer l'interface :
    initialiser,
    GameFrame Game = new GameFrame("Javapoly");

    2 fonctions importantes :
    PrintMSG(String T) :
    affiche dans la boite de dialogue un texte
    exemple :
    Game.PrintMSG("Bonjour, bienvenu dans JAVAPOLY");

    getCommand():
    Retourne la dernière commande entrée par l'utilisateur
    exemple :
    String temp = Game.getCommand(); //fonction bloquante
     */
    private static GamePanel panel = new GamePanel();

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

    public static String getCommand(){
        return panel.getCommand();
    }

    public static void PrintMSG(String text){//affiche un message dans la boite de dialogue du jeu
        if(text != "") {
            panel.PrintMSG(text);
        }
    }
    public static boolean isType(){
        return panel.getIsType();
    }
    /*
    public static void debug(){
    System.out.println(panel.getIsType());
    }
     */
}