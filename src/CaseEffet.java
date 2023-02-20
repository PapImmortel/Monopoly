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
        this.aEffet="";

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
                this.setaEffet("Rendez-vous à la RUE DE LA PAIX");
                break;
            case 1:
                pJoueur.setPosition(pListCase.get(0));
                depart(pJoueur);
                this.setaEffet("Avancez jusqu'à la case depart");
                break;
            case 2:
                if(pJoueur.getPosition().getNbCase()-24>0)
                {
                    depart(pJoueur);
                }
                pJoueur.setPosition(pListCase.get(24));
                this.setaEffet("Rendez-vous à l'Avenue Henry-Martin. Si vous passez par la case depart,\n vous recevez 200euros .");
                break;
            case 3:
                if(pJoueur.getPosition().getNbCase()-11>0) {
                    depart(pJoueur);
                }
                pJoueur.setPosition((pListCase.get(11)));
                this.setaEffet("Avancez au BOULEVARD DE LA VILLETTE. Si vous passez par la case depart,\n recevez 200euros ");
                break;

            case 4:
                pJoueur.ajouteArgent(-pJoueur.getNbMaisonHotel()[0]*40);
                pJoueur.ajouteArgent(-pJoueur.getNbMaisonHotel()[1]*115);
                this.setaEffet("Vous êtes imposés pour les réparations de voirie à raison de 40 euros par maison \net 115 euros par hôtel.");
                break;
            case 5:
                if(pJoueur.getPosition().getNbCase()-15>0)
                {
                    depart(pJoueur);
                }
                pJoueur.setPosition((pListCase.get(15)));
                this.setaEffet("Allez à la GARE DE LYON. Si vous passez par la case depart, recevez 200euros ");
                break;
            case 6:
                pJoueur.ajouteArgent(100);
                this.setaEffet("Vous avez gagné le prix de mots croisés. Recevez 100 euros");
                break;
            case 7:
                pJoueur.ajouteArgent(50);
                this.setaEffet("La Banque vous verse un dividende de 50 euros");
                break;
            case 8:
                pJoueur.setSortiePrison(pJoueur.getSortiePrison()+1);
                this.setaEffet("Vous êtes libérés de prison. Cette carte est conservée jusqu'à utilisation. ");
                break;
            case 9:
                int pos =pJoueur.getPosition().getNbCase()-3;
                pJoueur.setPosition(pListCase.get(pos));
                this.setaEffet("Reculez de trois cases ");
                break;
            case 10:
                pJoueur.setPosition(pListCase.get(10));
                pJoueur.setEstPrisonnier(1);
                this.setaEffet("Allez en prison sans passer par la case depart.");
                break;
            case 11:
                pJoueur.ajouteArgent(-pJoueur.getNbMaisonHotel()[0]*25);
                pJoueur.ajouteArgent(-pJoueur.getNbMaisonHotel()[1]*100);
                this.setaEffet("Faites des réparations dans toutes vos maisons. Versez pour chaque maison 25 euros.\n Versez pour chaque hôtel 100 euros");
                break;
            case 12:
                pJoueur.ajouteArgent(-15);
                this.setaEffet("Amende pour excès de vitesse: tu perds 15 euros");
                break;
            case 13:
                pJoueur.ajouteArgent(-150);
                this.setaEffet("Payez pour vos frais de scolarité: perdez 150 euros");
                break;

            case 14:
                pJoueur.ajouteArgent(-20);
                this.setaEffet("Amende pour ivresse : perdez 20 euros");
                break;

            case 15:
                pJoueur.ajouteArgent(150);
                this.setaEffet("Votre immeuble et votre prêt rapportent. Vous recevez 150 euros");
                break;


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
                this.setaEffet("Avancez jusqu'à la case depart");
                break;
            case 1:
                pJoueur.ajouteArgent(200);
                this.setaEffet("Erreur de la Banque en votre faveur. Recevez 200 euros");
                break;
            case 2:
                pJoueur.ajouteArgent(-50);
                this.setaEffet("Payez votre Police d'Assurance s'élevant à 50 euros");
                break;
            case 3:
                pJoueur.ajouteArgent(-100);
                this.setaEffet("Payez à l'hôpital 100 euros");
                break;
            case 4:
                pJoueur.setSortiePrison(pJoueur.getSortiePrison()+1);
                this.setaEffet("Vous êtes libérés de prison. Cette carte est conservée jusqu'à utilisation.");
                break;

            case 5:
                pJoueur.setPosition(pListCase.get(10));
                pJoueur.setEstPrisonnier(1);
                this.setaEffet("Allez en prison sans passer par la case depart");
                break;

            case 6:
                pJoueur.setPosition(pListCase.get(1));
                this.setaEffet("Retournez à BELLEVILLE");
                break;
            case 7:
                pJoueur.ajouteArgent(100);
                this.setaEffet("Vous héritez de 100 euros");
                break;

            case 8:

                for (Map.Entry<Integer,Player> PlayerEntry : pListPlayer.entrySet())
                {
                    Player joueur =PlayerEntry.getValue();
                    if(!(pJoueur.getNomJoueur().equals(joueur.getNomJoueur()))&& joueur.getArgent()>=0)
                    {
                        joueur.ajouteArgent(-10);
                        pJoueur.ajouteArgent(10);
                    }

                }//while()
                this.setaEffet("C'est votre anniversaire: chaque joueur doit vous donner 10 euros");
                break;

            case 9:
                pJoueur.ajouteArgent(20);
                this.setaEffet("Les Contributions vous remboursent la somme de 20 euros");
                break;
            case 10:
                pJoueur.ajouteArgent(25);
                this.setaEffet("Recevez votre intérêt sur l'emprunt à 7%. Vous gagnez 25 euros");
                break;
            case 11:
                pJoueur.ajouteArgent(-50);
                this.setaEffet("Payez la note du Médecin s'élevant à 50 euros");
                break;

            case 12:
                this.setaEffet("Payez une amende de 10 euros ou bien tirez une carte chance");
                return 1;

            case 13:
                pJoueur.ajouteArgent(50);
                this.setaEffet("La vente de votre stock vous rapporte 50 euros");
                break;
            case 14:
                pJoueur.ajouteArgent(10);
                this.setaEffet("Vous avez gagné le deuxième prix de beauté. Recevez 10 euros");
                break;

            case 15:
                pJoueur.ajouteArgent(100);
                this.setaEffet("Recevez votre revenu annuel: 100 euros");
                break;



        }
        return 0;
    }
    public void depart(Player pJoueur)
    {
        pJoueur.ajouteArgent(200);
    }
}