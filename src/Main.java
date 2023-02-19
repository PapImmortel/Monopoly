import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        Frame Menu = new Frame("Menu Javapoly");
        HashMap<Integer, String> ListJoueur = new HashMap<>();
        String[] ListCouleur;

        int Joueur;

        while(!Menu.isFinish()){
            System.out.print("");
        }

        ListJoueur = Menu.getPlayerList();
        ListCouleur = Menu.getColorList();
        Joueur = Menu.getIndex();
        Menu.setVisible(false);
        VideoGame jeux = new VideoGame(Joueur,ListJoueur, ListCouleur);//Constructeur paramÃ©trique de VideoGame


    }//main(.)
}//Main
