import java.util.*;

/**
 * Classe du Joueur avec toutes les informations du joueur
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 */
public class Player
{

    private int aArgent;
    private final String aNomJoueur;
    private final String aCouleur;
    private Cases_Plateau aPosition;
    private  int aNbMonopole;
    private int aSortiePrison;
    private final HashMap<Integer,Patrimoine> aPatrimoine; // int , Case
    private int aPrisonnier;
    private final int[] aListPossession=new int[10];


    /**
     * Constructeur de la classe Player
     * @param pArgent int l'argent actuel du joueur
     * @param pNomJoueur String le nom du joueur
     * @param pCouleur String la couleur du joueur
     * @param pPosition Cases_Plateau la case où se situe le joueur
     */
    public Player(int pArgent,String pNomJoueur, String pCouleur,Cases_Plateau pPosition)
    {
        this.aArgent = pArgent;
        this.aNomJoueur = pNomJoueur;
        this.aCouleur = pCouleur;
        //this.aPosition = Depart;
        this.aNbMonopole = 0;
        this.aSortiePrison = 0;
        this.aPatrimoine = new HashMap<>();
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
     * Accesseur de l'argent du joueur
     * @return aArgent int retourne l'argent du joueur
     */
    public int getArgent()
    {
        return  this.aArgent;
    }//getArgent()

    /**
     * Accesseur du nom du joueur
     * @return aNomJoueur String retourne le nom du joueur
     */
    public String getNomJoueur()
    {
        return aNomJoueur;
    }//getNomJoueur()

    /**
     * Accesseur de la Couleur du joueur
     * @return aCouleur String retourne la Couleur du joueur
     */
    public String getCouleur()
    {
        return aCouleur;
    }//getCouleur


    /**
     * fonction permettant d'ajouter de l'argent avec un chiffre positif ou d'en supprimer avec un chiffre négatif
     * @param pArgent int la valeur d'argent à ajouter au joueur (négative ou positive)
     */
    public void ajouteArgent(int pArgent)
    {
        this.aArgent += pArgent;
    }



    /**
     * Mutateur de la position d'un joueur
     * @param pCase Cases_Plateau Case où le joueur va se situer
     */
    public void setPosition(Cases_Plateau pCase)
    {
        this.aPosition = pCase;
    }//setPosition(.)

    /**
     * Accesseur de la position d'un joueur
     * @return aPosition Cases_Plateau retourne la case actuelle du joueur
     */
    public Cases_Plateau getPosition() {
        return this.aPosition;
    }//getPosition()

    /**
     * Mutateur du nombre de monopoles du joueur
     * @param pNbMonopole int nombre de monopoles du joueur
     */
    public void setNbMonopole(int pNbMonopole)
    {
        this.aNbMonopole = pNbMonopole;
    }//setNbMonopole(.)

    /**
     * Accesseur du nombre de monopoles du joueur
     * @return aNbMonopole int retourne le nombre de monopoles du joueur
     */
    public int getNbMonopole()
    {
        return this.aNbMonopole;
    }//getNbMonopole()

    /**
     * Mutateur du nombre de tickets de sortie de prison encore utilisables
     * @param pSortiePrison int nouvelle valeur de l'attribue aSortiePrison
     */
    public void setSortiePrison(int pSortiePrison)
    {
        this.aSortiePrison = pSortiePrison;
    }//setSortiePrison(.)

    /**
     * Accesseur du nombre de tours passé en prison
     * @return aSortiePrison int retourne le nombre de tours passé en prison
     */
    public int getSortiePrison()
    {
        return this.aSortiePrison;
    }//getSortiePrison()

    /**
     * Mutateur du patrimoine d'un joueur
     * @param pPatrimoine Patrimoine le patrimoine que l'on souhaite ajouter ou supprimer
     * @param pChange int si cette valeur vaut 1, on ajoute le patrimoine sinon on le supprime
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
     * @return aPatrimoine HashMap<Integer,Patrimoine> retourne la liste des patrimoines du joueur
     */
    public HashMap<Integer,Patrimoine> getPatrimoine()
    {
        return this.aPatrimoine;
    }

    /**
     * retourne un String contenant la liste des propriétés du joueur
     * @return PatrimoineJoueur String retourne toutes les possessions d'un joueur
     */
    public String affichePatrimoine()
    {
        Iterator<Map.Entry<Integer,Patrimoine>> iterator = aPatrimoine.entrySet().iterator();
        StringBuilder PatrimoineJoueur = new StringBuilder(aNomJoueur + " possède " + aNbMonopole + " monopole(s).\n");
        if (aPatrimoine.isEmpty())
        {
            PatrimoineJoueur.append(" et 0 patrimoines.");
            return PatrimoineJoueur.toString();
        }//if(aPatrimoine.isEmpty())
        PatrimoineJoueur.append(aNomJoueur).append(" possède les propriétés suivantes : ");
        while (iterator.hasNext())
        {
            Map.Entry<Integer,Patrimoine> terrain = iterator.next();
            Patrimoine Case1 = terrain.getValue();
            PatrimoineJoueur.append(" \n").append(Case1.getNomCase());
            if(!Case1.getColor().equals("gare")||!Case1.getColor().equals("compagnie"))
            {
                Rue Case2 = (Rue) Case1;
                PatrimoineJoueur.append("(").append(Case2.getColor());
                if(Case2.getNbMaison()[0]>0)
                {
                    PatrimoineJoueur.append(", ").append(Case2.getNbMaison()[0]).append(" maison(s)");
                }
                else if(Case2.getNbMaison()[1]>0)
                {
                    PatrimoineJoueur.append(", ").append(Case2.getNbMaison()[1]).append(" hôtel");
                }
                PatrimoineJoueur.append(")");

            }
        }//while()
        return PatrimoineJoueur.toString();
    }//affichePatrimoine()

    /**
     * mutateur permettant de modifier le nombre de tours passé en prison
     * @param pPrisonnier int le nombre de tours passé en prison
     */
    public void setEstPrisonnier(int pPrisonnier)
    {
        this.aPrisonnier=pPrisonnier;
    }
    /**
     * Accesseur du nombre de tours passé en prison
     * @return aPrisonnier int le nombre de tours passés en prison
     */
    public int getEstPrisonnier()
    {
        return this.aPrisonnier;
    }

    /**
     * Accesseur permettant de savoir si l'on possède un monopole dans une couleur précise
     * @param pCouleur String la couleur où l'on souhaite savoir s'il y a un monopole
     * @return boolean renvoie un booleen indiquant si l'on a un monopole dans la couleur indiqué en entrée
     */
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

    /**
     * mutateur de l'attribue listPossession permettant d'ajouter l'acquisition ou la suppression d'un patrimoine dans une certaine couleur
     * @param pCouleur String la couleur du patrimoine à ajouter/supprimer
     * @param pModif int prend la valeur 1 si l'on ajoute le patrimoine et -1 sinon
     */
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
                if(this.aListPossession[1]==0){setNbMonopole(-1);}

                this.aListPossession[1]-=pModif;
                if(this.aListPossession[1]==0){setNbMonopole(1);}

                break;
            case "rose":
                if(this.aListPossession[2]==0){setNbMonopole(-1);}
                this.aListPossession[2]-=pModif;
                if(this.aListPossession[2]==0){setNbMonopole(1);}

                break;

            case "orange":
                if(this.aListPossession[3]==0){setNbMonopole(-1);}

                this.aListPossession[3]-=pModif;
                if(this.aListPossession[3]==0){setNbMonopole(1);}


                break;

            case "rouge":
                if(this.aListPossession[4]==0){setNbMonopole(-1);}

                this.aListPossession[4]-=pModif;
                if(this.aListPossession[4]==0){setNbMonopole(1);}

                break;

            case "jaune":
                if(this.aListPossession[5]==0){setNbMonopole(-1);}

                this.aListPossession[5]-=pModif;
                if(this.aListPossession[5]==0){setNbMonopole(1);}

                break;

            case "vert":
                if(this.aListPossession[6]==0){setNbMonopole(-1);}

                this.aListPossession[6]-=pModif;
                if(this.aListPossession[6]==0){setNbMonopole(1);}

                break;

            case "bleu":
                if(this.aListPossession[7]==0){setNbMonopole(-1);}

                this.aListPossession[7]-=pModif;
                if(this.aListPossession[7]==0){setNbMonopole(1);}

                break;

            case "gare":
                if(this.aListPossession[8]==0){setNbMonopole(-1);}

                this.aListPossession[8]-=pModif;
                if(this.aListPossession[8]==0){setNbMonopole(1);}

                break;

            case "compagnie":
                if(this.aListPossession[9]==0){setNbMonopole(-1);}

                this.aListPossession[9]-=pModif;
                if(this.aListPossession[9]==0){setNbMonopole(1);}

                break;
        }
    }

    /**
     * Accesseur permettant de connaitre la liste des monopoles que l'on possède
     * @return String retourne la liste des couleurs où l'on a un monopole
     */
    public String afficheMonopole()
    {
        if(getNbMonopole()==0)
        {
            return " Vous ne possédez aucun monopole , vous ne pouvez donc pas construire.\n";
        }
        else {
            StringBuilder vListMonopole = new StringBuilder(" Vous possédez toutes les rues de couleur :   ");
            for (int i = 0; i < 8; i++) {
                if (this.aListPossession[i] == 0) {
                    switch (i) {
                        case 0:
                            vListMonopole.append("marron ");
                            break;
                        case 1:
                            vListMonopole.append("cyan ");
                            break;

                        case 2:
                            vListMonopole.append("rose ");
                            break;
                        case 3:
                            vListMonopole.append("orange ");
                            break;

                        case 4:
                            vListMonopole.append("rouge ");
                            break;

                        case 5:
                            vListMonopole.append("jaune ");
                            break;

                        case 6:
                            vListMonopole.append("vert ");
                            break;

                        case 7:
                            vListMonopole.append("bleu ");
                            break;

                    }
                }
            }
            return vListMonopole + "\n ";
        }
    }

    /**
     * accesseur renvoyant le nombre de gares que l'on possède
     * @return int le nombre de gares que l'on possède
     */
    public int getNbGare()
    {
        return 4-this.aListPossession[8];
    }

    /**
     * accesseur renvoyant le nombre de compagnies que l'on possède
     * @return int le nombre de compagnies que l'on possède
     */
    public int getNbCompagnie()
    {
        return 2-this.aListPossession[9];
    }

    /**
     * accesseur du nombre de maisons et d'hotel que l'on possède
     * @return un tableau avec le nombre de maisons puis le nombre d'hotel que l'on possède
     */
    public int[] getNbMaisonHotel()
    {
        Iterator<Map.Entry<Integer,Patrimoine>> iterator = aPatrimoine.entrySet().iterator();
        int [] nbResultat= {0,0};
        if (aPatrimoine.isEmpty())
        {
            return nbResultat;
        }//if(aPatrimoine.isEmpty())
        while (iterator.hasNext())
        {
            Map.Entry<Integer,Patrimoine> Monopole = iterator.next();
            Patrimoine terrain = Monopole.getValue();
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