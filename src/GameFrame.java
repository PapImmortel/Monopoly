import javax.swing.*;
import java.util.HashMap;
public class GameFrame extends JFrame {

    private static final GamePanel panel = new GamePanel();

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

        return GamePanel.getCommand();
    }

    public static void PrintMSG(String text){//affiche un message dans la boite de dialogue du jeu
        if(!text.equals("")){
            GamePanel.PrintMSG(text);
        }
    }
    public static void setPlayerList(HashMap<Integer, Player> ListJoueurP){
        GamePanel.setPlayerList(ListJoueurP);
    }


    public static void UpdateMoneyGUI(){
        GamePanel.UpdateMoneyGUI();
    }
    public static void setNPlayer(int Nb){
        GamePanel.setNPlayer(Nb);
    }
}