import javax.swing.*;
import java.util.HashMap;

public class Frame extends JFrame{

    private static Panel panel = new Panel();
    public Frame(String title){
        //Titre de la fenetre
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
        return panel.getIsFinish();
    }
    public static HashMap getPlayerList(){
        return panel.getPlayerList();
    }
    public static String[] getColorList(){
        return panel.getColorList();
    }
    public static int getIndex(){
        return panel.getIndexPlayer();
    }
}