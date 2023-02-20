import java.util.HashMap;
/**
 * Classe des patrimoines de type Rue
 * @author Arvind Tangavelou
 * @author Quentin Guyot
 * @author Timothée Royer
 * @author Clément Lavie
 */
public class Rue extends Patrimoine
{
    private int aNbMaison;
    private int aHotel;



    private final int [] aPrixRente;

    /**
     * Constructeur de la classe Rue
     * @param pNomPatrimoine String le nom de la case
     * @param pIdPropriete int le numéro de la case
     * @param pPrixAchat int le prix d'achat de la case
     * @param pJoueurBoss int le numéro du joueur qui possède cette case(0 s'il n'y a pas de propriétaire)
     * @param pHypotheque int le prix d'hypothèque du terrain
     * @param pNbMaison int le nombre de maisons construites
     * @param pHotel int le nombre d'hôtels construits
     * @param pColor String la couleur du monopole de cette case
     * @param pPrixPassage int[] la liste d'entier indiquant le prix à payer en fonction du nombre de maisons
     */
    public Rue(String pNomPatrimoine,int pIdPropriete, int pPrixAchat,int pJoueurBoss,int pNbMaison, int pHotel, String pColor, int[] pPrixPassage, int pHypotheque)
    {
        super(pNomPatrimoine,pIdPropriete,pPrixAchat,pJoueurBoss,pColor,pHypotheque);
        this.aNbMaison= pNbMaison;
        this.aHotel=pHotel;

        this.aPrixRente=pPrixPassage;
    }

    /**
     * Accesseur du prix à payer si l'on atterrit sur cette case alors que l'on est pas propriétaire
     * @param vListPlayer HashMap<Integer,Player> la liste des joueurs
     * @return int renvoie le prix à payer
     */
    @Override public int getPrixPayer(HashMap<Integer,Player> vListPlayer)
    {
        if(this.aNbMaison==0 && this.aHotel==0 )
        {
            int vJoueur=getJoueurBoss();
            if(vListPlayer.get(vJoueur).getMonopole(super.getColor()))
            {
                return this.aPrixRente[0]*2;
            }
            else {
                return aPrixRente[0];
            }
        }
        else if(this.aHotel==1)
        {
            return this.aPrixRente[5];
        }
        else {
            return this.aPrixRente[this.aNbMaison];
        }
    }

    /**
     * mutateur du nombre de maisons
     * @param pNbMaison le nombre de maisons à ajouter
     */
    public void setaNbMaison(int pNbMaison)
    {
        if (pNbMaison+this.aNbMaison<=4 && this.aHotel==0)
        {
            aNbMaison+=pNbMaison;
        }
        else if(pNbMaison+this.aNbMaison==5 && this.aHotel==0)
        {
            this.aNbMaison=0;
            this.aHotel=1;
        }
        else {
            System.out.print("Erreur");
        }
    }

    /**
     * accesseur du nombre de maisons et hotels construits sur ce terrain
     * @return int[] renvoie une liste contenant le nombre de maisons et hôtel construits
     */

    public int[] getNbMaison()
    {

        return new int [] {this.aNbMaison,this.aHotel};
    }

    /**
     * mutateur qui supprime une maison ou un hôtel sur ce terrain
     */
    public void supprimeMaison()
    {
        if(this.aHotel==1)
        {
            this.aHotel=0;
        }
        else if(this.aNbMaison>0)
        {
            this.aNbMaison-=1;
        }
        else {
            System.out.println("ERREUR");
        }


    }




}
