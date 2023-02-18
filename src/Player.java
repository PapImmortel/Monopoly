import java.util.*;

import static java.util.Collection.*;

public class Player
{
    /**
     * Classe du Joueur avec toutes les informations du joueur
     * @author Arvind Tangavelou
     * @author Quentin Guyot
     * @author Timothée Royer
     * @author Clément Lavie
     * @date (2023/01/12)
     */
    private int aArgent;
    private String aNomJoueur;
    private String aCouleur;
    private Cases_Plateau aPosition;
    private  int aNbMonopole;
    private int aSortiePrison;
    private HashMap<Integer,Patrimoine> aPatrimoine; // int , Case
    private int aPrisonnier;
    private int[] aListPossession=new int[10];



    /**
     *  Constructeur à 3 paramètre de la classe Player
     * @param pArgent Argent de départ du joueur
     * @param pNomJoueur Nom du joueur
     * @param pCouleur Couleur choisis par le joueur
     */
    public Player(int pArgent,String pNomJoueur, String pCouleur,Cases_Plateau pPosition)
    {
        this.aArgent = pArgent;
        this.aNomJoueur = pNomJoueur;
        this.aCouleur = pCouleur;
        //this.aPosition = Depart;
        this.aNbMonopole = 0;
        this.aSortiePrison = 0;
        this.aPatrimoine = new HashMap<Integer,Patrimoine>();
        this.aPrisonnier =0;
        this.aListPossession[0]=2;
        this.aListPossession[1]=3;
        this.aListPossession[2]=3;
        this.aListPossession[3]=3;
        this.aListPossession[4]=3;
        this.aListPossession[5]=3;
        this.aListPossession[6]=3;
        this.aListPossession[7]=2;
        this.aListPossession[8]=4;
        this.aListPossession[9]=2;
        this.aPosition=pPosition;

    }//Player(.,.,.)

    /**
     * Mutateur d'argent
     * @param pArgent aArgent nouveau montant du joueur
     */
    public void setArgent(int pArgent)
    {
        this.aArgent = pArgent;
    }//setArgent(.)

    /**
     * Accesseur de l'argent du joueur
     * @return aArgent retourne l'argent du joueur
     */
    public int getArgent()
    {
        return  this.aArgent;
    }//getArgent()

    /**
     * Accesseur du nom du joueur
     * @return aNomJoueur nom du joueur
     */
    public String getNomJoueur()
    {
        return aNomJoueur;
    }//getNomJoueur()

    /**
     * Accesseur de la Couleur du joueur
     * @return aCouleur Couleur du joueur
     */
    public String getCouleur()
    {
        return aCouleur;
    }//getCouleur


    /**
     * fonction pour ajouter de l'argent avec un chiffre positif ou supprimer avec un chiffre négatif
     * @param pArgent
     */
    public void ajouteArgent(int pArgent)
    {
        this.aArgent += pArgent;
    }



    /**
     * Mutateur de la position d'un joueur
     * @param pCase aPosition Case où le joueur va se trouver
     */
    public void setPosition(Cases_Plateau pCase)
    {
        this.aPosition = pCase;
    }//setPosition(.)

    /**
     * Accesseur de la position d'un joueur
     * @return aPosition Case actuel du joueur
     */
    public Cases_Plateau getPosition() {
        return this.aPosition;
    }//getPosition()

    /**
     * Mutateur du nombre de monopole du joueur
     * @param pNbMonopole aNbMonopole nombre de monopole du joueur
     */
    public void setNbMonopole(int pNbMonopole)
    {
        this.aNbMonopole = pNbMonopole;
    }//setNbMonopole(.)

    /**
     * Accesseur du nombre de monopole du joueur
     * @return aNbMonopole nombre de monopole du joueur
     */
    public int getNbMonopole()
    {
        return this.aNbMonopole;
    }//getNbMonopole()

    /**
     * Mutateur du nombre de pSortiePrison
     * @param pSortiePrison nouvelle valeur de aSortiePrison
     */
    public void setSortiePrison(int pSortiePrison)
    {
        this.aSortiePrison = pSortiePrison;
    }//setSoritiePrison(.)

    /**
     * Accesseur du nombre de tour fait en prison
     * @return aSortiePrison
     */
    public int getSortiePrison()
    {
        return this.aSortiePrison;
    }//getSortiePrison()

    /**
     * Mutateur du patrimoine d'un joueur
     * @param pPatrimoine nouveau Patrimoine
     */
    public void ajouterPatrimoine(Patrimoine pPatrimoine,int pChange)
    {
        if(pChange==1)
        {
            this.aPatrimoine.put(pPatrimoine.getNbCase(),pPatrimoine);
            this.setMonopole(pPatrimoine.getColor(),1);
        }
        else {
            this.aPatrimoine.remove(pPatrimoine.getNbCase());
            this.setMonopole(pPatrimoine.getColor(),-1);

        }
    }//ajouterPatrimoine()


    /**
     * accesseur de la liste du patrimoine d'un joueur
     * @return aPatrimoine la liste des ses propriété
     */
    public HashMap<Integer,Patrimoine> getPatrimoine()
    {
        return this.aPatrimoine;
    }

    /**
     * retourne une String contenant la liste des propriètés du joueur
     * @return PatrimoineJoueur sous forme de String avec le nom du joueur et son nombre de monopole ainsi qye la liste de ses patrimoines
     */
    public String affichePatrimoine()
    {
        Iterator iterator = aPatrimoine.entrySet().iterator();
        String PatrimoineJoueur = aNomJoueur + "possede " + aNbMonopole + ".\n";
        if (aPatrimoine.isEmpty())
        {
            return PatrimoineJoueur;
        }//if(aPatrimoine.isEmpty())
        PatrimoineJoueur = PatrimoineJoueur + aNomJoueur + " possede les propriétés suivante : \n";
        while (iterator.hasNext())
        {
            Map.Entry terrain = (Map.Entry) iterator.next();
            Patrimoine Case1 = (Patrimoine) terrain.getValue();
            PatrimoineJoueur = PatrimoineJoueur + Case1.getNomCase() + "\n";
        }//while()
        return  PatrimoineJoueur;
    }//affichePatrimoine()


    public void setEstPrisonnier(int pPrisonnier)
    {
        this.aPrisonnier=pPrisonnier;
    }
    /**
     * retourne une  int avec la valeur du nombre de tour ou on a été prisonnier
     * @return aPrisonnier sous forme d'entier avec la valeur du nombre de tour passé en prison
     */
    public int getEstPrisonnier()
    {
        return this.aPrisonnier;
    }

    public boolean getMonopole(String pCouleur)
    {
        switch (pCouleur)
        {
            case "marron":
                return this.aListPossession[0]==0;

            case "cyan":
                return this.aListPossession[1]==0;
            case "rose":
                return this.aListPossession[2]==0;
            case "orange":
                return this.aListPossession[3]==0;
            case "rouge":
                return this.aListPossession[4]==0;
            case "jaune":
                return this.aListPossession[5]==0;
            case "vert":
                return this.aListPossession[6]==0;
            case "bleu":
                return this.aListPossession[7]==0;
            case "gare":
                return this.aListPossession[8]==0;
            case "compagnie":
                return this.aListPossession[9]==0;
        }
        return false;
    }

    public void setMonopole(String pCouleur,int pModif)
    {
        switch (pCouleur)
        {
            case "marron":
                if(this.aListPossession[0]==0){setNbMonopole(-1);}
                this.aListPossession[0]-=pModif;
                if(this.aListPossession[0]==0){setNbMonopole(1);}
                break;
            case "cyan":
                if(this.aListPossession[0]==0){setNbMonopole(-1);}

                this.aListPossession[1]-=pModif;
                if(this.aListPossession[0]==0){setNbMonopole(1);}

                break;
            case "rose":
                if(this.aListPossession[0]==0){setNbMonopole(-1);}
                this.aListPossession[2]-=pModif;
                if(this.aListPossession[0]==0){setNbMonopole(1);}

                break;

            case "orange":
                if(this.aListPossession[0]==0){setNbMonopole(-1);}

                this.aListPossession[3]-=pModif;
                if(this.aListPossession[0]==0){setNbMonopole(1);}


                break;

            case "rouge":
                if(this.aListPossession[0]==0){setNbMonopole(-1);}

                this.aListPossession[4]-=pModif;
                if(this.aListPossession[0]==0){setNbMonopole(1);}

                break;

            case "jaune":
                if(this.aListPossession[0]==0){setNbMonopole(-1);}

                this.aListPossession[5]-=pModif;
                if(this.aListPossession[0]==0){setNbMonopole(1);}

                break;

            case "vert":
                if(this.aListPossession[0]==0){setNbMonopole(-1);}

                this.aListPossession[6]-=pModif;
                if(this.aListPossession[0]==0){setNbMonopole(1);}

                break;

            case "bleu":
                if(this.aListPossession[0]==0){setNbMonopole(-1);}

                this.aListPossession[7]-=pModif;
                if(this.aListPossession[0]==0){setNbMonopole(1);}

                break;

            case "gare":
                if(this.aListPossession[0]==0){setNbMonopole(-1);}

                this.aListPossession[8]-=pModif;
                if(this.aListPossession[0]==0){setNbMonopole(1);}

                break;

            case "compagnie":
                if(this.aListPossession[0]==0){setNbMonopole(-1);}

                this.aListPossession[9]-=pModif;
                if(this.aListPossession[0]==0){setNbMonopole(1);}

                break;
        }
    }
    public String afficheMonopole()
    {
        if(getNbMonopole()==0)
        {
            return " Vous ne possedez aucun monopole , vous ne pouvez donc pas construire.\n";
        }
        else {
            String vListMonopole = " Vous possédez toutes les rues de couleur :   ";
            for (int i = 0; i < 8; i++) {
                if (this.aListPossession[i] == 0) {
                    switch (i) {
                        case 0:
                            vListMonopole += "marron ";

                        case 1:
                            vListMonopole += "cyan ";
                        case 2:
                            vListMonopole += "rose ";
                        case 3:
                            vListMonopole += "orange ";
                        case 4:
                            vListMonopole += "rouge ";
                        case 5:
                            vListMonopole += "jaune ";
                        case 6:
                            vListMonopole += "vert ";
                        case 7:
                            vListMonopole += "bleu ";
                    }
                }
            }
            return vListMonopole + "\n ";
        }
    }
    public int getNbGare()
    {
        return 4-this.aListPossession[8];
    }
    public int getNbCompagnie()
    {
        return 2-this.aListPossession[9];
    }

    /**
     *
     * @return un tableau avec le nombre de maisons puis le nombre d'hotel
     */
    public int[] getNbMaisonHotel()
    {
        Iterator iterator = aPatrimoine.entrySet().iterator();
        int [] nbResultat=new int[2];
        if (aPatrimoine.isEmpty())
        {
            nbResultat[0]=0;
            nbResultat[1]=0;
            return nbResultat;
        }//if(aPatrimoine.isEmpty())
        while (iterator.hasNext())
        {
            Map.Entry Monopole = (Map.Entry) iterator.next();
            Patrimoine terrain = (Patrimoine) Monopole.getValue();
            if(terrain.getNbCase()!=12 &&terrain.getNbCase()!=28 && (terrain.getNbCase()%5)!=0)
            {
                Rue terrain2 = (Rue)terrain;
                nbResultat[0]+=terrain2.getNbMaison()[0];
                nbResultat[1]+=terrain2.getNbMaison()[1];
            }
        }//while()
        return nbResultat;
    }
}//Player.java