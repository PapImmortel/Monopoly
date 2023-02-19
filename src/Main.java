import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        Frame Menu = new Frame("Menu Javapoly");
        String[] ListCouleur;

        int Joueur;

        while(!Menu.isFinish()){
            System.out.print("");
        }

        HashMap<Integer, String> ListJoueur = Menu.getPlayerList();
        ListCouleur = Menu.getColorList();
        Joueur = Menu.getIndex();
        Menu.setVisible(false);
        VideoGame jeux = new VideoGame(Joueur,ListJoueur, ListCouleur);//Constructeur paramÃ©trique de VideoGame


    }//main(.)
}//Main
