import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> ListJoueur = new HashMap<>();
        System.out.println("Bienvenue dans le Monopoly java \n");
        System.out.println("Tapez le nombre de joueur entre 2 et 4 ou  0 pour quitter \n");
        int Joueur = scanner.nextInt();
        if (Joueur <= 0)
        {
            System.exit(0);
        }//if(Joueur <= 0)
        else if (Joueur >4)
        {
            System.out.println("On ne peut pas jouer avec "+ Joueur +" joueur !!");
            System.exit(0);
        }//if(Joueur>4)
        else if (Joueur == 1)
        {
            System.out.println("Désolé mais tu ne peux pas jouer tout seul !");
            System.exit(0);
        }//if(Joueur == 1)
        else
        {
            for (int i = 1; i <= Joueur; i++)
            {
                System.out.println("Entrez le nom du joueur numéros " + i);
                String Joueur1 = scanner.nextLine();
                ListJoueur.put(i,Joueur1);
                System.out.println("Entrez la couleur du Joueur numeros " + i);
                String Couleur = scanner.nextLine();
                System.out.println("Bonjour " + Joueur1 + ", ta couleur est : " + Couleur);
            }
            VideoGame jeux = new VideoGame(Joueur,ListJoueur);//Constructeur paramétrique de VideoGame

        }//else

    }//main(.)
}//Main