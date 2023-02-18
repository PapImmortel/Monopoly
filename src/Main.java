import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        Frame Menu = new Frame("Menu Javapoly");
        HashMap<Integer, String> ListJoueur = new HashMap<>();
        int Joueur;

        while(!Menu.isFinish()){
        }

        ListJoueur = Menu.getPlayerList();
        Joueur = Menu.getIndex();
        VideoGame jeux = new VideoGame(Joueur,ListJoueur);//Constructeur paramétrique de VideoGame


    }//main(.)
}//Main
