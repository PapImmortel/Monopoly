import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class CaseEffet extends Cases_Plateau{


    private int aNumeroEffet;//0=depart 1=chance 2=communauter

    /**
     *constructeur de la classe CaseEffet
     * @param pNomCase String le nom de la case
     * @param pNbCase  int le numero de la case
     * @param pNumeroEffet int le numero du type
     */
    public CaseEffet(String pNomCase,int pNbCase,int pNumeroEffet)
    {
        super(pNomCase,pNbCase,false);
        this.aNumeroEffet=pNumeroEffet;
    }
    public int effetCase(Player pJoueur,  HashMap<Integer,Player> pListPlayer, HashMap<Integer,Cases_Plateau> pListCase)
    {
        if(this.aNumeroEffet==1)
        {
            this.caseChance(pJoueur,pListPlayer,pListCase);
            return 0;
        }
        else if (this.aNumeroEffet==2)
        {
            int a=this.caseCommunauter(pJoueur,pListPlayer,pListCase);
            return a;
        }
        return -1;
    }
    /**
     * Effet des cartes chances
     * @param pJoueur Player le joueur actif
     * @param pListPlayer HashMap<Integer,Player> la liste des joueurs
     * @param pListCase HashMap<Integer,Cases_Plateau> la liste des cases
     * @return
     */
    public void caseChance(Player pJoueur,  HashMap<Integer,Player> pListPlayer, HashMap<Integer,Cases_Plateau> pListCase)
    {
        Random random=new Random();
        int vNumEffet= random.nextInt(16);
        switch (vNumEffet){
            case 0:
                pJoueur.setPosition(pListCase.get(39));
            case 1:
                pJoueur.setPosition(pListCase.get(0));
                depart(pJoueur);
            case 2:
                if(pJoueur.getPosition().getNbCase()-24>0)
                {
                    depart(pJoueur);
                }
                pJoueur.setPosition(pListCase.get(24));
            case 3:
                if(pJoueur.getPosition().getNbCase()-11>0)
                {
                    depart(pJoueur);
                }
                pJoueur.setPosition((pListCase.get(11)));
            case 4:
                pJoueur.ajouteArgent(-pJoueur.getNbMaisonHotel()[1]*40);
                pJoueur.ajouteArgent(-pJoueur.getNbMaisonHotel()[2]*115);

                //Vous êtes imposé pour les réparations de voirie à raison de F4 000 par maison et F11 500 par hôtel.
            case 5:
                if(pJoueur.getPosition().getNbCase()-15>0)
                {
                    depart(pJoueur);
                }
                pJoueur.setPosition((pListCase.get(15)));
            case 6:
                pJoueur.ajouteArgent(100);
            case 7:
                pJoueur.ajouteArgent(50);
            case 8:
                //Vous êtes libéré de prison. Cette carte peut être conservée jusqu’à ce qu’elle soit utilisée ou vendue.
                pJoueur.setSortiePrison(pJoueur.getSortiePrison()+1);
            case 9:
                int pos =pJoueur.getPosition().getNbCase()-3;
                pJoueur.setPosition(pListCase.get(pos));
            case 10:
                pJoueur.setPosition(pListCase.get(10));
                pJoueur.setEstPrisonnier(1);
                //Aller en prison. Rendez-vous directement en prison. Ne franchissez pas par la case départ, ne touchez pas F20 000
            case 11:
                pJoueur.ajouteArgent(-pJoueur.getNbMaisonHotel()[1]*25);
                pJoueur.ajouteArgent(-pJoueur.getNbMaisonHotel()[2]*100);
                //Faites des réparations dans toutes vos maisons. Versez pour chaque maison F2 500. Versez pour chaque hôtel F10 000
            case 12:
                pJoueur.ajouteArgent(-15);
            case 13:
                pJoueur.ajouteArgent(-150);
            case 14:
                pJoueur.ajouteArgent(-20);
            case 15:
                pJoueur.ajouteArgent(150);



        }


    }
    /**
     * Effet des cartes communautés
     * @param pJoueur Player le joueur actif
     * @param pListPlayer Hashmap la liste des joueurs
     * @param pListCase Hashmap la liste des cases
     * @return
     */
    public int caseCommunauter(Player pJoueur,  HashMap<Integer,Player> pListPlayer, HashMap<Integer,Cases_Plateau> pListCase)
    {
        Random random=new Random();
        int vNumEffet= random.nextInt(16);
        switch (vNumEffet){

            case 0:
                pJoueur.setPosition(pListCase.get(0));
                depart(pJoueur);
            case 1:
                pJoueur.ajouteArgent(200);
            case 2:
                pJoueur.ajouteArgent(-50);

            case 3:
                pJoueur.ajouteArgent(50);
            case 4:
                pJoueur.setSortiePrison(pJoueur.getSortiePrison()+1);
            case 5:
                pJoueur.setPosition(pListCase.get(10));
                pJoueur.setEstPrisonnier(1);
            case 6:
                pJoueur.setPosition(pListCase.get(1));
            case 7:
                pJoueur.ajouteArgent(100);
            case 8:
                Iterator iterator = pListPlayer.entrySet().iterator();
                while (iterator.hasNext())
                {
                    Map.Entry joujoueur = (Map.Entry) iterator.next();
                    Player joueur = (Player) joujoueur.getValue();
                    if(!(pJoueur.getNomJoueur().equals(joueur.getNomJoueur()))&& joueur.getArgent()<0)
                    {
                        joueur.ajouteArgent(-10);
                        pJoueur.ajouteArgent(10);
                    }

                }//while()
                //tout les joueurs vous donn 10
            case 9:
                pJoueur.ajouteArgent(20);
            case 10:
                pJoueur.ajouteArgent(25);
            case 11:
                pJoueur.ajouteArgent(-50);
            case 12:
                return 1;
            // Payer 10 ou carte chance
            case 13:
                int cPos=pJoueur.getPosition().getNbCase();
                if(35<cPos || cPos<5)
                {
                    pJoueur.setPosition(pListCase.get(5));
                }
                else if (5<cPos && cPos<15)
                {
                    pJoueur.setPosition(pListCase.get(15));
                }
                else if (15<cPos && cPos<25)
                {
                    pJoueur.setPosition(pListCase.get(15));
                }
                else if (25<cPos && cPos<35)
                {
                    pJoueur.setPosition(pListCase.get(25));
                }
            case 14:
                pJoueur.ajouteArgent(10);
            case 15:
                pJoueur.ajouteArgent(100);



        }

        return 0;
    }
    public void depart(Player pJoueur)
    {
        pJoueur.ajouteArgent(200);
    }
}