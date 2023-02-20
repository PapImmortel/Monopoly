import javax.swing.*;
import java.util.HashMap;

public class Frame extends JFrame{

    private static final Panel panel = new Panel();
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

    public static boolean isFinish(){
        return Panel.getIsFinish();
    }
    public static HashMap<Integer,String> getPlayerList(){
        return Panel.getPlayerList();
    }
    public static String[] getColorList(){
        return Panel.getColorList();
    }
    public static int getIndex(){
        return Panel.getIndexPlayer();
    }
}