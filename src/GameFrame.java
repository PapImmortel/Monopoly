import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GameFrame extends JFrame {

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

    public static void setPlayerList(HashMap<Integer, Player> ListJoueurP){
        panel.setPlayerList(ListJoueurP);
    }
    public static boolean isType(){
        return panel.getIsType();
    }

    public static void UpdateMoneyGUI(){
        panel.UpdateMoneyGUI();
    }
    public static void setNPlayer(int Nb){
        panel.setNPlayer(Nb);
    }

}
