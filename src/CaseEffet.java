import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Classe pour les effets des cartes communauté et chances
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 * @date (2023/02/18)
 */
public class CaseEffet extends Cases_Plateau{



    private final int aNumeroEffet;//0=depart 1=chance 2=communauté
    private String aEffet;

    /**
     *
     * @param pNomCase String le nom de la case
     * @param pNbCase  int le numéro de la case
     * @param pNumeroEffet int le numéro du type
     */
    public CaseEffet(String pNomCase,int pNbCase,int pNumeroEffet)
    {
        super(pNomCase,pNbCase,false);
        this.aNumeroEffet=pNumeroEffet;
    }

    /**
     * Mutateur de l'attribue aEffet
     * @param pEffet récupère le texte indiquant l'effet de la case
     */
    public void setaEffet(String pEffet)
    {
        this.aEffet=pEffet;
    }
    /**
     * Accesseur du type de caseEffet (carte communauté ou chance)
     * @return aNumeroEffet
     */
    public int getNumeroEffet()
    {
        return this.aNumeroEffet;
    }

    /**
     * Accesseur de l'attribue aEffet
     * @return aEffet
     */
    public String getaEffet()
    {
        return this.aEffet;
    }

    /**
     * Fonction générale pour les effets des cartes à effets
     * @param pJoueur Player le joueur actif
     * @param pListPlayer Hashmap la liste des joueurs
     * @param pListCase Hashmap la liste des cases
     * @return renvoie 0 sauf si c'est la carte chance donnant un choix à l'utilisateur
     */
    public int effetCase(Player pJoueur,  HashMap<Integer,Player> pListPlayer, HashMap<Integer,Cases_Plateau> pListCase)
    {
        if(this.aNumeroEffet==1)
        {
            this.caseChance(pJoueur,pListCase);
            return 0;
        }
        else if (this.aNumeroEffet==2)
        {
            return this.caseCommunaute(pJoueur,pListPlayer,pListCase);
        }
        return 0;
    }

    /**
     * Effet des cartes chance
     * @param pJoueur Player le joueur actif
     * @param pListCase Hashmap la liste des cases
     */
    public void caseChance(Player pJoueur, HashMap<Integer,Cases_Plateau> pListCase)
    {
        Random random=new Random();
        int vNumEffet= random.nextInt(16);
        switch (vNumEffet){
            case 0:
                pJoueur.setPosition(pListCase.get(39));
                this.setaEffet("Va à la case RUE DE LA PAIX");
            case 1:
                pJoueur.setPosition(pListCase.get(0));
                depart(pJoueur);
                this.setaEffet("Retourne a la case depart");
            case 2:
                if(pJoueur.getPosition().getNbCase()-24>0)
                {
                    depart(pJoueur);
                }
                pJoueur.setPosition(pListCase.get(24));
                this.setaEffet("Va Avenue Henry-Martin si tu passes par la case depart, tu reçois 200euros ");
            case 3:
                if(pJoueur.getPosition().getNbCase()-11>0) {
                    depart(pJoueur);
                }
                pJoueur.setPosition((pListCase.get(11)));
                this.setaEffet("Va BOULEVARD DE LA VILLETTE si tu passes par la case depart, tu reçois 200euros ");

            case 4:
                pJoueur.ajouteArgent(-pJoueur.getNbMaisonHotel()[0]*40);
                pJoueur.ajouteArgent(-pJoueur.getNbMaisonHotel()[1]*115);
                this.setaEffet("Vous êtes imposés pour les réparations de voirie à raison de F4 000 par maison et F11 500 par hôtel.");
            case 5:
                if(pJoueur.getPosition().getNbCase()-15>0)
                {
                    depart(pJoueur);
                }
                pJoueur.setPosition((pListCase.get(15)));
                this.setaEffet("Va GARE DE LYON si tu passes par la case depart, reçoit 200euros ");
            case 6:
                pJoueur.ajouteArgent(100);
                this.setaEffet("Reçois 100 euros");
            case 7:
                pJoueur.ajouteArgent(50);
                this.setaEffet("Reçois 50 euros");
            case 8:
                pJoueur.setSortiePrison(pJoueur.getSortiePrison()+1);
                this.setaEffet("Vous êtes libérés de prison. Cette carte est conservée jusqu'à utilisation. ");
            case 9:
                int pos =pJoueur.getPosition().getNbCase()-3;
                pJoueur.setPosition(pListCase.get(pos));
                this.setaEffet("Recule de trois cases ");
            case 10:
                pJoueur.setPosition(pListCase.get(10));
                pJoueur.setEstPrisonnier(1);
                this.setaEffet("Va en prison sans passer par la case depart");
            case 11:
                pJoueur.ajouteArgent(-pJoueur.getNbMaisonHotel()[0]*25);
                pJoueur.ajouteArgent(-pJoueur.getNbMaisonHotel()[1]*100);
                this.setaEffet("Faites des réparations dans toutes vos maisons. Versez pour chaque maison 25euros. Versez pour chaque hôtel 100euro");
            case 12:
                pJoueur.ajouteArgent(-15);
                this.setaEffet("Perds 15 euros");
            case 13:
                pJoueur.ajouteArgent(-150);
                this.setaEffet("Perds 150 euros");

            case 14:
                pJoueur.ajouteArgent(-20);
                this.setaEffet("Perds 20 euros");

            case 15:
                pJoueur.ajouteArgent(150);
                this.setaEffet("Reçois 150 euros");


        }


    }
    /**
     * Effet des cartes communautés
     * @param pJoueur Player le joueur actif
     * @param pListPlayer Hashmap la liste des joueurs
     * @param pListCase Hashmap la liste des cases
     * @return 1 si une tombe sur la case pioche une carte chance ou paye
     */
    public int caseCommunaute(Player pJoueur,  HashMap<Integer,Player> pListPlayer, HashMap<Integer,Cases_Plateau> pListCase)
    {
        Random random=new Random();
        int vNumEffet= random.nextInt(16) ;
        switch (vNumEffet){

            case 0:
                pJoueur.setPosition(pListCase.get(0));
                depart(pJoueur);
                this.setaEffet("retourne à la case depart");
            case 1:
                pJoueur.ajouteArgent(200);
                this.setaEffet("Reçois 200 euros");
            case 2:
                pJoueur.ajouteArgent(-50);
                this.setaEffet("Perds 50 euros");
            case 3:
                pJoueur.ajouteArgent(50);
                this.setaEffet("Perds 20 euros");
            case 4:
                pJoueur.setSortiePrison(pJoueur.getSortiePrison()+1);
                this.setaEffet("Vous êtes libérés de prison. Cette carte est conservée jusqu'à utilisation.");

            case 5:
                pJoueur.setPosition(pListCase.get(10));
                pJoueur.setEstPrisonnier(1);
                this.setaEffet("Va en prison sans passer par la case depart");

            case 6:
                pJoueur.setPosition(pListCase.get(1));
                this.setaEffet("Retourne à BELLEVILLE");
            case 7:
                pJoueur.ajouteArgent(100);
                this.setaEffet("Reçois 100 euros");

            case 8:

                for (Map.Entry<Integer,Player> PlayerEntry : pListPlayer.entrySet())
                {
                    Player joueur =PlayerEntry.getValue();
                    if(!(pJoueur.getNomJoueur().equals(joueur.getNomJoueur()))&& joueur.getArgent()<0)
                    {
                        joueur.ajouteArgent(-10);
                        pJoueur.ajouteArgent(10);
                    }

                }//while()
                this.setaEffet("tous les joueurs vous donnent 10 euros");

            case 9:
                pJoueur.ajouteArgent(20);
                this.setaEffet("Reçois 20 euros");
            case 10:
                pJoueur.ajouteArgent(25);
                this.setaEffet("Reçois 25 euros");
            case 11:
                pJoueur.ajouteArgent(-50);
                this.setaEffet("Perds 50 euros");

            case 12:
                this.setaEffet("Paye 10 ou pioche une carte chance");
                return 1;

            case 13:
                int cPos=pJoueur.getPosition().getNbCase();
                if(35<cPos || cPos<5)
                {
                    if(cPos>35)
                    {
                        depart(pJoueur);
                    }
                    pJoueur.setPosition(pListCase.get(5));
                }
                else if (5<cPos && cPos<15)
                {
                    pJoueur.setPosition(pListCase.get(15));
                }
                else if (15<cPos && cPos<25)
                {
                    pJoueur.setPosition(pListCase.get(25));
                }
                else if (25<cPos && cPos<35)
                {
                    pJoueur.setPosition(pListCase.get(35));
                }
                this.setaEffet("Va a la Gare la plus proche");
            case 14:
                pJoueur.ajouteArgent(10);
                this.setaEffet("Reçois 10 euros");

            case 15:
                pJoueur.ajouteArgent(100);
                this.setaEffet("Reçois 100 euros");



        }
        return 0;
    }
    public void depart(Player pJoueur)
    {
        pJoueur.ajouteArgent(200);
    }
}